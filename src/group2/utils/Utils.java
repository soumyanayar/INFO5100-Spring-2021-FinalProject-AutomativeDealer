package group2.utils;


import group8.Car;
import group8.CarCategory;
import group8.Dealer;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.*;

public class Utils {

    static public List<Map<String, Object>> resultSetToList(ResultSet rs) throws SQLException {
        ResultSetMetaData md = rs.getMetaData();
        int columns = md.getColumnCount();
        List<Map<String, Object>> rows = new ArrayList<Map<String, Object>>();
        while (rs.next()){
            Map<String, Object> row = new HashMap<String, Object>(columns);
            for(int i = 1; i <= columns; ++i){
                row.put(md.getColumnName(i), rs.getObject(i));
            }
            rows.add(row);
        }
        return rows;
    }

    static public Car transToCar(Map<String, Object> map) {
        Car car = new Car();
        car.setID(String.valueOf(map.get("vehicle_id")));
        car.setMake(String.valueOf(map.get("make_name")));
        car.setModel(String.valueOf(map.get("model_name")));
//        car.setName(String.valueOf(map.get("make_name")) + String.valueOf(map.get("model_name")));
//        String year = String.valueOf(map.get("year"));
        if (map.get("year") != null) {
            car.setYear(Integer.parseInt(String.valueOf(map.get("year"))));
        }

        if (map.get("price") != null) {
            car.setMSRP(Double.parseDouble(String.valueOf(map.get("price"))));
        }

        if (String.valueOf(map.get("category")).equals("New")){
            car.setCarCategory(CarCategory.USED);
        } else if (String.valueOf(map.get("category")).equals("Used")){
            car.setCarCategory(CarCategory.USED);
        }

        car.setColor(String.valueOf(map.get("color")));

        car.setEngine(String.valueOf(map.get("engine")));
        car.setTransmission(String.valueOf(map.get("transmission")));
        car.setFuel(String.valueOf(map.get("fuel")));
        car.setVIN(String.valueOf(map.get("vin")));
        if (map.get("stock") != null) {
            car.setStockNum(String.valueOf(map.get("stock")));
        }
        if (map.get("seat_count") != null) {
            car.setSeatCount(Integer.valueOf(String.valueOf(map.get("seat_count"))));
        }
        if (map.get("miles") != null) {
            car.setMileage(Integer.valueOf(String.valueOf(map.get("miles"))));
        }

        if (map.get("rating") != null) {
            car.setRating(Integer.valueOf(String.valueOf(map.get("rating"))));
        }
        if (map.get("description") != null) {
            car.setDescription(String.valueOf(map.get("description")));
        }

        String urls = String.valueOf(map.get("image_urls"));
        final String[] arr = urls.split(",");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = "src/group2/images/" + arr[i];
        }
        car.setImages(Arrays.asList(arr));

        return car;
    }

    static public Car transToCarV2(Map<String, Object> map) {
        Car car = new Car();
        car.setID(String.valueOf(map.get("VehicleId")));
        car.setMake(String.valueOf(map.get("Make")));
        car.setModel(String.valueOf(map.get("Model")));
//        car.setName(String.valueOf(map.get("make_name")) + String.valueOf(map.get("model_name")));
        String year = String.valueOf(map.get("Year"));
        if (year != null) {
            car.setYear(Integer.parseInt(year));
        }


        car.setMSRP(Double.parseDouble(String.valueOf(map.get("Price"))));
        if (String.valueOf(map.get("Category")).equals("New")){
            car.setCarCategory(CarCategory.USED);
        } else if (String.valueOf(map.get("Category")).equals("Used")){
            car.setCarCategory(CarCategory.USED);
        }

        car.setColor(String.valueOf(map.get("Color")));

        car.setEngine(String.valueOf(map.get("engine")));
        car.setTransmission(String.valueOf(map.get("transmission")));
        car.setFuel(String.valueOf(map.get("fuel")));
        car.setVIN(String.valueOf(map.get("VIN")));
        if (map.get("stock") != null) {
            car.setStockNum(String.valueOf(map.get("stock")));
        }
        if (map.get("seat_count") != null) {
            car.setSeatCount(Integer.valueOf(String.valueOf(map.get("seat_count"))));
        }
        if (map.get("Miles") != null) {
            car.setMileage(Integer.valueOf(String.valueOf(map.get("Miles"))));
        }

        if (map.get("Ratings") != null) {
            car.setRating(Integer.valueOf(String.valueOf(map.get("Ratings"))));
        }
        if (map.get("description") != null) {
            car.setDescription(String.valueOf(map.get("description")));
        }

        String urls = String.valueOf(map.get("image_urls"));
        final String[] arr = urls.split(",");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = "src/group2/images/" + arr[i];
        }
        car.setImages(Arrays.asList(arr));

        return car;
    }

    static public Dealer transToDealer(Map<String, Object> map) {
        Dealer dealer = new Dealer();
        dealer.setName(String.valueOf(map.get("DealerName")));
        dealer.setStreetAddress(String.valueOf(map.get("DealerAddress")));
        dealer.setCity(String.valueOf(map.get("City")));
        dealer.setState(String.valueOf(map.get("State")));
        dealer.setCountry(String.valueOf(map.get("Country")));


        return dealer;
    }



}
