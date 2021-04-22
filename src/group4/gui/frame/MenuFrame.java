package group4.gui.frame;

import group7.ui.IncentiveManagerUI;
import group8.data.NewJDBC;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.*;

import static group4.gui.frame.MainFrame.run;

public class MenuFrame extends JFrame implements ActionListener {
    public static String dealerID;
    private JTextField tfDealerID;

    public MenuFrame(){
        setLayout(new FlowLayout(FlowLayout.CENTER, 10, 20));
        JLabel lDealerID = new JLabel("Dealer ID:");
        tfDealerID = new JTextField(8);
        add(lDealerID);
        add(tfDealerID);
        JButton btnInventory = new JButton("Inventory");
        btnInventory.setActionCommand("Inventory");
        btnInventory.addActionListener(this);
        add(btnInventory);
        JButton btnIncentive = new JButton("Incentive");
        btnIncentive.setActionCommand("Incentive");
        btnIncentive.addActionListener(this);
        add(btnIncentive);
    }

    public void actionPerformed(ActionEvent e){
        String command=e.getActionCommand();
        System.out.println(command);
        if(command.equals("Incentive")){
            dealerID = tfDealerID.getText();
            EventQueue.invokeLater(() -> {
                try {
                    UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
                    new IncentiveManagerUI(NewJDBC.getInstance(), dealerID);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            });
        }
        if(command.equals("Inventory")){
            dealerID = tfDealerID.getText();
            EventQueue.invokeLater(run);
        }
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
                    MenuFrame menuFrame = new MenuFrame();
                    menuFrame.setTitle("Dealer System");
                    menuFrame.setSize(250, 150);
                    menuFrame.setLocationRelativeTo(null);
                    menuFrame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}