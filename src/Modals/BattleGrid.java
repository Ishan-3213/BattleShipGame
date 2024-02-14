// -----------------------------------------------------
// Assignment 1
// © Ishan Pansuriya, Tanmay Soni
// Written by:
// Ishan Pansuriya: 40232841
// Tanmay Soni: 40240650
// -----------------------------------------------------
package Modals;

import Constants.CellOwner;
import Constants.CellType;
/**
 * Represents the battle grid for a game, storing information about the state of each cell.
 * This class includes methods to:
 * initialize the grid
 * display it
 * check for valid positions,
 * set elements for both human and computer players,
 * mark cells as called,
 * check for game over conditions.
 */
public class BattleGrid {
    private GridCell[][] grid;
    /**
     * Number of human ships sunk.
     */
    public int humanShipsSunk = 0;
    /**
     * Number of computer ships sunk.
     */
    public int computerShipsSunk = 0;
    /**
     * Constructs a BattleGrid and initializes the grid with default values.
     */
    public BattleGrid() {
        initializeGrid();
    }

    private void initializeGrid() {
        // Initialize the grid with default values
        grid = new GridCell[8][8];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                grid[i][j] = new GridCell(CellType.NOTHING, null);
            }
        }
    }

    /**
     * Displays the current state of the battle grid in the console.
     */
    public void displayGrid() {
        // Display logic for each cell in the grid
        System.out.println("  A B C D E F G H");
        for (int i = 0; i < 8; i++) {
            System.out.print((i + 1) + " ");
            for (int j = 0; j < 8; j++) {
                char displayChar = '_';
                if (grid[i][j].isCalled()) {
                    if (grid[i][j].getType() == CellType.SHIP) {
                        displayChar = (grid[i][j].getOwner() == CellOwner.HUMAN) ? 's' : 'S';
                    } else if (grid[i][j].getType() == CellType.GRENADE) {
                        displayChar = (grid[i][j].getOwner() == CellOwner.HUMAN) ? 'g' : 'G';
                    } else {
                        displayChar = '*';
                    }
                }
                System.out.print(displayChar + " ");
            }
            System.out.println();
        }
    }

    /**
     * Checks if a position is a valid cell in the grid.
     *
     * @param row The row index of the cell.
     * @param col The column index of the cell.
     * @return True if the position is valid, false otherwise.
     */
    public boolean isValidPosition(int row, int col) {
        return row >= 0 && row < 8 && col >= 0 && col < 8 && grid[row][col].getType() == CellType.NOTHING;
    }

    /**
     * Checks if a position is a valid cell for an attack.
     *
     * @param row The row index of the cell.
     * @param col The column index of the cell.
     * @return True if the position is valid for an attack, false otherwise.
     */
    public boolean isValidAttackPosition(int row, int col) {
        return row >= 0 && row < 8 && col >= 0 && col < 8;
    }

    /**
     * Sets the specified cell to the given {CellType} for the human player.
     *
     * @param row  The row index of the cell.
     * @param col  The column index of the cell.
     * @param type The type to set for the cell.
     */
    public void setHumanElement(int row, int col, CellType type) {
        grid[row][col] = new GridCell(type, CellOwner.HUMAN);
    }

    /**
     * Sets the specified cell to the given {CellType} for the computer player.
     *
     * @param row  The row index of the cell.
     * @param col  The column index of the cell.
     * @param type The type to set for the cell.
     */
    public void setComputerElement(int row, int col, CellType type) {
        grid[row][col] = new GridCell(type, CellOwner.COMPUTER);
    }

    /**
     * Marks the specified cell as called, indicating that it has been attacked.
     *
     * @param row The row index of the cell.
     * @param col The column index of the cell.
     */
    public void markAsCalled(int row, int col) {
        grid[row][col].markAsCalled();
    }

    /**
     * Retrieves the {CellType} of the specified cell.
     *
     * @param row The row index of the cell.
     * @param col The column index of the cell.
     * @return The {CellType} of the cell.
     */
    public CellType getCellType(int row, int col) {
        return grid[row][col].getType();
    }

    /**
     * Retrieves the owner of the specified cell.
     *
     * @param row The row index of the cell.
     * @param col The column index of the cell.
     * @return The owner of the cell.
     */
    public CellOwner getCellOwner(int row, int col) {
        return grid[row][col].getOwner();
    }

    /**
     * Checks if the specified cell has been called (attacked).
     *
     * @param row The row index of the cell.
     * @param col The column index of the cell.
     * @return {true} if the cell has been called, {false} otherwise.
     */
    public boolean getIsCalled(int row, int col) {
        return grid[row][col].isCalled();
    }

    /**
     * Checks if the game is over based on the number of ships sunk by each player.
     *
     * @param human    The human player.
     * @param computer The computer player.
     * @return true if the game is over, false otherwise.
     */
    public boolean isGameOver(Players human, Players computer){
        return human.getshipsSunk(this)==6 || computer.getshipsSunk(this)==6;
    }
}
