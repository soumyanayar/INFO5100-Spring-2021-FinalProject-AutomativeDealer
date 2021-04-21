package group4.dao.impl;

import group4.dao.ModelDao;
import group4.entity.Make;
import group4.entity.Model;
import group4.util.DBCon;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ModelDaoImpl implements ModelDao {
    DBCon dbCon = new DBCon();

    private List<Model> getModelList(ResultSet rs) {
        List<Model> modelList = new ArrayList<Model>();
        try {
            while(rs.next()) {
                Model model = new Model();
                model.setModelID(rs.getInt("model_id"));
                model.setModelName(rs.getString("model_name"));
                model.setMakeID(rs.getInt("make_id"));
                modelList.add(model);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            dbCon.closeAll();
        }
        return modelList;
    }

    private List<Model> getModelIDandNameList(ResultSet rs) {
        List<Model> modelList = new ArrayList<Model>();
        try {
            while(rs.next()) {
                Model model = new Model();
                model.setModelID(rs.getInt("model_id"));
                model.setModelName(rs.getString("model_name"));
                modelList.add(model);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            dbCon.closeAll();
        }
        return modelList;
    }



    @Override
    public List<Model> queryAll() {
        return getModelList(dbCon.query("SELECT * FROM model_test"));
    }

    @Override
    public List<Model> queryModelIDandName() {
        return getModelIDandNameList(dbCon.query("SELECT model_id,model_name FROM model_test"));
    }

    @Override
    public List<Model> queryByMakeID(int vehicleId) {
        return getModelList(dbCon.query("SELECT * FROM model_test WHERE make_id=?", vehicleId));
    }

    public static void main(String[] args) {
        ModelDaoImpl test = new ModelDaoImpl();
//        List<Model> testList = test.queryByMakeID(1);
        List<Model> modelList = test.queryModelIDandName();
        System.out.println(modelList);
    }
}
