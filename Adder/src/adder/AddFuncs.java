/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adder;

/**
 *
 * @author adfaj
 */
public class AddFuncs {

    public AddFuncs() {
    }
     public <T extends Number> double add(T num1, T num2) {
         return (num1.doubleValue() + num2.doubleValue());
     }

    @Override
    public String toString() {
        return super.toString(); //To change body of generated methods, choose Tools | Templates.
    }
     
     
}
