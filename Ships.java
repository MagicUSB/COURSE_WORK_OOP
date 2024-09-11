import java.util.Random;

// Class representing Ships
class Ships {
    private int count;

    public Ships(int count) {
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
            board[x][y] = 'S';  // 'S' represents a ship
        }
    }
}