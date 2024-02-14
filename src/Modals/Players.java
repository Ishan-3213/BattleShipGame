package Modals;

import Constants.CellOwner;
import Constants.CellType;

import java.util.Random;
import java.util.Scanner;

public class Players {
    private final CellOwner playerType;
    public final int ships = 6;
    public final int grenades = 4;
    private boolean turnSkipped = false;

    public Players(CellOwner playerType) {
        this.playerType = playerType;
    }

    public int getshipsSunk(BattleGrid grid){
        if (playerType == CellOwner.HUMAN){
            return grid.humanShipsSunk;
        }else {
            return grid.computerShipsSunk;
        }
    }

    public void increaseShipsSunk(BattleGrid grid, int row, int col){
        if (grid.getCellOwner(row, col) == CellOwner.HUMAN){
            grid.humanShipsSunk++;
            System.out.println("HUMAN"+grid.humanShipsSunk);
        }else {
            grid.computerShipsSunk++;
            System.out.println("Computer"+grid.computerShipsSunk);
        }
    }
    public void setTurnSkipped(boolean turnSkipped) {
        this.turnSkipped = turnSkipped;
    }

    public void humanInput(BattleGrid grid, Scanner scanner){
        for (int i=1; i<=ships; i++){
            placeHumanElement(grid, scanner, CellType.SHIP, i);
        }
        System.out.println();
        for (int i=1; i<=grenades; i++){
            placeHumanElement(grid, scanner, CellType.GRENADE, i);
        }
        System.out.println();
    }

    public void placeHumanElement(BattleGrid grid, Scanner scanner, CellType type, int index) {
        while (true) {
            System.out.print("Enter the coordinates of your "+type+" #"+index+":");
            String input = scanner.next().toUpperCase();
            int row = input.charAt(1) - '1';
            int col = input.charAt(0) - 'A';

            if (grid.isValidPosition(row,col)) {
                grid.setHumanElement(row,col,type);
                break;
            } else if (!(row >= 0 && row < 8 && col >= 0 && col < 8)){
                System.out.println("sorry, coordinates outside the grid. try again.");
            }else {
                System.out.println("sorry, coordinates already used. try again.");
            }
        }
    }

    public void humanTurn(BattleGrid grid, Scanner scanner) {
        if(turnSkipped){
            setTurnSkipped(false);
            System.out.println("Your Turn Skipped");
            System.out.println();
        }else {
            System.out.print("Position of your rocket: ");
            while (true) {
                String input = scanner.next().toUpperCase();
                int row = input.charAt(1) - '1';
                int col = input.charAt(0) - 'A';
                if (grid.isValidAttackPosition(row,col)) {
                    if (grid.getCellType(row, col) == CellType.SHIP && !grid.getIsCalled(row,col)){
                        System.out.println("Ship hit!");
                        increaseShipsSunk(grid, row, col);
                    } else if (grid.getCellType(row, col) == CellType.GRENADE && !grid.getIsCalled(row,col)) {
                        System.out.println("Boom! Grenade. You lose a turn.");
                        setTurnSkipped(true);
                    }else {
                        System.out.println("Nothing.");
                    }
                    grid.markAsCalled(row,col);
                    System.out.println();
                    break;
                } else {
                    System.out.println("sorry, coordinates outside the grid. try again.");
                }
            }

        }
    }

    public void computerInput(BattleGrid grid, Random random) {
        for (int i = 0; i < 6; i++) {
            placeComputerElement(grid, random, CellType.SHIP);
        }

        for (int i = 0; i < 4; i++) {
            placeComputerElement(grid, random, CellType.GRENADE);
        }
        System.out.println("OK, the computer placed its ships and grenades at random. Let’s play.");
        System.out.println();
    }

    public void placeComputerElement(BattleGrid grid, Random random, CellType type) {
        while (true) {
            int row = random.nextInt(8);
            int col = random.nextInt(8);

            if (grid.isValidPosition(row, col)) {
                grid.setComputerElement(row, col, type);
                break;
            }
        }
    }

    public void computerTurn(BattleGrid grid, Random random) {
        if(turnSkipped){
            setTurnSkipped(false);
            System.out.println("Computer's Turn Skipped");
            System.out.println();
        }else {
                int row = random.nextInt(8);
                int col = random.nextInt(8);
                char r = (char) (row + '1');
                char c = (char) (col + 'A');
                System.out.println("Position of computer's rocket: "+c+r);
                if (grid.isValidAttackPosition(row, col)) {
                    if (grid.getCellType(row, col) == CellType.SHIP && !grid.getIsCalled(row,col)){
                        System.out.println("Ship hit!");
                        increaseShipsSunk(grid, row, col);
                    } else if (grid.getCellType(row, col) == CellType.GRENADE && !grid.getIsCalled(row,col)) {
                        System.out.println("Boom! Grenade. Computer lose a turn.");
                        setTurnSkipped(true);
                    }else {
                        System.out.println("Nothing.");
                    }
                    grid.markAsCalled(row,col);
                    System.out.println();
                }
            }
        }
}
