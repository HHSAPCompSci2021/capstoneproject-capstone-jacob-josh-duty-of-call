/**
 * Map represents the grid that the game will be played on
 * @version 5/10/22
 * 
 * @author Joshua Lee & Jacob Tang
 *
 */

package grid;

import java.awt.Rectangle;

/**
 * 
 * creates a map on drawing surface
 *
 */
public class Map extends Screen {
	
	private DrawingSurface surface;

	//public final int DRAWING_WIDTH, DRAWING_HEIGHT;

	public Map(DrawingSurface surface) {
		super(800, 600);
		this.surface = surface;
	}
	
	public void draw() {
		
	}

}
