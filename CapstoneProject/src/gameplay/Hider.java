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

	/**
	 * Increases velocity of hider increases move distance of hider
	 */
	public void accelerate(double xVel, double yVel) {
		this.xVel += xVel;
		this.yVel += yVel;


	}
	
	/**
	 * Checks which power is chosen and lets hider use the power chosen
	 */
	public void usePower() {
		if (namePower() == "speed boost") {
			speedBoost();
		} else if (namePower() == "taser stun") {
			taserStun();
		} else if (namePower() == "reborn") {
			reborn();
		} else if(namePower() == "teleport") {
			teleport();
		}

	}

	/**
	 * Randomly assigns a power to the hider
	 * @return the power of the hider 
	 */
	public String choosePower() {
		
		//int i =  (int)((Math.random() * 3)+1);
		int i = 3;

		if (i == 1) {
			powerName = "speed boost";
		} else if (i == 2) {
			powerName = "taser stun";
		} else if (i == 3) {
			powerName = "reborn";
		} else if(i == 4) {
			powerName = "teleport";
		}
		return powerName;

	}

	/**
	 * returns the power name of the hider
	 * @return power name of hider
	 */
	public String namePower() {
		return powerName;
	}

	/**
	 * Checks to see if hider is tagged by seeker and if so, hider loses life
	 * @param other seeker
	 * @return true if hider is tagged, false otherwise
	 */
	public boolean isTagged(Seeker other) {
		if (this.intersects(other)) {
			this.loseLife();
			return true;
		}
		return false;
	}

	/**
	 * returns the amount of lives the hider has
	 * @return lives of hider
	 */
	public int getLives() {
		return lives;
	}

	/**
	 * Hider loses a life
	 */
	public void loseLife() {
		lives--;
	}

	/**
	 * Hider gains a life
	 */
	public void extraLife() {
		lives++;
	}

	/**
	 * Sets score of hider
	 * @param score of hider
	 */
	public void setScore(int score) {
		this.score = score;
	}

	/**
	 * Gets score of hider
	 * @return score of hider
	 */
	public int getScore() {
		return score;
	}

	/**
	 * Sets x coordinate of hider
	 * @param x coordinate of hider
	 */
	public void setX(double x) {
		this.x = x;
	}

	/**
	 * Sets y coordinate of hider
	 * @param y coordinate of hider
	 */
	public void setY(double y) {
		this.y = y;
	}

	/**
	 * Returns x coordinate of hider
	 * @return x coordinate of hider
	 */
	public double getX() {
		return x;
	}

	/**
	 * Returns y coordinate of hider
	 * @return y coordinate of hider
	 */
	public double getY() {
		return y;
	}

	/**
	 * Returns the x coordinate of the next step of hider
	 * @param x coordinate of hider
	 * @return the next x coordinate of hider
	 */
	public double nextX(double x) {
		return this.x + (x * xVel);
	}

	/**
	 * Returns the y coordinate of the next step of hider
	 * @param y coordinate of hider
	 * @return the next y coordinate of hider
	 */
	public double nextY(double y) {
		return this.y + (y * yVel);
	}

	/**
	 * Sets the direction of the hider
	 * @param direction direction of hider
	 */
	public void setDirection(int direction) {
		this.dir = direction;
	}

	/**
	 * Gets the direction of the hider
	 * @return the direction of the hider
	 */
	public int getDirection() {
		return dir;
	}

	/**
	 * Gifts hider an extra life
	 */
	public void reborn() {
		extraLife();
		
		
	}
	
	/**
	 * Teleports the hider to a random valid location on the map
	 */
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

	/**
	 * Hider accelerates as movement speeds up
	 */
	public void speedBoost() {
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

	}

	/**
	 * Hider stuns seeker disabling seekers movement for 5 seconds
	 */
	public void taserStun() {
		System.out.println("before");
		if (seeker.getX() + 60 >= getX() && seeker.getX() - 60 <= getX() && seeker.getY() - 60 <= getY()
				&& seeker.getY() + 60 >= getY()) {
			System.out.println("after");
			seeker.taze();
		}

	}

}
