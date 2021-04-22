package group4.gui.panel;

import group4.dao.MakeDao;
import group4.dao.ModelDao;
import group4.dao.VehicleDao;
import group4.dao.impl.MakeDaoImpl;
import group4.dao.impl.ModelDaoImpl;
import group4.dao.impl.VehicleDaoImpl;
import group4.entity.Make;
import group4.entity.Model;
import group4.entity.Vehicle;
import group4.gui.frame.MainFrame;
import group4.util.GUIUtil;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Objects;

public class AddPanel extends JPanel {
    public static AddPanel instance = new AddPanel();
    private JTextField txtVehicleID;
    private JTextField txtVin;
    private JTextField txtDealerID;
    private JComboBox cmbMake;
    private JComboBox cmbModel;
    private JComboBox cmbYear;
    private JTextField txtCategory;
    private JTextField txtPrice;
    private JTextField txtColor;
    private JTextField txtMiles;
    private JTextField txtRating;
    private JTextField txtImageUrls;
    private JTextField txtEngine;
    private JTextField txtTransmission;
    private JTextField txtStock;
    private JTextField txtSeatCount;
    private JTextField txtFuel;
    private JTextArea txtDescription;

    private VehicleDao vehicleDao;
    private MakeDao makeDao;
    private ModelDao modelDao;
    private TablePanel tablePanel;
    private MainFrame main;

    public AddPanel() {
        setLayout(null);

        JLabel label_1 = new JLabel("Vehicle ID:");
        label_1.setBounds(530, 40, 160, 20);
        add(label_1);

        txtVehicleID = new JTextField();
        txtVehicleID.setBounds(600, 40, 150, 20);
        add(txtVehicleID);
        txtVehicleID.setColumns(10);

        JLabel label_2 = new JLabel("Vin:");
        label_2.setBounds(530, 65, 60, 20);
        add(label_2);

        txtVin = new JTextField();
        txtVin.setBounds(600, 65, 150, 20);
        add(txtVin);
        txtVin.setColumns(10);

        JLabel label_3 = new JLabel("Dealer ID:");
        label_3.setBounds(530, 90, 160, 15);
        add(label_3);

        txtDealerID = new JTextField();
        txtDealerID.setBounds(600, 90, 150, 20);
        add(txtDealerID);
        txtDealerID.setColumns(10);

        JLabel label_4 = new JLabel("Make:");
        label_4.setBounds(530, 115, 60, 20);
        add(label_4);

        makeDao = new MakeDaoImpl();
        List<Make> makeList = makeDao.queryAll();
        cmbMake = new JComboBox(makeList.toArray());
        cmbMake.setBounds(600, 115, 155, 20);
        add(cmbMake);

        JLabel label_5 = new JLabel("Model:");
        label_5.setBounds(530, 140, 60, 20);
        add(label_5);

        modelDao = new ModelDaoImpl();
        List<Model> modelList = modelDao.queryAll();
        cmbModel = new JComboBox(modelList.toArray());
        cmbModel.setBounds(600, 140, 155, 20);
        add(cmbModel);

        JLabel label_6 = new JLabel("Year:");
        label_6.setBounds(530, 165, 60, 20);
        add(label_6);

        ArrayList<String> years_tmp = new ArrayList<String>();
        for(int years = 1980; years<= Calendar.getInstance().get(Calendar.YEAR); years++) {
            years_tmp.add(years+"");
        }
        cmbYear = new JComboBox(years_tmp.toArray());
        cmbYear.setBounds(600, 165, 155, 20);
        add(cmbYear);

        JLabel label_7 = new JLabel("Category:");
        label_7.setBounds(530, 190, 60, 20);
        add(label_7);

        txtCategory = new JTextField();
        txtCategory.setBounds(600, 190, 150, 20);
        add(txtCategory);
        txtCategory.setColumns(10);

        JLabel label_8 = new JLabel("Price:");
        label_8.setBounds(530, 215, 60, 20);
        add(label_8);

        txtPrice = new JTextField();
        txtPrice.setBounds(600, 215, 150, 20);
        add(txtPrice);
        txtPrice.setColumns(10);

        JLabel label_9 = new JLabel("Color:");
        label_9.setBounds(530, 240, 60, 20);
        add(label_9);

        txtColor = new JTextField();
        txtColor.setBounds(600, 240, 150, 20);
        add(txtColor);
        txtColor.setColumns(10);

        JLabel label_10 = new JLabel("Miles:");
        label_10.setBounds(800, 65, 80, 20);
        add(label_10);

        txtMiles = new JTextField();
        txtMiles.setBounds(890, 65, 150, 20);
        add(txtMiles);
        txtMiles.setColumns(10);

        JLabel label_11 = new JLabel("Rating:");
        label_11.setBounds(800, 90, 80, 20);
        add(label_11);

        txtRating = new JTextField();
        txtRating.setBounds(890, 90, 150, 20);
        add(txtRating);
        txtRating.setColumns(10);

        JLabel label_12 = new JLabel("Image Urls:");
        label_12.setBounds(800, 115, 80, 20);
        add(label_12);

        txtImageUrls = new JTextField();
        txtImageUrls.setBounds(890, 115, 150, 20);
        add(txtImageUrls);
        txtImageUrls.setColumns(10);

        JLabel label_13 = new JLabel("Engine:");
        label_13.setBounds(800, 140, 80, 20);
        add(label_13);

        txtEngine = new JTextField();
        txtEngine.setBounds(890, 140, 150, 20);
        add(txtEngine);
        txtEngine.setColumns(10);

        JLabel label_14 = new JLabel("Transmission:");
        label_14.setBounds(800, 165, 160, 20);
        add(label_14);

        txtTransmission = new JTextField();
        txtTransmission.setBounds(890, 165, 150, 20);
        add(txtTransmission);
        txtTransmission.setColumns(10);

        JLabel label_15 = new JLabel("Stock:");
        label_15.setBounds(800, 190, 80, 20);
        add(label_15);

        txtStock = new JTextField();
        txtStock.setBounds(890, 190, 150, 20);
        add(txtStock);
        txtStock.setColumns(10);

        JLabel label_16 = new JLabel("Seat Count:");
        label_16.setBounds(800, 215, 80, 20);
        add(label_16);

        txtSeatCount = new JTextField();
        txtSeatCount.setBounds(890, 215, 150, 20);
        add(txtSeatCount);
        txtSeatCount.setColumns(10);

        JLabel label_17 = new JLabel("Fuel:");
        label_17.setBounds(800, 240, 80, 20);
        add(label_17);

        txtFuel = new JTextField();
        txtFuel.setBounds(890, 240, 150, 20);
        add(txtFuel);
        txtFuel.setColumns(10);

        JLabel label_18 = new JLabel("Car Description:");
        label_18.setBounds(530, 290, 160, 20);
        add(label_18);

        txtDescription = new JTextArea(3,10);
        txtDescription.setLineWrap(true);
        txtDescription.setWrapStyleWord(true);
        txtDescription.setBounds(640, 290, 400, 50);
        //add(txtVehicleDesc);
        //txtVehicleDesc.setColumns(10);
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(640, 290, 400, 60);
        scrollPane.setViewportView(txtDescription);
        add(scrollPane);

        JButton btnNewButton = new JButton("Add");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                int vehicleID = Integer.parseInt(txtVehicleID.getText());
                int vin = Integer.parseInt(txtVin.getText());
                int dealerID = Integer.parseInt(txtDealerID.getText());
                Make make = (Make) cmbMake.getSelectedItem();
                Model model = (Model) cmbModel.getSelectedItem();
                int year = Integer.parseInt(Objects.requireNonNull(cmbYear.getSelectedItem()).toString());
                String category = txtCategory.getText();
                double price = Double.parseDouble(txtPrice.getText());
                String color = txtColor.getText();
                int miles = Integer.parseInt(txtMiles.getText());
                int rating = Integer.parseInt(txtRating.getText());
                String imageUrls = txtImageUrls.getText();
                String engine = txtEngine.getText();
                String transmission = txtTransmission.getText();
                int stock = Integer.parseInt(txtStock.getText());
                int seatCount = Integer.parseInt(txtSeatCount.getText());
                String fuel = txtFuel.getText();
                String description = txtDescription.getText();

                Vehicle vehicle=new Vehicle();
                vehicle.setVehicleID(vehicleID);
                vehicle.setVin(vin);
                vehicle.setDealerID(dealerID);
                vehicle.setMakeID(Objects.requireNonNull(make).getMakeID());
                vehicle.setModelID(Objects.requireNonNull(model).getModelID());
                vehicle.setYear(year);
                vehicle.setCategory(category);
                vehicle.setPrice(price);
                vehicle.setColor(color);
                vehicle.setMiles(miles);
                vehicle.setRating(rating);
                vehicle.setImageUrls(imageUrls);
                vehicle.setEngine(engine);
                vehicle.setTransmission(transmission);
                vehicle.setStock(stock);
                vehicle.setSeatCount(seatCount);
                vehicle.setFuel(fuel);
                vehicle.setDescription(description);

                vehicleDao = new VehicleDaoImpl();

                if(vehicleDao.add(vehicle)){
                    JOptionPane.showMessageDialog(null, "Successfully added");
                    txtVehicleID.setText("");
                    txtVin.setText("");
                    txtDealerID.setText("");
                    cmbMake.setSelectedIndex(0);
                    cmbModel.setSelectedIndex(0);
                    cmbYear.setSelectedIndex(0);
                    txtCategory.setText("");
                    txtPrice.setText("");
                    txtColor.setText("");
                    txtMiles.setText("");
                    txtRating.setText("");
                    txtImageUrls.setText("");
                    txtEngine.setText("");
                    txtTransmission.setText("");
                    txtStock.setText("");
                    txtSeatCount.setText("");
                    txtFuel.setText("");
                    txtDescription.setText("");

                }else{
                    JOptionPane.showMessageDialog(null, "Fail to add");
                }

            }
        });
        btnNewButton.setBounds(950, 360, 116, 23);
        add(btnNewButton);

    }

    public static void main(String[] args) {
        GUIUtil.showPanel(AddPanel.instance,1);
    }
}