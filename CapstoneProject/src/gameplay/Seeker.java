/**
 * Seeker represents seeker in the game

 * @version 5/10/22
 * 
 * @author Joshua Lee
 *
 */
package gameplay;


import processing.core.PApplet;
import processing.core.PImage;

public class Seeker extends Sprite {
	
	public static final int SEEKER_WIDTH = 30;
	public static final int SEEKER_HEIGHT = 30;
	private int score;
	private PImage img;

	
/*
 * creates a seeker that extends a sprite
 */
	public Seeker(PImage img, int x, int y) {
		super(img, x, y, SEEKER_WIDTH, SEEKER_HEIGHT);
		this.img = img;
	}
	
	public void draw(PApplet drawer) {
		drawer.image(img, (float)x, (float)y, SEEKER_WIDTH, SEEKER_HEIGHT);
	}
	
	/*
	 * overrides the move method to show how the seeker moves
	 */
	public void move(int dirX, int dirY) {
		if (dirX == 1) {
			x+=15;
		}
		if (dirX == -1) {
			x-=15;
		}
		if (dirY == 1) {
			y+=15;
		}
		if (dirY == -1) {
			y-=15;
		}
	}
	
	
	public double getX() {
		return super.getX();
	}
	public double getY() {
		return super.getY();
	}
	public void setScore(int score) {
		this.score = score;
	}
	public int getScore() {
		return score;
	}
}
