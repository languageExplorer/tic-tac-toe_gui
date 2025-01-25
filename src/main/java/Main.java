package main.java;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String input;

        while (true) {
            System.out.println("Would you like to play against Computer? \"No\" for two player game. (Y/N)");
            input = scanner.nextLine();

            if (input.equalsIgnoreCase("Y")) singlePlayer(scanner);
            else multiPlayer(scanner);

            System.out.println("Would you like to play another game? (Y/N)");
            input = scanner.nextLine();
            if (!(input.equalsIgnoreCase("Y"))) return;
        }
    }

    public static void singlePlayer(Scanner scanner) {

        String input;

        Grid grid = new Grid();
        boolean playerFirst = false;
        boolean playersMove = false;
        int row;
        int col;

        System.out.println("Would you like to move first? (Y/N)");
        input = scanner.nextLine();
        if (input.equalsIgnoreCase("Y")) {
            playerFirst = true;
            playersMove = true;
        }

        while (true) {
            grid.printGrid();

            if (playersMove) {
                System.out.println("Your move.");

                System.out.println("In which row would you like to place a cross? (1/2/3)");
                input = scanner.nextLine();
                if (input.equalsIgnoreCase("1")) row = 0;
                else if (input.equalsIgnoreCase("2")) row = 1;
                else if (input.equalsIgnoreCase("3")) row = 2;
                else {
                    System.out.println("This row does not exist. Please, try again!");
                    continue;
                }

                System.out.println("In which column would you like to place a cross? (1/2/3)");
                input = scanner.nextLine();
                if (input.equalsIgnoreCase("1")) col = 0;
                else if (input.equalsIgnoreCase("2")) col = 1;
                else if (input.equalsIgnoreCase("3")) col = 2;
                else {
                    System.out.println("This column does not exist. Please, try again!");
                    continue;
                }

                if (grid.grid[row][col] != ' ') {
                    System.out.println("There is \"" + grid.grid[row][col] + "\" already placed there. Please, try again!");
                    continue;
                }

                grid.setGrid(row, col, true);
                playersMove = false;

            } else {
                playersMove = true;

                if (playerFirst) grid.computerMoveFirst();
                else grid.computerMoveSecond();

                System.out.println("Computer move.");
            }

            if (grid.checkWin() != ' ') {
                if (grid.checkWin() == 'x') System.out.println("You win!");
                else System.out.println("You lose!");
                grid.printGrid();
                break;
            }
        }
    }

    public static void multiPlayer(Scanner scanner) {

        String input;

        Grid grid = new Grid();
        boolean playerOneMove = true;
        int row;
        int col;

        while (true) {
            grid.printGrid();

            if (playerOneMove) {
                System.out.println("Player one (cross) move.");

                System.out.println("In which row would you like to place a cross? (1/2/3)");
                input = scanner.nextLine();
                if (input.equalsIgnoreCase("1")) row = 0;
                else if (input.equalsIgnoreCase("2")) row = 1;
                else if (input.equalsIgnoreCase("3")) row = 2;
                else {
                    System.out.println("This row does not exist. Please, try again!");
                    continue;
                }

                System.out.println("In which column would you like to place a cross? (1/2/3)");
                input = scanner.nextLine();
                if (input.equalsIgnoreCase("1")) col = 0;
                else if (input.equalsIgnoreCase("2")) col = 1;
                else if (input.equalsIgnoreCase("3")) col = 2;
                else {
                    System.out.println("This column does not exist. Please, try again!");
                    continue;
                }

                if (grid.grid[row][col] != ' ') {
                    System.out.println("There is \"" + grid.grid[row][col] + "\" already placed there. Please, try again!");
                    continue;
                }

                grid.setGrid(row, col, true);
                playerOneMove = false;

            } else {
                System.out.println("Player two (circle) move.");

                System.out.println("In which row would you like to place a circle? (1/2/3)");
                input = scanner.nextLine();
                if (input.equalsIgnoreCase("1")) row = 0;
                else if (input.equalsIgnoreCase("2")) row = 1;
                else if (input.equalsIgnoreCase("3")) row = 2;
                else {
                    System.out.println("This row does not exist. Please, try again!");
                    continue;
                }

                System.out.println("In which column would you like to place a circle? (1/2/3)");
                input = scanner.nextLine();
                if (input.equalsIgnoreCase("1")) col = 0;
                else if (input.equalsIgnoreCase("2")) col = 1;
                else if (input.equalsIgnoreCase("3")) col = 2;
                else {
                    System.out.println("This column does not exist. Please, try again!");
                    continue;
                }

                if (grid.grid[row][col] != ' ') {
                    System.out.println("There is \"" + grid.grid[row][col] + "\" already placed there. Please, try again!");
                    continue;
                }

                grid.setGrid(row, col, false);
                playerOneMove = true;
            }

            if (grid.checkWin() != ' ') {
                if (grid.checkWin() == 'x') System.out.println("Player one wins!");
                else System.out.println("Player two wins!");
                grid.printGrid();
                break;
            }
        }
    }
}