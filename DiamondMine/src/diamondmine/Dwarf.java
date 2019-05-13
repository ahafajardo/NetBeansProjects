/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package diamondmine;

import java.security.SecureRandom;

/**
 *
 * @author adfaj
 */
public class Dwarf implements Runnable {
    private String name;
    private final SecureRandom dwarfRandom = new SecureRandom();
    private int sleepTime;
    private int diamondsCollected;
    private DiamondMine mine;

    public Dwarf() {
        this.name = "The Missing Dwarf";
        this.sleepTime = dwarfRandom.nextInt(5000) + 10;
        this.mine = new DiamondMine();
        this.diamondsCollected = 0;
    }

    public Dwarf(String name, DiamondMine mine) {
        this.name = name;
        this.sleepTime = dwarfRandom.nextInt(5000) + 10;
        this.mine = mine;
        this.diamondsCollected = 0;
    }

    public int getDiamondsCollected() {
        return diamondsCollected;
    }

    public void setDiamondsCollected(int diamondsCollected) {
        this.diamondsCollected = diamondsCollected;
    }

    @Override
    public void run() {
        while(mine.isLeftover()) {
            try {
                if(mine.isLeftover()) {
                    diamondsCollected = diamondsCollected + mine.diamondCollection(this.name);
                    Thread.sleep(sleepTime);
                }
                else
                    System.out.println("All diamonds have been collected.");
            }
            catch (InterruptedException ex) {
            }
        }
        
        if(mine.isRunning())
            mine.kill();
    }
}
