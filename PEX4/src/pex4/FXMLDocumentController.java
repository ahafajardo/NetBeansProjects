/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pex4;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Callback;

/**
 *
 * @author adfaj
 */
public class FXMLDocumentController implements Initializable {
    public ObservableList<Human> players;
    
    private Game monopoly;
    
    @FXML
    private TableColumn<Human, Integer> moneyCol;

    @FXML
    private TableColumn<Human, String> playerCol;
    
    @FXML
    private TableView<Human> scoreTable;
    
    @FXML
    private ImageView player1Icon;
    
    @FXML
    private ImageView player2Icon;
    

    public ObservableList<Human> getPlayers() {
        return players;
    }

    public void setPlayers(ObservableList<Human> players) {
        this.players = players;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
        monopoly = new Game(players);
        
        scoreTable = new TableView<> (players);
        
        playerCol = new TableColumn<> ("Player");
        playerCol.setCellValueFactory((CellDataFeatures<Human, String> human) -> new ReadOnlyObjectWrapper(human.getValue().getAvatar().getAvatarTitle()) // human.getValue() returns the Human instance for a particular TableView row
        );
        
        moneyCol = new TableColumn<> ("Money");
        moneyCol.setCellValueFactory((CellDataFeatures<Human, Integer> human) -> new ReadOnlyObjectWrapper(human.getValue().getTotalMoney()) // human.getValue() returns the Human instance for a particular TableView row
        );
        
        scoreTable.getColumns().add(playerCol);
        scoreTable.getColumns().add(moneyCol);
        
//        player1Icon.setTranslateX(monopoly.board.tiles.get(0).getLocationX());
//        player1Icon.setTranslateY(monopoly.board.tiles.get(0).getLocationY());
//        
//        player2Icon.setTranslateX(monopoly.board.tiles.get(0).getLocationX());
//        player2Icon.setTranslateY(monopoly.board.tiles.get(0).getLocationY());

        /* 
        Here is where I had to stop. I was unable to figure out how to make my list of players observable to the controller,
        despite poring over the Java documentation to find a solution. I intended this so that my controller could populate
        the table that showed the players and their current scores. On top of this, even making an attempt to place images
        while this controller was initializing caused the controller to throw an exception, saying that the root could not be null,
        let alone trying to insert an image.
        */
    }
    
}
