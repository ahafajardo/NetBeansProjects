/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Winner;

/**
 *
 * @author adfaj
 */
public class LottoTest {
    public static void main(String[] args) {
        Game theGame = new Game();
        theGame.spinBalls();
        theGame.play_once();
    }
}
