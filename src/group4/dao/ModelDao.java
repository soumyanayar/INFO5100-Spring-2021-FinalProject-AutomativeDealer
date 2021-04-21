package group4.dao;

import group4.entity.Model;

import java.util.List;

public interface ModelDao {
    List<Model> queryAll();
    List<Model> queryModelIDandName();
    List<Model> queryByMakeID(int makeID);
}
