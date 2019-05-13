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
public abstract class Tile implements ITile {
    protected int locationX;
    protected int locationY;

    public Tile(int locationX, int locationY) {
        this.locationX = locationX;
        this.locationY = locationY;
    }
    
    @Override
    public abstract void onTileLanding(Player player);
    
    @Override
    public abstract void applyEffect(Player player);

    @Override
    public double getLocationX() {
        return locationX;
    }

    public double getLocationY() {
        return locationY;
    }
}
