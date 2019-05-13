
package Monopoly.Tile;

import Monopoly.Controller.IncomeTaxController;
import Monopoly.Player;
import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 * @author Jonathan Hopper
 */
public class IncomeTax extends Tile{
    
    public IncomeTax(GridPane layOut) {
        tileLayOut = layOut;
        indexLayout = new int[][]{ 
            {1, 2, 3, 4}, 
            {0, 0, 1, 1}, 
            {0, 1, 0, 1} 
        };
    }
    
    @Override
    public void Effect(Player p) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(
                    getClass().getResource("/JavaFX/IncomeTax.fxml")
            );
            fxmlLoader.setController(
                    new IncomeTaxController(p)
            );
            Scene scene = new Scene(fxmlLoader.load());
            Stage stage = new Stage();
            stage.setTitle("Player " + p);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
        }
    }
    
}
