package peggame;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.platform.commons.annotation.Testable;
/**
 * This class implements the PegGame interface and represents the core logic of the Square Peg game.
 * It manages the game board, state, and provides methods for getting possible moves, making moves,
 * and checking the current game state.
 */
@Testable
public class SquarePegGame implements PegGame{

    private GameState state;
    private char[][] board; // 2D Array for representing 

    public SquarePegGame(char[][] board) {
        this.state = GameState.NOT_STARTED;
        this.board = board;
    }
/**
     * Gets a collection of all valid Move objects representing possible jumps from the current board state.
     * A jump is valid if there's an empty space two positions away in a given direction (horizontal, vertical, or diagonal),
     * and a peg is present in the middle position to be jumped over.
     *
     * @return A collection (List) of valid Move objects, or an empty list if no valid moves exist.
     */
    @Override
    public Collection<Move> getPossibleMoves() {
        List<Move> possibleMoves = new ArrayList<>();
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                if (board[row][col] == 'o') {
                    // Check for horizontal and vertical jumps
                    checkDirection(possibleMoves, row, col, -2, 0); // Up
                    checkDirection(possibleMoves, row, col, 2, 0);  // Down
                    checkDirection(possibleMoves, row, col, 0, -2); // Left
                    checkDirection(possibleMoves, row, col, 0, 2);  // Right
                    // Check for diagonal jumps
                    checkDirection(possibleMoves, row, col, -2, -2); // Up-Left
                    checkDirection(possibleMoves, row, col, -2, 2);  // Up-Right
                    checkDirection(possibleMoves, row, col, 2, -2);  // Down-Left
                    checkDirection(possibleMoves, row, col, 2, 2);   // Down-Right
                }
            }
        }
        return possibleMoves;
    }
 /**
     * Helper method to check for a valid jump in a specific direction from a given location on the board.
     *
     * @param moves The list of possible moves to be added to if a valid jump is found.
     * @param r1 The row coordinate of the starting location.
     * @param c1 The column coordinate of the starting location.
     * @param verticalOffset The vertical offset (how many rows to move) for the jump direction.
     * @param horizontalOffset The horizontal offset (how many columns to move) for the jump direction.
     */
    private void checkDirection(List<Move> moves, int r1, int c1, int verticalOffset, int horizontalOffset) {
        int targetRow = r1 + verticalOffset;
        int targetCol = c1 + horizontalOffset;
        int overRow = r1 + verticalOffset / 2;
        int overCol = c1 + horizontalOffset / 2;

        if (targetRow >= 0 && targetRow < board.length &&
                targetCol >= 0 && targetCol < board[0].length &&
                board[targetRow][targetCol] == '.' && board[overRow][overCol] == 'o') {
            moves.add(new Move(new Location(r1, c1), new Location(targetRow, targetCol)));
        }
    }
/**
     * Gets the current game state (NOT_STARTED, IN_PROGRESS, STALEMATE, or WON).
     *
     * @return The current GameState enum value.
     */
    @Override
    public GameState getGameState() {
        return this.state;
    }
    /**
     * The move is valid if it's present in the list of possible moves retrieved by `getPossibleMoves()`.
     * If the move is valid, the board is updated by moving the peg and jumping over another peg.
     * The game state is also updated based on whether there are any more possible moves or if the game is won (only one peg remaining).
     *
     * @param move The Move object representing the desired jump.
     * @throws PegGameException If the move is invalid (not present in possible moves).
     */
    @Override
    public void makeMove(Move move) throws PegGameException {
        Location from = move.getFrom();
        Location to = move.getTo();
        Location over = new Location((from.getRow() + to.getRow()) / 2, (from.getCol() + to.getCol()) / 2);

        if (!getPossibleMoves().contains(move)) {
            throw new PegGameException("Invalid move!");
        }

        board[from.getRow()][from.getCol()] = '.';
        board[to.getRow()][to.getCol()] = 'o';
        board[over.getRow()][over.getCol()] = '.';

        if (getPossibleMoves().isEmpty()) {
            if(countPegs() == 1){
                this.state = GameState.WON;
            }else{
                this.state = GameState.STALEMATE;
            }
        } else {
            state = GameState.IN_PROGRESS;
        }
    }
 /**
     * Counts the number of pegs remaining on the board.
     *
     * @return The number of pegs (characters 'o') on the board.
     */
    private int countPegs() {
        int count = 0;
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                if (board[row][col] == 'o') {
                    count++;
                }
            }
        }
        return count;
    }

    @Override
    public String toString() {
        String boardString = "";
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[i].length; j++){
                if(board[i][j] == '.')
                    boardString += '-' + " ";
                else
                    boardString += 'o' + " ";
            }
            boardString += "\n";
        }
        return boardString;
    }
/**
     * JUnit test to verify the initial game state is NOT_STARTED.
     */
    @Test
    public void testInitialState() {
        char[][] board = {
                {'o', 'o', '.'},
                {'.', '.', '.'},
                {'.', '.', 'o'}
        };
        SquarePegGame game = new SquarePegGame(board);
        assertEquals(GameState.NOT_STARTED, game.getGameState(), "Initial state should be NOT_STARTED");
    }

    @Test
    public void testPossibleMoves() {
        char[][] board = {
                {'o', 'o', '.'},
                {'.', '.', '.'},
                {'.', '.', 'o'}
        };
        SquarePegGame game = new SquarePegGame(board);
        Collection<Move> moves = game.getPossibleMoves();
        assertNotNull(moves, "Possible moves should not be null");
        assertFalse(moves.isEmpty(), "There should be possible moves");
    }
 /**
     * Getter method to access the internal game board representation (2D character array).
     *
     * @return A copy of the 2D character array representing the game board.
     */
    public char[][] getBoard() {
        return this.board;
    }

}
