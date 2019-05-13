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
public class Tax extends Tile {
    int dueTax;

    public Tax(int locationX, int locationY, int dueTax) {
        super(locationX, locationY);
        this.dueTax = dueTax;
    }
    
    @Override
    public void onTileLanding(Player player) {
        applyEffect(player);
    }

    @Override
    public void applyEffect(Player player) {
        player.makePayment(dueTax);
    }
    
    
}
