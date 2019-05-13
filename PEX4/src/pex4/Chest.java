/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pex4;

import java.util.Random;

/**
 *
 * @author adfaj
 */
public class Chest extends Tile {
    private int card;
    private final String[] cardDescriptions;

    public Chest(int locationX, int locationY) {
        super(locationX, locationY);
        this.cardDescriptions = new String[]{"Bank error in your favor, collect $200!", "Advance to Go!", "Doctor's fee, pay $50!"};
    }
    
    @Override
    public void onTileLanding(Player player) {
        applyEffect(player);
    }

    @Override
    public void applyEffect(Player player) {
        Random r = new Random();
        card = r.nextInt(3);
        
        switch (card) {
            case 0:
                player.receivePayment(200);
                break;
            case 1:
                player.setCurrentPosition(0);
                player.receivePayment(200);
                break;
            case 2:
                player.makePayment(50);
                break;
        }
    }
    
    public String getCardDescription(int card) {
        if(card < 3 && card > -1)
            return cardDescriptions[card];
        else
            return cardDescriptions[0];
    }

    public String[] getCardDescriptions() {
        return cardDescriptions;
    }
    
    
}
