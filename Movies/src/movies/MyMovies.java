/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package movies;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author adfaj
 */

/*
    When creating authorship application, use an array list to store each line, and count to find number of lines.
*/

public class MyMovies {
    private Movie[] theBest;
    private String[] friends;
    private List<String> myFriends;

    public MyMovies() {
        theBest = new Movie[3];
        friends = new String[4];
        myFriends = new ArrayList<>();
    }
    
    public void changeFriends() {
        myFriends.add("Tom Brady");
        myFriends.add("Levon Bell");
        myFriends.remove("Tom Brady");
    }

    
    
    
}
