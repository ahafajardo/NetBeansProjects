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
public class Chance extends Tile {
    private int card;
    private final String[] cardDescriptions;

    public Chance(int locationX, int locationY) {
        super(locationX, locationY);
        this.cardDescriptions = new String[]{"Go to Jail!", "Advance to Go!", "Your building and loan matures, collect $150!"};
        
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
                player.setCurrentPosition(10);
                player.setInJail(true);
                break;
            case 1:
                player.setCurrentPosition(0);
                player.receivePayment(200);
                break;
            case 2:
                player.receivePayment(150);
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
