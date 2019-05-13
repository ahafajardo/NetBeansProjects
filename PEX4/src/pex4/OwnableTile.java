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
public abstract class OwnableTile extends Tile {
    protected int rentPrice;
    protected Player owner;
    protected int marketPrice;
    protected boolean owned;
    protected String propertyTitle;

    public OwnableTile(int locationX, int locationY, int rentPrice, Player owner, int marketPrice, String propertyTitle) {
        super(locationX, locationY);
        this.rentPrice = rentPrice;
        this.owner = owner;
        this.marketPrice = marketPrice;
        this.owned = false;
        this.propertyTitle = propertyTitle;
    }
    
    

    public boolean isOwned() {
        return owned;
    }

    public Player getOwner() {
        return owner;
    }

    public void setOwner(Player owner) {
        this.owner = owner;
    }

    public String getPropertyTitle() {
        return propertyTitle;
    }

    public int getMarketPrice() {
        return marketPrice;
    }

    public int getRentPrice() {
        return rentPrice;
    }
    
    
}
