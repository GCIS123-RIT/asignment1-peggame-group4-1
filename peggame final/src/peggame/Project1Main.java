package peggame;

import java.util.Scanner;
/**
 * This class serves as the main entry point for the Square Peg game application.
 * It handles user input, initializes the game, and starts the game loop.
 */
public class Project1Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the filename for the peg game board:");
        String filename = scanner.nextLine();
        try {
            PegGame game = GameFileParser.readGameFromFile(filename);
            PegGameCLI.playGame(game);
        } catch (Exception e) {
            System.err.println("Error starting the game: " + e.getMessage());
        }
    }


}
