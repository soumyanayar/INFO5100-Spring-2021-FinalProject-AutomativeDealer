package group4.entity;

import java.io.Serializable;
import java.util.Objects;

public class Model implements Serializable {
    private int modelID;
    private String modelName;
    private int makeID;

    public Model(){
        super();
    }

    public Model(int modelID) {
        super();
        this.modelID = modelID;
    }

    public Model(int modelID, int makeID) {
        super();
        this.modelID = modelID;
        this.makeID = makeID;
    }

    public Model(int modelID, String modelName, int makeID){
        super();
        this.modelID = modelID;
        this.modelName = modelName;
        this.makeID = makeID;
    }

    public int getModelID() {
        return modelID;
    }

    public void setModelID(int modelID) {
        this.modelID = modelID;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public int getMakeID() {
        return makeID;
    }

    public void setMakeID(int makeID) {
        this.makeID = makeID;
    }

    @Override
    public String toString() {
        return this.modelName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Model model = (Model) o;
        return model.getModelID() == this.getModelID();
    }

    @Override
    public int hashCode() {
        return Objects.hash(modelID, modelName, makeID);
    }
}
