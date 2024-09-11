import javax.swing.*;
import java.awt.*;

// Main class to run the game
public class Main {

    private static final int BOARD_SIZE = 5;

    public static void main(String [] args) {
        playGame();
    }

    public static void playGame() {
        JFrame frame = new JFrame("Battleship Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setLayout(new BorderLayout());

        Ships ships = new Ships(3); // 3 ships per player
        Mines mines = new Mines(2); // 2 mines per player

        Player player = new Player("Player", BOARD_SIZE);
        Computer computer = new Computer("Computer", BOARD_SIZE);

        // Place ships and mines for both players
        player.board.placeShipsAndMines(ships, mines);
        computer.board.placeShipsAndMines(ships, mines);

        JPanel gamePanel = new JPanel(new GridLayout(BOARD_SIZE, BOARD_SIZE));
        JPanel computerPanel = new JPanel(new GridLayout(BOARD_SIZE, BOARD_SIZE));
        JLabel statusLabel = new JLabel("Player's Turn", SwingConstants.CENTER);

        JButton[][] playerButtons = new JButton[BOARD_SIZE][BOARD_SIZE];
        JButton[][] computerButtons = new JButton[BOARD_SIZE][BOARD_SIZE];

        // Create a grid for player's buttons (computer's side)
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                computerButtons[i][j] = new JButton("-");
                gamePanel.add(computerButtons[i][j]);
            }
        }

        // Add the status label and the game grid to the frame
        frame.add(statusLabel, BorderLayout.NORTH);
        frame.add(gamePanel, BorderLayout.CENTER);

        // Player makes a move, then computer automatically makes one
        player.makeMove(computer, computerButtons, statusLabel);

        // Display the frame
        frame.setVisible(true);
    }
}