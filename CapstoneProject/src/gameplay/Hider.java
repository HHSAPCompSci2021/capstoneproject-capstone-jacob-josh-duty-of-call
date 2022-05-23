/**
 * Hider represents hider in the game

 * @version 5/10/22
 * 
 * @author Jacob Tang
 *
 */
package gameplay;

import java.util.List;
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
	
	private SpecialPowers power;
	private boolean wallPhase;
	private boolean taserStun;
	private boolean invincible;
	
	private Map map;
	private Seeker seeker;
	
	private String powerName;
	
	private PImage img;
	
	private int lives = 1;
	private int score;
	
	private int dir;
	
	public Hider(PImage img, int x, int y) {
		super(img, x, y, HIDER_WIDTH, HIDER_HEIGHT);
		this.img = img;
		lives = 1;
		//powers = null;
		
		
	}
	
	public void draw(PApplet drawer) {
		drawer.image(img, (float)x, (float)y, HIDER_WIDTH, HIDER_HEIGHT);
	}
	
	public boolean isTouching(List<Sprite> boundaries) {
		for (Sprite s: boundaries) {
			if (s.contains(this.x, this.y)) {
				return true;
			}
		}
		return false;
		
		
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
			x+=20;
		}

		if (dirY == 1) {
			y+=20;
		}
		
		if (dirX == -1) {
			x-=20;
		}
		if (dirY == -1) {
			y-=20;
		}

	}
	

//	public String assignPowers() {
//		int i = (int)(Math.random()*3);
//		
//		if(power.choosePower(i) == "speed boost") {
//			powerName = "speed boost";
//		}
//		else if(power.choosePower(i) == "taser stun") {
//			powerName = "taser stun";
//		}
//		else if(power.choosePower(i) == "invincible") {
//			powerName = "invincible";
//		}
//		return powerName;
//	
//	}
	
	public void usePower() {
		if(choosePower() == "speed boost") {
			speedBoost();
		}
		else if(choosePower() == "taser stun") {
			taserStun();
		}
		else if(choosePower() == "invincible") {
			invincible();
		}
		
	}
	
	public String choosePower() {
//		int i =  (int)((Math.random() * 3)+1);
		int i = 1;
		
			if (i == 1) {
				powerName = "speed boost";
				//return "speed boost
			} else if (i == 2) {
				powerName = "taser stun";
			} else if (i == 3) {
				powerName = "invincible";
			}
		
		return powerName;
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
	public void extraLife() {
		lives++;
	}
	public void setScore(int score) {
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
	
	/*
	 * makes hider "invincible"
	 */
	public void invincible() {

		new java.util.Timer().schedule(new java.util.TimerTask() {
			@Override
			public void run() {
				if (isTagged(seeker)) {
					extraLife();
					// hider.isTagged(seeker) = false;
				}
			}
		}, 5000);

	}

	/*
	 * gives seeker faster movement speed
	 */
	public void speedBoost() {
//		new java.util.Timer().schedule(new java.util.TimerTask() {
//			@Override
//			public void run() {
		if (this.getDirection() == 0 ) {
				accelerate(0, -1);
		}
		if (this.getDirection() == 180 ) {
			accelerate(0, 1);
	}
		if (this.getDirection() == 90 ) {
			accelerate(1, 0);
	}
		if (this.getDirection() == 270 ) {
			accelerate(-1, 0);
	}
		
		
//			}
//		}, 5000);

	}


	/*
	 * stuns seeker
	 */
	public void taserStun() {
//		new java.util.Timer().schedule(new java.util.TimerTask() {
//			@Override
//			public void run() {
		if (seeker.getX() +30 <= getX() || seeker.getX()-30 >= getX() || seeker.getY()+30 >= getY() || seeker.getY() <= getY()) {
				seeker.move(0, 0);
		}
//			}
//		}, 3000);

	}

	
}
