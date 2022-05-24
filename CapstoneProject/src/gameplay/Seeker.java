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

/**
 * 
 * Creates a seeker class that extends sprite
 * @version 5/24/22
 * 
 * @author Joshua Lee & Jacob Tang
 *
 */
public class Seeker extends Sprite {

	public static final int SEEKER_WIDTH = 30;
	public static final int SEEKER_HEIGHT = 30;
	private int score;
	private PImage img;
	public double xfinal, yfinal;
	private int dir;
	private long timeTazed = -1;

	/*
	 * creates a seeker that extends a sprite
	 */
	public Seeker(PImage img, int x, int y) {
		super(img, x, y, SEEKER_WIDTH, SEEKER_HEIGHT);
		this.img = img;
	}

	/**
	 * draws the seeker on the PApplet
	 * @param drawer PApplet drawer the seeker is drawn on
	 */
	public void draw(PApplet drawer) {
		drawer.image(img, (float) x, (float) y, SEEKER_WIDTH, SEEKER_HEIGHT);
	}

	/*
	 * overrides the move method to show how the seeker moves
	 */
	
	/**
	 * controls the movement of the seeker
	 * @param x amount moved to the right or left
	 * @param y amount moved up or down
	 */
	public void move(int x, int y) {
		if (timeTazed>=0 && (System.currentTimeMillis() - timeTazed)<= 5000) {
			return;
		}
		this.x+=x;
		this.y+=y;
		
		xfinal = this.x;
		yfinal = this.y;
		
	}

	/**
	 * calculates the time that the seeker has been tazed
	 */
	public void taze() {
		timeTazed = System.currentTimeMillis();
	}

	/**
	 * returns the x coordinate of the seeker
	 */
	public double getX() {
		return this.x;
	}

	/**
	 * returns the y coordinate of the seeker
	 */
	public double getY() {
		return this.y;
	}

	/**
	 * sets the score of the seeker
	 * @param score the score of the seeker
	 */
	public void setScore(int score) {
		//score+= (peopleTagged(hider)*100);
		this.score = score;
	}

	/**
	 * gets the score of the seeker
	 * @return score of the seeker
	 */
	public int getScore() {
		return score;
	}
	
	/**
	 * sets the direction of the seeker
	 * @param direction the degree and direction the seeker is facing
	 */
	public void setDirection(int direction) {
		this.dir = direction;
	}
	
	/**
	 * returns the direction of the seeker
	 * @return dir the direction of the seeker
	 */
	public int getDirection() {
		return dir;
	}
}
