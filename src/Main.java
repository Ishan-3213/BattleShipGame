// -----------------------------------------------------
// Assignment 1
// © Ishan Pansuriya, Tanmay Soni
// Written by:
// Ishan Pansuriya: 40232841
// Tanmay Soni: 40240650
// -----------------------------------------------------
import Constants.CellOwner;
import Modals.BattleGrid;
import Modals.Players;

import java.util.Scanner;
import java.util.Random;

/**
 * Battleship Game Simulation
 *
 * This program simulates a simplified version of the Battleship game played on an 8 by 8 grid.
 * Players take turns placing ships and grenades, then attempt to sink their opponent's ships
 * by calling positions on the grid. The game continues until one player sinks all the opponent's ships.
 * The program includes functionality for human and computer players, validating inputs, and displaying
 * the grid after each turn. The grid is initially hidden, revealing only called positions. The final
 * grid displays the positions of all ships and grenades. Ships and grenades cannot overlap.
 *
 * Assignment for COMP6481 - Winter 2024
 * Authors: Ishan Pansuriya (40232841), Tanmay Soni (40240650)
 * Due Date: February 14th 2024
 */
public class Main {

    /**
     * Main method to initiate and run the Battleship game simulation.
     *
     * @param args Command-line arguments (not used in this program).
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        // Initialize the BattleGrid, human player, and computer player
        BattleGrid grid = new BattleGrid();
        Players human = new Players(CellOwner.HUMAN);
        Players computer = new Players(CellOwner.COMPUTER);

        System.out.println("Hi, let’s play Battleship!\n");

        // Allow the human player to place ships and grenades
        human.humanInput(grid, scanner);
        // Place ships and grenades for the computer player
        computer.computerInput(grid, random);

        // Game loop
        while (!grid.isGameOver(human, computer)) {
            // Human player's turn
            human.humanTurn(grid, scanner);
            grid.displayGrid();

            // Check if the game is over after the human player's turn
            if (grid.isGameOver(human, computer)) break;

            // Computer player's turn
            computer.computerTurn(grid, random);
            grid.displayGrid();
            System.out.println();
        }

        // Display the winner of the game
        if (human.getshipsSunk(grid) == 6) {
            System.out.println("Computer Won!");
        } else {
            System.out.println("You Win!");
        }

        // Display the final state of the grid
        System.out.println();
        grid.displayGrid();
    }
}