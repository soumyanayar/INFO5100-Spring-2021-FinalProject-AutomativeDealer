package group3;
/**
 * @author  Zhehui Yang
 * @date: 2021/4/14
 */
public class Lead {
    public String firstName;
    public String lastName;
    public String email;
    public String phoneNumber;
    public String zipCode;
    public String carModel;
    public String carColor;
    public String carYear;
    public String message;
    public String replyMessage;
    public boolean contacted;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) { this.zipCode = zipCode; }

    public String getCarModel() {
        return carModel;
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }

    public String getCarColor() {
        return carColor;
    }

    public void setCarColor(String carColor) {
        this.carColor = carColor;
    }

    public String getCarYear() {
        return carYear;
    }

    public void setCarYear(String carYear) {
        this.carYear = carYear;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getReplyMessage() { return replyMessage; }

    public void setReplyMessage(String reply) {
        this.replyMessage = replyMessage;
    }

    public boolean getContacted() { return contacted; }

    public void setContacted(boolean contacted) {
        this.contacted = contacted;
    }
}
