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
public abstract class Ship {
    protected String name;
    protected int speed;
    
    public Ship() {
        name = "My Ship";
        speed = 0;
    }
    
    abstract void speedup();
    
    public void fire() {
        System.out.printf("%s, FIRE THE CANNONS!%n", name);
    }
}
