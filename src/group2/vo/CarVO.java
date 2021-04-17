package group2.vo;

import java.util.List;
import java.util.Map;

public class CarVO {
    private Integer carId;
    private String name;
    private Double MSRP;
    private Integer mileage;
    private List<String> images;
    private Boolean condition;
    private String engine;
    private String transmission;
    private String driveTrain;
    private String fuel;
    private String exteriorImage;
    private String interiorImage;
    private Integer stock;
    private String description;
    private Double fuelEconomyCity;
    private Double fuelEconomyHighWay;
    private Map<String, Object> extraFeature;
    private Integer dealerId;

    public Integer getCarId() {
        return carId;
    }

    public void setCarId(Integer carId) {
        this.carId = carId;
    }

    public Integer getDealerId() {
        return dealerId;
    }

    public void setDealerId(Integer dealerId) {
        this.dealerId = dealerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getMSRP() {
        return MSRP;
    }

    public void setMSRP(Double MSRP) {
        this.MSRP = MSRP;
    }

    public Integer getMileage() {
        return mileage;
    }

    public void setMileage(Integer mileage) {
        this.mileage = mileage;
    }

    public List<String> getImages() {
        return images;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }

    public Boolean getCondition() {
        return condition;
    }

    public void setCondition(Boolean condition) {
        this.condition = condition;
    }

    public String getEngine() {
        return engine;
    }

    public void setEngine(String engine) {
        this.engine = engine;
    }

    public String getTransmission() {
        return transmission;
    }

    public void setTransmission(String transmission) {
        this.transmission = transmission;
    }

    public String getDriveTrain() {
        return driveTrain;
    }

    public void setDriveTrain(String driveTrain) {
        this.driveTrain = driveTrain;
    }

    public String getFuel() {
        return fuel;
    }

    public void setFuel(String fuel) {
        this.fuel = fuel;
    }

    public String getExteriorImage() {
        return exteriorImage;
    }

    public void setExteriorImage(String exteriorImage) {
        this.exteriorImage = exteriorImage;
    }

    public String getInteriorImage() {
        return interiorImage;
    }

    public void setInteriorImage(String interiorImage) {
        this.interiorImage = interiorImage;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getFuelEconomyCity() {
        return fuelEconomyCity;
    }

    public void setFuelEconomyCity(Double fuelEconomyCity) {
        this.fuelEconomyCity = fuelEconomyCity;
    }

    public Double getFuelEconomyHighWay() {
        return fuelEconomyHighWay;
    }

    public void setFuelEconomyHighWay(Double fuelEconomyHighWay) {
        this.fuelEconomyHighWay = fuelEconomyHighWay;
    }

    public Map<String, Object> getExtraFeature() {
        return extraFeature;
    }

    public void setExtraFeature(Map<String, Object> extraFeature) {
        this.extraFeature = extraFeature;
    }
}
