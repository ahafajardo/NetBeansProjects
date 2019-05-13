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
public abstract class Player {
    protected int dice1;
    protected int dice2;
    protected Random r1;
    protected Random r2;
    protected Avatar avatar;
    protected int totalMoney;
    protected int currentPosition;
    protected boolean bankrupt;
    protected boolean inJail;
    protected int jailCounter;

    public Player(Avatar avatar, int totalMoney, int currentPosition, boolean bankrupt, boolean inJail) {
        this.dice1 = 1;
        this.dice2 = 1;
        this.r1 = new Random();
        this.r2 = new Random();
        this.avatar = avatar;
        this.totalMoney = totalMoney;
        this.currentPosition = currentPosition;
        this.bankrupt = bankrupt;
        this.inJail = inJail;
        this.jailCounter = 0;
    }
    
    
    
    public abstract int[] rollDice ();
    
    public abstract int addDice ();
    
    public abstract void makeMove (int spaces);
    
    public abstract void makePayment (int cost);
    
    public abstract void receivePayment (int revenue);
    
    public int getCurrentPosition() {
        return currentPosition;
    }

    public void setCurrentPosition(int currentPosition) {
        this.currentPosition = currentPosition;
    }

    public int getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(int totalMoney) {
        this.totalMoney = totalMoney;
    }

    public boolean isBankrupt() {
        return bankrupt;
    }

    public void setBankrupt(boolean bankrupt) {
        this.bankrupt = bankrupt;
    }

    public boolean isInJail() {
        return inJail;
    }
    
    public void setInJail(boolean inJail) {
        this.inJail = inJail;
    }

    public int getDice1() {
        return dice1;
    }

    public int getDice2() {
        return dice2;
    }

    public Avatar getAvatar() {
        return avatar;
    }

    public void setAvatar(Avatar avatar) {
        this.avatar = avatar;
    }

    public int getJailCounter() {
        return jailCounter;
    }

    public void setJailCounter(int jailCounter) {
        this.jailCounter = jailCounter;
    }
    
    
}
