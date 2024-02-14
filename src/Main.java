import Constants.CellOwner;
import Modals.BattleGrid;
import Modals.Players;

import java.util.Scanner;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        BattleGrid grid = new BattleGrid();

        Players human = new Players(CellOwner.HUMAN);
        Players computer = new Players(CellOwner.COMPUTER);

        System.out.println("Hi, let’s play Battleship!\n");

        human.humanInput(grid, scanner);
        computer.computerInput(grid, random);

        while (!grid.isGameOver(human, computer)){
            human.humanTurn(grid, scanner);
            grid.displayGrid();
            if (grid.isGameOver(human, computer)) break;
            computer.computerTurn(grid, random);
            grid.displayGrid();
            System.out.println();
        }
        if (human.getshipsSunk(grid)==6){
            System.out.println("Computer Won!");
        }else {
            System.out.println("You Win!");
        }
        System.out.println();
        grid.displayGrid();
    }


}