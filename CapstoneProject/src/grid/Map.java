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
		
		
		lineDraw();
		
	}
	
	public boolean isValidLocation() {
		return false;
	}
	
	public void lineDraw() {
		left = new Line2D.Float(10,10,10, 50);
	}
	
	public double getHeight() {
		return x;
	}

	public double getWidth() {
		return y;
	}
}
