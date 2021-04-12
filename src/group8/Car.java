package group8;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jasmineshin
 */
public class Car {
    
    private String id;
    private String make;
    private String model;
    private int year;
    private double msrp;
    private boolean used;
    private String color;
    private String location;
    private int mileage;
    private double discount = 1.0;

    //engine
    //picture
    
    public Car(String id, String make, String model, int year, double msrp, boolean used,
                String color, String location, int mileage){
        this.id = id;
        this.make = make;
        this.model = model;
        this.year = year;
        this.msrp = msrp;
        this.used = used;
        this.color = color;
        this.location = location;
        this.mileage = mileage;
    }
    
    /*******************  GETTER  *******************/
    public String getID(){
        return id;
    }
    public String getMake(){
        return make;
    }
    public String getModel(){
        return model;
    }
    public int getYear(){
        return year;
    }
    public double getMSRP(){
        return msrp;
    }
    public boolean isUsed(){
        return used;
    }
    public String getColor(){
        return color;
    }
    public String getLocation(){
        return location;
    }
    public int getMileage(){
        return mileage;
    }
    public double getPriceAfterDiscount(){
        return msrp * discount;
    }
    
    /*******************  SETTER  *******************/
    public void setID(String id){
        this.id = id;
    }
    public void setMake(String make){
        this.make = make;
    }
    public void setModel(String model){
        this.model = model;
    }
    public void setYear(int year){
        this.year = year;
    }
    public void setMSRP(double msrp){
        this.msrp = msrp;
    }
    public void setUsed(boolean used){
        this.used = used;
    }
    public void setColor(String color){
        this.color = color;
    }
    public void setLocation(String location){
        this.location = location;
    }
    public void setMileage(int mileage){
        this.mileage =  mileage;
    }
    public void setDiscount(double discount){
        this.discount = discount;
    }
}
