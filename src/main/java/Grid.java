package main.java;

public class Grid {
    char[][] grid;

    public Grid() {
        this.grid = new char[][]
                {{' ', ' ', ' '}, {' ', ' ', ' '}, {' ', ' ', ' '}};
    }

    public void setGrid(int row, int col, boolean playerMove) {
        grid[row][col] = playerMove ? 'x' : 'o';
    }

    public char checkWin() {
        // Diagonals
        if (grid[0][0] != ' ' && grid[0][0] == grid[1][1] && grid[1][1] == grid[2][2]) return grid[1][1];
        if (grid[2][0] != ' ' && grid[2][0] == grid[1][1] && grid[1][1] == grid[0][2]) return grid[1][1];

        // Rows
        for (int i = 0; i < 3; i++) {
            if (grid[i][0] != ' ' && grid[i][0] == grid[i][1] && grid[i][1] == grid[i][2]) return grid[i][0];
        }

        // Columns
        for (int j = 0; j < 3; j++) {
            if (grid[0][j] != ' ' && grid[0][j] == grid[1][j] && grid[1][j] == grid[2][j]) return grid[0][j];
        }

        return ' ';
    }

    public void printGrid() {
        System.out.println("-------------");
        for (int i = 0; i < 3; i++) {
            System.out.println("| " + grid[i][0] + " | " + grid[i][1] + " | " + grid[i][2] + " |");
            System.out.println("-------------");
        }
    }

    public void botPlayerMovesFirst() {
        bestMove('o', 'x');
    }

    public void botComputerMovesFirst() {
        bestMove('x', 'o');
    }

    private void bestMove(char ai, char opponent) {
        int[] move;

        // Win
        move = findWinningMove(ai);
        if (move != null) {
            grid[move[0]][move[1]] = ai;
            return;
        }

        // Block opponent
        move = findWinningMove(opponent);
        if (move != null) {
            grid[move[0]][move[1]] = ai;
            return;
        }

        // Center
        if (grid[1][1] == ' ') {
            grid[1][1] = ai;
            return;
        }

        // Opposite corner
        int[][] corners = {{0, 0}, {0, 2}, {2, 0}, {2, 2}};
        for (int[] corner : corners) {
            int oppRow = 2 - corner[0];
            int oppCol = 2 - corner[1];
            if (grid[corner[0]][corner[1]] == opponent && grid[oppRow][oppCol] == ' ') {
                grid[oppRow][oppCol] = ai;
                return;
            }
        }

        // Empty corner
        for (int[] corner : corners) {
            if (grid[corner[0]][corner[1]] == ' ') {
                grid[corner[0]][corner[1]] = ai;
                return;
            }
        }

        // Empty side
        int[][] sides = {{0, 1}, {1, 0}, {1, 2}, {2, 1}};
        for (int[] side : sides) {
            if (grid[side[0]][side[1]] == ' ') {
                grid[side[0]][side[1]] = ai;
                return;
            }
        }
    }

    private int[] findWinningMove(char player) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (grid[i][j] == ' ') {
                    grid[i][j] = player;
                    if (checkWin() == player) {
                        grid[i][j] = ' ';
                        return new int[]{i, j};
                    }
                    grid[i][j] = ' ';
                }
            }
        }
        return null;
    }
}
