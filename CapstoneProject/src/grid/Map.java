/**
 * Map represents the grid that the game will be played on

 * @version 5/10/22
 * 
 * @author Joshua Lee & Jacob Tang
 *
 */

package grid;


import java.util.ArrayList;
import java.util.List;

import gameplay.Sprite;
import processing.core.PApplet;

/**
 * 
 * Creates a map on drawing surface
 *
 */
public class Map {
	
	private int x,y;
	
	private List<Sprite> boundaries;
	

	public Map(DrawingSurface surface) {
		boundaries = new ArrayList<Sprite>();
		boundaries.add(new Sprite(40, 80, 100, 80));
		boundaries.add(new Sprite(40, 190, 250, 100));
		boundaries.add(new Sprite(40, 320, 30, 200));
		boundaries.add(new Sprite(40, 550, 200, 40));
		
		boundaries.add(new Sprite(170, 80, 500, 20));
		boundaries.add(new Sprite(170, 140, 300, 20));
		
		boundaries.add(new Sprite(670, 80, 30, 150));
		boundaries.add(new Sprite(730, 80, 20, 250));
		
		boundaries.add(new Sprite(100, 320, 140, 200));
		boundaries.add(new Sprite(270, 320, 20, 270));
		
		boundaries.add(new Sprite(670, 500, 150, 90));
		boundaries.add(new Sprite(780, 80, 40, 100));
		boundaries.add(new Sprite(780, 210, 40, 120));
		
		boundaries.add(new Sprite(530, 140, 110, 90));
		boundaries.add(new Sprite(470, 140, 30, 90));
		
		boundaries.add(new Sprite(320, 190, 120, 35));
		boundaries.add(new Sprite(320, 255, 380, 35));
		
		boundaries.add(new Sprite(670, 360, 150, 30));
		boundaries.add(new Sprite(670, 420, 30, 50));
		boundaries.add(new Sprite(790, 420, 30, 50));
		boundaries.add(new Sprite(700, 420, 90, 10));
		
		boundaries.add(new Sprite(320, 500, 150, 90));
		boundaries.add(new Sprite(500, 470, 30, 120));
		boundaries.add(new Sprite(610, 500, 30, 90));
		boundaries.add(new Sprite(530, 580, 80, 10));

		boundaries.add(new Sprite(320, 420, 210, 50));
		boundaries.add(new Sprite(560, 330, 80, 140));
		
		boundaries.add(new Sprite(320, 320, 100, 20));
		boundaries.add(new Sprite(320, 370, 100, 20));
		boundaries.add(new Sprite(450, 320, 80, 70));
		boundaries.add(new Sprite(530, 580, 80, 10));
		
	}
	
	/**
	 * Draws a map with rectangular boundaries that the hider and seeker can't cross through.
	 * @param drawer PApplet surface to draw Map on
	 */
	public void draw(PApplet drawer) {
		x = drawer.width;
		y = drawer.height;
		drawer.fill(255);
		
		drawer.rect(10, 50, drawer.width - 50, drawer.height - 100);
		
		drawer.fill(100);
		
		
		drawer.rect(40, 80, 100, 80);
		drawer.rect(40, 190, 250, 100);
		drawer.rect(40, 320, 30, 200);
		drawer.rect(40, 550, 200, 40);
		
		drawer.rect(170, 80, 500, 20);
		drawer.rect(170, 140, 300, 20);
		
		drawer.rect(670, 80, 30, 150);
		drawer.rect(730, 80, 20, 250);
		
		drawer.rect(100, 320, 140, 200);
		drawer.rect(270, 320, 20, 270);
		
		drawer.rect(670, 500, 150, 90);
		drawer.rect(780, 80, 40, 100);
		drawer.rect(780, 210, 40, 120);
		
		drawer.rect(530, 140, 110, 90);
		drawer.rect(470, 140, 30, 90);
		
		drawer.rect(320, 190, 120, 35);
		drawer.rect(320, 255, 380, 35);
		
		drawer.rect(670, 360, 150, 30);
		drawer.rect(670, 420, 30, 50);
		drawer.rect(790, 420, 30, 50);
		drawer.rect(700, 420, 90, 10);
		
		drawer.rect(320, 500, 150, 90);
		drawer.rect(500, 470, 30, 120);
		drawer.rect(610, 500, 30, 90);
		drawer.rect(530, 580, 80, 10);
		
		drawer.rect(320, 420, 210, 50);
		drawer.rect(560, 330, 80, 140);
		
		drawer.rect(320, 320, 100, 20);
		drawer.rect(320, 370, 100, 20);
		drawer.rect(450, 320, 80, 70);
		drawer.rect(530, 580, 80, 10);
		
	}
	
	public void setHeight(int x) {
		this.x = x;
	}
	public void setWidth(int y) {
		this.y = y;
	}
	
	
	public double getHeight() {
		return y;
	}

	public double getWidth() {
		return x;
	}
}
