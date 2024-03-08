package peggame;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.platform.commons.annotation.Testable;
/**
 * This class represents a move in the Square Peg game, consisting of a starting location (from) and a destination location (to) for a peg.
 */
@Testable
public class Move {
    private Location from;
    private Location to;

    /**
     * Constructor for the Move class.
     *
     * @param from The starting location of the peg.
     * @param to The destination location for the peg after the move.
     */ 
    public Move(Location from, Location to){
        this.from = from;
        this.to = to;
    }
/**
     * Gets the starting location of the peg for this move.
     *
     * @return The starting location (type: Location).
     */
    public Location getFrom(){
        return this.from;
    }
 /**
     * Gets the destination location for the peg after this move.
     *
     * @return The destination location (type: Location).
     */
    public Location getTo(){
        return this.to;
    }
 /**
     * Returns a string representation of the move in the format "Move{from=..., to=...}".
     * The "..." parts are replaced by the string representations of the starting and ending locations.
     *
     * @return A string representation of the move.
     */ 
    @Override
    public String toString() {
        return "Move{" +
                "from=" + from +
                ", to=" + to +
                '}';
    }
  /**
     * Compares this Move object with another object for equality.
     * Two moves are considered equal if they have the same starting and destination locations.
     *
     * @param obj The object to compare with.
     * @return True if the objects are equal, false otherwise.
     */
    @Override
    public boolean equals(Object o){
        Move move2 = (Move) o;
        if(move2.getFrom().equals(this.getFrom()) && move2.getTo().equals(this.getTo()))
            return true;
        else
            return false;
    }
 /**
     * JUnit test to verify that moves with the same starting and ending locations are considered equal.
     */
    @Test
    public void testMoveEquality() {
        Location loc1 = new Location(1, 1);
        Location loc2 = new Location(2, 2);
        Move move1 = new Move(loc1, loc2);
        Move move2 = new Move(loc1, loc2);

        assertEquals(move1, move2, "Two moves with the same locations should be equal");
    }
  /**
     * JUnit test to verify that the toString() method returns the expected format.
     */
    @Test
    public void testMoveToString() {
        Location loc1 = new Location(1, 1);
        Location loc2 = new Location(2, 2);
        Move move = new Move(loc1, loc2);

        String expected = "Move{from=Location{row=1, col=1}, to=Location{row=2, col=2}}";
        assertEquals(expected, move.toString(), "toString should return the correct representation");
    }
}
