/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pex4;

import java.util.ArrayList;

/**
 *
 * @author adfaj
 */
public class Board {
    ArrayList<ITile> tiles;

    public Board(ArrayList<ITile> tiles) {
        this.tiles = tiles;
    }
    
    void executeTurn (Player player) {
        if(!player.isInJail()){
            player.rollDice();
            player.makeMove(player.addDice());
            tiles.get(player.currentPosition).applyEffect(player);
        }
        else {
            player.rollDice();
            if(player.getDice1() == player.getDice2() || player.getJailCounter() >= 3){
                if(player.getJailCounter() >= 3)
                    player.makePayment(50);
                player.setInJail(false);
                player.setJailCounter(0);
                player.makeMove(player.addDice());
                tiles.get(player.currentPosition).applyEffect(player);
            }
            else {
                player.setJailCounter(player.getJailCounter() + 1);
            }
        }
    }
}
