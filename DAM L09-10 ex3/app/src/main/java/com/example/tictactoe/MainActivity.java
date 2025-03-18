package com.example.tictactoe;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private Button[] buttons = new Button[9];
    private int[] board = {0, 0, 0, 0, 0, 0, 0, 0, 0};
    private boolean playerX = true;
    private TextView statusText;
    private Button resetButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        statusText = findViewById(R.id.statusText);
        resetButton = findViewById(R.id.resetButton);

        GridLayout gridLayout = findViewById(R.id.gridLayout);
        for (int i = 0; i < 9; i++) {
            buttons[i] = (Button) gridLayout.getChildAt(i);
            final int index = i;
            buttons[i].setOnClickListener(v -> makeMove(index));
        }

        resetButton.setOnClickListener(v -> resetGame());
    }

    private void makeMove(int index) {
        if (board[index] == 0) {
            board[index] = playerX ? 1 : 2;
            buttons[index].setText(playerX ? "X" : "O");
            buttons[index].setEnabled(false);

            if (checkWin()) {
                statusText.setText((playerX ? "X" : "O") + " a castigat");
                disableButtons();
            } else if (isBoardFull()) {
                statusText.setText("Remiza");
            } else {
                playerX = !playerX;
                statusText.setText("Randul lui " + (playerX ? "X" : "O"));
            }
        }
    }

    private boolean checkWin() {
        int[][] winPatterns = {
                {0, 1, 2}, {3, 4, 5}, {6, 7, 8}, // Linii
                {0, 3, 6}, {1, 4, 7}, {2, 5, 8}, // Coloane
                {0, 4, 8}, {2, 4, 6} // Diagonale
        };

        for (int[] pattern : winPatterns) {
            if (board[pattern[0]] != 0 &&
                    board[pattern[0]] == board[pattern[1]] &&
                    board[pattern[1]] == board[pattern[2]]) {
                return true;
            }
        }
        return false;
    }

    private boolean isBoardFull() {
        for (int cell : board) {
            if (cell == 0) return false;
        }
        return true;
    }

    private void disableButtons() {
        for (Button button : buttons) {
            button.setEnabled(false);
        }
    }

    private void resetGame() {
        for (int i = 0; i < 9; i++) {
            board[i] = 0;
            buttons[i].setText("");
            buttons[i].setEnabled(true);
        }
        playerX = true;
        statusText.setText("Jucator X incepe");
    }
}
