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
public class Utility extends OwnableTile {
    public Utility(int locationX, int locationY, Player banker, int marketPrice, String propertyTitle) {
        super(locationX, locationY, 4, banker, marketPrice, propertyTitle);
    }
    
    @Override
    public void onTileLanding(Player player) {
        if(!player.equals(owner) && isOwned())
            applyEffect(player);   
    }
    
    @Override
    public void applyEffect(Player player) {
        int diceTotal = (player.getDice1() + player.getDice2());
        player.makePayment(rentPrice * diceTotal);
        owner.receivePayment(rentPrice * diceTotal);
    }
    
    public void purchaseProperty(Player player) {
        if(!isOwned() && player.getTotalMoney() > marketPrice){
            player.makePayment(marketPrice);
            setOwner(player);
        }
    }
}
