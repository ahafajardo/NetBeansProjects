
package Monopoly.Tile;

import Monopoly.Player;
import java.util.ArrayList;
import java.util.Collections;
import javafx.scene.layout.GridPane;

/**
 * @author Jonathan Hopper
 */
public class RailRoad extends Property{
    private static final ArrayList<RailRoad> RAILROADS = new ArrayList<>();
    private final ArrayList<Player> OWNER_FREQ = new ArrayList<>();
    
    public RailRoad(GridPane layOut, int cost) {
        tileLayOut = layOut;
        COST = cost;
        OWNER = null;
        indexLayout = new int[][]{ 
            {1, 2, 3, 4}, 
            {0, 0, 1, 1}, 
            {0, 1, 0, 1} 
        };
        RAILROADS.add(this);
    }
    
    @Override
    public void payRent(Player p) {
        // setting modifier
        RAILROADS.forEach( (rails) -> {
            OWNER_FREQ.add(rails.getOwner());
        });
        int ownerModifier = Collections.frequency(OWNER_FREQ, this.getOwner());
        
        // setting balances
        p.setBalance(p.getBalance() - 25 * ownerModifier);
        OWNER.setBalance(OWNER.getBalance() + 25 * ownerModifier);
    }
}
