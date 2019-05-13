
package Monopoly.Tile;

import Monopoly.Board;
import Monopoly.Controller.CardController;
import Monopoly.Player;
import java.io.IOException;
import java.util.Collections;
import java.util.Stack;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/*
 * @author Jonathan Hopper
 */
public class Chance extends Tile{

    private static final int CARDS_AMOUNT = 3;
    private static final Stack<Integer> cards = new Stack<>();
    
    // default constructor
    public Chance(GridPane layOut) {
        tileLayOut = layOut;
        indexLayout = new int[][]{ 
            {1, 2, 3, 4}, 
            {0, 1, 0, 1}, 
            {0, 0, 1, 1} 
        };
    }
    
    public static void addCards(){
        for(int i = 1; i < CARDS_AMOUNT; i++) {
            cards.push(i);
        }
    }
    
    public void shuffleCards() {
        Collections.shuffle(cards);
    }
    
    private void goToFreeParking(Player p){
        Board.tileList.get(20).setPlayer(p);
    }
    
    private void goBackSpaces(Player p ,int spaceAmount) {
        Board.tileList.get(
            Board.tileList.indexOf(p.getTile()) - 3
        ).setPlayer(p);
        p.setTile(Board.tileList.get(
            Board.tileList.indexOf(p.getTile()) - 3
        ));
        p.getTile().Effect(p);
    }
    
    private void poorTax(Player p) {
        p.setBalance(p.getBalance() - 75);
    }
    
    
    
    public void Effect(Player p) {
        int pop = cards.pop();
        Stage stage = null;
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(
                    getClass().getResource("/JavaFX/Card.fxml")
            );
            fxmlLoader.setController(
                    new CardController(p, pop)
            );
            Scene scene = new Scene(fxmlLoader.load());
            stage = new Stage();
            stage.setTitle("Player " + p);
            stage.setScene(scene);
        } catch (IOException e) {
        }
        stage.show();

        switch (pop) {
            // GoTo Free Parking
            case 1:
                goToFreeParking(p);
                break;
            //
            case 2:
                goBackSpaces(p, 3);
                break;
            // 
           case 3:
                poorTax(p);
                break;
       }
        // adds to bottom of stack
        cards.push(pop);
    }
}
