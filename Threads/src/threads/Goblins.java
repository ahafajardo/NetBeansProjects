/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package threads;

import java.security.SecureRandom;
/**
 *
 * @author adfaj
 */
public class Goblins implements Runnable {
    private final SecureRandom goblinRandom = new SecureRandom();
    private final String goblinName;
    private final int sleepTime;

    public Goblins() {
        this.goblinName = "No Name";
    }

    public Goblins(String goblinName) {
        this.goblinName = goblinName;
        sleepTime = goblinRandom.nextInt(5);
    }
    
    @Override
    public void run() {
        try {
            Thread.sleep(sleepTime);
        }
        catch (InterruptedException ex){
        }
    }
    
    
}
