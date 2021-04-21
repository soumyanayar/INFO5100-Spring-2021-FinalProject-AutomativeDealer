package group1;

import group5.ui.FilterAndBrowseUI;
import group8.Dealer;
import group8.DealerDirectory;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.util.ArrayList;
import java.util.List;

public class DealerSearch extends JFrame {
    private JPanel mainPanel;
    private JButton searchButton;
    private JTextField queryTextField;
    private JRadioButton stateRadioButton;
    private JRadioButton zipCodeRadioButton;
    private JRadioButton dealerNameRadioButton;
    private JTable dealerTable;
    private JLabel validationText;
    private JPanel searchPanel;
    private JPanel searchContainerPanel;

    public DealerSearch() throws HeadlessException {
        setQueryTextFieldTooltip("State/State code");
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                boolean isValidQuery = false;
                DefaultTableModel model = (DefaultTableModel) dealerTable.getModel();
                try {
                    DealerDirectory dealerDirectory = new DealerDirectory();
                    String queryString = queryTextField.getText();
                    List<Dealer> dealers = new ArrayList<>();
                    if (stateRadioButton.isSelected()) {
                        if (queryString.length() > 0 && isValidStateOrStateCode(queryString)) {
                            isValidQuery = true;
                            dealers = dealerDirectory.getDealerByStateOrStateId(queryString);
                        } else {
                            invalidQueryTextFieldEntry("Please enter a valid State or State code");
                        }

                    } else if (zipCodeRadioButton.isSelected()) {
                        if (queryString.length() > 0 && isValidZipCode(queryString)) {
                            isValidQuery = true;
                            dealers = dealerDirectory.getDealerByZipCode(queryString);
                        } else {
                            invalidQueryTextFieldEntry("Please enter a valid zipcode");
                        }
                    } else if (dealerNameRadioButton.isSelected()) {
                        if (queryString.length() > 0 && isValidDealerName(queryString)) {
                            isValidQuery = true;
                            dealers = dealerDirectory.getDealerByDealerName(queryString);
                        } else {
                            invalidQueryTextFieldEntry("Please enter a valid dealer name");
                        }
                    }
                    model.setRowCount(0);
                    for (int i = 0; i < dealers.size(); i++) {
                        Dealer dealer = dealers.get(i);
                        model.addRow(new Object[]{dealer.getName().toUpperCase()});
                        String zip_code = "ZipCode: " + dealer.getZipcode();
                        String dealer_address = "Address: " + dealer.getStreetAddress() + ", " + dealer.getCity();
                        model.addRow(new Object[]{dealer_address});
                        model.addRow(new Object[]{zip_code});
                        model.addRow(new Object[]{});
                        model.addRow(new Object[]{});
                    }
                    if (dealers.size() == 0 && isValidQuery) {
                        JOptionPane.showMessageDialog(null, "No dealers found. Please try again with a different search parameter", "InfoBox: " + "No Dealers found", JOptionPane.INFORMATION_MESSAGE);
                    }
                } catch (Exception e) {
                    System.out.println(e);
                    JOptionPane.showMessageDialog(mainPanel, "Error In Connectivity");
                }
            }
        });
        queryTextField.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                super.focusGained(e);
                clearValidations();
            }
        });
        stateRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clearQueryTextField();
                setQueryTextFieldTooltip("State/State code");
                clearValidations();
            }
        });
        zipCodeRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clearQueryTextField();
                setQueryTextFieldTooltip("Zipcode");
                clearValidations();
            }
        });
        dealerNameRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clearQueryTextField();
                setQueryTextFieldTooltip("Dealer name");
                clearValidations();
            }
        });

        dealerTable.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                try {
                    int row = dealerTable.rowAtPoint(evt.getPoint());
                    int col = dealerTable.columnAtPoint(evt.getPoint());
                    if (row % 5 == 0 && col >= 0) {
                        Object dealerValueClicked = dealerTable.getValueAt(row, col);

                        DealerDirectory dealerDirectory = new DealerDirectory();
                        List<Dealer> dealers = new ArrayList<>();
                        dealers = dealerDirectory.getDealerByDealerName(dealerValueClicked.toString());

                        Dealer clickedDealer = dealers.get(0);
                        String dealerID = clickedDealer.getDealerID();
                        JFrame filterAndBrowseUI = new FilterAndBrowseUI(clickedDealer);
                        filterAndBrowseUI.setVisible(true);
                        setVisible(false); //to hide the log in frame
                    }
                } catch (Exception e) {
                    System.out.println(e);
                    JOptionPane.showMessageDialog(mainPanel, "Error In Connectivity");
                }
            }
        });
    }

    private void clearValidations() {
        queryTextField.setBorder(new LineBorder(Color.white, 0));
        validationText.setText("");
    }

    private void setQueryTextFieldTooltip(String tooltipText) {
        queryTextField.setToolTipText(tooltipText);
    }

    public static void main(String[] args) {
        DealerSearch formView = new DealerSearch();
        formView.setVisible(true);
        formView.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        formView.pack();
    }

    static boolean isValidZipCode(String zipCode) {
        String regex = "\\d{5}";
        return zipCode.matches(regex);
    }

    static boolean isValidStateOrStateCode(String stateOrStateCode) {
        String regex = "^[a-zA-Z]*$";
        return stateOrStateCode.matches(regex);
    }

    static boolean isValidDealerName(String stateOrStateCode) {
        String regex = "\\D*";
        return stateOrStateCode.matches(regex);
    }

    private void invalidQueryTextFieldEntry(String s) {
        validationText.setText(s);
        validationText.setForeground(Color.RED);
        queryTextField.setBorder(new LineBorder(Color.red, 1));
    }

    private void clearQueryTextField() {
        queryTextField.setText("");
    }

    private void createUIComponents() {
        searchButton = new JButton();
        queryTextField = new JTextField();
        stateRadioButton = new JRadioButton();
        zipCodeRadioButton = new JRadioButton();
        dealerNameRadioButton = new JRadioButton();
        dealerTable = new JTable(new DefaultTableModel(null, new String[]{""}));
        dealerTable.setOpaque(false);
        ((DefaultTableCellRenderer)dealerTable.getDefaultRenderer(Object.class)).setOpaque(false);
    }

    private void ShowErrorMessage(String errorMessage, String title) {
        JOptionPane.showMessageDialog(null, errorMessage, title, JOptionPane.ERROR_MESSAGE);
    }

    public JTable getDealerTable() {
        return dealerTable;
    }

    public JPanel getSearchPanel() {
        return searchPanel;
    }

    public JPanel getSearchContainerPanel() {
        return searchContainerPanel;
    }
}
