package group4.dao;

import group4.entity.Vehicle;

import java.util.List;

public interface VehicleDao {
    boolean add(Vehicle vehicle);

    boolean update(Vehicle vehicle);

    boolean delete(int vehicleId);

    Vehicle queryByID(int vehicleId);

    List<Vehicle> queryAll();
}
