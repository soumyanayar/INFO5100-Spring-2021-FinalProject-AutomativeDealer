package group2.dao;

import group2.utils.Utils;
import group8.Car;
import group8.data.NewJDBC;

import javax.xml.transform.Result;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class VehicleDAO {

    private NewJDBC newJDBC;

    public VehicleDAO() {
        try {
            this.newJDBC = NewJDBC.getInstance();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public List<Map<String, Object>> getById(int id) throws SQLException {
        final ResultSet query = newJDBC.query("select * from NewVehicleData where vehicleId = ?", new String[]{String.valueOf(id)});
        List<Map<String, Object>> res = Utils.resultSetToList(query);
        return res;
    }

    public static void main(String[] args) throws SQLException {
        VehicleDAO vehicleDAO = new VehicleDAO();
        vehicleDAO.getById(1);
    }






}
