package group1;

import group8.Dealer;
import group8.DealerDirectory;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class DealerSearch extends JFrame {
    private JPanel test;
    private JButton searchButton;
    private JTextField queryTextField;
    private JRadioButton stateRadioButton;
    private JRadioButton zipCodeRadioButton;
    private JRadioButton dealerNameRadioButton;
    private JScrollPane scrollPane;
    private JTable dealerTable;

    public static void main(String[] args) {
        DealerSearch formView = new DealerSearch();
        formView.setVisible(true);
        formView.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        formView.pack();
    }

    public DealerSearch() throws HeadlessException {
        add(test);
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                DefaultTableModel model = (DefaultTableModel) dealerTable.getModel();
                try {
                    DealerDirectory dealerDirectory = new DealerDirectory();
                    String queryString = queryTextField.getText();
                    List<Dealer> dealers = new ArrayList<>();
                    if(stateRadioButton.isSelected()) {
                        dealers = dealerDirectory.getDealerByStateOrStateId(queryString);
                    }else if(zipCodeRadioButton.isSelected()){
                        dealers = dealerDirectory.getDealerByZipCode(queryString);
                    }
                    model.setRowCount(0);
                    for (Dealer dealer : dealers) {
                        model.addRow(new Object[]{dealer.getName(), dealer.getPhoneNumber(), dealer.getStreetAddress(), dealer.getCity(), dealer.getZipcode()});
                    }
                    if (dealers.size() == 0) {
                        JOptionPane.showMessageDialog(null, "Please try different zip code or state code", "InfoBox: " + "No Dealers found", JOptionPane.INFORMATION_MESSAGE);
                    }
                } catch (Exception e) {
                    System.out.println(e);
                    JOptionPane.showMessageDialog(test, "Error In Connectivity");
                }
            }
        });
    }

    private void createUIComponents() {
        UIDefaults defaults = UIManager.getLookAndFeelDefaults();
        defaults.putIfAbsent("Table.alternateRowColor", Color.LIGHT_GRAY);
        searchButton = new JButton();
        queryTextField = new JTextField();
        stateRadioButton = new JRadioButton();
        zipCodeRadioButton = new JRadioButton();
        dealerNameRadioButton = new JRadioButton();
        dealerTable = new JTable(new DefaultTableModel(
                null,
                new String[]{
                        "Name", "Phone Number", "Address", "City", "Zipcode"
                }
        ));
        scrollPane = new JScrollPane(dealerTable);
    }
}
