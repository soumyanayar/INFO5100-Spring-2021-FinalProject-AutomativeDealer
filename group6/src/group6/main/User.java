package group6.main;

/**
 * @author Anupama Singh
 * @date: 04/09/2021
 */
public class User {
    private String firstName, lastName, eMail, phoneNumber, zipCode;
    private FormAction form;
    // optional
    private Integer useType;
    private String messageText;

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

    public void setForm(FormAction formAction) {
        this.form = formAction;
    }
    public FormAction getForm() {
        return form;
    }

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    // optional
    public String getMessageText() {
        return messageText;
    }

    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }

    // optional
    public void setUseType(Integer useType) {
        this.useType = useType;
    }


    public String getUseType() {
        if (this.useType == null) {
            return "Empty";
        }
        return useType == 0 ? "Business" : "Personal";
    }
}
