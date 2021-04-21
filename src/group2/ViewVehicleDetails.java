package group2;

import group2.utils.Utils;
import group6.FormActionDirectory;
import group6.LeadFormController;
import group8.Car;
import group8.CarCategory;
import group8.Dealer;
import group2.dao.VehicleDAO;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ViewVehicleDetails {
    private List<String> vehicleImageList;
    private JPanel innerPanel;
    private JPanel vehicleShortDescriptionPanel;
    private JPanel vehicleDetailsPanel;
    private JPanel vehicleImageAndLeadFormPanel;
    private JPanel vehicleInfoPanel;
    private JScrollPane vehicleDescriptionPane;
    private JPanel vehicleDescriptionPanel;
    private JScrollPane dealersInformationPane;
    private JPanel dealersInformationPanel;
    private JLabel vehicleMSRPLabel;
    private JPanel vehicleImagePanel;
    private JButton leadFormButton;
    private JLabel vehicleInfoLabel;
    private JLabel vehicleDescriptionLabel;
    private JLabel dealersInformationLabel;
    private JTextArea vehicleDescriptionTextArea;
    private JTextArea dealersInformationTextArea;
    private JLabel vehicleNameLabel;
    private JScrollPane scrollPane;
    private JTextField vehicleNameTextField;
    private JTextField vehicleMSRPTextField;
    private Dimension iconLabelDimension = new Dimension(60, 50);
    private Dimension imageLabelDimension = new Dimension(120, 50);
    private Dimension dataLabelDimension = new Dimension(196, 50);
    private Dimension labelPanelDimension = new Dimension(376, 50);
    private ImageIcon carImage;
    private ImageIcon engineImage;
    private ImageIcon transmissionImage;
    private ImageIcon vinImage;
    private ImageIcon fuelImage;
    private ImageIcon colorImage;
    private ImageIcon stockNumberImage;
    private ImageIcon mileageImage;
    private ImageIcon seatCountImage;
    private ImageIcon ratingsImage;
    private JPanel requestLeadFormPanel;
    private JPanel vehicleInfoLabelPanel;
    private JPanel vehicleConditionLabelPanel;
    private JPanel vehicleEngineLabelPanel;
    private JPanel vehicleTransmissionLabelPanel;
    private JPanel vehicleVINLabelPanel;
    private JPanel vehicleFuelLabelPanel;
    private JPanel vehicleColorLabelPanel;
    private JPanel vehicleStockNumberLabelPanel;
    private JPanel vehicleMileageLabelPanel;
    private JPanel vehicleSeatCountLabelPanel;
    private JPanel vehicleRatingsLabelPanel;
    private JFrame frame;
    private Car car;
    private Dealer dealer;

        public ViewVehicleDetails(String vehicleId) {
        VehicleDAO vehicleDAO = new VehicleDAO();
        try {
            final List<Map<String, Object>> res = vehicleDAO.getById(1);
            this.car = Utils.transToCar(res.get(0));
            this.dealer = Utils.transToDealer(res.get(0));
            vehicleImageList = new ArrayList<>();

        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }
    public ViewVehicleDetails(Car myCar, Dealer myDealer) {
        vehicleImageList = new ArrayList<>();
        vehicleImageList.add(System.getProperty("user.dir") + "\\src\\group2\\Icons\\img1.jpg");
        vehicleImageList.add(System.getProperty("user.dir") + "\\src\\group2\\Icons\\img2.jpg");
        vehicleImageList.add(System.getProperty("user.dir") + "\\src\\group2\\Icons\\img3.jpg");
        vehicleImageList.add(System.getProperty("user.dir") + "\\src\\group2\\Icons\\img4.jpg");
        this.car = myCar;
        this.dealer = myDealer;
        this.car.setImages(vehicleImageList);
    }
    public void showVehicleDetails(){
        createVehicleShortDescriptionPanel(this.car);
        createVehicleDetailsPanel(this.car);
        createVehicleDescriptionPanel(this.car);
        createDealersInformationPanel(this.dealer);
        createOuterPanel();
    }

    public void createOuterPanel() {
        frame = new JFrame();

        scrollPane = new JScrollPane();
        scrollPane.setBackground(new Color(-4473925));
        scrollPane.setMaximumSize(new Dimension(916, 940));
        scrollPane.setMinimumSize(new Dimension(916, 940));
        scrollPane.setPreferredSize(new Dimension(916, 940));
//        scrollPane.setBorder(new LineBorder(new Color(255,0,0)));

        innerPanel = new JPanel();
        innerPanel.setLayout(new BoxLayout(innerPanel, BoxLayout.Y_AXIS));
        innerPanel.setPreferredSize(new Dimension(916, 940));
        innerPanel.setMaximumSize(new Dimension(916, 940));
        innerPanel.setMinimumSize(new Dimension(916, 940));
//        innerPanel.setBorder(new LineBorder(new Color(0,255,0)
//        ));
        scrollPane.setViewportView(innerPanel);

        innerPanel.add(vehicleShortDescriptionPanel, 0);
        innerPanel.add(vehicleDetailsPanel, 1);
        innerPanel.add(vehicleDescriptionPanel, 2);
        innerPanel.add(dealersInformationPanel, 3);
        JPanel additionalBlankPanel = new JPanel();
        additionalBlankPanel.setBorder(new LineBorder(Color.BLACK));
        additionalBlankPanel.add(Box.createRigidArea(new Dimension(916, 1)));
        additionalBlankPanel.setPreferredSize(new Dimension(916, 1));
        additionalBlankPanel.setMaximumSize(new Dimension(916, 1));
        additionalBlankPanel.setMinimumSize(new Dimension(916, 1));
        innerPanel.add(additionalBlankPanel);

        frame.pack();
        frame.setSize(new Dimension(950, 950));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setContentPane(scrollPane);
    }

    public void createVehicleShortDescriptionPanel(Car myCar) {
        vehicleShortDescriptionPanel = new JPanel();
        vehicleNameLabel = new JLabel();
        vehicleMSRPLabel = new JLabel();

        vehicleShortDescriptionPanel.setPreferredSize(new Dimension(916, 74));
        vehicleShortDescriptionPanel.setMaximumSize(new Dimension(916, 74));
        vehicleShortDescriptionPanel.setMinimumSize(new Dimension(916, 74));
        vehicleShortDescriptionPanel.setLayout(new BoxLayout(vehicleShortDescriptionPanel, BoxLayout.X_AXIS));
        vehicleShortDescriptionPanel.setBorder(new LineBorder(Color.BLACK));

        if (myCar.getMake() == null || myCar.getModel() == null) {
            vehicleNameLabel.setText("--");
        } else {
            vehicleNameLabel.setText(myCar.getYear() + " " + myCar.getMake() + " " + myCar.getModel());
        }
        vehicleNameLabel.setFont(new Font("Calibri", Font.BOLD, 36));
        vehicleNameLabel.setMinimumSize(new Dimension(750, 74));
        vehicleNameLabel.setMaximumSize(new Dimension(750, 74));
        vehicleNameLabel.setPreferredSize(new Dimension(750, 74));

        if (myCar.getMSRP() == 0) {
            vehicleMSRPLabel.setText("--");
        } else {
            vehicleMSRPLabel.setText("$ "+Double.toString(myCar.getMSRP()));
        }
        Font VehicleMSRPLabelFont = new Font("Calibri", Font.BOLD, 28);
        vehicleMSRPLabel.setFont(VehicleMSRPLabelFont);
        vehicleMSRPLabel.setMinimumSize(new Dimension(166, 74));
        vehicleMSRPLabel.setMaximumSize(new Dimension(166, 74));
        vehicleMSRPLabel.setPreferredSize(new Dimension(166, 74));

        vehicleShortDescriptionPanel.add(vehicleNameLabel, 0);
        vehicleShortDescriptionPanel.add(vehicleMSRPLabel, 1);
    }

    public void createVehicleDetailsPanel(Car myCar) {
        vehicleDetailsPanel = new JPanel();
        vehicleDetailsPanel.setLayout(new BoxLayout(vehicleDetailsPanel, BoxLayout.X_AXIS));
        vehicleDetailsPanel.setPreferredSize(new Dimension(916, 600));
        vehicleDetailsPanel.setMaximumSize(new Dimension(916, 600));
        vehicleDetailsPanel.setMinimumSize(new Dimension(916, 600));
//        vehicleDetailsPanel.setBorder(new LineBorder(new Color(0, 0, 0)));

        createVehicleImageAndLeadFormPanel(myCar);
        createVehicleInfoDetailsPanel(myCar);
        vehicleDetailsPanel.add(vehicleImageAndLeadFormPanel, 0);
        vehicleDetailsPanel.add(vehicleInfoPanel, 1);
    }

    public void createVehicleImageAndLeadFormPanel(Car myCar) {
        vehicleImageAndLeadFormPanel = new JPanel();
        vehicleImageAndLeadFormPanel.setLayout(new BoxLayout(vehicleImageAndLeadFormPanel, BoxLayout.Y_AXIS));
        vehicleImageAndLeadFormPanel.setPreferredSize(new Dimension(540, 600));
        vehicleImageAndLeadFormPanel.setMinimumSize(new Dimension(540, 600));
        vehicleImageAndLeadFormPanel.setMaximumSize(new Dimension(540, 600));
//        vehicleImageAndLeadFormPanel.setBorder(new LineBorder(new Color(0,0,190)));

        vehicleImagePanel = new VehicleImagePanel(vehicleImageList).imagePanel();
        requestLeadFormPanel = new JPanel();
        requestLeadFormPanel.setLayout(new BoxLayout(requestLeadFormPanel, BoxLayout.X_AXIS));
        requestLeadFormPanel.setPreferredSize(new Dimension(540, 100));
        requestLeadFormPanel.setMinimumSize(new Dimension(540, 100));
        requestLeadFormPanel.setMaximumSize(new Dimension(540, 100));
        requestLeadFormPanel.setBorder(new LineBorder(Color.black));

        leadFormButton = new JButton();
        leadFormButton.setText("Request Lead Form");
        leadFormButton.setFont(new Font(Font.SERIF, Font.PLAIN, 16));
        leadFormButton.setBorder(new BevelBorder(0));
        leadFormButton.setPreferredSize(new Dimension(200, 30));
        leadFormButton.setMaximumSize(new Dimension(200, 30));
        leadFormButton.setMinimumSize(new Dimension(200, 30));
        leadFormButton.setBackground(new Color(185, 185, 185));
        leadFormButton.setFocusPainted(false);

        leadFormButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FormActionDirectory formAction = new FormActionDirectory(myCar);
                LeadFormController leadFormRequest = new LeadFormController(myCar, formAction);
                leadFormRequest.showLeadForm();
                frame.dispose();
            }
        });

        requestLeadFormPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        leadFormButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        requestLeadFormPanel.add(Box.createRigidArea(new Dimension(170, 100)));
        requestLeadFormPanel.add(leadFormButton);
        requestLeadFormPanel.add(Box.createRigidArea(new Dimension(170, 100)));

        vehicleImageAndLeadFormPanel.add(vehicleImagePanel, 0);
        vehicleImageAndLeadFormPanel.add(requestLeadFormPanel, 1);
    }

    public void createVehicleInfoDetailsPanel(Car myCar) {

        vehicleInfoPanel = new JPanel();
        vehicleInfoPanel.setLayout(new BoxLayout(vehicleInfoPanel, BoxLayout.Y_AXIS));

        vehicleInfoPanel.setBorder(new LineBorder(Color.BLACK));
        vehicleInfoPanel.setPreferredSize(new Dimension(376, 600));
        vehicleInfoPanel.setMaximumSize(new Dimension(376, 600));
        vehicleInfoPanel.setMaximumSize(new Dimension(376, 600));

        vehicleInfoLabelPanel = new JPanel();
        vehicleInfoLabelPanel.setLayout(new BoxLayout(vehicleInfoLabelPanel, BoxLayout.Y_AXIS));
        vehicleInfoLabelPanel.setPreferredSize(labelPanelDimension);
        vehicleInfoLabelPanel.setMaximumSize(labelPanelDimension);
        vehicleInfoLabelPanel.setMinimumSize(labelPanelDimension);

        vehicleInfoLabel = new JLabel();
        vehicleInfoLabel.setFont(new Font("Calibri", Font.BOLD, 24));
        vehicleInfoLabel.setText("Vehicle Info");
        vehicleInfoLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        vehicleInfoLabelPanel.add(vehicleInfoLabel, 0);

        vehicleInfoPanel.add(vehicleInfoLabelPanel);

        carImage = new ImageIcon(System.getProperty("user.dir") + "\\src\\group2\\Icons\\carCondition.jpg");
        engineImage = new ImageIcon(System.getProperty("user.dir") + "\\src\\group2\\Icons\\CarEngine.jpg");
        transmissionImage = new ImageIcon(System.getProperty("user.dir") + "\\src\\group2\\Icons\\Transmission.jpg");
        vinImage = new ImageIcon(System.getProperty("user.dir") + "\\src\\group2\\Icons\\VIN.jpg");
        fuelImage = new ImageIcon(System.getProperty("user.dir") + "\\src\\group2\\Icons\\Fuel.jpg");
        colorImage = new ImageIcon(System.getProperty("user.dir") + "\\src\\group2\\Icons\\CarColor.jpg");
        stockNumberImage = new ImageIcon(System.getProperty("user.dir") + "\\src\\group2\\Icons\\vehicleid.jpg");
        mileageImage = new ImageIcon(System.getProperty("user.dir") + "\\src\\group2\\Icons\\Mileage.jpg");
        seatCountImage = new ImageIcon(System.getProperty("user.dir") + "\\src\\group2\\Icons\\carseat.jpg");
        ratingsImage = new ImageIcon(System.getProperty("user.dir") + "\\src\\group2\\Icons\\Ratings.jpg");

        if (myCar.getCarCategory() != null && validateCarInfoDetails(myCar.getCarCategory().toString())) {
            vehicleConditionLabelPanel = vehicleSubInfoPanel(carImage, "Car Condition", myCar.getCarCategory().toString());
            vehicleInfoPanel.add(vehicleConditionLabelPanel);
        }
        if (validateCarInfoDetails(myCar.getEngine())) {
            vehicleEngineLabelPanel = vehicleSubInfoPanel(engineImage, "Engine", myCar.getEngine());
            vehicleInfoPanel.add(vehicleEngineLabelPanel);
        }
        if (validateCarInfoDetails(myCar.getTransmission())) {
            vehicleTransmissionLabelPanel = vehicleSubInfoPanel(transmissionImage, "Transmission", myCar.getTransmission());
            vehicleInfoPanel.add(vehicleTransmissionLabelPanel);
        }
        if (validateCarInfoDetails(myCar.getVIN())) {
            vehicleVINLabelPanel = vehicleSubInfoPanel(vinImage, "VIN", myCar.getVIN());
            vehicleInfoPanel.add(vehicleVINLabelPanel);
        }
        if (validateCarInfoDetails(myCar.getFuel())) {
            vehicleFuelLabelPanel = vehicleSubInfoPanel(fuelImage, "Fuel", myCar.getFuel());
            vehicleInfoPanel.add(vehicleFuelLabelPanel);
        }
        if (validateCarInfoDetails(myCar.getColor())) {
            vehicleColorLabelPanel = vehicleSubInfoPanel(colorImage, "Color", myCar.getColor());
            vehicleInfoPanel.add(vehicleColorLabelPanel);
        }
        if (validateCarInfoDetails(myCar.getstockNum())) {
            vehicleStockNumberLabelPanel = vehicleSubInfoPanel(stockNumberImage, "Stock #", myCar.getstockNum());
            vehicleInfoPanel.add(vehicleStockNumberLabelPanel);
        }
        if (myCar.getMileage() >= 0) {
            vehicleMileageLabelPanel = vehicleSubInfoPanel(mileageImage, "Mileage", Integer.toString(myCar.getMileage()));
            vehicleInfoPanel.add(vehicleMileageLabelPanel);
        }
        if (myCar.getSeatCount() > 0) {
            vehicleSeatCountLabelPanel = vehicleSubInfoPanel(seatCountImage, "No of Seats", Integer.toString(myCar.getSeatCount()));
            vehicleInfoPanel.add(vehicleSeatCountLabelPanel);
        }
        if (myCar.getRating() >= 0) {
            vehicleRatingsLabelPanel = vehicleSubInfoPanel(ratingsImage, "Ratings", Integer.toString(myCar.getRating()));
            vehicleInfoPanel.add(vehicleRatingsLabelPanel);
        }

        //vehicleInfoBoxLayoutPanel ends here
    }

    private JPanel vehicleSubInfoPanel(ImageIcon image, String imageText, String dataText) {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
        panel.setMinimumSize(labelPanelDimension);
        panel.setMaximumSize(labelPanelDimension);
        panel.setPreferredSize(labelPanelDimension);
        panel.add(Box.createRigidArea(new Dimension(5, 0)));
        panel.add(vehicleIconLabel(image));
        panel.add(vehicleImageLabel(imageText));
        panel.add(vehicleDataLabel(dataText));
        return panel;
    }

    private boolean validateCarInfoDetails(String s) {
        if (s == null || s.trim().length() == 0) {
            return false;
        }
        return true;
    }

    private JLabel vehicleIconLabel(ImageIcon image) {
        JLabel label = new JLabel();
        label.setIcon(image);
        label.setPreferredSize(iconLabelDimension);
        label.setMaximumSize(iconLabelDimension);
        label.setMinimumSize(iconLabelDimension);
        return label;
    }

    private JLabel vehicleDataLabel(String text) {
        JLabel label = new JLabel();
        label.setText(text);
        label.setPreferredSize(dataLabelDimension);
        label.setMinimumSize(dataLabelDimension);
        label.setMinimumSize(dataLabelDimension);
        label.setFont(new Font("Calibri", Font.BOLD, 16));
        return label;
    }

    private JLabel vehicleImageLabel(String text) {
        JLabel label = new JLabel();
        label.setText(text);
        label.setPreferredSize(imageLabelDimension);
        label.setMaximumSize(imageLabelDimension);
        label.setMinimumSize(imageLabelDimension);
        label.setFont(new Font("Calibri", Font.BOLD, 16));
        return label;
    }

    public void createVehicleDescriptionPanel(Car myCar) {
        //vehicleDescriptionPanel start
        vehicleDescriptionPanel = new JPanel();
        vehicleDescriptionPanel.setLayout(new BoxLayout(vehicleDescriptionPanel, BoxLayout.Y_AXIS));
        vehicleDescriptionPanel.setMaximumSize(new Dimension(916, 140));
        vehicleDescriptionPanel.setMinimumSize(new Dimension(916, 140));
        vehicleDescriptionPanel.setPreferredSize(new Dimension(916, 140));

        vehicleDescriptionPanel.setBackground(new Color(187, 187, 187));
        vehicleDescriptionPanel.setBorder(new LineBorder(Color.BLACK));

        vehicleDescriptionLabel = new JLabel();
        vehicleDescriptionLabel.setText("Vehicle Description");
        vehicleDescriptionLabel.setFont(new Font("Calibri", Font.BOLD, 16));
        vehicleDescriptionPane = new JScrollPane();
        vehicleDescriptionPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        vehicleDescriptionPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
        vehicleDescriptionPane.setMaximumSize(new Dimension(916, 120));
        vehicleDescriptionPane.setMinimumSize(new Dimension(916, 120));
        vehicleDescriptionPane.setPreferredSize(new Dimension(916, 120));
        vehicleDescriptionPane.setBackground(new Color(187, 187, 187));
//        vehicleDescriptionPane1.setBorder(new LineBorder(new Color(0, 0, 0)));

        vehicleDescriptionTextArea = new JTextArea();
        vehicleDescriptionTextArea.setMaximumSize(new Dimension(916, 120));
        vehicleDescriptionTextArea.setMinimumSize(new Dimension(916, 120));
        vehicleDescriptionTextArea.setPreferredSize(new Dimension(916, 120));
        vehicleDescriptionTextArea.setWrapStyleWord(true);
        vehicleDescriptionTextArea.setVisible(true);
        vehicleDescriptionTextArea.setLineWrap(true);
        vehicleDescriptionTextArea.setBackground(new Color(238, 238, 238));
        vehicleDescriptionTextArea.setText(myCar.getDescription());
        vehicleDescriptionTextArea.setFont(new Font("Calibri", Font.PLAIN, 13));

        vehicleDescriptionPane.setViewportView(vehicleDescriptionTextArea);

        vehicleDescriptionPanel.add(vehicleDescriptionLabel, 0);
        vehicleDescriptionPanel.add(vehicleDescriptionPane, 1);

        //vehicleDescriptionPanel ends here

    }

    public void createDealersInformationPanel(Dealer myDealer) {
        dealersInformationPanel = new JPanel();
        dealersInformationPanel.setLayout(new BoxLayout(dealersInformationPanel, BoxLayout.Y_AXIS));
        dealersInformationPanel.setMaximumSize(new Dimension(916, 70));
        dealersInformationPanel.setMinimumSize(new Dimension(916, 70));
        dealersInformationPanel.setPreferredSize(new Dimension(916, 70));

        dealersInformationPanel.setBackground(new Color(187, 187, 187));
        dealersInformationPanel.setBorder(new LineBorder(new Color(0, 0, 0)));

        dealersInformationLabel = new JLabel();
        dealersInformationLabel.setText("Dealership Information");
        dealersInformationLabel.setFont(new Font("Calibri", Font.BOLD, 16));

        dealersInformationPane = new JScrollPane();
        dealersInformationPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        dealersInformationPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
        dealersInformationPane.setMaximumSize(new Dimension(916, 60));
        dealersInformationPane.setMinimumSize(new Dimension(916, 60));
        dealersInformationPane.setPreferredSize(new Dimension(916, 60));
        dealersInformationPane.setBackground(new Color(187, 187, 187));

        dealersInformationTextArea = new JTextArea();
        dealersInformationTextArea.setMaximumSize(new Dimension(916, 100));
        dealersInformationTextArea.setMinimumSize(new Dimension(916, 100));
        dealersInformationTextArea.setPreferredSize(new Dimension(916, 100));
        dealersInformationTextArea.setBackground(new Color(238, 238, 238));
        String dealerInfo = myDealer.getDealerID() + "\n" + myDealer.getName() + "\n" + myDealer.getStreetAddress() + "\n" + myDealer.getCity() + ", " + myDealer.getStateID() + " " + myDealer.getZipcode() + "\n" + "Phone : "+myDealer.getPhoneNumber();
        dealersInformationTextArea.setText(dealerInfo);
        System.out.println(dealerInfo);
//        dealersInformationTextArea.setText("Beautiful White Frost. Abel Chevrolet Buick. Many Financing Options available. Credit Challenged? We can help! We have great relationships with many lenders which allows us to offer financing that many others can't! We're here to help you get in the vehicle you want! At Abel, we do our best to offer you an unique experience when purchasing a New or Pre-Owned vehicle. Unlike traditional car dealers, we offer a non-pressured environment giving you the time and space to make an informed decision. Our advertised prices are our best deal upfront. No Games, just fair prices and outstanding customer service. We won't waste your time! Once you've found the Abel Vehicle you're looking for, on average, you'll go from test drive to driving home in less than an hour!");
        dealersInformationTextArea.setFont(new Font("Calibri", Font.PLAIN, 13));

        dealersInformationPane.setViewportView(dealersInformationTextArea);

        dealersInformationPanel.add(dealersInformationLabel, 0);
        dealersInformationPanel.add(dealersInformationPane, 1);
    }

    public static void main(String[] args) {
        Car myCar = new Car();
        myCar.setID("1234");
        myCar.setMake("Audi");
        myCar.setModel("Acura MDX SH-AWD w/Advance");
        myCar.setYear(2010);
        myCar.setMSRP(13955);
        myCar.setCarCategory(CarCategory.USED);
        myCar.setColor("Grey");
        myCar.setEngine("3.7L V6");
        myCar.setTransmission("Automatic 6-Speed");
        myCar.setFuel("Gasoline");
        myCar.setVIN("2HNYD2H59AH533278");
        myCar.setSeatCount(4);
        myCar.setMileage(1174);
        myCar.setRating(4);
        myCar.setDescription("Beautiful White Frost. Abel Chevrolet Buick. Many Financing Options available. Credit Challenged? We can help! We have great relationships with many lenders which allows us to offer financing that many others can't! We're here to help you get in the vehicle you want! At Abel, we do our best to offer you an unique experience when purchasing a New or Pre-Owned vehicle. Unlike traditional car dealers, we offer a non-pressured environment giving you the time and space to make an informed decision. Our advertised prices are our best deal upfront. No Games, just fair prices and outstanding customer service. We won't waste your time! Once you've found the Abel Vehicle you're looking for, on average, you'll go from test drive to driving home in less than an hour!");

        Dealer myDealer = new Dealer();
        myDealer.setDealerID("D1234");
        myDealer.setName("Rairdons Honda of Sumner");
        myDealer.setStreetAddress("16302 Auto Lane");
        myDealer.setCity("Sumner");
        myDealer.setState("Washington");
        myDealer.setStateID("WA");
        myDealer.setPhoneNumber("(855) 661-4448");

//        ViewVehicleDetails carDetails = new ViewVehicleDetails(myCar, myDealer);
        ViewVehicleDetails carDetails = new ViewVehicleDetails("1");
        carDetails.showVehicleDetails();

    }
}