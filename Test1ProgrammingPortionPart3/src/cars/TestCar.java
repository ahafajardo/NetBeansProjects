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
public class TestCar {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Car myCar = new Car(2010, "Purple", "Toyota Camry");
        System.out.printf("Current speed of %s %d %s: %d%n", myCar.getColor(), myCar.getYear(), myCar.getMake(), myCar.getSpeed());
        myCar.accelerate();
        System.out.printf("Current speed of %s %d %s: %d%n", myCar.getColor(), myCar.getYear(), myCar.getMake(), myCar.getSpeed());
        myCar.accelerate();
        System.out.printf("Current speed of %s %d %s: %d%n", myCar.getColor(), myCar.getYear(), myCar.getMake(), myCar.getSpeed());
        myCar.accelerate();
        System.out.printf("Current speed of %s %d %s: %d%n", myCar.getColor(), myCar.getYear(), myCar.getMake(), myCar.getSpeed());
        myCar.accelerate();
        System.out.printf("Current speed of %s %d %s: %d%n", myCar.getColor(), myCar.getYear(), myCar.getMake(), myCar.getSpeed());
        myCar.accelerate();
        System.out.printf("Current speed of %s %d %s: %d%n", myCar.getColor(), myCar.getYear(), myCar.getMake(), myCar.getSpeed());
        myCar.brake();
        System.out.printf("Current speed of %s %d %s: %d%n", myCar.getColor(), myCar.getYear(), myCar.getMake(), myCar.getSpeed());
        myCar.brake();
        System.out.printf("Current speed of %s %d %s: %d%n", myCar.getColor(), myCar.getYear(), myCar.getMake(), myCar.getSpeed());
        myCar.brake();
        System.out.printf("Current speed of %s %d %s: %d%n", myCar.getColor(), myCar.getYear(), myCar.getMake(), myCar.getSpeed());
        myCar.brake();
        System.out.printf("Current speed of %s %d %s: %d%n", myCar.getColor(), myCar.getYear(), myCar.getMake(), myCar.getSpeed());
        myCar.brake();
        System.out.printf("Current speed of %s %d %s: %d%n", myCar.getColor(), myCar.getYear(), myCar.getMake(), myCar.getSpeed());
    }
    
}
