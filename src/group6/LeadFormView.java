package group6;

import group8.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.image.BufferedImage;
import java.net.URL;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;

import static group8.CarCategory.NEW;

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
    private JLabel termsConditionLabel;
    private JLabel errorLabel = new JLabel();
    Car car;
    LeadFormController controller;

    public JPanel getMainPanel() {
        return mainPanel;
    }

    public LeadFormView(Car car, FormActionDirectory formActionDirectory){
        this.car = car;
        this.setValue();
        setSize(new Dimension(500, 800));
        setMaximumSize(new Dimension(500, 800));
        fName.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                super.focusLost(e);
                if(fName == null){

                }
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
                    showErrorMessage("Enter a valid E-mail ", eMail.getParent());
                    eMail.setBorder(BorderFactory.createLineBorder(Color.RED));
                }
            }
        });
        eMail.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                super.focusGained(e);
                eMail.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
            }
        });
        ph_No.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                super.focusLost(e);
                if(!isValidPhone(ph_No.getText())){
                   showErrorMessage("Enter a valid Phone No", ph_No.getParent());
                   ph_No.setBorder(BorderFactory.createLineBorder(Color.RED));
                }
            }
        });
        ph_No.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                super.focusGained(e);
                ph_No.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
            }
        });
        zipCode.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                super.focusLost(e);
                if(!isValidZipCode(zipCode.getText())){
                    showErrorMessage("Enter a valid Zip Code", zipCode.getParent());
                    zipCode.setBorder(BorderFactory.createLineBorder(Color.RED));
                }
            }
        });
        zipCode.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                super.focusGained(e);
                zipCode.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
            }
        });
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                (String firstName, String lastName, String eMail, String phoneNumber, String zipCode)
                User user = new User(fName.getText(), lName.getText(), eMail.getText(), ph_No.getText(), zipCode.getText());
                /**
                 * Add optional information to User
                 */
                String message = "";
                LeadModel optional = null;
                if (textArea1.getText() != null) {
                    message = textArea1.getText();
                }
                if (personalUseRadioButton.isSelected())
                    optional = new LeadModel(message, LeadModel.UseType.PERSONAL, user);
                else if (businessUseRadioButton.isSelected())
                    optional = new LeadModel(message, LeadModel.UseType.BUSINESS, user);
                user.setOptional(optional);

                controller.submitLeadForm(user);
                System.exit(0);
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
        String regex = "\\d{5}";
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
        submitButton.setFont(DealerFont.getSubTitleFont());
        // TODO: remove this
        imageLabel.setBackground(Color.BLUE);
        termsConditionLabel.setFont(DealerFont.getDescriptionFont());

    }

    private void setValue(){
        carModelLabel.setText(car.getYear()+" "+car.getMake()+" "+car.getModel());
        carColorLabel.setText("Color: " + car.getColor());
        carStockLabel.setText("Price: $" + car.getMSRP());
        carVinLabel.setText("Type: " + car.getCarCategory().name());
        instructionLabel.setText("<html>Fill out the contact form below and one of our friendly helpful sales <br/> staff will answer any questions you have about this vehicle.</html>");
        setProperties();
        termsConditionLabel.setText("<html><strong>" +"By submitting your request, you consent to be contacted at the <br/> phone number you provided-which may include auto-dials,<br/> text messages and/or pre-recorded calls.By subscribing to receive <br/> recurring SMS offers, you consent to receive text messages sent <br/> through an automatic telephone dialing system, and message <br/> and data rates may apply. This consent is not a condition of <br/> purchase. You may opt out at any time by replying STOP to <br/> a text message, or calling (206) 241-1888 to have your <br/> telephone number removed from our system.</strong></html>");

        String path = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSC4vdqyjdI2Zz713z7WWoiEjPK3nzO9FSUM3vJQZgaB-Hc9l6qe_hNcKMWkHVX3MvJ3ow&usqp=CAU";


        try {
            URL url = new URL(path);
            BufferedImage image = null;
            image = ImageIO.read(url);
            ImageIcon icon = new ImageIcon(image);
            imageLabel.setIcon(icon);
            imageLabel.setText("");
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }

    }
    private void showErrorMessage(String error, Container container){
//        errorLabel.setText(error);
//        this.add(errorLabel);
//        this.revalidate();
//        this.repaint();
//        this.pack();
       JOptionPane.showMessageDialog(null,error);
    }
}
