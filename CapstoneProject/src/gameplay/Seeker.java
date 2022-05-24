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

	public void draw(PApplet drawer) {
		drawer.image(img, (float) x, (float) y, SEEKER_WIDTH, SEEKER_HEIGHT);
	}

	/*
	 * overrides the move method to show how the seeker moves
	 */
	public void move(int x, int y) {
		System.out.println("current time:" + System.currentTimeMillis());
		System.out.println("time tazed:" + timeTazed);
		if (timeTazed>=0 && (System.currentTimeMillis() - timeTazed)<= 5000) {
			System.out.println("in the loop");
			return;
		}
		this.x+=x;
		this.y+=y;
		
		xfinal = this.x;
		yfinal = this.y;
		
	}

	public void taze() {
		timeTazed = System.currentTimeMillis();
		System.out.println(timeTazed);
	}
//	public int peopleTagged(Hider other) {
//		if (this.intersects(other)) {
//			this.tagged += 1;
//		}
//		return this.tagged;
//	}

	public double getX() {
		return this.x;
	}

	public double getY() {
		return this.y;
	}

	public void setScore(int score) {
		//score+= (peopleTagged(hider)*100);
		this.score = score;
	}

	public int getScore() {
		return score;
	}
	public void setDirection(int direction) {
		this.dir = direction;
	}
	public int getDirection() {
		return dir;
	}
}
