/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ships;

/**
 *
 * @author adfaj
 */
public class ShipTester {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Battleship myBattleship = new Battleship();
        myBattleship.fire();
        
        Carrier myCarrier = new Carrier();
        myCarrier.fire();
    }
    
}
