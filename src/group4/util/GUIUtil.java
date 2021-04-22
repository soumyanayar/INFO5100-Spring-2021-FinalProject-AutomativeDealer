package group4.util;

import javax.swing.*;

public class GUIUtil {
    private static String imageFolder = "img";

    public static void useLNF() {
        try {
            javax.swing.UIManager.setLookAndFeel("com.birosoft.liquid.LiquidLookAndFeel");
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static void showPanel(JPanel p, double strechRate) {
//        GUIUtil.useLNF();
        JFrame f = new JFrame();
        f.setSize(1500, 500);
        f.setLocationRelativeTo(null);
        CenterPanel cp = new CenterPanel(strechRate);
        f.setContentPane(cp);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
        cp.show(p);
    }
}
