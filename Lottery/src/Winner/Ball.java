/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Winner;

import java.security.SecureRandom;
import java.util.Random;

/**
 *
 * @author adfaj
 */
public class Ball {
    private int number;
    private Random rand;
    private final int MAXVAL = 100;
    
    public Ball () {
        rand = new SecureRandom();
    }
    
    public Ball (int num) {
        rand = new SecureRandom();
        number = num;
    }
    
    public int getNumber () {
        return number;
    }

    public void setNumber (int num) {
        number = num;
    }
    
    public int spinBall () {
        return rand.nextInt(MAXVAL + 1);
    }
}
