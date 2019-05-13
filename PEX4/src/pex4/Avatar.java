/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pex4;

import javafx.scene.image.Image;

/**
 *
 * @author adfaj
 */
public class Avatar {
    Image playerImage;
    String avatarTitle;

    public Avatar(Image playerImage, String avatarTitle) {
        this.playerImage = playerImage;
        this.avatarTitle = avatarTitle;
    }

    public Image getPlayerImage() {
        return playerImage;
    }

    public String getAvatarTitle() {
        return avatarTitle;
    }

    public void setAvatarTitle(String avatarTitle) {
        this.avatarTitle = avatarTitle;
    }

    public void setPlayerImage(Image playerImage) {
        this.playerImage = playerImage;
    }
    
    
}
