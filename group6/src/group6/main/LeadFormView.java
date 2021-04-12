package group6.main;

import group8.Main.Car;

import javax.swing.*;
import java.awt.*;

public class LeadFormView extends JFrame{
    private JPanel mainPanel;
    private JLabel requestQuoteLabel;
    private JLabel imageLabel;
    private JLabel carModelLabel;
    private JLabel carColorLabel;
    private JLabel carStockLabel;
    private JLabel carVinLabel;
    private JLabel instructionLabel;
    private JTextField textField1;
    private JRadioButton personalUseRadioButton;
    private JRadioButton businessUseRadioButton;
    private JTextArea textArea1;
    private JTextArea bySubmittingYourTextArea;
    private JLabel commentLabel;
    private JLabel zipCodeLabel;
    private JLabel phoneNo;
    private JLabel emailLabel;
    private JLabel lastNameLabel;
    private JLabel firstNameLabel;
    private JButton submitButton;
    Car car;

    public JPanel getMainPanel() {
        return mainPanel;
    }

    public LeadFormView(Car car){
        this.car = car;
        this.setValue();
        setSize(new Dimension(500, 800));
    }

    void setProperties() {
//        requestQuoteLabel.setFont(Font.);
    }

    private void setValue(){
        carModelLabel.setText(car.getYear()+" "+car.getMake()+" "+car.getModel());
        carColorLabel.setText(car.getColor());
        instructionLabel.setText("<html>Fill out the contact form below and one of our friendly<br>helpful sales staff will answer any questions you have about this vehicle.</html>");
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
