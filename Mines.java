import java.util.Random;

// Class representing Mines
class Mines {
    private int count;

    public Mines(int count) {
        this.count = count;
    }

    public void place(char[][] board) {
        Random random = new Random();
        for (int i = 0; i < count; i++) {
            int x, y;
            do {
                x = random.nextInt(board.length);
                y = random.nextInt(board[0].length);
            } while (board[x][y] != '-');
            board[x][y] = 'M';  // 'M' represents a mine
        }
    }
}