package group8.data;

import group8.Car;
import group8.CarCategory;
import group8.Dealer;
import group8.IDataProvider;
import group8.Incentive;
import java.sql.Blob;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.sql.rowset.serial.SerialBlob;

/**
 * @author Guiyu Liu Apr 13, 2021.
 */
public class DbDealerStorage implements IDataProvider {

    private NewJDBC db;

    public DbDealerStorage() throws SQLException, ClassNotFoundException {
        db = NewJDBC.getInstance();
    }

    public Dealer getDealerById(String id) {
        String sql = "select * from Dealers where dealerID = ?";
        try {
            String[] aStrParams = new String[1];
            aStrParams[0] = id;
            ResultSet resultSet = db.query(sql, aStrParams);
            return mapRow(resultSet);

        } catch (SQLException e) {
            System.out.println(e);
            System.out.println("No result for Dealer with Id : " + id);
            return null;
        }
    }

    public void printColInfo() throws SQLException {
        db.printColumnInfo();
    }

    public void printNumCol() throws SQLException {
        System.out.println("There are " + db.getNumColumns() + " columns in ");
    }

    public void printAll() throws SQLException {
        db.getAllRows();
    }

    public void printNumRow() throws SQLException {
        db.getNumRows();
    }

    private List<Map<String, Object>> resultSetToList(ResultSet rs) throws SQLException {
        ResultSetMetaData md = rs.getMetaData();
        int columns = md.getColumnCount();
        List<Map<String, Object>> rows = new ArrayList<Map<String, Object>>();
        while (rs.next()) {
            Map<String, Object> row = new HashMap<String, Object>(columns);
            for (int i = 1; i <= columns; ++i) {
                row.put(md.getColumnName(i), rs.getObject(i));
            }
            rows.add(row);
        }
        return rows;
    }

    public Dealer mapRow(ResultSet rs) throws SQLException {

        Dealer dealer = new Dealer();
        rs.next();
        dealer.setDealerID(rs.getString("dealerID"));
        dealer.setName(rs.getString("name"));
        dealer.setCity(rs.getString("city"));
        dealer.setPhoneNumber(rs.getString("phoneNumber"));
        dealer.setState(rs.getString("state"));
        dealer.setStateID(rs.getString("stateID"));
        dealer.setStreetAddress(rs.getString("streetAddress"));
        dealer.setZipcode(rs.getString("zipcode"));

        return dealer;
    }

    @Override
    public List<Car> getAllCarsByDealerId(String dealerId) {
        List<Car> result = new ArrayList<>();
        String query = "Select * from NewVehicleData where DealerId = ?";
        try {
            String[] aStrParams = new String[1];
            aStrParams[0] = dealerId;
            ResultSet resultSet = db.query(query, aStrParams);
            while (resultSet.next()) {
                // Car(String stockID, String VIN, String dealerID, String make, String model,
                // int year, CarCategory category, double price, String color, int mileage,
                // Blob img, String incentiveID, String discountPrice, int rating)
                String stockID = resultSet.getString(1);
                String VIN = resultSet.getString(2);
                String dealerID = resultSet.getString(3);
                String make = resultSet.getString(4);
                String model = resultSet.getString(5);
                int year = resultSet.getInt(6);
                CarCategory category = resultSet.getString(7).equals("New") ? CarCategory.NEW : CarCategory.USED;
                double msrp = resultSet.getDouble(8);
                String color = resultSet.getString(9);
                int miles = resultSet.getInt(10);
                String img = resultSet.getString(11);
                byte[] content = img.getBytes();
                Blob blob = new SerialBlob(content);
                String incentiveId = resultSet.getString(12);
                String discountPrice = resultSet.getString(13);
                int rating = resultSet.getInt(14);
                Car c = new Car(stockID, VIN, dealerID, make, model, year, category, msrp, color, miles, blob,
                        incentiveId, discountPrice, rating);
                result.add(c);
            }

        } catch (SQLException e) {
            System.out.println(e);
            System.out.println("No result for Dealer with Id : " + dealerId);
            return null;
        }
        return result;
    }

    @Override
    public List<Car> getAllCars() {
        throw new UnsupportedOperationException("Not supported yet."); // To change body of generated methods, choose
                                                                       // Tools | Templates.
    }

    @Override
    public List<Incentive> getAllIncentivesByDealerId(String dealerId) {
        throw new UnsupportedOperationException("Not supported yet."); // To change body of generated methods, choose
                                                                       // Tools | Templates.
    }

    @Override
    public List<Incentive> getAllIncentives() {
        throw new UnsupportedOperationException("Not supported yet."); // To change body of generated methods, choose
                                                                       // Tools | Templates.
    }

    @Override
    public void persistIncentive(Incentive incentive) {
//        String sql = " insert into Incentives (IncentiveId, Title, Description, Disclaimer, StartDate, EndDate, DiscountValue, DiscountType, DealerId, IsDeleted, FilterList, VehicleIdList)"
//                + " values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
//        try {
//            String[] aStrParams = new String[12];
//            aStrParams[0] = incentive.getId();
//            aStrParams[1] = incentive.getTitle();
//            aStrParams[2] = incentive.getDescription();
//            aStrParams[3] = incentive.getDisclaimer();
//            aStrParams[4] = incentive.getStartDate();
//            aStrParams[5] = incentive.getEndDate();
//            aStrParams[6] = null;
//            aStrParams[7] = incentive.getIncentiveType();
//            aStrParams[8] = incentive.getDealerId();
//            aStrParams[9] = null;
//            aStrParams[10] = null;
//            aStrParams[11] = incentive.getCarVINList();
//        } catch (SQLException e) {
//            System.out.println(e);
//            System.out.println("The incentive with id: " + incentive.getId() + " save failed!");
//        }
    }
}
