
package Monopoly.Tile;

import javafx.scene.layout.GridPane;

/*
 * @author Jonathan Hopper
 */
public class FreeParking extends Tile{

    public FreeParking(GridPane layOut, int[][] idxLayout) {
        tileLayOut = layOut;
        indexLayout = idxLayout;
    }
    
    // default constructor
    public FreeParking(GridPane layOut) {
        tileLayOut = layOut;
        indexLayout = new int[][]{ 
            {1, 2, 3, 4}, 
            {0, 0, 1, 1}, 
            {0, 1, 0, 1} 
        };
    }
}
