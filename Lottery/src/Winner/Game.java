/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Winner;

/**
 *
 * @author adfaj
 */
public class Game {
    private Ball[] balls;
    private int totalBalls = 5;
    
    public Game () {
        balls = new Ball[totalBalls];
        for (int i = 0; i < totalBalls; i++) {
            balls[i] = new Ball();
        }
    }
    
    public void play_once () {
        for(int i = 0; i < totalBalls; i++) {
            System.out.printf("Ball number %d: %d%n", i + 1, balls[i].getNumber());
        }
    }
    
    public void spinBalls () {
        int tempNum;
        boolean valid = false;
        
        for(int i = 0; i < totalBalls; i++) {
            while (!valid) {
                tempNum = balls[i].spinBall();
                valid = notTaken(tempNum);
                if(valid)
                    balls[i].setNumber(tempNum);
            }
            valid = false;
        }
    }
    
    public boolean notTaken (int numToCheck) {
        for(int i = 0; i < totalBalls; i++) {
            if (balls[i].getNumber() == numToCheck)
                return false;
        }
        
        return true;
    }
}
