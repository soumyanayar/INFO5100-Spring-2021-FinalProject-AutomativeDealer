package group4.dao.impl;

import group4.dao.VehicleDao;
import group4.entity.Vehicle;
import group4.util.DBCon;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import group4.gui.frame.MenuFrame;

public class VehicleDaoImpl implements VehicleDao {
    DBCon dbCon = new DBCon();
    private final String DBNAME = "vehicle_test";

    private Vehicle setData(ResultSet rs){
        Vehicle vehicle = new Vehicle();
        try {
            vehicle.setVehicleID(rs.getInt("vehicle_id"));
            vehicle.setVin(rs.getInt("vin"));
            vehicle.setDealerID(rs.getInt("dealer_id"));
            vehicle.setMakeID(rs.getInt("make_id"));
            vehicle.setModelID(rs.getInt("model_id"));
            vehicle.setYear(rs.getInt("year"));
            vehicle.setCategory(rs.getString("category"));
            vehicle.setPrice(rs.getDouble("price"));
            vehicle.setColor(rs.getString("color"));
            vehicle.setMiles(rs.getInt("miles"));
            vehicle.setRating(rs.getInt("rating"));
            vehicle.setImageUrls(rs.getString("image_urls"));
            vehicle.setEngine(rs.getString("engine"));
            vehicle.setDescription(rs.getString("description"));
            vehicle.setTransmission(rs.getString("transmission"));
            vehicle.setStock(rs.getInt("stock"));
            vehicle.setSeatCount(rs.getInt("seat_count"));
            vehicle.setFuel(rs.getString("fuel"));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return vehicle;
    }

    private List<Vehicle> getVehicleList(ResultSet rs){
        List<Vehicle> vehicleList = new ArrayList<Vehicle>();
        try {
            while(rs.next()){
                vehicleList.add(setData(rs));
            }
        } catch (SQLException e){
            e.printStackTrace();
        } finally {
            dbCon.closeAll();
        }
        return vehicleList;
    }

    private Vehicle getVehicleEntity(ResultSet rs){
        Vehicle vehicle = null;
        try {
            if(rs.next()){
                vehicle = setData(rs);
            }
        } catch (SQLException e){
            e.printStackTrace();
        } finally {
            dbCon.closeAll();
        }
        return vehicle;
    }

    @Override
    public boolean add(Vehicle vehicle) {
        return dbCon.update("INSERT INTO "+DBNAME+"(vehicle_id,vin,dealer_id,make_id,model_id,year,category,price,color,miles,rating,image_urls,engine,description,transmission,stock,seat_count,fuel) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)", vehicle.getVehicleID(), vehicle.getVin(),vehicle.getDealerID(), vehicle.getMakeID(), vehicle.getModelID(),vehicle.getYear(), vehicle.getCategory(), vehicle.getPrice(), vehicle.getColor(), vehicle.getMiles(), vehicle.getRating(), vehicle.getImageUrls(), vehicle.getEngine(), vehicle.getDescription(), vehicle.getTransmission(), vehicle.getStock(), vehicle.getSeatCount(),vehicle.getFuel()) > 0;
    }

    @Override
    public boolean update(Vehicle vehicle) {
        return dbCon.update("UPDATE "+DBNAME+" SET vin=?,dealer_id=?,make_id=?,model_id=?,year=?,category=?,price=?,color=?,miles=?,rating=?,image_urls=?,engine=?,description=?,transmission=?,stock=?,seat_count=?,fuel=? WHERE vehicle_id=?", vehicle.getVin(),vehicle.getDealerID(), vehicle.getMakeID(), vehicle.getModelID(),vehicle.getYear(), vehicle.getCategory(), vehicle.getPrice(), vehicle.getColor(), vehicle.getMiles(), vehicle.getRating(), vehicle.getImageUrls(), vehicle.getEngine(), vehicle.getDescription(), vehicle.getTransmission(), vehicle.getStock(), vehicle.getSeatCount(),vehicle.getFuel(),vehicle.getVehicleID()) > 0;
    }

    @Override
    public boolean delete(int vehicleId) {
        return dbCon.update("DELETE FROM "+DBNAME+" WHERE vehicle_id=?", vehicleId) > 0;
    }

    @Override
    public Vehicle queryByID(int vehicleId) {
        return getVehicleEntity(dbCon.query("SELECT * FROM " + DBNAME + " WHERE vehicle_id=?", vehicleId));
    }

    @Override
    public List<Vehicle> queryAll() {
        if (Objects.equals(MenuFrame.dealerID, "all")){
            return getVehicleList(dbCon.query("SELECT * FROM " + DBNAME));
        } else{
            return getVehicleList(dbCon.query("SELECT * FROM " + DBNAME + " WHERE dealer_id = " + MenuFrame.dealerID));
        }
    }

    public static void main(String[] args) {
        VehicleDaoImpl test = new VehicleDaoImpl();
//        Vehicle vehicle = test.queryByID(1);
//        System.out.println(vehicle);
        List<Vehicle> vehicleList = test.queryAll();
        System.out.println(vehicleList);
    }
}
