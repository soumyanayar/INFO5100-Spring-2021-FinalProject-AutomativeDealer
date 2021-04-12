package group6.main;

/**
 * @author Anupama Singh
 * @date: 04/09/2021
 */
public class User {
    private String firstName, lastName, eMail, phoneNumber, zipCode;
    private FormAction form;

    public User(String firstName, String lastName, String eMail, String phoneNumber, String zipCode) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.eMail = eMail;
        this.phoneNumber = phoneNumber;
        this.zipCode = zipCode;
    }

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

    public String getMail() {
        return eMail;
    }

    public void setMail(String eMail) {
        this.eMail = eMail;
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

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    /**
     * connect form and user
     * @param formAction
     */
    public void assignForm(FormAction formAction) {
        this.form = formAction;
    }

    public FormAction getForm() {
        return form;
    }
}
