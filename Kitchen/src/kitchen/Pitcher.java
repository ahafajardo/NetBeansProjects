/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kitchen;

/**
 *
 * @author adfaj
 */
public class Pitcher <T> {
    T liquid;
    
    public Pitcher() {
        
    }
    
    public void fill(T liquid) {
        this.liquid = liquid;
        System.out.println(liquid.toString());
    }
    
    
}
