package OOP2.LoginHomework;

import javax.swing.*;
import java.awt.*;

public class Login extends JFrame {

    public Login() {

        // 視窗設定
        setTitle("登入");
        setSize(300, 200);
        setLayout(new FlowLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // 元件
        JLabel l1 = new JLabel("帳號:");
        JTextField t1 = new JTextField(15);

        JLabel l2 = new JLabel("密碼:");
        JPasswordField t2 = new JPasswordField(15);

        JButton btn = new JButton("登入");

        // 加入視窗
        add(l1);
        add(t1);
        add(l2);
        add(t2);
        add(btn);

        // 按鈕事件
        btn.addActionListener(e -> {

            String account = t1.getText();
            String password = new String(t2.getPassword());

            if (account.equals("admin") &&
                password.equals("1234")) {

                System.out.println("登入成功");

            } else {

                System.out.println("帳號或密碼錯誤");

            }
        });

        // 最後才顯示視窗
        setVisible(true);
    }

    public static void main(String[] args) {
        new Login();
    }
}