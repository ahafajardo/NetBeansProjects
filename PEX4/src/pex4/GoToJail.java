/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pex4;

/**
 *
 * @author adfaj
 */
public class GoToJail extends Tile {

    public GoToJail(int locationX, int locationY) {
        super(locationX, locationY);
    }
    
    
    @Override
    public void onTileLanding(Player player) {
        applyEffect(player);
    }

    @Override
    public void applyEffect(Player player) {
        player.setCurrentPosition(10);
        player.setInJail(true);
    }
    
    
}
