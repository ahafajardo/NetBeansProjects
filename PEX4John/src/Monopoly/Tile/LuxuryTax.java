
package Monopoly.Tile;

import Monopoly.Player;
import javafx.scene.layout.GridPane;

/**
 *
 * @author Orend
 */
public class LuxuryTax extends Tile{

    public LuxuryTax(GridPane layOut) {
        tileLayOut = layOut;
        indexLayout = new int[][]{ 
            {1, 2, 3, 4}, 
            {0, 0, 1, 1}, 
            {0, 1, 0, 1} 
        };
    }
    
    @Override
    public void Effect(Player p) {
        p.setBalance(p.getBalance() - 75);
    }
    
}
