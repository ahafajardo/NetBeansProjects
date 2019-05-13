
package Monopoly;

import Monopoly.Tile.*;
import java.util.ArrayList;
import java.util.Arrays;
import javafx.scene.Node;
import javafx.scene.layout.GridPane;

/*
 * @author Jonathan Hopper
 */
public class Board {
     int[][] jailLayout = new int[][]{ 
            {1, 2, 3, 4}, 
            {0, 0, 1, 2}, 
            {0, 1, 2, 2} 
        };
     
    public static ArrayList<Tile> tileList = new ArrayList<>();
    
    private final GridPane mainPane;
    
    // constructor
    public Board(ArrayList<Player> playerList, GridPane gridPane) {                         
        mainPane = gridPane;
        
        // setting player characters
        Go testTile = new Go((GridPane) getNodeFromGridPane(mainPane, 10, 10));
        playerList.forEach( (tPlayer) -> {
            tPlayer.setCharacter(testTile.getPlayer(tPlayer.getID()));
            tPlayer.setTile(testTile);
        });
        
        
        // setting up board
        tileList.addAll(Arrays.asList(
                testTile,
                new Property((GridPane) getNodeFromGridPane(mainPane, 9, 10), 60, 2),
                new Chest((GridPane) getNodeFromGridPane(mainPane, 8, 10)),
                new Property((GridPane) getNodeFromGridPane(mainPane, 7, 10), 60, 4),
                new IncomeTax((GridPane) getNodeFromGridPane(mainPane, 6, 10)), // Tuition Payment
                new RailRoad((GridPane) getNodeFromGridPane(mainPane, 5, 10), 200),
                new Property((GridPane) getNodeFromGridPane(mainPane, 4, 10), 100, 6),
                new Chance((GridPane) getNodeFromGridPane(mainPane, 3, 10)),
                new Property((GridPane) getNodeFromGridPane(mainPane, 2, 10), 100, 6),
                new Property((GridPane) getNodeFromGridPane(mainPane, 1, 10), 120, 8),
                new FreeParking((GridPane) getNodeFromGridPane(mainPane, 0, 10), jailLayout),
                new Property((GridPane) getNodeFromGridPane(mainPane, 0, 9), 140, 10),
                new Utility((GridPane) getNodeFromGridPane(mainPane, 0, 8), 150), // Utility
                new Property((GridPane) getNodeFromGridPane(mainPane, 0, 7), 140, 10),
                new Property((GridPane) getNodeFromGridPane(mainPane, 0, 6), 160, 12),
                new RailRoad((GridPane) getNodeFromGridPane(mainPane, 0, 5), 200),
                new Property((GridPane) getNodeFromGridPane(mainPane, 0, 4), 180, 14),
                new Chest((GridPane) getNodeFromGridPane(mainPane, 0, 3)),
                new Property((GridPane) getNodeFromGridPane(mainPane, 0, 2), 180, 14),
                new Property((GridPane) getNodeFromGridPane(mainPane, 0, 1), 200, 16),
                new FreeParking((GridPane) getNodeFromGridPane(mainPane, 0, 0)),
                new Property((GridPane) getNodeFromGridPane(mainPane, 1, 0), 220, 18),
                new Chance((GridPane) getNodeFromGridPane(mainPane, 2, 0)),
                new Property((GridPane) getNodeFromGridPane(mainPane, 3, 0), 220, 18),
                new Property((GridPane) getNodeFromGridPane(mainPane, 4, 0), 240, 20),
                new RailRoad((GridPane) getNodeFromGridPane(mainPane, 5, 0), 200),
                new Property((GridPane) getNodeFromGridPane(mainPane, 6, 0), 260, 22),
                new Property((GridPane) getNodeFromGridPane(mainPane, 7, 0), 260, 22),
                new Utility((GridPane) getNodeFromGridPane(mainPane, 8, 0), 150), // Utility
                new Property((GridPane) getNodeFromGridPane(mainPane, 9, 0), 280, 24),
                new Jail((GridPane) getNodeFromGridPane(mainPane, 0, 10)), // Jail
                new Property((GridPane) getNodeFromGridPane(mainPane, 10, 1), 300, 26),
                new Property((GridPane) getNodeFromGridPane(mainPane, 10, 2), 300, 26),
                new Chest((GridPane) getNodeFromGridPane(mainPane, 10, 3)),
                new Property((GridPane) getNodeFromGridPane(mainPane, 10, 4), 320, 28),
                new RailRoad((GridPane) getNodeFromGridPane(mainPane, 10, 5), 200),
                new Chance((GridPane) getNodeFromGridPane(mainPane, 10, 6)),
                new Property((GridPane) getNodeFromGridPane(mainPane, 10, 7), 350, 35),
                new LuxuryTax((GridPane) getNodeFromGridPane(mainPane, 10, 8)), // Required Textbook
                new Property((GridPane) getNodeFromGridPane(mainPane, 10, 9), 400, 40)
        ));
    }
    
    // obtaining tile-specific GridPane
    private Node getNodeFromGridPane(GridPane gridPane, int col, int row) {
        Integer checkCol, checkRow;
        for (Node node : gridPane.getChildren()) {
            checkCol = GridPane.getColumnIndex(node);
            checkRow = GridPane.getRowIndex(node);
            checkCol = checkCol==null ? 0:checkCol;
            checkRow = checkRow==null ? 0:checkRow;
            if (checkCol == col && checkRow == row) {
                return node;
            }
        }
        return null;
    }
    
}
