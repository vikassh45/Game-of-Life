package game;

public class Runner {
	public final static void main(String[] args) {
	    final int ZERO    = 0x00;
	    final int ONE    = 0x01;
		GameOfLife game=new GameOfLife();
    	
        int[][] board = {{ZERO, ZERO, ZERO, ZERO, ZERO},
                         {ZERO, ZERO, ZERO, ONE, ZERO},
                         {ZERO, ZERO, ONE, ONE, ZERO},
                         {ZERO, ZERO, ZERO, ONE, ZERO},
                         {ZERO, ZERO, ZERO, ZERO, ZERO}};
		game.test(5,board);
	    }
	}
