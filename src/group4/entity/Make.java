package group4.entity;

import java.io.Serializable;
import java.util.Objects;

public class Make implements Serializable {
    private int makeID;
    private String makeName;

    public Make() {
        super();
    }

    public Make(int makeID){
        this.makeID = makeID;
    }

    public Make(int makeID, String makeName) {
        super();
        this.makeID = makeID;
        this.makeName = makeName;
    };

    public int getMakeID() {
        return makeID;
    }

    public void setMakeID(int makeID) {
        this.makeID = makeID;
    }

    public String getMakeName() {
        return makeName;
    }

    public void setMakeName(String makeName) {
        this.makeName = makeName;
    }

    @Override
    public String toString() {
        return this.makeName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Make make = (Make) o;
        return make.getMakeID() == this.getMakeID();
    }

    @Override
    public int hashCode() {
        return Objects.hash(makeID, makeName);
    }

}
