package group3;
/**
 * @author  Zhehui Yang
 * @date: 2021/4/15
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.*;
import java.util.List;

public class LeadForms extends JFrame implements ItemListener {
    private int numberOfLeads;
    private int height;
    private int width;
    private Map<String, List<LeadForm>> modelToLeadsMap;
    private JPanel listingPanel;

    public LeadForms(String title) {
        super(title);
        width = 750;
        modelToLeadsMap = new HashMap<>();
        listingPanel = new JPanel();
    }

    public void init(List<Lead> leads) {
        this.numberOfLeads = leads.size();
        height = numberOfLeads * 400;
        listingPanel.setLayout(new GridLayout(numberOfLeads, 1));
        JPanel optionPanel = new JPanel();
        optionPanel.setSize(750, 10);
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridBagLayout());
        GridBagConstraints controlLayout = new GridBagConstraints();
        controlLayout.fill = GridBagConstraints.VERTICAL;
        controlLayout.gridy = 0;
        controlLayout.ipadx = 750;
        mainPanel.add(optionPanel, controlLayout);
        controlLayout.ipady = 500;
        controlLayout.gridy = 1;
        controlLayout.gridwidth = 3;
        mainPanel.add(new JScrollPane(listingPanel), controlLayout);
        super.setContentPane(mainPanel);
        optionPanel.add(new JLabel("Filter By "));
        JComboBox<String> filteredByComboBox = new JComboBox<String>();
        optionPanel.add(filteredByComboBox);
        optionPanel.setSize(new Dimension(750, 100));
        // super.setContentPane(new JScrollPane(listingPanel));
        for (int i = 0; i < numberOfLeads; i++) {
            Lead lead = leads.get(i);
            System.out.println("Current lead name is" + lead.getLastName());
            LeadForm leadForm = new LeadForm();
            leadForm.init(this, lead);
            leadForm.getMainPanel().setSize(750, 100);
            listingPanel.add(leadForm.getMainPanel(), BorderLayout.NORTH);
            if (modelToLeadsMap.get(lead.getCarModel().toUpperCase()) != null) {
                modelToLeadsMap.get(lead.getCarModel().toUpperCase()).add(leadForm);
            } else {
                filteredByComboBox.addItem(lead.getCarModel().toUpperCase());
                List<LeadForm> tmpLeadFormList = new ArrayList<>();
                tmpLeadFormList.add(leadForm);
                modelToLeadsMap.put(lead.getCarModel().toUpperCase(), tmpLeadFormList);
            }
        }
        filteredByComboBox.addItemListener(this);
//        super.add(BorderLayout.CENTER, new JScrollPane(mainPanel));
        super.setSize(500, 300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true);
    }

    public void initOrigin(List<Lead> leads) {
        this.numberOfLeads = leads.size();
        height = numberOfLeads * 400;
        listingPanel.setLayout(new GridLayout(numberOfLeads, 1));
        JPanel optionPanel = new JPanel();
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(2, 1));
        mainPanel.add(optionPanel);
        mainPanel.add(new JScrollPane(listingPanel));
        super.setContentPane(mainPanel);
        optionPanel.add(new JLabel("Filter By "));
        JComboBox<String> filteredByComboBox = new JComboBox<String>();
        optionPanel.add(filteredByComboBox);
        optionPanel.setSize(new Dimension(750, 100));
        // super.setContentPane(new JScrollPane(listingPanel));
        for (int i = 0; i < numberOfLeads; i++) {
            Lead lead = leads.get(i);
            System.out.println("Current lead name is" + lead.getLastName());
            LeadForm leadForm = new LeadForm();
            leadForm.init(this, lead);
            leadForm.getMainPanel().setSize(750, 100);
            listingPanel.add(leadForm.getMainPanel(), BorderLayout.NORTH);
            if (modelToLeadsMap.get(lead.getCarModel().toUpperCase()) != null) {
                modelToLeadsMap.get(lead.getCarModel().toUpperCase()).add(leadForm);
            } else {
                filteredByComboBox.addItem(lead.getCarModel().toUpperCase());
                List<LeadForm> tmpLeadFormList = new ArrayList<>();
                tmpLeadFormList.add(leadForm);
                modelToLeadsMap.put(lead.getCarModel().toUpperCase(), tmpLeadFormList);
            }
        }
        filteredByComboBox.addItemListener(this);
        super.setSize(width, 300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true);
    }

    public static void main(String[] args) {
        LeadForms frame = new LeadForms("Leads List");
        LeadDataAccessor lda = new LeadDataAccessor("D:\\NewVehicleData.csv");
        frame.init(lda.getLeads());

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

    @Override
    public void itemStateChanged(ItemEvent e){
        if (e.getStateChange() == ItemEvent.SELECTED) {

            listingPanel.removeAll();
            List<LeadForm> selectedLeads = modelToLeadsMap.get(e.getItem());
            listingPanel.setLayout(new GridLayout(selectedLeads.size(), 1));
            for (LeadForm leadForm: selectedLeads) {
                listingPanel.add(leadForm.getMainPanel(), BorderLayout.NORTH);
            }
            listingPanel.updateUI();
        }
    }
}
