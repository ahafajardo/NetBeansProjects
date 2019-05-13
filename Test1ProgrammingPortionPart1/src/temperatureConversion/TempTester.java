/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package temperatureConversion;

/**
 *
 * @author adfaj
 */
public class TempTester {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Temperature cold = new Temperature();
        System.out.printf("Current Temp in Celsius: %f%n", cold.getTemp_C());
        
        Temperature warm = new Temperature(30);
        System.out.printf("Current Temp in Celsius: %f%n", warm.getTemp_C());
        System.out.printf("Current Temp in Fahrenheit: %f%n", warm.calc_Fahren());
        System.out.printf("Current Temp in Kelvin: %f%n", warm.calc_Kelvin());
        warm.setTemp_C(70);
        System.out.printf("New Temp in Celsius: %f%n", warm.getTemp_C());
        
    }
    
}
