package gameplay;

import java.awt.geom.Rectangle2D;

import processing.core.PApplet;
import processing.core.PImage;

/**
 * Sprite represents all the characters
 * @version 5/10/22
 * 
 * @author Joshua Lee
 *
 */

public class Sprite extends Rectangle2D.Double {
	/*
	 * creates a character that is replicated by the hiders and seekers
	 */
	private PImage image;
	
	/**
	 * Instantiates a Sprite and gives it default values
	 * @param x x coordinate of sprite
	 * @param y y coordinate of sprite
	 * @param w width of sprite
	 * @param h height of sprite
	 */
	public Sprite(int x, int y, int w, int h) {
		this(null, x, y, w, h);
	}
	/**
	 * Instantiates a Sprite image and gives it default values
	 * @param img Sprite image (png)
	 * @param x x coordinate of sprite
	 * @param y y coordinate of sprite
	 * @param w width of sprite
	 * @param h height of sprite
	 */
	public Sprite(PImage img, int x, int y, int w, int h) {
		super(x,y,w,h);
		image = img;
	}
	
	/**
	 * Moves Sprite to a give location
	 * @param x x coordinate of location sprite moves to
	 * @param y y coordinate of location sprite moves to
	 */
	public void moveToLocation(double x, double y) {
		super.x = x;
		super.y = y;
	}
	
	/**
	 * Moves Sprite to a give location
	 * @param x x coordinate of how much sprite moves left or right
	 * @param y y coordinate of how much sprite moves up or down
	 */
	public void moveByAmount(double x, double y) {
		super.x += x;
		super.y += y;
	}
	
	/**
	 * Draws a sprite with coordinates (x,y) and width and height.
	 * @param g PApplet surface to draw Sprite on
	 */
	public void draw(PApplet g) {
		if (image != null)
			g.image(image,(float)x,(float)y,(float)width,(float)height);
		else {
			g.fill(100);
			g.rect((float)x,(float)y,(float)width,(float)height);
		}
	}
	
	public boolean isCharacterInside(double x, double y) {
		boolean pointInside = false;
		if((this.getX() <= x && x <= this.getX() + width) && (this.getY() <= y && y <= this.getY() + height)) {
			pointInside = true;
			return pointInside;
		}
		return pointInside;
	}
//	public double getX() {
//		return x;
//	}
//	public void setX(double xCoord) {
//		xCoord = x;
//	}
//	
//	public double getY() {
//		return y;
//	}
//	public void setY(double yCoord) {
//		yCoord = y;
//	}
}
