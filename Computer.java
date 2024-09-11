import javax.swing.*;
import java.util.Random;

// Class representing the computer player (Inheritance and Polymorphism)
class Computer extends PlayerBase {
    public Computer(String name, int boardSize) {
        super(name, boardSize);
    }

    // Polymorphic method for computer's move (random selection)
    @Override
    public void makeMove(PlayerBase opponent, JButton[][] opponentButtons, JLabel statusLabel) {
        Random random = new Random();
        int x, y;
        do {
            x = random.nextInt(opponentButtons.length);
            y = random.nextInt(opponentButtons[0].length);
        } while (!opponentButtons[x][y].isEnabled());

        if (opponent.board.hitMine(x, y)) {
            statusLabel.setText("Computer hit a mine! You won!");
            opponentButtons[x][y].setText("M");
            askToPlayAgain();
        } else if (opponent.board.hitShip(x, y)) {
            statusLabel.setText("Computer hit a ship!");
            opponent.board.markHit(x, y);
            opponentButtons[x][y].setText("S");
        } else {
            statusLabel.setText("Computer missed.");
            opponentButtons[x][y].setText("X");
        }
        opponentButtons[x][y].setEnabled(false);
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
