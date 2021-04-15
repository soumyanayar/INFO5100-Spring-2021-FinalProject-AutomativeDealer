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
        String sql = "select * from Dealer where dealerID = ?";
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
        if (rs.next()) {
            dealer.setDealerID(rs.getString("DealerID"));
            dealer.setName(rs.getString("DealerName"));
            dealer.setCity(rs.getString("City"));
            dealer.setPhoneNumber(rs.getString("PhoneNumber"));
            dealer.setStreetAddress(rs.getString("DealerAddress"));
            dealer.setZipcode(rs.getString("ZipCode"));
            dealer.setCountry(rs.getString("Country"));
        }

        return dealer;
    }
}