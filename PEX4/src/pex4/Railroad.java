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
public class Railroad extends OwnableTile {
    public Railroad(int locationX, int locationY, int rentPrice, Player banker, int marketPrice, String propertyTitle) {
        super(locationX, locationY, rentPrice, banker, marketPrice, propertyTitle);
    }
    
    @Override
    public void onTileLanding(Player player) {
        if(!player.equals(owner) && isOwned())
            applyEffect(player);   
    }
    
    @Override
    public void applyEffect(Player player) {
        player.makePayment(rentPrice);
        owner.receivePayment(rentPrice);
    }
    
    public void purchaseProperty(Player player) {
        if(!isOwned()){
            player.makePayment(marketPrice);
            setOwner(player);
        }
    }
}
