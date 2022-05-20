/**
 * Map represents the grid that the game will be played on

 * @version 5/10/22
 * 
 * @author Joshua Lee & Jacob Tang
 *
 */

package grid;

import java.awt.Rectangle;
import java.awt.geom.Line2D;
import java.util.ArrayList;

import processing.core.PApplet;
import rparikh931.shapes.Line;

/**
 * 
 * creates a map on drawing surface
 *
 */
public class Map {
	
	private int x,y;
	
	private Line2D left;
	

	public Map() {
		
		
	}
	
	public void draw(PApplet drawer) {
		
		drawer.line(60, 60, 100, 100);
		
		lineDraw(40,60,80,100);
		
	}
	
	public boolean isValidLocation() {
		if ()
		return false;
	}
	
	public void lineDraw(float x1, float x2, float y1, float y2) {
		left = new Line2D.Float(x1,x2,y1, y2);
	}
	
	public double getHeight() {
		return x;
	}

	public double getWidth() {
		return y;
	}
}
