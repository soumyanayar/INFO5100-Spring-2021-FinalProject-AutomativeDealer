package group3;
/**
 * @author  Zhehui Yang
 * @date: 2021/4/12
 */
import javax.swing.*;
import java.awt.*;
import java.util.List;

public class LeadForms extends JFrame {
    private int numberOfLeads;
    private int height;
    private int width;

    public LeadForms(String title) {
        super(title);
        width = 750;
    }

    public void init(List<Lead> leads) {
        this.numberOfLeads = leads.size();
        height = numberOfLeads * 400;
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(numberOfLeads, 1));
//        super.setContentPane(mainPanel);
        super.setContentPane(new JScrollPane(mainPanel));
        for (int i = 0; i < numberOfLeads; i++) {
            Lead lead = leads.get(i);
            LeadForm leadForm = new LeadForm();
            leadForm.init(this, lead);
            leadForm.getMainPanel().setSize(750, 100);
            mainPanel.add(leadForm.getMainPanel(), BorderLayout.NORTH);
        }
//        super.add(BorderLayout.CENTER, new JScrollPane(mainPanel));
        super.setSize(width, 300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true);
    }

    public static void main(String[] args) {
        LeadForms frame = new LeadForms("Leads List");
        LeadDataAccessor dataAccessor = new LeadDataAccessor("/Users/bz/Desktop/github/INFO5100Spring2021FinalProject/src/group3/NewVehicleData.csv");
        frame.init(dataAccessor.getLeads());

        /*JScrollPane scrollPane = new JScrollPane();
        scrollPane.setSize(750,200);
        scrollPane.setVisible(true);*/



//        for(int i = 0; i < 5; i++){
//
//            LeadForm newForm = new LeadForm();
//            newForm.init(frame);
//            newForm.getMainPanel().setSize(750, 100);
//            scrollPane.add(newForm.getMainPanel());scrollPane.setViewportView(newForm);
//        }

//        LeadForm leadForm1 = new LeadForm();
//        leadForm1.init(frame);
//        LeadForm leadForm2 = new LeadForm();
//        leadForm2.init(frame);
//        leadForm2.getMainPanel().setSize(750, 100);
//        mainPanel.add(leadForm1.getMainPanel(), BorderLayout.NORTH);
//        mainPanel.add(leadForm2.getMainPanel(), BorderLayout.NORTH);
        // mainPanel.add(scrollPane,BorderLayout.CENTER);
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.pack();
//        frame.setVisible(true);
    }

    public void updateFrame(JFrame frame){
        frame.setSize(750, numberOfLeads * 100);
    }

    @Override
    public void setSize(int width, int height) {
        System.out.println("height is " + this.height);
        this.height += height;
        // super.setSize(this.width, this.height);
        // super.getContentPane().getComponents()[0].setSize(this.width, this.height);
    }
}
