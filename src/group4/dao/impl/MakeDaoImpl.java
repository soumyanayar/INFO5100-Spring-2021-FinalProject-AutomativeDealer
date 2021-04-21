package group4.dao.impl;

import group4.dao.MakeDao;
import group4.entity.Make;
import group4.util.DBCon;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MakeDaoImpl implements MakeDao {
    DBCon dbCon = new DBCon();

    private List<Make> getMakeList(ResultSet rs) {
        List<Make> makeList = new ArrayList<Make>();
        try {
            while(rs.next()) {
                Make make = new Make();
                make.setMakeID(rs.getInt("make_id"));
                make.setMakeName(rs.getString("make_name"));
                makeList.add(make);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            dbCon.closeAll();
        }
        return makeList;
    }

    @Override
    public List<Make> queryAll() {
        return getMakeList(dbCon.query("SELECT * FROM make_test"));
    }

    public static void main(String[] args) {
        MakeDaoImpl test = new MakeDaoImpl();
        List<Make> testList = test.queryAll();
        System.out.println(testList);
    }
}
