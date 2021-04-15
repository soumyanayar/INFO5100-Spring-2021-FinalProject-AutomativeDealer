package group8;

import group8.data.NewJDBC;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DealerDirectory {

    private NewJDBC jdbcInstance;

    public DealerDirectory() {
        try {
            jdbcInstance = NewJDBC.getInstance();
        } catch (SQLException | ClassNotFoundException exception) {
            exception.printStackTrace();
        }
    }

    public static void main(String[] args) throws SQLException {
        DealerDirectory dealerDirectory = new DealerDirectory();
        List<Dealer> dealers = dealerDirectory.getDealerByStateOrStateId("WA");
        System.out.println(dealers.size());
        System.out.println(dealerDirectory.getDealerByZipCode("98032"));
    }


    /*******************  METHODS  *******************/

    public List<Dealer> getDealerByStateOrStateId(String stateOrStateId) throws SQLException {
        List<Dealer> dealers = new ArrayList<>();
        String query = "select * from DealerWithState where State = ? or StateCode = ?";
        String[] params = new String[]{stateOrStateId, stateOrStateId};
        ResultSet resultSet = jdbcInstance.query(query, params);
        while (resultSet.next()) {
            dealers.add(getDealer(resultSet));
        }
        return dealers;
    }

    public List<Dealer> getDealerByZipCode(String zipcode) throws SQLException {
        List<Dealer> dealers = new ArrayList<>();
        String query = "select * from DealerWithState where ZipCode = ?";
        String[] params = new String[]{zipcode};
        ResultSet resultSet = jdbcInstance.query(query, params);
        while (resultSet.next()) {
            dealers.add(getDealer(resultSet));
        }
        return dealers;
    }

    private Dealer getDealer(ResultSet resultSet) throws SQLException {
        Dealer dealer = new Dealer();
        dealer.setDealerID(resultSet.getString("DealerId"));
        dealer.setName(resultSet.getString("DealerName"));
        dealer.setStreetAddress(resultSet.getString("DealerAddress"));
        dealer.setCity(resultSet.getString("City"));
        dealer.setStateID(resultSet.getString("StateCode"));
        dealer.setState(resultSet.getString("State"));
        dealer.setZipcode(resultSet.getString("ZipCode"));
        dealer.setPhoneNumber(resultSet.getString("PhoneNumber"));
        dealer.setLatitude(resultSet.getDouble("Latitude"));
        dealer.setLongitude(resultSet.getDouble("Longitude"));
        return dealer;
    }
}
