/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Planet;
/**
 *
 * @author adfaj
 * 
 */

import java.util.Scanner;

public class PlanetTest {
    public static void main(String[] args){
        String userName = "";
        Scanner input = new Scanner(System.in);
        
        System.out.printf("Enter your user name.%n");
        userName = input.next();
        
        System.out.printf("Welcome to Planet Maker, let's play god!%n%n");
        System.out.printf("What is the planet's radius?%n");
        double radius = input.nextDouble();
        
        System.out.printf("What is the planet's color? Use 1 for red, 2 for green, and 3 for blue.%n");
        int color = input.nextInt();
        while(color != 1 && color != 2 && color != 3) {
            System.out.printf("Use a value from 1 to 3:%n");
            color = input.nextInt();
        }
        
        System.out.printf("What is your planet's name?%n");
        String planetName = input.next();
        
        Planet newPlanet = new Planet(radius, color, planetName);
        
        System.out.printf("Calculating...%nDone!%nYour New Planet%n===============%n");
        System.out.printf("%s%nRadius: %f%nColor: %s%nArea: %f%n", newPlanet.getName(), newPlanet.getSize(),
                newPlanet.getColor().toString(), newPlanet.getArea());
    }
}
