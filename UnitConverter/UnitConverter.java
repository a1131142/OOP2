package OOP2.UnitConverter;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class UnitConverter extends JFrame implements ActionListener {

    static UnitConverter frm = new UnitConverter();

    // 換算類型
    static String[] types = {"長度", "重量", "溫度"};
    static String[] lengthUnits =
    {"公尺", "公分", "英吋", "英尺"};

    static String[] weightUnits =
    {"公斤", "公克", "磅", "盎司"};

    static String[] tempUnits =
    {"攝氏", "華氏", "克氏"};

    // NORTH：換算類型
    static JComboBox<String> typeBox =
        new JComboBox<>(types);

    // CENTER：輸入、輸出
    static JTextField inputField = new JTextField();
    static JTextField outputField = new JTextField();

    static JComboBox<String> fromBox = new JComboBox<>();
    static JComboBox<String> toBox = new JComboBox<>();

    // SOUTH
    static JButton convertBtn = new JButton("換算");

    public static void main(String[] args) {

        frm.setTitle("單位換算器");
        frm.setSize(480, 280);
        frm.setLayout(new BorderLayout());
        frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frm.setLocationRelativeTo(null);

        // NORTH
        frm.add(typeBox, BorderLayout.NORTH);

        // CENTER
        JPanel centerPanel = new JPanel(new GridLayout(2, 2));

        centerPanel.add(inputField);
        centerPanel.add(fromBox);
        centerPanel.add(outputField);
        centerPanel.add(toBox);

        frm.add(centerPanel, BorderLayout.CENTER);

        // SOUTH
        frm.add(convertBtn, BorderLayout.SOUTH);

        // 第二格只顯示結果
        outputField.setEditable(false);

        // 監聽
        typeBox.addActionListener(frm);
        convertBtn.addActionListener(frm);

        for (String unit : lengthUnits) {
            fromBox.addItem(unit);
            toBox.addItem(unit);
        }

        frm.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == typeBox) {
            String[] units = lengthUnits;
            if (typeBox.getSelectedIndex() == 1) {
                units = weightUnits;
            } else if (typeBox.getSelectedIndex() == 2) {
                units = tempUnits;
            }
            fromBox.setModel(new DefaultComboBoxModel<>(units));
            toBox.setModel(new DefaultComboBoxModel<>(units));
            outputField.setText("");
        } else if (e.getSource() == convertBtn) {
            try {
                double value = Double.parseDouble(inputField.getText().trim());
                double result = convert(value, typeBox.getSelectedIndex(),
                    fromBox.getSelectedIndex(), toBox.getSelectedIndex());
                if (!Double.isFinite(value) || !Double.isFinite(result)) {
                    throw new NumberFormatException();
                }
                outputField.setText(String.valueOf(result));
            } catch (NumberFormatException ex) {
                outputField.setText("");
                JOptionPane.showMessageDialog(frm, "請輸入有效數字，且數值不可過大。",
                    "輸入錯誤", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    static double convert(double value, int type, int from, int to) {
        if (from == to) {
            return value;
        }
        if (type == 0) {
            // 先換成公尺，再換成目標單位。
            double[] factors = {1.0, 0.01, 0.0254, 0.3048};
            return value * factors[from] / factors[to];
        }
        if (type == 1) {
            // 先換成公斤，再換成目標單位。
            double[] factors = {1.0, 0.001, 0.45359237, 0.028349523125};
            return value * factors[from] / factors[to];
        }
        // 溫度先換成攝氏；克氏為 Kelvin。
        double celsius = value;
        if (from == 1) {
            celsius = (value - 32.0) * 5.0 / 9.0;
        } else if (from == 2) {
            celsius = value - 273.15;
        }
        if (to == 1) {
            return celsius * 9.0 / 5.0 + 32.0;
        }
        if (to == 2) {
            return celsius + 273.15;
        }
        return celsius;
    }
}