package group5.DAO;

import java.sql.Blob;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.rowset.serial.SerialBlob;

import group8.Car;
import group8.CarCategory;

public class CarDAO {

	DBConnector dbCon = new DBConnector();
	private ArrayList<Car> completeList=new ArrayList<Car>();
	
	/*
	 * public ArrayList<Car> getAllCars() throws SQLException { String query =
	 * "select * from NewVehicleData"; ResultSet rs = dbCon.queryExecution(query);
	 * while (rs.next()) { VehicleDetails vehicle = new VehicleDetails();
	 * 
	 * vehicle.setId(rs.getString(1)); vehicle.setBrand(rs.getString(3));
	 * vehicle.setModel(rs.getString(4)); vehicle.setYear(rs.getString(5));
	 * vehicle.setType(rs.getString(6)); String category = rs.getString(7); //
	 * rs.getBLO if (category.equals("NEW")) { vehicle.setCategory("NEW"); } else {
	 * vehicle.setCategory("USED"); } vehicle.setColor(rs.getString(8)); float price
	 * = Float.parseFloat(rs.getString(9)); vehicle.setPrice(price); float mileage =
	 * Float.parseFloat(rs.getString(10)); vehicle.setMileage(mileage);
	 * completeList.add(vehicle); }
	 * 
	 * return completeList; }
	 */
	
	
	public ArrayList<Car> getAllCarsByDealerId() throws SQLException {
        ArrayList<Car> result = new ArrayList<Car>();
        String query = "Select * from NewVehicleData ";
        ResultSet rs = dbCon.queryExecution(query);
        try {
            
            while (rs.next()) {
                // Car(String stockID, String VIN, String dealerID, String make, String model,
                // int year, CarCategory category, double price, String color, int mileage,
                // Blob img, String incentiveID, String discountPrice, int rating)
                String stockID = rs.getString(1);
                String VIN = rs.getString(2);
                String dealerID = rs.getString(3);
                String make = rs.getString(4);
                String model = rs.getString(5);
                int year = rs.getInt(6);
                CarCategory category = rs.getString(7).equals("New") ? CarCategory.NEW : CarCategory.USED;
                double msrp = rs.getDouble(8);
                String color = rs.getString(9);
                int miles = rs.getInt(10);
                String img = rs.getString(11);
                byte[] content = img.getBytes();
                Blob blob = new SerialBlob(content);
                String incentiveId = rs.getString(12);
                String discountPrice = rs.getString(13);
                int rating = rs.getInt(14);
                Car c = new Car(stockID, VIN, dealerID, make, model, year, category, msrp, color, miles, blob,
                        incentiveId, discountPrice, rating);
                result.add(c);
            }

        } catch (SQLException e) {
            System.out.println(e);
          //  System.out.println("No result for Dealer with Id : " + dealerId);
            return null;
        }
        return result;
    }
}
