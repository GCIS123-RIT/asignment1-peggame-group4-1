package peggame;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.platform.commons.annotation.Testable;

@Testable
public class Location {
    private int row;
    private int col;
 /**
     * Constructor for the Location class.
     *
     * @param row The row coordinate (0-based indexing).
     * @param col The column coordinate (0-based indexing).
     */
    public Location(int row, int col){
        this.row = row;
        this.col = col;
    }
/**
     * Gets the row coordinate of the location.
     *
     * @return The row coordinate (0-based indexing).
     */
    public int getRow(){
        return this.row;
    }
/**
     * Gets the column coordinate of the location.
     *
     * @return The column coordinate (0-based indexing).
     */
    public int getCol(){
        return this.col;
    }
 /**
     * Returns a string representation of the location in the format "(row, col)".
     *
     * @return A string representation of the location.
     */
    @Override
    public String toString() {
        return "Location{" +
                "row=" + row +
                ", col=" + col +
                '}';
    }
 /**
     * Compares this Location object with another object for equality.
     * Two locations are considered equal if they have the same row and column coordinates.
     *
     * @param obj The object to compare with.
     * @return True if the objects are equal, false otherwise.
     */
    @Override
    public boolean equals(Object obj) {
        Location location2 = (Location) obj;
        if(location2.getCol() == this.getCol() && location2.getRow() == this.getRow())
            return true;
        else
            return false;
    }
/**
     * JUnit test to verify that locations with the same coordinates are considered equal.
     */
    @Test
    public void testLocationEquality() {
        Location loc1 = new Location(3, 4);
        Location loc2 = new Location(3, 4);
        Location loc3 = new Location(5, 6);

        assertEquals(loc1, loc2, "Locations with the same row and column should be equal");
        assertNotEquals(loc1, loc3, "Different locations should not be equal");
    }
/**
     * JUnit test to verify that the toString() method returns the expected format.
     */
    @Test
    public void testLocationToString() {
        Location loc = new Location(3, 4);
        String expected = "Location{row=3, col=4}";
        assertEquals(expected, loc.toString(), "toString should return the correct representation");
    }
}
