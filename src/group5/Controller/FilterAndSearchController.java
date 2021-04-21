package group5.Controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Vector;

import group5.DAO.CarDAO;
import group8.Car;
import group5.DTO.VehicleDetails;
import group5.service.CarService;
import group8.data.DbDealerStorage;

public class FilterAndSearchController {
	
	DbDealerStorage carDAO;
	CarService carService= new CarService();
	
	public FilterAndSearchController() throws ClassNotFoundException, SQLException {
		 carDAO =new DbDealerStorage();
	}

	public ArrayList<Car> getAllCars(String dealerID) throws SQLException{
		List<group8.Car> list=carDAO.getAllCarsByDealerId(dealerID);
		ArrayList<Car> arrlist = new ArrayList(list);
		return arrlist;	
		}
	
	 public Vector<String> getValidOption(String filterName, ArrayList<Car> completeList) {
		 return carService.getOptionsFromAllCars(filterName,completeList);
	 }
	 
	 public ArrayList<Car> getSearchedData(String searchKeyWord,ArrayList<Car> completeCarList) {
		 return carService.getSearchedData(searchKeyWord,completeCarList);
	 }
	 
	 public ArrayList<Car> getFilteredData(HashMap<String, String> searchParamsMap,ArrayList<group8.Car> completeList) {
		 return carService.getFilteredData(searchParamsMap, completeList);
	 }
		 
	 
}
