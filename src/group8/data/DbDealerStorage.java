package group8.data;

import group8.Dealer;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Guiyu Liu
 * Apr 13, 2021.
 */
public class DbDealerStorage {
    private NewJDBC db;

    public DbDealerStorage() throws SQLException, ClassNotFoundException {
        db = NewJDBC.getInstance();
    }

    public Dealer getDealerById(String id) {
        String sql = "select * from Dealers where dealerID = ?";
        try {
            String [] aStrParams = new String[1];
            aStrParams[0] = id;
            ResultSet resultSet = db.query(sql, aStrParams);
            return mapRow(resultSet);

        } catch (SQLException e) {
            System.out.println(e);
            System.out.println("No result for Dealer with Id : " + id);
            return null;
        }
    }

    private List<Map<String, Object>> resultSetToList(ResultSet rs) throws SQLException {
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
}