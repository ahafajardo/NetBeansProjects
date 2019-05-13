
package Monopoly.Tile;

import Monopoly.Player;
import javafx.scene.layout.GridPane;

/*
 * @author Jonathan Hopper
 */
public class Jail extends Tile{
    
    // default constructor
    public Jail(GridPane layOut) {
        tileLayOut = layOut;
        indexLayout = new int[][]{ 
            {1, 2, 3, 4}, 
            {1, 2, 1, 2}, 
            {0, 0, 1, 1} 
        };
    }
    
    @Override
    public void Effect(Player p) {
        p.toggleJail();
    }
}
