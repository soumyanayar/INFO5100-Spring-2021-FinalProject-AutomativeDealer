package group6.main;

import group8.Main.Car;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Runyao Xia
 * @date: 2021/4/10
 */
public class FormActionDirectory {
    private Car car;
    private List<FormAction> forms;
    private Integer id = 1;

    public FormActionDirectory(Car car) {
        this.car = car;
    }
    public FormAction newForm(String firstName, String lastName, String eMail, String phoneNumber, String zipCode) {
        User user= new User(firstName, lastName, eMail, phoneNumber, zipCode);
        FormAction form = new FormAction(user);
        form.setId(id++);
        if (forms == null) {
            forms = new ArrayList<>();
        }
        forms.add(form);
        return form;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public List<FormAction> getForms() {
        return forms;
    }
    /**
     * get user by form
     */


    /**
     * get form by user...
     */

    /**
     * find customer by car id or something
     */

    /**
     * if the form belongs to the user
     */

    /**
     * get user by name? or something
     */
}
