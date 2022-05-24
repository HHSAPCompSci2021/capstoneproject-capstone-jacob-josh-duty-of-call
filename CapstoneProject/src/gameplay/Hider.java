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
	public double xfinal, yfinal;

	private Map map;
	private Seeker seeker;

	private int xVel = 1, yVel = 1;
	private int right = 90;
	private int left = 270;
	private int up = 0;
	private int down = 180;

	private String powerName;

	private PImage img;

	private int lives;
	private int score;

	private int dir;
	private int numTeleports;

	/**
	 * 
	 * @param img
	 * @param x
	 * @param y
	 * @param s
	 * @param m
	 */
	public Hider(PImage img, int x, int y, Seeker s, Map m) {
		super(img, x, y, HIDER_WIDTH, HIDER_HEIGHT);
		this.img = img;
		lives = 1;
		seeker = s;
		map = m;
		numTeleports = 1;
		// powers = null;

	}

	public void draw(PApplet drawer) {
		drawer.image(img, (float) x, (float) y, HIDER_WIDTH, HIDER_HEIGHT);
	}

	public boolean isTouching(List<Sprite> boundaries) {
		for (Sprite s : boundaries) {
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

		// setLocation(xBoundary, yBoundary);
	}

	/**
	 * Overrides the move method and describes how the hider moves
	 * 
	 */
	public void move(int x, int y) {
		this.x += (x * xVel);
		this.y += (y * yVel);

		xfinal = this.x;
		yfinal = this.y;

	}

	public void accelerate(double xVel, double yVel) {
		this.xVel += xVel;
		this.yVel += yVel;

		// move(xVel, yVel);

	}

	public void usePower() {
		if (namePower() == "speed boost") {
			speedBoost();
		} else if (namePower() == "taser stun") {
			taserStun();
		} else if (namePower() == "invincible") {
			reborn();
		} else if(namePower() == "teleport") {
			teleport();
		}

	}

	public String choosePower() {
		
		int i =  (int)((Math.random() * 3)+1);

		if (i == 1) {
			powerName = "speed boost";
			// return "speed boost
		} else if (i == 2) {
			powerName = "taser stun";
		} else if (i == 3) {
			powerName = "reborn";
		} else if(i == 4) {
			powerName = "teleport";
		}
		return powerName;

	}

	public String namePower() {
		return powerName;
	}

	public boolean isTagged(Seeker other) {
		if (this.intersects(other)) {
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

	public double nextX(double x) {
		return this.x + (x * xVel);
	}

	public double nextY(double y) {
		return this.y + (y * yVel);
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
	public void reborn() {

//		new java.util.Timer().schedule(new java.util.TimerTask() {
//			@Override
//			public void run() 
		extraLife();
		x = 30;
		y = 70;
		// hider.isTagged(seeker) = false;

//			}
//		}, 5000);

	}
	
	public void teleport() {
		
		if(numTeleports==0) {
			return;
		}
		
		int tempx = (int)(Math.random()*map.getWidth());
		int tempy = (int)(Math.random()*map.getHeight());
		
		
		while(!map.isNextValid(tempx, tempy) || !(map.inBounds(tempx, tempy))) {
			tempx = (int)(Math.random()*map.getWidth());
			tempy = (int)(Math.random()*map.getHeight());
		}
		
		x = tempx;
		y = tempy;
		
		numTeleports--;
		
		
		
		
		
	}

	/*
	 * gives seeker faster movement speed
	 */
	public void speedBoost() {
//		new java.util.Timer().schedule(new java.util.TimerTask() {
//			@Override
//			public void run() {
		if (this.getDirection() == up) {
			accelerate(0, 1.2);
		}
		if (this.getDirection() == down) {
			accelerate(0, 1.2);
		}
		if (this.getDirection() == right) {
			accelerate(1.2, 0);
		}
		if (this.getDirection() == left) {
			accelerate(1.2, 0);
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
		System.out.println("before");
		if (seeker.getX() + 60 >= getX() && seeker.getX() - 60 <= getX() && seeker.getY() - 60 <= getY()
				&& seeker.getY() + 60 >= getY()) {
			System.out.println("after");
			seeker.taze();
		}
//			}
//		}, 3000);

	}

}
