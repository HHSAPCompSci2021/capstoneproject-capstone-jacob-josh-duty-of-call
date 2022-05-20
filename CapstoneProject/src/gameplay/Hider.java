/**
 * Hider represents hider in the game

 * @version 5/10/22
 * 
 * @author Jacob Tang
 *
 */
package gameplay;

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
	
	private ArrayList<SpecialPowers> powers;
	private String power;
	
	private SpecialPowers speedBoost;
	private boolean wallPhase;
	private boolean taserStun;
	private boolean invisibility;
	
	private PImage img;
	
	private int lives, score;
	
	private Map map;
	
	private double xVel, yVel;
	
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
		if(this.getX() <= 0) {
			move(0, 0);
		}
		if(this.getX() >= 800) {
			move(0, 0);
		}
		if(this.getY() <= 0) {
			move(0, 0);
		}
		if(this.getY() >= 600) {
			move(0, 0);
		}
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
		if(dirX == 0) {
			x+=0;
		}
		if(dirY == 0){
			y+=0;
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
			this.accelerate(1, 1);
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
	
	public String getPowers() {
		return power;
	}
	
	public boolean usePower() {
//		if(speedBoost) {
//			xVel+=2;
//			yVel+=2;
//			
//			x+=xVel;
//			y+=yVel;
//		}
		if(taserStun) {
			//hider.taserStun();
			return true;
		}
		if(wallPhase) {
			return true;
		}
		if(invisibility) {
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
