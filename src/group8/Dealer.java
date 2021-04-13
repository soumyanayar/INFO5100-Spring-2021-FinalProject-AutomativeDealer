package group8;

public class Dealer {
    private String dealerID;
    private String name;
    private String streetAddress;
    private String city;
    private String stateID;
    private String state;
    private String zipcode;
    private String phoneNumber;
    private Inventory inventory;

    public Dealer() {}

    public Dealer(String dealerID, String name, String streetAddress, String city, String stateID, String state,
                  String zipcode, String phoneNumber, Inventory inventory) {
        this.dealerID = dealerID;
        this.name = name;
        this.streetAddress = streetAddress;
        this.city = city;
        this.stateID = stateID;
        this.state = state;
        this.zipcode = zipcode;
        this.phoneNumber = phoneNumber;
        this.inventory = inventory;
    }

    /*******************  GETTER  *******************/
    public String getDealerID() {
        return dealerID;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public String getCity() {
        return city;
    }

    public String getStateID() {
        return stateID;
    }

    public String getState() {
        return state;
    }

    public String getZipcode() {
        return zipcode;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public String getName() {
        return name;
    }

    /*******************  SETTER  *******************/

    public void setDealerID(String dealerID) {
        this.dealerID = dealerID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setStateID(String stateID) {
        this.stateID = stateID;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    /*******************  METHODS  *******************/

}
