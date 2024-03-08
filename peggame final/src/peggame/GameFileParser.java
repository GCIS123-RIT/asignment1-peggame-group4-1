package peggame;
import static org.junit.jupiter.api.Assertions.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.junit.jupiter.api.Test;
import org.junit.platform.commons.annotation.Testable;
 /**
     * Reads a peg game from a file and creates a corresponding PegGame instance.
     *
     * @param filename The name of the file containing the game board.
     * @return A PegGame instance representing the parsed game.
     * @throws IOException If an error occurs while reading the file.
     */
@Testable
public class GameFileParser {

    public static PegGame readGameFromFile(String filename) throws IOException {
        // Function takes a filename and returns a PegGame<Interface> implementation
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            int size = Integer.parseInt(reader.readLine());// Read board size
            char[][] board = new char[size][size];// Create board
              // Read board content line by line
            for (int i = 0; i < size; i++) {
                String line = reader.readLine().substring(0,size);
                board[i] = line.toCharArray();
            }
            
            return new SquarePegGame(board);
        }
    }
    /**

    * JUnit test to verify that the `readGameFromFile()` method correctly parses a sample game file
    * and creates a corresponding SquarePegGame instance.
    *
     */
    @Test
    public void testReadGameFromFile() throws IOException {
        String testFilePath = "gm1.txt";
        PegGame game = GameFileParser.readGameFromFile(testFilePath);
        // 1. Test if the method returns a non-null game object
        assertNotNull(game, "Game should not be null");
        // 2. Test if the returned game is an instance of SquarePegGame
        assertTrue(game instanceof SquarePegGame, "Game should be instance of SquarePegGame");
        SquarePegGame squareGame = (SquarePegGame) game;
        // 3. Test if the parsed board has the correct dimensions
        char[][] board = squareGame.getBoard();
        assertEquals(3, board.length, "Board should have 3 rows");
         // 4. Test the placement of pegs and empty spaces on the board
        assertEquals('o', board[0][0], "Expected peg at (0,0)");
        assertEquals('o', board[0][1], "Expected peg at (0,1)");
        assertEquals('.', board[0][2], "Expected empty space at (0,2)");
        assertEquals('.', board[1][0], "Expected empty space at (1,0)");
        assertEquals('.', board[1][1], "Expected empty space at (1,1)");
        assertEquals('.', board[1][2], "Expected empty space at (1,2)");
        assertEquals('.', board[2][0], "Expected empty space at (2,0)");
        assertEquals('.', board[2][1], "Expected empty space at (2,1)");
        assertEquals('.', board[2][2], "Expected empty space at (2,2)");
    }

}
