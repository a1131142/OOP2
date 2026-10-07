//未使用AI

package OOP2.Homework4;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.*;
import javax.swing.*;
import java.util.Random;


public class Homework4 extends JFrame implements ActionListener{

    static Homework4 frm = new Homework4();
    static JLabel lbl = new JLabel("-");
    static JButton btn = new JButton("擲骰子");
    static  JLabel lbl2 = new JLabel("顯示統計資料");
    static int count = 0;
    static int total = 0;
    static double average = 0;

public static void main(String args[]){

    frm.setSize(400, 320);// 設定視窗大小
    frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// 設定關閉視窗時結束程式
    frm.setLocationRelativeTo(null);// 把視窗放到螢幕中央。
    

    // 元件加入視窗
    frm.add(lbl2, java.awt.BorderLayout.NORTH);
    frm.add(lbl, java.awt.BorderLayout.CENTER);
    frm.add(btn, java.awt.BorderLayout.SOUTH);

    lbl.setHorizontalAlignment(JLabel.CENTER);
    lbl.setFont(new java.awt.Font("Arial", java.awt.Font.PLAIN, 60));

    btn.addActionListener(frm);//把frm登記成btn的監聽者，當btn被按下時，會通知frm執行actionPerformed()方法
    frm.setVisible(true);

    }
    @Override 
    public void actionPerformed(ActionEvent e){
        Random random = new Random();
        int dice = random.nextInt(6)+1;

        count+=1;
        total+=dice;
        average = (double) total / count;

        if (dice == 1) {
            lbl.setForeground(Color.RED);
        } else if (dice == 6) {
            lbl.setForeground(Color.GREEN);
        } else {
            lbl.setForeground(Color.BLACK);
        }
        lbl.setText(String.valueOf(dice));

        lbl2.setText(
        "<html>" +
        "擲骰子次數: " + count + "<br>" +
        "骰子點數總和: " + total + "<br>" +
        "骰子點數平均值: " + String.format("%.2f", average) +
        "</html>"
        );
    }
    
}
