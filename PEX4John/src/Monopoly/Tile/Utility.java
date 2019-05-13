
package Monopoly.Tile;

import Monopoly.Game;
import Monopoly.Player;
import java.util.ArrayList;
import java.util.Collections;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

/**
 * @author Jonathan Hopper
 */
public class Utility extends Property{
    
    private static final ArrayList<Utility> UTILITIES = new ArrayList<>();
    private final ArrayList<Player> OWNER_FREQ = new ArrayList<>();
    
    public Utility(GridPane layOut, int cost) {
        tileLayOut = layOut;
        COST = cost;
        OWNER = null;
        indexLayout = new int[][]{ 
            {1, 2, 3, 4}, 
            {0, 0, 1, 1}, 
            {0, 1, 0, 1} 
        };
        UTILITIES.add(this);
    }
    
    @Override
    public void payRent(Player p) {
        // obtaining imageViews from dicePane
        ImageView diceImage1 = (ImageView) Game.dicePane.getChildren().get(0);
        ImageView diceImage2 = (ImageView) Game.dicePane.getChildren().get(1);
        // setting modifiers
        UTILITIES.forEach( (rails) -> {
            OWNER_FREQ.add(rails.getOwner());
        });
        int ownerModifier = Collections.frequency(OWNER_FREQ, this.getOwner());
        int diceRoll = (int) diceImage1.getUserData() + (int) diceImage2.getUserData();
        if(ownerModifier == 1)
            ownerModifier = 4;
        else if(ownerModifier == 2)
            ownerModifier = 10;
        
        // setting balances
        p.setBalance(p.getBalance() - diceRoll * ownerModifier);
        OWNER.setBalance(OWNER.getBalance() + diceRoll * ownerModifier);
    }
}
