package group6;

import group8.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.image.BufferedImage;
import java.net.URL;
import java.sql.Blob;
import java.sql.SQLException;

public class LeadFormView extends JFrame {
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
    private JLabel mileageLabel;
    private JLabel errorLabel = new JLabel();
    Car car;
    LeadFormController controller;
    private ButtonGroup group;
    private String[] info = new String[10];
    public static File file = new File("LEAD.csv");
    private boolean isErrorDialogShown = false;
    public JPanel getMainPanel() {
        return mainPanel;
    }

    public LeadFormView(Car car, FormActionDirectory formActionDirectory) {
        this.car = car;
        this.setContentPane(this.mainPanel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        setProperties();
        this.setValue();
        setSize(new Dimension(510, 800));
        setMaximumSize(new Dimension(510, 800));

        /*personalUseRadioButton = new JRadioButton("Personal");
        businessUseRadioButton = new JRadioButton("Business");
        group = new ButtonGroup();
        group.add(personalUseRadioButton);
        group.add(businessUseRadioButton);*/

        fName.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                super.focusLost(e);
                if (fName == null) {

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
                if (!isValidEmail(eMail.getText())) {
                    showErrorMessage("Enter a valid E-mail ");
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
                if (!isValidPhone(ph_No.getText())) {
                    showErrorMessage("Enter a valid Phone No");
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
                if (!isValidZipCode(zipCode.getText())) {
                    showErrorMessage("Enter a valid Zip Code");
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
                if (!fName.getText().isEmpty() && !lName.getText().isEmpty() && !eMail.getText().isEmpty() && !ph_No.getText().isEmpty()) {
                    User user = new User(fName.getText(), lName.getText(), eMail.getText(), ph_No.getText(), zipCode.getText());
                    /**
                     * Add optional information to User
                     */
                    String message = "";
                    String useType = "";
                    LeadModel optional = null;
                    if (textArea1.getText() != null) {
                        message = textArea1.getText();
                    }
                    if (personalUseRadioButton.isSelected()) {
                        optional = new LeadModel(message, LeadModel.UseType.PERSONAL, user);
                        useType = "Personal";
                    } else if (businessUseRadioButton.isSelected()) {
                        optional = new LeadModel(message, LeadModel.UseType.BUSINESS, user);
                        useType = "Business";
                    }
                    user.setOptional(optional);
                    controller.submitLeadForm(user);
                    //write into file
                    info[0] = fName.getText();
                    info[1] = lName.getText();
                    info[2] = eMail.getText();
                    info[3] = ph_No.getText();
                    info[4] = zipCode.getText();
                    info[5] = useType;
                    info[6] = message;
                    info[7] = carModelLabel.getText();
                    info[8] = carColorLabel.getText();
                    info[9] = carVinLabel.getText();
                    try {
                        write(info);
                    } catch (IOException ioException) {
                        ioException.printStackTrace();
                    }

                    //add message reminder
                    JOptionPane.showMessageDialog(null, "Submit Successfully!");
                    clear();
                    dispose();
                }else if (fName.getText().isEmpty()){
                    JOptionPane.showMessageDialog(null, "Please Enter First Name");
                }else if (lName.getText().isEmpty()){
                    JOptionPane.showMessageDialog(null, "Please Enter Last Name");
                }else if (eMail.getText().isEmpty()){
                    JOptionPane.showMessageDialog(null, "Please Enter Email");
                }else if (ph_No.getText().isEmpty()){
                    JOptionPane.showMessageDialog(null, "Please Enter Phone Number");
                }
                //System.exit(0);
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
        for (JTextField textField: new JTextField[] {lName, fName, eMail, ph_No, zipCode}) {
            textField.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
        }
        requestQuoteLabel.setFont(DealerFont.getTitleFont());
        carModelLabel.setFont(DealerFont.getHeaderFont());
        carColorLabel.setFont(DealerFont.getSubSubTitleFont());
        carStockLabel.setFont(DealerFont.getSubSubTitleFont());
        carVinLabel.setFont(DealerFont.getSubSubTitleFont());
        mileageLabel.setFont(DealerFont.getSubSubTitleFont());
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

        termsConditionLabel.setFont(DealerFont.getDescriptionFont());
    }

    private void setValue() {
        carModelLabel.setText(car.getYear() + " " + car.getMake() + " " + car.getModel());
        carColorLabel.setText("Color: " + car.getColor());
        carStockLabel.setText("Price: $" + car.getMSRP());
        carVinLabel.setText("Vin: " + car.getVIN());
        mileageLabel.setText("Mileage: " + car.getMileage() + "Miles");
        instructionLabel.setText("<html>Fill out the contact form below and one of our friendly helpful sales <br/> staff will answer any questions you have about this vehicle.</html>");
        termsConditionLabel.setText("<html>By submitting your request, you consent to be contacted at the phone number you <br/> provided-which may include auto-dials,text messages and/or pre-recorded calls.By <br/> subscribing to receive  recurring SMS offers, you consent to receive text messages <br/> sent  through an automatic telephone dialing system, and message and data rates may<br/> apply. This consent is not a condition of purchase. You may opt out at any time by <br/> replying STOP to a text message, or calling (206) 241-1888 to have your telephone<br/>number removed from our system.</html>");
        Blob imageBlob = car.getImage();
        if (imageBlob != null) {
            try {
                InputStream is = imageBlob.getBinaryStream(0, (int) imageBlob.length());
                BufferedImage imag = null;
                imag = ImageIO.read(is);
                Image image = imag;
                ImageIcon icon = new ImageIcon(image);
                imageLabel.setIcon(icon);

            } catch (IOException ioException) {
                ioException.printStackTrace();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        } else {

            BufferedImage img = null;
            try {
                img = ImageIO.read(new File("src/group6/car_placeholder.png"));
                Image scaledImage = img.getScaledInstance(imageLabel.getWidth(), imageLabel.getHeight(),
                        Image.SCALE_SMOOTH);
                ImageIcon image = new ImageIcon(scaledImage);
                imageLabel.setIcon(image);
                imageLabel.setBackground(Color.white);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        imageLabel.setText("");

    }

    private void showErrorMessage(String error) {
        if (isErrorDialogShown)
            return;
        isErrorDialogShown = true;
        JOptionPane.showMessageDialog(null, error);
        isErrorDialogShown = false;
    }

    //add clear method
    private void clear() {
        carModelLabel.setText("");
        carColorLabel.setText("");
        carStockLabel.setText("");
        carVinLabel.setText("");
        instructionLabel.setText("");
        termsConditionLabel.setText("");
        fName.setText("");
        lName.setText("");
        eMail.setText("");
        ph_No.setText("");
        zipCode.setText("");
        textArea1.setText("");
        personalUseRadioButton.setSelected(false);
        businessUseRadioButton.setSelected(false);
        info = new String[10];
    }

    // write in file
    public void write(String[] info) throws IOException {

        BufferedWriter bw = new BufferedWriter(new FileWriter(file, true));
        StringBuilder sb = new StringBuilder();
        if (!file.exists()) {
            file.createNewFile();
        }
        bw.newLine();
        for (String element : info) {
            sb.append(element);
            sb.append(",");
        }
        bw.write(sb.toString());
        bw.close();
    }

}

