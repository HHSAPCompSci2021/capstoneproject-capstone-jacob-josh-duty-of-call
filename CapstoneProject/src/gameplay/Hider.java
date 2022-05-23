/**
 * Hider represents hider in the game

 * @version 5/10/22
 * 
 * @author Jacob Tang
 *
 */
package gameplay;

import java.awt.List;
import java.util.ArrayList;

import grid.Map;
import processing.core.PApplet;
import processing.core.PImage;

/**
 * 
 * Instantiates a hider that inherits the qualities of a Sprite
 *
 */
public class Hider extends Sprite {
	
	public static final int HIDER_WIDTH = 30;
	public static final int HIDER_HEIGHT = 30;
	
	private SpecialPowers speedBoost;
	private boolean wallPhase;
	private boolean taserStun;
	private boolean invincible;
	
	private Map map;
	
	private PImage img;
	
	private int lives = 1;
	private int score;
	
	private int dir;
	
	public Hider(PImage img, int x, int y) {
		super(img, x, y, HIDER_WIDTH, HIDER_HEIGHT);
		this.img = img;
		lives = 1;
		
	}
	
	public void draw(PApplet drawer) {
		drawer.image(img, (float)x, (float)y, HIDER_WIDTH, HIDER_HEIGHT);
	}
	
	public void act() {
//		for (Sprite x: obstacles) {
//			if (super.intersects(x)) {
//				move(0,0);
//			}
//		}
		
		
//		if(getX() <= 1) {
//			x+=10;
//		}
//		if(getX() >= map.getWidth() - 51) {
//			y-=10;
//		}
//		if(getY() <= 1) {
//			y+=10;
//		}
//		if(getY() >= map.getHeight() - 101) {
//			y-=10;
//		}
		
		//setLocation(xBoundary, yBoundary);
	}

/**
 * Overrides the move method and describes how the hider moves
 * 
 */
	public void move(int dirX, int dirY) {
		if (dirX == 1) {
			x+=10;
		}
		if (dirX == -1) {
			x-=10;
		}
		if (dirY == 1) {
			y+=10;
		}
		if (dirY == -1) {
			y-=10;
		}
		
	}
	
	
	
	public void accelerate(int dirX, int dirY) {
		if (dirX == 1) {
			x+=5;
		}
		if (dirX == -1) {
			x-=5;
		}
		if (dirY == 1) {
			y+=5;
		}
		if (dirY == -1) {
			y-=5;
		}
	}
	
	public void assignPowers() {
		
	
	}
	
	public String getPowers() {
		return null;
	}
	
	public boolean usePower() {

		if(taserStun) {
			return true;
		}
		if(wallPhase) {
			return true;
		}
		if(invincible) {
			return true;
		}
		return false;
	}
	
	
	public boolean isTagged(Seeker other) {
		if(this.intersects(other)) {
			this.loseLife();
			return true;
		}
		return false;
	}
	
	public int getLives() {
		return lives;
	}
	
	public void loseLife() {
		lives--;
	}
	
	public void setScore(int score){
		this.score = score;
		if (getLives() != 0) {
			score += 1;
		}
	}
	public int getScore() {
		return score;
	}
	public void setX(double x) {
		this.x = x;
	}
	public void setY(double y) {
		this.y = y;
	}
	public double getX() {
		return x;
	}
	public double getY() {
		return y;
	}
	public void setDirection(int direction) {
		this.dir = direction;
	}
	public int getDirection() {
		return dir;
	}

	
}
