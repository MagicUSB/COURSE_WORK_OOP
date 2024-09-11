import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

// Abstract class for common player behavior (Abstraction)
abstract class PlayerBase {
    protected GamingBoard board;
    protected String name;

    public PlayerBase(String name, int boardSize) {
        this.name = name;
        this.board = new GamingBoard(boardSize);  // Each player gets their own game board
    }

    // Abstract method for making a move (Polymorphism and Abstraction)
    public abstract void makeMove(PlayerBase opponent, JButton[][] opponentButtons, JLabel statusLabel);

    public boolean hasLost() {
        return board.hasLost();
    }

    public void displayBoard() {
        board.displayBoard();
    }
}
