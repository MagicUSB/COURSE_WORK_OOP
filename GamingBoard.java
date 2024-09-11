// Class representing the GamingBoard (Encapsulation)
class GamingBoard {
    private char[][] board;
    private int size;

    public GamingBoard(int size) {
        this.size = size;
        this.board = new char[size][size];
        initializeBoard();
    }

    // Private method to initialize the board (Encapsulation)
    private void initializeBoard() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                board[i][j] = '-';
            }
        }
    }

    // Public method to place ships and mines (Encapsulation)
    public void placeShipsAndMines(Ships ships, Mines mines) {
        ships.place(board);
        mines.place(board);
    }

    public boolean hitShip(int x, int y) {
        return board[x][y] == 'S';
    }

    public boolean hitMine(int x, int y) {
        return board[x][y] == 'M';
    }

    public void markHit(int x, int y) {
        board[x][y] = 'X';
    }

    public boolean hasLost() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (board[i][j] == 'M') {
                    return true; // Losing condition: a mine was hit
                }
            }
        }
        return false;
    }

    public void displayBoard() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
}