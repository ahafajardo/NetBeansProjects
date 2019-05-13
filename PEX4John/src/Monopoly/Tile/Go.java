
package Monopoly.Tile;

import Monopoly.Player;
import javafx.scene.layout.GridPane;

/*
 * @author Jonathan Hopper
 */
public class Go extends Tile{
    
    // default constructor
    public Go(GridPane layOut) {
        tileLayOut = layOut;
        indexLayout = new int[][]{ 
            {1, 2, 3, 4}, 
            {0, 0, 1, 1}, 
            {0, 1, 0, 1} 
        };
    }
    
    @Override
    public void Effect(Player p) {
        p.setBalance(p.getBalance() + 200);
    }
}
