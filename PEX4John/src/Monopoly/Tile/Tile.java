
package Monopoly.Tile;

import Monopoly.Player;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;

/**
 * @author Jonathan Hopper
 */
public abstract class Tile {
    // tile abstract for all spaces
    public int[][] indexLayout;
    private Image icon;
    GridPane tileLayOut;
    
    public void Effect(Player p) {}
    
    public Button getPlayer(int playerID) {
        Integer checkCol, checkRow;
        for (Node node : tileLayOut.getChildren()) {
            checkCol = GridPane.getColumnIndex(node);
            checkRow = GridPane.getRowIndex(node);
            checkCol = checkCol==null?0:checkCol;
            checkRow = checkRow==null?0:checkRow;
            if (checkCol == indexLayout[1][playerID - 1] 
                    && checkRow == indexLayout[2][playerID - 1]) {
                return (Button) node;
            }
        }
        return null;
    }
    
    public void setPlayer(Player currentPlayer) {
        GridPane.setConstraints(
                currentPlayer.getCharacter(), 
                indexLayout[1][currentPlayer.getID() - 1], 
                indexLayout[2][currentPlayer.getID() - 1]
        );
        System.out.println();
        tileLayOut.getChildren().add(currentPlayer.getCharacter());
    }
}
