package group6.main;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jasmineshin ()
 */
public class Dealer {
    private String dealerID;
    private String name;
    private long num;
    
    public Dealer(String dealerID, String name, long num){
        this.dealerID = dealerID;
        this.name = name;
        this.num = num;
    }
    public String getName(){
        return name;
    }

}
