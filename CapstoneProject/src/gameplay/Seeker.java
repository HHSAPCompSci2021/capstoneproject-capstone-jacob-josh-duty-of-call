/**
 * Seeker represents seeker in the game
 * @version 5/10/22
 * 
 * @author Joshua Lee & Jacob Tang
 *
 */
package gameplay;

import processing.core.PImage;

public class Seeker extends Sprite {
	
	public static final int SEEKER_WIDTH = 30;
	public static final int SEEKER_HEIGHT = 30;

	
/*
 * creates a seeker that extends a sprite
 */
	public Seeker(PImage img, int x, int y) {
		super(img, x, y, SEEKER_WIDTH, SEEKER_HEIGHT);
	}
	
	/*
	 * overrides the move method to show how the seeker moves
	 */
	public void move(int dirX, int dirY) {
		if (dirX == 1) {
			x+=1;
		}
		if (dirX == -1) {
			x-=1;
		}
		if (dirY == 1) {
			y+=1;
		}
		if (dirY == -1) {
			y-=1;
		}
	}
}
