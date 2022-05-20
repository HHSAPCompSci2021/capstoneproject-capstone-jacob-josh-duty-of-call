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
	
	//private int x,y;
	private int rectWidth, rectHeight;
	

	public Map() {
		
		
	}
	
	public void draw(PApplet drawer) {
		drawer.fill(255);
		drawer.rect(10, 50, drawer.width - 50, drawer.height - 100);
		
		drawer.fill(100);
		drawer.rect(40, 80, 100, 80);
		drawer.rect(670, 500, 150, 90);
		drawer.rect(40, 190, 250, 100);
		drawer.rect(40, 320, 30, 200);
		drawer.rect(40, 550, 200, 50);
		drawer.rect(600, 500, 220, 100);
		drawer.rect(100, 320, 140, 200);
		drawer.rect(270, 320, 20, 280);
	}
	
//	public void setHeight(int x) {
//		this.x = x;
//	}
//	public void setWidth(int y) {
//		this.y = y;
//	}
//	
//	
//	public double getHeight() {
//		return x;
//	}
//
//	public double getWidth() {
//		return y;
//	}
}
