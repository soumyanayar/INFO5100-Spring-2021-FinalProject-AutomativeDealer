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
import group4.util.GUIUtil;

import javax.swing.*;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class TablePanel extends JPanel implements ActionListener {
    public static TablePanel instance = new TablePanel();
    private JTable table;
    private DefaultTableModel model;
    private VehicleDao vehicleDao;
    private MakeDao makeDao;
    private ModelDao modelDao;
    private String oldValue = "";
    private JButton btnDel;

    public TablePanel() {
        setLayout(new BorderLayout(0,0));
        JScrollPane scrollPane = new JScrollPane();
        add(scrollPane, BorderLayout.CENTER);

        table = new JTable();
        scrollPane.setColumnHeaderView(table);

        model = new DefaultTableModel(new Object[][] {}, new String[] {"Vehicle ID", "VIN", "Dealer ID", "Make ID", "Model ID", "Year", "Category","Price","Color","Miles","Rating","Image", "Engine", "Description", "Transmission","Stock","Seat Count","Fuel"});

        table.setModel(model);
        table.setRowHeight(40);

        scrollPane.setViewportView(table);

        makeDao = new MakeDaoImpl();
        modelDao = new ModelDaoImpl();
        vehicleDao = new VehicleDaoImpl();
        loadData();

        btnDel = new JButton("Delete Selected");
        JPanel flowPanel = new JPanel(new FlowLayout());
        flowPanel.add(btnDel);
        add(flowPanel,BorderLayout.SOUTH);
        btnDel.setActionCommand("del");

        btnDel.addActionListener(this);

        model.addTableModelListener(new TableModelListener() {

            @Override
            public void tableChanged(TableModelEvent e) {
                if (e.getColumn() < 0)
                    return;
                String nVal = table.getValueAt(e.getLastRow(), e.getColumn())
                        .toString();

                if (nVal.equals(oldValue)) {
                    return;
                }

                if (e.getColumn() == 0) {

                    table.setValueAt(oldValue, e.getLastRow(), e.getColumn());
                    return;
                }

                Vehicle vehicle = new Vehicle();
                vehicle.setVehicleID(Integer.valueOf(table.getValueAt(e.getLastRow(),0).toString()));
                vehicle.setVin(Integer.valueOf(table.getValueAt(e.getLastRow(), 1).toString()));
                vehicle.setDealerID(Integer.valueOf(table.getValueAt(e.getLastRow(), 2).toString()));
                Make make = (Make) table.getValueAt(e.getLastRow(), 3);
                vehicle.setMakeID(make.getMakeID());
                Model model = (Model) table.getValueAt(e.getLastRow(), 4);
                vehicle.setModelID(model.getModelID());
                vehicle.setYear(Integer.valueOf(table.getValueAt(e.getLastRow(), 5).toString()));
                vehicle.setCategory(table.getValueAt(e.getLastRow(),6).toString());
                vehicle.setPrice(Double.valueOf(table.getValueAt(e.getLastRow(),7).toString()));
                vehicle.setColor(table.getValueAt(e.getLastRow(),8).toString());
                vehicle.setMiles(Integer.valueOf(table.getValueAt(e.getLastRow(),9).toString()));
                vehicle.setRating(Integer.valueOf(table.getValueAt(e.getLastRow(), 10).toString()));
                vehicle.setImageUrls(table.getValueAt(e.getLastRow(), 11).toString());
                vehicle.setEngine(table.getValueAt(e.getLastRow(), 12).toString());
                vehicle.setDescription(table.getValueAt(e.getLastRow(), 13).toString());
                vehicle.setTransmission(table.getValueAt(e.getLastRow(), 14).toString());
                vehicle.setStock(Integer.valueOf(table.getValueAt(e.getLastRow(), 15).toString()));
                vehicle.setSeatCount(Integer.valueOf(table.getValueAt(e.getLastRow(), 16).toString()));
                vehicle.setFuel(table.getValueAt(e.getLastRow(), 17).toString());

                vehicleDao.update(vehicle);
                loadData();
            }
        });
    }

    public void loadData() {
        model.getDataVector().clear();
        List<Make> makeList = makeDao.queryAll();
        JComboBox cmbMake = new JComboBox(makeList.toArray());
        DefaultCellEditor makeID = new DefaultCellEditor(cmbMake);


        List<Model> modelList = modelDao.queryAll();
        JComboBox cmbModel = new JComboBox(modelList.toArray());
        DefaultCellEditor modelID = new DefaultCellEditor(cmbModel);

        ArrayList<String> yearList = new ArrayList<String>();
        for(int years = 1980; years<= Calendar.getInstance().get(Calendar.YEAR); years++) {
            yearList.add(years+"");
        }
        JComboBox cmbYear = new JComboBox(yearList.toArray());
        DefaultCellEditor year = new DefaultCellEditor(cmbYear);

        TableColumnModel col = table.getColumnModel();

        col.getColumn(3).setCellEditor(makeID);
        col.getColumn(4).setCellEditor(modelID);
        col.getColumn(5).setCellEditor(year);

        List<Vehicle> vehicleList = vehicleDao.queryAll();

        for (Vehicle vehicle: vehicleList){
            cmbMake.setSelectedItem(new Make(vehicle.getMakeID()));
//            List<Model> modelMatchMakeList = modelDao.queryByMakeID(vehicle.getMakeID());
//            for(Model model: modelMatchMakeList){
//                if(model.equals(new Model(vehicle.getModelID()))){
//                    cmbModel.addItem(model);
//                }
//            }
            cmbModel.setSelectedItem(new Model(vehicle.getModelID()));
            model.addRow(new Object[] {
        vehicle.getVehicleID(),vehicle.getVin(),vehicle.getDealerID(),cmbMake.getSelectedItem(), cmbModel.getSelectedItem(),vehicle.getYear(),vehicle.getCategory(),vehicle.getPrice(),vehicle.getColor(),vehicle.getMiles(),vehicle.getRating(),vehicle.getImageUrls(),vehicle.getEngine(),vehicle.getDescription(),vehicle.getTransmission(),vehicle.getStock(),vehicle.getSeatCount(),vehicle.getFuel()
    });

}
    }

    public void del() {
        if (table.getSelectedRowCount() <= 0) {
            JOptionPane.showMessageDialog(null, "Please select the line to delete");
            return;
        }
        int result = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete it?");

        if (result == JOptionPane.OK_OPTION) {
            int vehicleID = Integer.valueOf(table.getValueAt(table.getSelectedRow(), 0).toString());
            vehicleDao.delete(vehicleID);
            loadData();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command=e.getActionCommand();
        System.out.println(command);
        if(command.equals("del")){
            if(table==null){
                JOptionPane.showMessageDialog(null, "No data");
                return;
            }
            del();
        }

    }

    public static void main(String[] args) {
        GUIUtil.showPanel(TablePanel.instance,1);
    }
}
