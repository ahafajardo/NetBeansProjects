/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cars;

/**
 *
 * @author adfaj
 */
public class Car extends Vehicle {
    private int year;
    private String make;
    
    public Car (int y, String c, String m) {
        super(c, 0);
        this.year = y;
        this.make = m;
    }

    public String getMake() {
        return make;
    }

    public int getYear() {
        return year;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void accelerate() {
        setSpeed(getSpeed() + 5);
    }
    
    public void brake() {
        setSpeed(getSpeed() - 5);
    }
    
    @Override
    public void soundAlarm() {
        System.out.println("BEEP BEEP");
    }
}
