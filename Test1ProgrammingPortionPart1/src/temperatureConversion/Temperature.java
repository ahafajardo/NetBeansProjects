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
public class Temperature {
    private double temp_C;

    public Temperature() {
        temp_C = 0.0;
    }

    public Temperature(double temp_C) {
        this.temp_C = temp_C;
    }

    public double getTemp_C() {
        return temp_C;
    }

    public void setTemp_C(double temp_C) {
        this.temp_C = temp_C;
    }
    
    public double calc_Fahren(){
        double temp_F = (temp_C * (9.0/5.0)) + 32.0;
        return temp_F;
    }
    
    public double calc_Kelvin(){
        double temp_K = temp_C + 273.15;
        return temp_K;
    }
}
