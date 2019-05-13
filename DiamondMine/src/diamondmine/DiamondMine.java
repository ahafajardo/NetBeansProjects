/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package diamondmine;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author adfaj
 */
public class DiamondMine {
    int diamonds;
    boolean leftover;
    boolean running;
    List<Dwarf> dwarves;
    ExecutorService executorService;
    private final SecureRandom mineRandom = new SecureRandom();

    public DiamondMine() {
        this.diamonds = 1000;
        this.leftover = true;
        this.running = true;
        dwarves = new ArrayList<Dwarf>();
        runThreads();
    }

    public int getDiamonds() {
        return diamonds;
    }

    public boolean isLeftover() {
        return leftover;
    }

    public boolean isRunning() {
        return running;
    }
    
    public void runThreads() {
        Dwarf sleepy = new Dwarf("Sleepy", this);
        Dwarf doc = new Dwarf("Doc", this);
        Dwarf dopey = new Dwarf("Dopey", this);
        Dwarf happy = new Dwarf("Happy", this);
        Dwarf bashful = new Dwarf("Bashful", this);
        Dwarf grumpy = new Dwarf("Grumpy", this);
        Dwarf sneezy = new Dwarf("Sneezy", this);
        
        dwarves.add(sleepy);
        dwarves.add(doc);
        dwarves.add(dopey);
        dwarves.add(happy);
        dwarves.add(bashful);
        dwarves.add(grumpy);
        dwarves.add(sneezy);
        
        
        executorService = Executors.newCachedThreadPool();
        
        executorService.execute(sleepy);
        executorService.execute(doc);
        executorService.execute(dopey);
        executorService.execute(happy);
        executorService.execute(bashful);
        executorService.execute(grumpy);
        executorService.execute(sneezy);
    }
    
    public synchronized int diamondCollection(String s) {
        System.out.println(s + " left the hamlet.");
        int diamondsCollected = 0;
        int sleepTime = mineRandom.nextInt(6) + 5;
        
        try {
            Thread.sleep(sleepTime);
            System.out.println(s + " reached the mine.");
            if(diamonds > 0 && leftover) {
                if(diamonds > 50) {
                    diamondsCollected = mineRandom.nextInt(41) + 10;
                    diamonds -= diamondsCollected;
                    System.out.println(s + " got " + diamondsCollected + " diamonds. There are " + diamonds + " diamonds left.");
                }
                else if(diamonds > 10) {
                    diamondsCollected = mineRandom.nextInt(diamonds - 9) + 10;
                    diamonds -= diamondsCollected;
                    System.out.println(s + " got " + diamondsCollected + " diamonds. There are " + diamonds + " diamonds left.");
                }
                else {
                    diamondsCollected = diamonds;
                    diamonds = 0;
                    System.out.println(s + " got " + diamondsCollected + " diamonds. There are " + diamonds + " diamonds left.");
                }

            }

            if(diamonds == 0) {
                this.leftover = false;
                diamondsCollected = 0;
            }
        }
        catch (InterruptedException ex) {
        }
        
        
        
        return diamondsCollected;
    }
    
    public void kill() {
        running = false;
        int[] diamondCount = new int[7];
        executorService.shutdown();
        
        try {
            boolean tasksEnded = executorService.awaitTermination(1, TimeUnit.SECONDS);
            if (tasksEnded) {
                diamondCount[0] = dwarves.get(0).getDiamondsCollected();
                diamondCount[1] = dwarves.get(1).getDiamondsCollected();
                diamondCount[2] = dwarves.get(2).getDiamondsCollected();
                diamondCount[3] = dwarves.get(3).getDiamondsCollected();
                diamondCount[4] = dwarves.get(4).getDiamondsCollected();
                diamondCount[5] = dwarves.get(5).getDiamondsCollected();
                diamondCount[6] = dwarves.get(6).getDiamondsCollected();
                System.out.println("Mine Closed.");
            }
            else {
                System.out.println("Still talking to dwarves...");
            }
        } catch (InterruptedException ex) {
            Logger.getLogger(MineSimulator.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        System.out.println("Total Diamonds:");
        System.out.println("Sleepy collected " + diamondCount[0] + " diamonds.");
        System.out.println("Doc collected " + diamondCount[1] + " diamonds.");
        System.out.println("Dopey collected " + diamondCount[2] + " diamonds.");
        System.out.println("Happy collected " + diamondCount[3] + " diamonds.");
        System.out.println("Bashful collected " + diamondCount[4] + " diamonds.");
        System.out.println("Grumpy collected " + diamondCount[5] + " diamonds.");
        System.out.println("Sneezy collected " + diamondCount[6] + " diamonds.");
        
        System.exit(0);
    }
}
