package test;

import org.junit.Assert;
import org.junit.Test;

import game.GameOfLife;

public class GameOfLifeTest {
	
	GameOfLife life=new GameOfLife();
	
	@Test
	public void getNextBoardTest() {
		int[][] test= {{0,1,0},{0,0,1},{1,1,1},{0,0,0}};
		int[][] result= {{0,0,0},{1,0,1},{0,1,1},{0,1,0}};
		Assert.assertEquals(result,life.getNextBoard(test));
	}
	
		@Test
		public void getLiveNeighbourTest() {
		int[][] test= {{0,1,0},{0,0,1},{1,1,1},{0,0,0}};
		Assert.assertEquals(3,life.getActiveNeighbours(2, 1, test));	
	}
		
		@Test
		public void getNewDeadStateTest() {
		Assert.assertEquals(0,life.getCellState(0, 1));	
	}
		
		@Test
		public void getNewLiveStateTest() {
		Assert.assertEquals(1,life.getCellState(0, 3));	
	}
		
		@Test(expected = IllegalArgumentException.class)
		public void badStateTest() {
		Assert.assertEquals(0,life.getCellState(5, 1));	
	}
		
}
