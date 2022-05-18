/**
 * Seeker represents seeker in the game
 * @version 5/10/22
 * 
 * @author Joshua Lee & Jacob Tang
 *
 */
package gameplay;

import java.awt.List;
import java.util.ArrayList;

import processing.core.PImage;

public class Seeker extends Sprite {
	
	public static final int SEEKER_WIDTH = 30;
	public static final int SEEKER_HEIGHT = 30;
	private int tagged;

	
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
			x+=1.5;
		}
		if (dirX == -1) {
			x-=1.5;
		}
		if (dirY == 1) {
			y+=1.5;
		}
		if (dirY == -1) {
			y-=1.5;
		}
	}
	
//	public void tagged(ArrayList<Sprite> hiders) {
//		for (Seeker s: hiders) {
//			if(super.intersects(s)) {
//				tagged +=1;
//			}
//		}
//	}
	
	public double getX() {
		return super.getX();
	}
	public double getY() {
		return super.getY();
	}
}
