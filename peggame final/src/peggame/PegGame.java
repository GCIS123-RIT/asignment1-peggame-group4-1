package peggame;

import java.util.Collection;
import java.util.Scanner;

public interface PegGame {
     /**
     * Gets a collection of all valid moves possible from the current game state.
     * 
     * @return A collection of `Move` objects representing the possible moves.
     */
    public Collection<Move> getPossibleMoves();
    public GameState getGameState();
    /**
     * Attempts to make a move on the game board.
     * 
     * @param move The `Move` object representing the intended move.
     * @throws PegGameException If the move is invalid or cannot be made due to game rules.
     */
    public void makeMove(Move move) throws PegGameException;
/**
     * This static method provides a general way to start and play a game using any implementation
     * of the `PegGame` interface. It takes the game instance and a Scanner object for user input.
     * 
     * @param game The PegGame instance representing the specific game variation.
     * @param scanner A Scanner object used for user input during gameplay.
     * @throws PegGameException If an error occurs during gameplay.
     */
    public static void playGame(PegGame game, Scanner scanner) throws PegGameException // Added to start/play a game of any type/variation
    {

    }
}
