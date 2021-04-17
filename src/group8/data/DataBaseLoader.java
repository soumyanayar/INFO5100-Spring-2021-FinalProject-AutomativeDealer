/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package group8.data;

import group8.Car;
import group8.CarCategory;
import group8.Dealer;
import group8.DealerDirectory;
import java.sql.Blob;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.sql.rowset.serial.SerialBlob;

/**
 *
 * @author jasmineshin
 */
public class DataBaseLoader {
    
    private NewJDBC database;
    private DealerDirectory dir;

    public DataBaseLoader() throws SQLException, ClassNotFoundException {
        database = NewJDBC.getInstance();
        dir = new DealerDirectory();
        loadDealerDirectory();
        loadCarToDealerInventory();
    }
    
    // loads all dealer from Dealer.csv into dealer directory
    private void loadDealerDirectory() throws SQLException{
//        dir.clearAll();
//        ResultSet s = database.getAllDealers();
//        // fetch each line and add new dealer into dealer directory
//        while(s.next()){
//            String dealerID = s.getString(1);
//            String name = s.getString(2);
//            String address = s.getString(3);
//            String number = s.getString(4);
//            String zip = s.getString(5).substring(2);
//            String state = s.getString(5).substring(0, 2);
//            String city = s.getString(6);
//            String country = s.getString(7);
//            Dealer dealer = new Dealer(dealerID, name, address, number, zip, state, city, country);
//            dir.addDealer(dealerID, dealer);
//        }
    }
    
    // loads all car to dealer's inventory
    private void loadCarToDealerInventory() throws SQLException{
//        ResultSet s = database.getAllCars();
//        while(s.next()){
//            String stockID = s.getString(1);
//            String VIN = s.getString(2);
//            String dealerID = s.getString(3);
//            String make = s.getString(4);
//            String model = s.getString(5);
//            int year = s.getInt(6);
//            CarCategory category = s.getString(7).equals("New") ? CarCategory.NEW : CarCategory.USED;
//            double msrp = s.getDouble(8);
//            String color = s.getString(9);
//            int miles = s.getInt(10);
//            String img = s.getString(11);
//            byte[] content = img.getBytes();
//            Blob blob = new SerialBlob(content);
//            String incentiveId = s.getString(12);
//            String discountPrice = s.getString(13);
//            int rating = s.getInt(14);
//            Car c = new Car(stockID, VIN, dealerID, make, model, year, category, msrp, color, miles, blob, incentiveId, discountPrice, rating);
//            dir.addCarToDealer(dealerID, c);
//        }
    }
    
    public DealerDirectory getDealerDirectory(){
        return dir;
    }
    
}
