package gameplay;

import java.awt.geom.Rectangle2D;

import processing.core.PApplet;
import processing.core.PImage;

/**
 * Sprite represents all the characters
 * @version 5/10/22
 * 
 * @author Joshua Lee & Jacob Tang
 *
 */

public class Sprite extends Rectangle2D.Double {
	/*
	 * creates a character that is replicated by the hiders and seekers
	 */
	private double x;
	private double y;
	private double width;
	private double height;
	private PImage image;
	
	public Sprite(int x, int y, int w, int h) {
		this.x = x;
		this.y = y;
		this.width = w;
		this.height = h;
	}
	public Sprite(PImage img, int x, int y, int w, int h) {
		super(x,y,w,h);
		image = img;
	}
	
	public void moveToLocation(double x, double y) {
		super.x = x;
		super.y = y;
	}
	
	public void moveByAmount(double x, double y) {
		super.x += x;
		super.y += y;
	}
	
	public void draw(PApplet g) {
		if (image != null)
			g.image(image,(float)x,(float)y,(float)width,(float)height);
		else {
			g.fill(100);
			g.rect((float)x,(float)y,(float)width,(float)height);
		}
	}
	public double getX(double xCoord) {
		xCoord = x;
		return x;
	}
	public void setX(double xCoord) {
		xCoord = x;
	}
	
	public double getT(double yCoord) {
		yCoord = x;
		return x;
	}
	public void setT(double yCoord) {
		yCoord = x;
	}
}
