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
        if (grid[0][0] != ' ' && grid[0][0] == grid[0][1] && grid[0][1] == grid[0][2]) return grid[0][1];
        if (grid[1][0] != ' ' && grid[1][0] == grid[1][1] && grid[1][1] == grid[1][2]) return grid[1][1];
        if (grid[2][0] != ' ' && grid[2][0] == grid[2][1] && grid[2][1] == grid[2][2]) return grid[2][1];

        // Columns
        if (grid[0][0] != ' ' && grid[0][0] == grid[1][0] && grid[1][0] == grid[2][0]) return grid[1][0];
        if (grid[0][1] != ' ' && grid[0][1] == grid[1][1] && grid[1][1] == grid[2][1]) return grid[1][1];
        if (grid[0][2] != ' ' && grid[0][2] == grid[1][2] && grid[1][2] == grid[2][2]) return grid[1][2];

        // No winner
        return ' ';
    }

    public void printGrid() {
        System.out.println("-------------");
        System.out.println("| " + grid[0][0] + " | " + grid[0][1] + " | " + grid[0][2] + " |");
        System.out.println("-------------");
        System.out.println("| " + grid[1][0] + " | " + grid[1][1] + " | " + grid[1][2] + " |");
        System.out.println("-------------");
        System.out.println("| " + grid[2][0] + " | " + grid[2][1] + " | " + grid[2][2] + " |");
        System.out.println("-------------");
    }

    public void computerMove() {
        // TODO
        // Dumb AI
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (grid[i][j] == ' ') {
                    grid[i][j] = 'o';
                    return;
                }
            }
        }
    }
}
