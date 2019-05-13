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
public class Battleship extends Ship {
    protected int numTomahawks;

    public Battleship() {
        super();
        numTomahawks = 0;
    }
    
    @Override
    public void speedup(){
        speed += 10;
    }
    
    @Override
    public void fire() {
        System.out.printf("%s, DEPLOY THE %d TOMAHAWKS!%n", name, numTomahawks);
    }
}
