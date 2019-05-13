
package Monopoly;

import Monopoly.Tile.Chance;
import Monopoly.Tile.Tile;
import java.util.ArrayList;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

/*
 * @author Jonathan Hopper
 */
public class Game {
    
    
    public ArrayList<GridPane> gridList;
    
    public static Pane propertyPane;
    public static Pane dicePane;
    
    ArrayList<Player> gamePlayers;
    private Player currentPlayer;
    
    // constructor
    public Game(ArrayList<Player> playerList, GridPane mainPane, Pane property, Pane dice) {
        gamePlayers = playerList;
        propertyPane = property;
        dicePane = dice;
        currentPlayer = gamePlayers.get(0);
        new Board(playerList, mainPane);
        Chance.addCards();
    }
    
    // return current player's turn
    public Player getCurrentPlayer() {
        return currentPlayer;
    }
    
    // change to next player
    public void nextPlayer() {
        try {
            currentPlayer = gamePlayers.get(gamePlayers.indexOf(currentPlayer) + 1);
        } catch (Exception e) {
            currentPlayer = gamePlayers.get(0);
        }
    }
    
    // roll dice
    public void rollDice() {
        // obtaining actual dice rolls
        int dice1 = currentPlayer.rollDice();
        int dice2 = currentPlayer.rollDice();
        int diceRoll = dice1 + dice2;
        
        // setting imageViews for dice rolls
        ImageView diceImage1 = (ImageView) dicePane.getChildren().get(0);
        ImageView diceImage2 = (ImageView) dicePane.getChildren().get(1);
        diceImage1.setImage(
                new Image("/images/diceFaces/" + dice1 + ".png")
        );
        diceImage2.setImage(
                new Image("/images/diceFaces/" + dice2 + ".png")
        );
        // setting data to be used for Tile specific effects
        diceImage1.setUserData(dice1);
        diceImage2.setUserData(dice2);
        
        // ensuring roll stays within arrayList size
        int tileIndex = (int) Board.tileList.indexOf(currentPlayer.getTile()) + diceRoll;
        if(tileIndex >= 39) {
            tileIndex = tileIndex - 39;
            currentPlayer.setBalance(currentPlayer.getBalance() + 200); // passing go
        }
        
        // obtaining next tile
        Tile nextTile = Board.tileList.get(
                tileIndex
        );
        
        nextTile.setPlayer(currentPlayer);
        currentPlayer.setTile(nextTile);
        
        // doubles check
        if(dice1 == dice2)
            rollDice();
        else
            nextTile.Effect(currentPlayer);
    }
}
