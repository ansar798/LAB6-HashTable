/**
 * Movie.java
 * @author Jennifer Parrish
 * CIS 22C, Lab 6
 */

import java.text.DecimalFormat;

public class Movie {
    private String title;
    private String director;
    private int year;
    private double grossMillions;
    
    /**
     * Constructor for the Movie class
     * @param title the Movie's title 
     * @param director the Movie's director
     */
    public Movie(String title, String director) {
        this.title = title;
        this.director = director;
        this.year = -1;
        this.grossMillions = -1;
    }
    
    /**
     * Constructor for the Movie class
     * @param title the Movie's title 
     * @param director the Movie's director
     * @param year the year the Movie was released
     * @param gross the amount grossed
     * over the lifetime of the movie, 
     * given in Millions of dollars
     */
    public Movie(String title, String director,
            int year, double gross) {
        this.title = title;
        this.director = director;
        this.year = year;
        this.grossMillions = gross;
    }
    
    /**
     * Accesses the title of the Movie
     * @return the Movie's title
     */
    public String getTitle() {
        return title;
    }
    
    /**
     * Accesses the director of the Movie
     * @return the Movie's director
     */
    public String getDirector() {
        return director;
    }
    
    /**
     * Access the year the Movie was released
     * in theaters
     * @return the year the Movie was released
     */
    public int getYear() {
        return year;
    }
    
    /**
     * Access the gross amount earned by the 
     * Movie in Millions of dollars
     * @return the Movie's gross in Millions
     */
    public double getGross() {
        return grossMillions;
    }
    
    /**
     * Sets the title of the Movie
     * @param title the Movie's title
     */
    public void setTitle(String title) {
        this.title = title;
    }
    
    /**
     * Sets the director of the Movie
     * @param director the Movie's director
     */
    public void setDirector(String director) {
        this.director = director;
    }
    
    /**
     * Sets the year the Movie was released
     * @param year the year the Movie was released
     */
    public void setYear(int year) {
        this.year = year;
    }
    
    /**
     * Sets the gross amount earned by the Movie
     * in Millions of dolalrs
     * @param gross the gross amount in Millions
     * of dollars
     */
    public void setGross(double gross) {
        grossMillions = gross;
    }
    
    /**
     * Creates a String of the Movie information
     * the following format:
     * Title: <title>
     * Director: <director>
     * Year: <year>
     * Gross in Millions: $<grossMillions>
     * Note that there should be no <>
     * in the resulting String
     * Also the grossMillions should be displayed
     * as follows: XXX,XXX.XX
     */
    @Override public String toString() {
        DecimalFormat d = new DecimalFormat("###,###.0");
        String result = "Title: " + title
                + "\nDirector: " + director
                + "\nYear: " + year
                + "\nGross in Millions: $" + d.format(grossMillions) + "\n";
        return result;
    }
    
    /**
     * Determines whether two Movie objects are 
     * equal by comparing titles and directors
     * @param otherMovie the second Movie object
     * @return whether the Movies are equal
     */
    @Override public boolean equals(Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof Movie)) {
            return false;
        }
        else {
            Movie otherMovie = (Movie) o;
            return otherMovie.title.equals(title) && otherMovie.director.equals(director);
        }
        
    }
    
    
    /**
     * Returns a consistent hash code for 
     * each Movie by summing the Unicode values
     * of each character in the key
     * Key = title + director
     * @return the hash code
     */
    @Override public int hashCode() {
        String key = title + director;
        int sum = 0;
        for (int i = 0; i < key.length(); i++) {
            sum += (int) key.charAt(i);
        }
        return sum;
    }

}
