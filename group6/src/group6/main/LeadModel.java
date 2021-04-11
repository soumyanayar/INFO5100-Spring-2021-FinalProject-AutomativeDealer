package group6.main;

import group8.Main.Car;

/**
 * @author Anupama Singh
 * @date: 04/09/2021
 */
public class LeadModel {
    private String messageText;

    public String getMessageText() {
        return messageText;
    }

    public UseType getUserType() {
        return userType;
    }

    public User getUser() {
        return user;
    }

    private UseType userType;
    private User user;
    //private Car car;
    public LeadModel(String messageText, UseType userType, User user){
        this.messageText = messageText;
        this.userType = userType;
        this.user = user;
    }

    public enum UseType {
        BUSINESS, PERSONAL;
    }

}


