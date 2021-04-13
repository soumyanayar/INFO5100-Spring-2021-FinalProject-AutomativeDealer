package group8;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DealerDirectory {

    private utils.JDBC jdbcInstance;

    public DealerDirectory() {
        try {
            jdbcInstance = utils.JDBC.getInstance();
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }


    /*******************  METHODS  *******************/

    public List<Dealer> getDealerByStateOrStateId(String stateOrStateId) throws SQLException {
        List<Dealer> dealers = new ArrayList<>();
        String query = "select * from dealer where state = ? or state_id = ?";
        String[] params = new String[]{stateOrStateId, stateOrStateId};
        ResultSet resultSet = jdbcInstance.query(query, params);
        while(resultSet.next()){
            Dealer dealer = new Dealer();
            dealer.setDealerID(resultSet.getString("id"));
            dealer.setName(resultSet.getString("name"));
            dealer.setStreetAddress(resultSet.getString("street_address"));
            dealer.setCity(resultSet.getString("city"));
            dealer.setStateID(resultSet.getString("state_id"));
            dealer.setState(resultSet.getString("state"));
            dealer.setZipcode(resultSet.getString("zipcode"));
            dealer.setPhoneNumber(resultSet.getString("phone_number"));
            dealers.add(dealer);
        }
        return dealers;
    }
}
