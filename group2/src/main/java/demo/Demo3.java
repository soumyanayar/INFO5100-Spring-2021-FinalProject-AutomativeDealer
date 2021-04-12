package demo;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Demo3 extends JFrame {
    public void GUI() {
        setTitle("Test image");
        JPanel panel = new JPanel();
        JLabel label = new JLabel();
        ImageIcon img = new ImageIcon("group2/images/demo2.jpeg");
        label.setIcon(img);
        panel.add(label);
        add(panel);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String args[]) {
        System.out.println(System.getProperty("user.dir"));
        Demo3 d = new Demo3();
        d.GUI();
    }
}