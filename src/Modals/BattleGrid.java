package Modals;

import Constants.CellOwner;
import Constants.CellType;

public class BattleGrid {
    private GridCell[][] grid;

    public int humanShipsSunk = 0;

    public int computerShipsSunk = 0;

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

    public void displayGrid() {
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

    public boolean isValidPosition(int row, int col) {
        return row >= 0 && row < 8 && col >= 0 && col < 8 && grid[row][col].getType() == CellType.NOTHING;
    }

    public boolean isValidAttackPosition(int row, int col) {
        return row >= 0 && row < 8 && col >= 0 && col < 8;
    }

    public void setHumanElement(int row, int col, CellType type) {
        grid[row][col] = new GridCell(type, CellOwner.HUMAN);
    }

    public void setComputerElement(int row, int col, CellType type) {
        grid[row][col] = new GridCell(type, CellOwner.COMPUTER);
    }

    public void markAsCalled(int row, int col) {
        grid[row][col].markAsCalled();
    }
    public CellType getCellType(int row, int col) {
        return grid[row][col].getType();
    }

    public CellOwner getCellOwner(int row, int col) {
        return grid[row][col].getOwner();
    }

    public boolean getIsCalled(int row, int col) {
        return grid[row][col].isCalled();
    }

    public boolean isGameOver(Players human, Players computer){
        return human.getshipsSunk(this)==6 || computer.getshipsSunk(this)==6;
    }
}
