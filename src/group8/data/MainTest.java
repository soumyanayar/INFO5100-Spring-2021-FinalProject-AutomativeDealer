package group8.data;

import java.sql.SQLException;

/**
 * @author Guiyu Liu
 * Apr 13, 2021.
 */
public class MainTest {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        DbDealerStorage dbDealerStorage = new DbDealerStorage();
        System.out.println(dbDealerStorage.getDealerById("2").getName());
    }
}