/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pex4;

import java.util.ArrayList;
import javafx.collections.ObservableList;

/**
 *
 * @author adfaj
 */
public class Game {
    Board board;
    ObservableList<Human> players;
    Human banker;
    Human p1;
    Human p2;
    Human p3;
    Human p4;

    public Game(ObservableList<Human> players) {
        this.players = players;
    }
    
    
    
    enum GameMode {
        P2, P3, P4
    }
    
    void startGame(int selector) {
        
        GameMode mode;
        
        banker = new Human();
        
        switch (selector) {
            case 0:
                mode = GameMode.P2;
                break;
            case 1:
                mode = GameMode.P3;
                break;
            case 2:
                mode = GameMode.P4;
                break;
            default:
                mode = GameMode.P2;
        }
        
        switch (mode) {
            case P2:
                p1 = players.get(0);
                p2 = players.get(1);
                break;
            case P3:
                p1 = players.get(0);
                p2 = players.get(1);
                p3 = players.get(2);
                break;
            case P4:
                p1 = players.get(0);
                p2 = players.get(1);
                p3 = players.get(2);
                p4 = players.get(3);
                break;
        }
        
        ArrayList<ITile> boardTiles = new ArrayList<ITile>();
        
        boardTiles.add(new FreeParking(604, 612));
        boardTiles.add(new Property(604, 554, 2, banker, 60, "Old Kent Road"));
        boardTiles.add(new Chest(604, 494));
        boardTiles.add(new Property(604, 444, 4, banker, 60, "Whitechapel Road"));
        boardTiles.add(new Tax(604, 374, 200));
        boardTiles.add(new Railroad(604, 324, 25, banker, 200, "Kings Cross Station"));
        boardTiles.add(new Property(604, 264, 6, banker, 100, "The Angel Islington"));
        boardTiles.add(new Chance(604, 214));
        boardTiles.add(new Property(604, 154, 6, banker, 100, "Euston Road"));
        boardTiles.add(new Property(604, 104, 8, banker, 120, "Pentonville Road"));
        boardTiles.add(new Jail(604, 14));
        boardTiles.add(new Property(554, 14, 10, banker, 140, "Pall Mall"));
        boardTiles.add(new Utility(494, 14, banker, 150, "Electric Company"));
        boardTiles.add(new Property(434, 14, 10, banker, 140, "White Hall"));
        boardTiles.add(new Property(374, 14, 12, banker, 160, "North Avenue"));
        boardTiles.add(new Railroad(334, 14, 25, banker, 200, "Marylebone Station"));
        boardTiles.add(new Property(274, 14, 14, banker, 180, "Bow Street"));
        boardTiles.add(new Chest(214, 14));
        boardTiles.add(new Property(154, 14, 14, banker, 180, "Marlborough Street"));
        boardTiles.add(new Property(94, 14, 16, banker, 200, "Vine Street"));
        boardTiles.add(new FreeParking(24, 14));
        boardTiles.add(new Property(24, 104, 18, banker, 220, "Strand"));
        boardTiles.add(new Chance(24, 154));
        boardTiles.add(new Property(24, 214, 18, banker, 220, "Fleet Street"));
        boardTiles.add(new Property(24, 264, 20, banker, 240, "Trafalgar Square"));
        boardTiles.add(new Railroad(24, 324, 25, banker, 200, "Fenchurch Station"));
        boardTiles.add(new Property(24, 374, 22, banker, 260, "Leicester Square"));
        boardTiles.add(new Property(24, 444, 22, banker, 260, "Conventry Street"));
        boardTiles.add(new Utility(24, 494, banker, 150, "Water Works"));
        boardTiles.add(new Property(24, 554, 24, banker, 280, "Picadilly"));
        boardTiles.add(new GoToJail(24, 612));
        boardTiles.add(new Property(94, 612, 26, banker, 300, "Regent Street"));
        boardTiles.add(new Property(154, 612, 26, banker, 300, "Oxford Street"));
        boardTiles.add(new Chest(214, 612));
        boardTiles.add(new Property(274, 612, 28, banker, 320, "Bond Street"));
        boardTiles.add(new Railroad(334, 612, 25, banker, 200, "Liverpool Station"));
        boardTiles.add(new Chance(374, 612));
        boardTiles.add(new Property(434, 612, 35, banker, 350, "Park Lane"));
        boardTiles.add(new Tax(494, 612, 100));
        boardTiles.add(new Property(554, 612, 50, banker, 400, "Mayfair"));
        
        board = new Board(boardTiles);
    }
    
    boolean checkGameOver() {
        boolean gameOver = true;
        int activePlayers = 0;
        
        for(int i = 0; i < players.size(); i++) {
            if(players.get(i).isBankrupt() == false){
                activePlayers++;
            }
        }
        
        if(activePlayers > 1)
            gameOver = false;
        
        return gameOver;
    }
    
    Human findWinner() {
        int largestWealth = 0;
        Human winner = players.get(0);
        
        for(int i = 0; i < players.size(); i++) {
            if(players.get(i).getTotalMoney() > largestWealth){
                winner = players.get(i);
                largestWealth = players.get(i).getTotalMoney();
            }
        }
        
        return winner;
    }
}
