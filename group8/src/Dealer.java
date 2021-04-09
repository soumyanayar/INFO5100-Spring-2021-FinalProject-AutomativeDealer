/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jasmineshin
 */
public class Dealer {
    private String name;
    private long num;
    private Inventory inventory;
    
    public Dealer(String name, long num){
        this.name = name;
        this.num = num;
        inventory = new Inventory(this);
    }
    public String getName(){
        return name;
    }

}
