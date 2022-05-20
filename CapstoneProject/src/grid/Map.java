/**
 * Map represents the grid that the game will be played on

 * @version 5/10/22
 * 
 * @author Joshua Lee & Jacob Tang
 *
 */

package grid;

import java.awt.Color;
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
	

	public Map() {
		
		
	}
	
	public void draw(PApplet drawer) {
		
		drawer.line(0, 0, 800, 0);
		drawer.line(0, 0, 0, 600);
		drawer.line(0, 600, 800, 600);
		drawer.line(800, 0, 800, 600);
		
		
	}
	
	
	public double getHeight() {
		return x;
	}

	public double getWidth() {
		return y;
	}
}
