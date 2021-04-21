package group4.gui.develop;

import group4.util.CenterPanel;
import group4.util.GUIUtil;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class MainPanel extends JPanel {
//    static {
//        GUIUtil.useLNF();
//    }

    public static MainPanel instance = new MainPanel();
    public JButton bInventory;
    public JButton bIncentive;
    public CenterPanel startPanel;

    private static void addAButton(String text, Container container) {
        JButton button = new JButton(text){
            {
                setPreferredSize(new Dimension(250, 150));
                setMaximumSize(getPreferredSize());
                setAlignmentX(Component.CENTER_ALIGNMENT);
            }
        };
        container.add(button);
    }

    public static void addComponentsToPane(JComponent pane) {
        pane.setBorder(new EmptyBorder(new Insets(180, 200, 150, 200)));
        pane.setLayout(new BoxLayout(pane, BoxLayout.X_AXIS));
        addAButton("Inventory", pane);
        addAButton("Incentive", pane);
    }

    private MainPanel() {
        startPanel = new CenterPanel(1);
        addComponentsToPane(startPanel);
        add(startPanel);
    }

    private void addListener() {
        MainMenuListener listener = new MainMenuListener();
        bInventory.addActionListener(listener);
        bIncentive.addActionListener(listener);
    }

    public static void main(String[] args) {
        GUIUtil.showPanel(MainPanel.instance,1);
    }
}
