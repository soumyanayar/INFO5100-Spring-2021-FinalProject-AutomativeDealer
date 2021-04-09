
import java.util.ArrayList;
import java.util.HashMap;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jasmineshin
 */
public class Inventory {
    
    private Dealer dealer;
    private HashMap <String, ArrayList<Car>> carMap;
    
    public Inventory(Dealer d){
        carMap = new HashMap<>();
        dealer = d;
    }
}
