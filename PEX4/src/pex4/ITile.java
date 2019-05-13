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
public interface ITile {
    void onTileLanding(Player player);
    
    void applyEffect(Player player);

    public double getLocationX();

    public double getLocationY();
}
