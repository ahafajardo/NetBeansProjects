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
public class Vehicle {
    private String color;
    private int speed;

    public Vehicle(String hue, int how_fast) {
        this.color = hue;
        this.speed = how_fast;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int s) {
        this.speed = s;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String c) {
        this.color = c;
    }
    
    public void soundAlarm() {
        System.out.println("Vehicle Alarm initiated");
    }
}
