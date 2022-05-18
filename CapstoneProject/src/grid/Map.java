/**
 * Map represents the grid that the game will be played on
 * @version 5/10/22
 * 
 * @author Joshua Lee & Jacob Tang
 *
 */

package grid;

import java.awt.Rectangle;
import java.util.ArrayList;

/**
 * 
 * creates a map on drawing surface
 *
 */
public class Map {
	
	private boolean[][] grid;
	public final int ROWS = 50;
	public final int COLS = 50;
	private int x,y;
	

	public Map() {
		grid = new boolean[ROWS][COLS];
	}
	
	public void draw() {
		
	}
	
	public boolean isValidLocation() {
		return false;
	}
	
	public double getHeight() {
		return x;
	}

	public double getWidth() {
		return y;
	}
}
