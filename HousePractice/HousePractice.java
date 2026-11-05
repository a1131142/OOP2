import javax.swing.*;
import java.awt.*;

public class HousePractice extends JPanel {
    private static final String SIGNATURE = "A1131142 高薇茗";

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // 1. 天空與草地：各占 500 × 400 畫布的一半。
        g.setColor(new Color(135, 206, 235));
        g.fillRect(0, 0, 500, 200);
        g.setColor(new Color(76, 175, 80));
        g.fillRect(0, 200, 500, 200);

        // 2. 太陽：黃色正圓，搭配八條向外延伸的光芒。
        g.setColor(Color.YELLOW);
        g.fillOval(380, 35, 70, 70);
        for (int i = 0; i < 8; i++) {
            double angle = Math.toRadians(i * 45);
            int x1 = 415 + (int) Math.round(45 * Math.cos(angle));
            int y1 = 70 + (int) Math.round(45 * Math.sin(angle));
            int x2 = 415 + (int) Math.round(65 * Math.cos(angle));
            int y2 = 70 + (int) Math.round(65 * Math.sin(angle));
            g.drawLine(x1, y1, x2, y2);
        }

        // 3. 雲朵：三個互相重疊的白色橢圓。
        g.setColor(Color.WHITE);
        g.fillOval(60, 55, 80, 50);
        g.fillOval(100, 40, 80, 60);
        g.fillOval(140, 55, 80, 50);

        // 4. 房屋主體：填色後加上黑色外框。
        g.setColor(new Color(255, 228, 181));
        g.fillRect(150, 190, 200, 155);
        g.setColor(Color.BLACK);
        g.drawRect(150, 190, 200, 155);

        // 5. 屋頂：只用三條 drawLine 畫出三角形。
        g.setColor(new Color(205, 92, 92));
        g.drawLine(130, 190, 250, 100);
        g.drawLine(250, 100, 370, 190);
        g.drawLine(370, 190, 130, 190);

        // 6. 門：棕色圓角矩形，以及黃色圓形門把。
        g.setColor(new Color(139, 69, 19));
        g.fillRoundRect(225, 265, 50, 80, 20, 20);
        g.setColor(Color.YELLOW);
        g.fillOval(262, 304, 7, 7);

        // 7. 兩扇窗戶：白底、黑框和十字窗框。
        for (int x = 170; x <= 280; x += 110) {
            g.setColor(Color.WHITE);
            g.fillRect(x, 220, 50, 50);
            g.setColor(Color.BLACK);
            g.drawRect(x, 220, 50, 50);
            g.drawLine(x + 25, 220, x + 25, 270);
            g.drawLine(x, 245, x + 50, 245);
        }

        // 8. 在畫面右下角簽名。
        g.setColor(Color.BLACK);
        g.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 16));
        int signatureWidth = g.getFontMetrics().stringWidth(SIGNATURE);
        g.drawString(SIGNATURE, 490 - signatureWidth, 385);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("我的小房子");
            HousePractice panel = new HousePractice();
            panel.setPreferredSize(new Dimension(500, 400));
            frame.add(panel);
            frame.pack();
            frame.setResizable(false);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}
