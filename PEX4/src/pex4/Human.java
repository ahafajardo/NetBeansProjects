/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pex4;

import java.util.Random;

/**
 *
 * @author adfaj
 */
public class Human extends Player {

    public Human() {
        super(null, 0, 0, false, false);
    }

    
    
    public Human(Avatar avatar) {
        super(avatar, 1500, 0, false, false);
    }
    
    
    @Override
    public int[] rollDice() {
        int[] dicePair = new int[2];
        
        dice1 = r1.nextInt(6) + 1;
        dice2 = r2.nextInt(6) + 1;
        dicePair[0] = dice1;
        dicePair[1] = dice2;
        return dicePair;
    }
    
    @Override
    public int addDice() {
        int totalSpaces = dice1 + dice2;
        return totalSpaces;
    }
    
    @Override
    public void makeMove(int spaces) {
        if(currentPosition + spaces > 39){
            currentPosition = currentPosition + spaces - 40;
            receivePayment(200);
        }
        else
            currentPosition = currentPosition + spaces;
    }
    
    @Override
    public void makePayment(int cost) {
        totalMoney = totalMoney - cost;
    }
    
    @Override
    public void receivePayment(int revenue) {
        totalMoney = totalMoney + revenue;
    }
}
