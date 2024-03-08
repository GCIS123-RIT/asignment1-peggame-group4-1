package peggame;

import java.util.Scanner;

public class PegGameCLI {
    /**
     * Main method to start a game of Square Peg using the CLI.
     *
     * @param game The `PegGame` instance representing the specific game variation.
     */
    public static void playGame(PegGame game){
        Scanner scanner = new Scanner(System.in);
        printGameState(game);
        while(true){
            System.out.println("Enter a command ( <quit> | <move> <r1> <c1> <r2> <c2> )");
            String input = scanner.nextLine();
            String[] input_parts = input.split(" ");
            if(input_parts[0].equals("quit")){
                System.out.println("Bye-bye!");
                break;
            }else if(input_parts[0].equals("move") && input_parts.length == 5){
                processMoveCommand(input_parts, game);
            }else{
                System.out.println("Invalid command! Commands: <quit> | <move> <r1> <c1> <r2> <c2>");
            }
            if(game.getGameState() == GameState.WON){
                System.out.println("#--------------------#");
                System.out.println("You've won the game!");
                printGameState(game);
                break;
            }else if(game.getGameState() == GameState.STALEMATE){
                System.out.println("#--------------------#");
                System.out.println("Stalemate! Game ends.");
                printGameState(game);
                break;
            }
        }
        scanner.close();
    }
/**
     * Processes a user-provided "move" command.
     *
     * @param input_parts The split parts of the user input (command and arguments).
     * @param game The `PegGame` instance representing the game.
     */
    private static void processMoveCommand(String[] input_parts, PegGame game){
        try {
            int r1 = Integer.parseInt(input_parts[1].substring(1));
            int c1 = Integer.parseInt(input_parts[2].substring(1));
            int r2 = Integer.parseInt(input_parts[3].substring(1));
            int c2 = Integer.parseInt(input_parts[4].substring(1));
            Location from = new Location(r1, c1);
            Location to = new Location(r2, c2);
            Move move = new Move(from, to);
            game.makeMove(move);
            printGameState(game);
        }catch(NumberFormatException e){
            System.out.println("Invalid input! Format: <move> <r1> <c1> <r2> <c2>");
        }catch (PegGameException e) {
            System.out.println("Invalid move!");
        }
    }
 /**
     * Prints the current game state description and the game board representation.
     *
     * @param game The `PegGame` instance representing the game.
     */
    private static void printGameState(PegGame game){
        System.out.println("Current Game State: " + game.getGameState());
        System.out.println(game);
    }
}
