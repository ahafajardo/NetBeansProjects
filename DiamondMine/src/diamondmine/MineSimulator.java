/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package diamondmine;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author adfaj
 */
public class MineSimulator {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        DiamondMine dwarfMine = new DiamondMine();
        
        dwarfMine.runThreads();
    }
    
}
