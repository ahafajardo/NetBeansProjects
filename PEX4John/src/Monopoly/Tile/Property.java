
package Monopoly.Tile;

import Monopoly.Board;
import Monopoly.Game;
import Monopoly.Player;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

/*
 * @author Jonathan Hopper
 */
public class Property extends Tile{
    protected int RENT;
    protected int COST;
    protected Player OWNER;

    // default constructor (for railRoads and Utilities)
    public Property() { }
    
    // property constructor
    public Property(GridPane layOut, int cost, int rent) {
        tileLayOut = layOut;
        COST = cost;
        RENT = rent;
        OWNER = null;
        indexLayout = new int[][]{ 
            {1, 2, 3, 4}, 
            {0, 1, 0, 1}, 
            {1, 1, 2, 2} 
        };
    }
    
    // purchase or pay rent
    @Override
    public void Effect(Player p) {
        if(((Property) p.getTile()).getOwner() == null) {
            ImageView propertyImageView = (ImageView) Game.propertyPane.getChildren().get(0);
            String propertyIndex = Integer.toString(Board.tileList.indexOf(p.getTile()));
            propertyImageView.setImage(
                    new Image("/images/Property/" + propertyIndex + ".png")
            );
            Game.propertyPane.setVisible(true);
        }
        else {
            ((Property) p.getTile()).payRent(p);
        }
    }
    
    // get owner of property
    public Player getOwner() {
        return OWNER;
    }
    
    // purchasing property
    public void Purchase(Player p) {
        OWNER = p;
        OWNER.setBalance(OWNER.getBalance() - COST);
        OWNER.ownedTiles.add(this);
    }
    
    // paying rent
    public void payRent(Player p) {
        p.setBalance(p.getBalance() - RENT);
        OWNER.setBalance(OWNER.getBalance() + RENT);
    }
}
