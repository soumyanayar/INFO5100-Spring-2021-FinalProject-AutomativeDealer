package group6;

import group8.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class LeadFormView extends JFrame{
    private JPanel mainPanel;
    private JLabel requestQuoteLabel;
    private JLabel imageLabel;
    private JLabel carModelLabel;
    private JLabel carColorLabel;
    private JLabel carStockLabel;
    private JLabel carVinLabel;
    private JLabel instructionLabel;
    private JTextField fName;
    private JRadioButton personalUseRadioButton;
    private JRadioButton businessUseRadioButton;
    private JTextArea textArea1;
    private JTextArea agreement;
    private JLabel commentLabel;
    private JLabel zipCodeLabel;
    private JLabel phoneNo;
    private JLabel emailLabel;
    private JLabel lastNameLabel;
    private JLabel firstNameLabel;
    private JButton submitButton;
    private JTextField lName;
    private JTextField eMail;
    private JTextField ph_No;
    private JTextField zipCode;
    Car car;

    public JPanel getMainPanel() {
        return mainPanel;
    }

    public LeadFormView(Car car){
        this.car = car;
        this.setValue();
        setSize(new Dimension(500, 800));
        fName.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                super.focusLost(e);
            }
        });
        lName.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                super.focusLost(e);
            }
        });
        eMail.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                super.focusLost(e);
                if(!isValidEmail(eMail.getText())){
                    showErrorMessage("Enter a valid E-mail ");
                }
            }
        });
        ph_No.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                super.focusLost(e);
                isValidPhone(phoneNo.getText());
            }
        });
        zipCode.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                super.focusLost(e);
                isValidZipCode(zipCode.getText());
            }
        });
    }
    static boolean isValidEmail(String eMail) {
        String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
        return eMail.matches(regex);
    }
    static boolean isValidPhone(String phoneNo) {
        String regex = "^\\(?([0-9]{3})\\)?[-.\\s]?([0-9]{3})[-.\\s]?([0-9]{4})$";
        return phoneNo.matches(regex);
    }
    static boolean isValidZipCode(String zipCode) {
        String regex = "\\d{5}(-\\d{4})?";
        return zipCode.matches(regex);
    }


    void setProperties() {

        requestQuoteLabel.setFont(DealerFont.getTitleFont());
        carModelLabel.setFont(DealerFont.getHeaderFont());
        carColorLabel.setFont(DealerFont.getNormalFont());
        carStockLabel.setFont(DealerFont.getNormalFont());
        carVinLabel.setFont(DealerFont.getNormalFont());
        instructionLabel.setFont(DealerFont.getDescriptionFont());
        firstNameLabel.setFont(DealerFont.getNormalFont());
        fName.setFont(DealerFont.getNormalFont());
        lastNameLabel.setFont(DealerFont.getNormalFont());
        lName.setFont(DealerFont.getNormalFont());
        emailLabel.setFont(DealerFont.getNormalFont());
        eMail.setFont(DealerFont.getNormalFont());
        phoneNo.setFont(DealerFont.getNormalFont());
        ph_No.setFont(DealerFont.getNormalFont());
        zipCodeLabel.setFont(DealerFont.getNormalFont());
        zipCode.setFont(DealerFont.getNormalFont());
        commentLabel.setFont(DealerFont.getNormalFont());
        textArea1.setFont(DealerFont.getNormalFont());
        personalUseRadioButton.setFont(DealerFont.getNormalFont());
        businessUseRadioButton.setFont(DealerFont.getNormalFont());
        agreement.setFont(DealerFont.getDescriptionFont());
        submitButton.setFont(DealerFont.getSubTitleFont());
        // TODO: remove this
        imageLabel.setBackground(Color.BLUE);

    }

    private void setValue(){
        carModelLabel.setText(car.getYear()+" "+car.getMake()+" "+car.getModel());
        carColorLabel.setText(car.getColor());
        instructionLabel.setText("<html>Fill out the contact form below and one of our friendly<br>helpful sales staff will answer any questions you have about this vehicle.</html>");
        setProperties();

    }
    private void showErrorMessage(String error){
        JOptionPane.showMessageDialog(null,error);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Request Quote");
        Car car = new Car("1", "BMW", "QC2", 2020, 222, false, "Green", "Seattle", 12);
        Car car2 = new Car("1", "AUDI", "QC2", 2020, 222, false, "Green", "Seattle", 12);
        frame.setContentPane(new LeadFormView(car).mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);



    }
}
