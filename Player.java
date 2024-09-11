import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// Class representing the human player (Inheritance and Polymorphism)
class Player extends PlayerBase {
    public Player(String name, int boardSize) {
        super(name, boardSize);
    }

    // Polymorphic method to make a move
    @Override
    public void makeMove(PlayerBase opponent, JButton[][] opponentButtons, JLabel statusLabel) {
        for (int i = 0; i < opponentButtons.length; i++) {
            for (int j = 0; j < opponentButtons[i].length; j++) {
                int x = i;
                int y = j;
                opponentButtons[i][j].addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (opponent.board.hitMine(x, y)) {
                            statusLabel.setText("You hit a mine! You lost.");
                            opponentButtons[x][y].setText("M");
                            askToPlayAgain();
                        } else if (opponent.board.hitShip(x, y)) {
                            statusLabel.setText("You hit a ship!");
                            opponent.board.markHit(x, y);
                            opponentButtons[x][y].setText("S");
                        } else {
                            statusLabel.setText("You missed.");
                            opponentButtons[x][y].setText("X");
                        }
                        opponentButtons[x][y].setEnabled(false);
                        opponent.makeMove(Player.this, opponentButtons, statusLabel); // Trigger computer's move
                    }
                });
            }
        }
    }

    // After losing or winning, ask if the player wants to play again
    private void askToPlayAgain() {
        int response = JOptionPane.showConfirmDialog(null, "Do you want to play again?", "Play Again",
                JOptionPane.YES_NO_OPTION);
        if (response == JOptionPane.YES_OPTION) {
            Main.playGame();
        } else {
            System.exit(0);
        }
    }
}