package group3;
/**
 * @author  Zhehui Yang
 * @date: 2021/4/12
 */
import javax.swing.*;
import java.awt.*;

public class LeadForms extends JPanel {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Leads List");
        LeadForm leadForm1 = new LeadForm();
        leadForm1.init(frame);
        LeadForm leadForm2 = new LeadForm();
        leadForm2.init(frame);
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(2, 1));
        leadForm1.getMainPanel().setSize(750, 100);
        leadForm2.getMainPanel().setSize(750, 100);
        mainPanel.add(leadForm1.getMainPanel(), BorderLayout.NORTH);
        mainPanel.add(leadForm2.getMainPanel(), BorderLayout.NORTH);
        frame.setContentPane(mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setSize(750, 200);
        frame.setVisible(true);
    }
}
