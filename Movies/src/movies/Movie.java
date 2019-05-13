/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package movies;

/**
 *
 * @author adfaj
 */

enum Genre {
    
}

public class Movie {
    private String title;
    private String genre;
    private int year;

    public Movie() {
    }

    public Movie(String title, String genre, int year) {
        this.title = title;
        this.genre = genre;
        this.year = year;
    }
    
    
}
