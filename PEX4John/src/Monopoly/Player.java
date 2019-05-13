
package Monopoly;

import Monopoly.Tile.Tile;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Random;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/*
 * @author Jonathan Hopper
 */
abstract public class Player {
    
    private double balance;
    private Tile currentTile;
    private boolean isJailed;
    private int jailCounter;
    
    public final ArrayList<Tile> ownedTiles;
    
    private final int ID;
    
    private Button characterButton;
    private final Image icon;
    private Label balanceLabel;
    
    
    private final Random rand;
    
    public Player(Image characterIcon, int identity) {
        balance = 1500.00;
        isJailed = false;
        jailCounter = 0;
        ownedTiles = new ArrayList<>();
        rand = new SecureRandom();
        icon = characterIcon;
        ID = identity;
    }
    
    public void toggleJail() {
        isJailed = !isJailed;
    }
    
    public int getJailCount() {
        return jailCounter;
    }
    
    public void setJailCounter(int counter) {
        jailCounter = counter;
    }
    
    public double getBalance() {
        return balance;
    }
    
    public void setBalance(double b) {
        balance = b;
        balanceLabel.setText("$" + Double.toString(balance));
    }
    
    public void setBalanceLabel(Label balLabel) {
        balanceLabel = balLabel;
    }
    
    public void setTile(Tile tile) {
        currentTile = tile;
    }
    
    public Tile getTile() {
        return currentTile;
    }
    
    public void setCharacter(Button player) {
        characterButton = player;
        ImageView playerCharacter = (ImageView) characterButton.getGraphic();
        playerCharacter.setImage(icon);
    }
    
    public Button getCharacter() {
        return characterButton;
    }
    
    public Image getIcon() {
        return icon;
    }
    
    public int getID() {
        return ID;
    }
    
    public String getProperties() {
        return ownedTiles.toString();
    }
    
    public int rollDice() {
        return rand.nextInt(6) + 1;
    }
    
}
