# Peg Solitaire Game

## Introduction
Peg Solitaire is a classic puzzle game played on a board with holes and pegs. The game has simple rules and offers a challenging puzzle to solve. This version of the game is implemented in Java and can be played via a command-line interface.

## How to Play
The objective of Peg Solitaire is to clear the board of all but one peg by jumping pegs over each other, removing each peg that gets jumped over.

### Game Board
The game is played on a square board filled with holes arranged in rows and columns. Each hole can either contain a peg (represented by 'o') or be empty (represented by '-').

### Starting the Game
The game begins with pegs in every hole except one, creating the initial challenge.

### Making Moves
A move consists of selecting a peg and jumping it over an adjacent peg (either vertically, horizontally, or diagonally) into an empty hole. The peg that was jumped over is then removed from the board. To make a move, enter the command in the format: `move r1 c1 r2 c2`, where `r1` and `c1` are the row and column of the peg you want to move, and `r2` and `c2` are the row and column of the destination hole.

### Winning the Game
The game is won when only one peg remains on the board.

### Ending the Game
If no more valid moves are possible and more than one peg remains on the board, the game ends in a stalemate. You can also choose to end the game at any time by entering the `quit` command.

## Running the Game
To start the game, compile and run the Java program and follow the on-screen instructions.


