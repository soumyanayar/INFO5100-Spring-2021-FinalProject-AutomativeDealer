package group6.main;

import group8.Main.Dealer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Runyao Xia
 * @date: 2021/4/10
 */
public class FormAction {
    private List<User> users;
    private Dealer dealer;

    public FormAction(Dealer dealer) {
        users = new ArrayList<>();
        this.dealer = dealer;
    }
    public User newUser(String firstName, String lastName, String eMail, String phoneNumber, String zipCode) {
        User user = new User(firstName, lastName, eMail, phoneNumber, zipCode);
        user.assignForm(this);
        return user;
    }

    public List<User> getUsers() {
        return users;
    }

    public Dealer getDealer() {
        return dealer;
    }

    public void setDealer(Dealer dealer) {
        this.dealer = dealer;
    }
}
