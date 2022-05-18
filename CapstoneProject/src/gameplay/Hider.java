/**
 * Hider represents hider in the game
 * @version 5/10/22
 * 
 * @author Joshua Lee & Jacob Tang
 *
 */
package gameplay;

import java.util.ArrayList;

import processing.core.PImage;

/**
 * 
 * Instantiates a hider that inherits the qualities of a Sprite
 *
 */
public class Hider extends Sprite {
	
	public static final int HIDER_WIDTH = 30;
	public static final int HIDER_HEIGHT = 30;
	
	private ArrayList<SpecialPowers> powers;
	
	private SpecialPowers speedBoost;
	private boolean wallPhase;
	private boolean taserStun;
	private boolean invisibility;
	
	private int lives, score;
	
	private double xVel, yVel;
	
	private int direction;
	
	public Hider(PImage img, int x, int y) {
		super(img, x, y, HIDER_WIDTH, HIDER_HEIGHT);
		lives = 1;
		
	}

/**
 * Overrides the move method and describes how the hider moves
 * 
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
	
	public void accelerate(int dirX, int dirY) {
		if (dirX == 1) {
			x+=2;
		}
		if (dirX == -1) {
			x-=2;
		}
		if (dirY == 1) {
			y+=2;
		}
		if (dirY == -1) {
			y-=2;
		}
	}
	
	public void assignPowers() {
		
		int i = (int)(Math.random()*powers.size());
		
		if(powers.get(i)==speedBoost) {
			
		}
//		powers.add(1, speedboost);
//		powers.add(2, taserstun);
//		powers.add(3, wallphase);
//		powers.add(4, invisibility);
//		
//		int i = (int)(Math.random()*powers.size());
//		if(powers.get(i) == "speedboost") {
//			speedBoost = true;
//			powers.remove(i);
//				
//		}
//		if(powers.get(i) == "taserstun") {
//			taserStun = true;
//			powers.remove(i);
//			
//		}
//		if(powers.get(i) == "wallphase") {
//			wallPhase = true;
//			powers.remove(i);
//		}
//		if(powers.get(i) == "invisibility") {
//			invisibility = true;
//			powers.remove(i);
//		}
		
	}
	
	public void act() {
//		if(speedBoost) {
//			xVel+=2;
//			yVel+=2;
//			
//			x+=xVel;
//			y+=yVel;
//		}
		if(taserStun) {
			//hider.taserStun();
		}
		if(wallPhase) {
			
		}
		if(invisibility) {
			
		}
		
	}
	
	public void draw() {
		
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
		this.direction = direction;
	}
	public int getDirection() {
		return direction;
	}

	
}
