package game;

public final class GameOfLife {
    final int ZERO    = 0x00;
    final int ONE    = 0x01;
    void test(int nrIterations, int[][] board) {
 
        
        System.out.println("Game of Life");
        printBoard(board);

        for (int i = 0 ; i < nrIterations ; i++) {
            System.out.println();
            board = getNextBoard(board);
            printBoard(board);
        }
    }

    void printBoard(int[][] board) {

        for (int i = 0, e = board.length ; i < e ; i++) {
            for (int j = 0, f = board[i].length ; j < f ; j++) {
                System.out.print(Integer.toString(board[i][j]) + ",");
            } 
            System.out.println();
        }
    }
    public int[][] getNextBoard(int[][] board) {

        if (board.length == 0 || board[0].length == 0) {
            throw new IllegalArgumentException("No Row or Column found");
        }

        int nrRows = board.length;
        int nrCols = board[0].length;
        int[][] buf = new int[nrRows][nrCols];

        for (int row = 0 ; row < nrRows ; row++) {
	
            for (int col = 0 ; col < nrCols ; col++) {
                buf[row][col] = getCellState(board[row][col], getActiveNeighbours(row, col, board));
            }
        }   
        return buf;
    }

    public int getActiveNeighbours(int cellRow, int cellCol, int[][] board) {

        int activeNeighbours = 0;
        int rowEnd = Math.min(board.length , cellRow + 2);
        int colEnd = Math.min(board[0].length, cellCol + 2);

        for (int row = Math.max(0, cellRow - 1) ; row < rowEnd ; row++) {
            
            for (int col = Math.max(0, cellCol - 1) ; col < colEnd ; col++) {
            	
                if ((row != cellRow || col != cellCol) && board[row][col] == ONE) {
                	activeNeighbours++;
                }
            }
        }
        return activeNeighbours;
    }

    public int getCellState(int curState, int activeNeighbours) {

        int newState = curState;

        switch (curState) {
        case ONE:
            if (activeNeighbours < 2 || activeNeighbours > 3) {
                newState = ZERO;
            }
            if (activeNeighbours == 2 || activeNeighbours == 3) {
                newState = ONE;
            }
          break;

        case ZERO:
            if (activeNeighbours == 3) {
                newState = ONE;
            }
            break;

        default:
            throw new IllegalArgumentException("State of cell must be either ONE or ZERO");
        }			
        return newState;
    }
}
