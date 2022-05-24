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
 * @version 5/24/22
 * 
 * @author Joshua Lee & Jacob Tang
 *
 */
public class Map {

	private int x, y;

	private List<Sprite> boundaries;
	private List<Sprite> outline;


	/**
	 * creates a new map with boundaries
	 * 
	 * @param surface Drawing surface to draw on
	 */
	public Map(DrawingSurface surface) {
//		this.surface = surface;
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

		outline = new ArrayList<Sprite>();
		outline.add(new Sprite(10, 50, surface.width - 50, surface.height - 100));

	}

	/**
	 * Draws a map with rectangular boundaries that the hider and seeker can't cross
	 * through.
	 * 
	 * @param drawer PApplet surface to draw Map on
	 */
	public void draw(PApplet drawer) {


		x = drawer.width;
		y = drawer.height;
		drawer.fill(255);

		drawer.rect(10, 50, drawer.width - 50, drawer.height - 100);

		drawer.fill(100);

		boundaries.get(0).draw(drawer);
		boundaries.get(1).draw(drawer);
		boundaries.get(2).draw(drawer);
		boundaries.get(3).draw(drawer);
		boundaries.get(4).draw(drawer);
		boundaries.get(5).draw(drawer);
		boundaries.get(6).draw(drawer);
		boundaries.get(7).draw(drawer);
		boundaries.get(8).draw(drawer);
		boundaries.get(9).draw(drawer);
		boundaries.get(10).draw(drawer);
		boundaries.get(11).draw(drawer);
		boundaries.get(12).draw(drawer);
		boundaries.get(13).draw(drawer);
		boundaries.get(14).draw(drawer);
		boundaries.get(15).draw(drawer);
		boundaries.get(16).draw(drawer);

		boundaries.get(17).draw(drawer);
		boundaries.get(18).draw(drawer);
		boundaries.get(19).draw(drawer);
		boundaries.get(20).draw(drawer);
		boundaries.get(21).draw(drawer);
		boundaries.get(22).draw(drawer);
		boundaries.get(23).draw(drawer);
		boundaries.get(24).draw(drawer);
		boundaries.get(25).draw(drawer);
		boundaries.get(26).draw(drawer);
		boundaries.get(27).draw(drawer);
		boundaries.get(28).draw(drawer);
		boundaries.get(29).draw(drawer);

	}

	/**
	 * Sets the height of the object
	 * 
	 * @param x the height set
	 */
	public void setHeight(int x) {
		this.x = x;
	}

	/**
	 * Sets the width of the object
	 * 
	 * @param y the width set
	 */
	public void setWidth(int y) {
		this.y = y;
	}

	/**
	 * gets the height of the object
	 * 
	 * @return y the height of the object
	 */
	public double getHeight() {
		return y;
	}

	/**
	 * gets the width of the object
	 * @return x the width of the object
	 */
	public double getWidth() {
		return x;
	}


	/**
	 * Tests whether the next point is a valid point and is not in the boundaries set within the map
	 * @param x x coordinate of the next move
	 * @param y y coordinate of the next move
	 * @return true if the point is a valid point false otherwise
	 */
	public boolean isNextValid(double x, double y) {
		boolean nextIn = true;
		for (int i = 0; i < boundaries.size(); i++) {
			if ((x >= boundaries.get(i).x && x <= boundaries.get(i).x + boundaries.get(i).getWidth())
					&& (y >= boundaries.get(i).y && y <= boundaries.get(i).y + boundaries.get(i).getHeight())) {
				nextIn = false;
				return nextIn;
			}
		}
		return nextIn;

	}

	/**
	 * Tests whether the next point is within the boundaries of the map
	 * @param x x coordinate of the next move
	 * @param y y coordinate of the next move
	 * @return true if the hider is in bound false otherwise
	 */
	public boolean inBounds(double x, double y) {
		boolean hiderInBound = false;
		for (int i = 0; i < outline.size(); i++) {
			if ((x >= outline.get(i).x && x <= outline.get(i).x + outline.get(i).getWidth())
					&& (y >= outline.get(i).y && y <= outline.get(i).y + outline.get(i).getHeight())) {
				hiderInBound = true;
				return hiderInBound;
			}
		}
		return hiderInBound;

	}
}
