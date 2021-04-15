package group8.data;

import group8.Car;
import java.sql.SQLException;
import java.util.List;

/**
 * @author Guiyu Liu
 * Apr 13, 2021.
 */
public class MainTest {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        DbDealerStorage dbDealerStorage = new DbDealerStorage();
        dbDealerStorage.printAll();
        //dbDealerStorage.printNumRow();
        //dbDealerStorage.printNumCol();
        //dbDealerStorage.printColInfo();
        List<Car> res = dbDealerStorage.getAllCarsByDealerId("18");
        for(Car c : res){
            System.out.println(c.getMake());
        }
        //System.out.println(dbDealerStorage.getDealerById("testId").getName());
    }
}