package main.java;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class GUI extends Application {
    private Grid grid = new Grid();
    private boolean playerOneMove = true; // 'X' moves first
    private Button[][] buttons = new Button[3][3];

    @Override
    public void start(Stage primaryStage) {
        GridPane gridPane = new GridPane();

        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                Button button = new Button(" ");
                button.setFont(new Font(30));
                button.setMinSize(100, 100);
                int r = row, c = col;
                button.setOnAction(e -> handleMove(r, c, button));
                buttons[row][col] = button;
                gridPane.add(button, col, row);
            }
        }

        Scene scene = new Scene(gridPane, 300, 300);
        primaryStage.setTitle("Tic-Tac-Toe");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void handleMove(int row, int col, Button button) {
        if (!button.getText().equals(" ")) return; // Ignore already marked cells

        char mark = playerOneMove ? 'x' : 'o';
        grid.setGrid(row, col, playerOneMove);
        button.setText(String.valueOf(mark));

        if (grid.checkWin() != ' ') {
            System.out.println((grid.checkWin() == 'x' ? "Player One (X)" : "Player Two (O)") + " wins!");
            disableBoard();
            return;
        }

        playerOneMove = !playerOneMove;
    }

    private void disableBoard() {
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                buttons[row][col].setDisable(true);
            }
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
