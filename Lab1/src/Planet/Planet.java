/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Planet;

/**
 *
 * @author adfaj
 */
import java.awt.Color;

public class Planet {
    private double size;
    private Color color;
    private String name;
    
    public Planet(){
        
    }
    
    public Planet(double sz, int clr, String nm) {
        size = sz;
        name = nm;
        switch (clr) {
            case 1:
                color = Color.RED;
                break;
            case 2:
                color = Color.GREEN;
                break;
            case 3:
                color = Color.BLUE;
                break;
        }
    }
    
    public void setSize(double sz) {
        size = sz;
    }
    
    public double getSize() {
        return size;
    }
    
    public void setColor(int clr) {
        switch (clr) {
            case 1:
                color = Color.RED;
                break;
            case 2:
                color = Color.GREEN;
                break;
            case 3:
                color = Color.BLUE;
                break;
        }
    }
    
    public Color getColor() {
        return color;
    }
    
    public void setName(String nm) {
        name = nm;
    }
    
    public String getName() {
        return name;
    }
    
    public double getArea() {
        return 4.0 * Math.PI * size * size;
    }
}
