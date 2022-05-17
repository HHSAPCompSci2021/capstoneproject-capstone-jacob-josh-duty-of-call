package grid;

import gameplay.Hider;


import gameplay.Seeker;
import gameplay.Sprite;
import processing.core.PApplet;
import processing.core.PImage;

/**
 * Drawing Surface represents the surface that the drawing will be on
 * @version 5/10/22
 * 
 * @author Joshua Lee & Jacob Tang
 *
 */

public class DrawingSurface extends PApplet {

	//private Sprite sprite;
	private Hider hider;
	private Seeker seeker;
	
	private boolean play;
	private boolean start;
	private boolean gameOver;
	
//	private PImage startScreen;
//	private PImage endScreen;
	private Map map;
	
	
	
	/**
	 * creates a surface to be drawn on and extends PApplet
	 */
	public DrawingSurface() {
		play = false;
		start = true;
		gameOver = false;

	}
	
	/**
	 * set up function that sets up the drawingsurface
	 */
	public void setup() {
		
	}
	
	/**
	 * draws the program when it is executed
	 */
	public void draw() {
		if(hider.getLives()==0) {
			gameOver = true;
			textSize(50);
			text("GAME OVER. PLEASE WAIT UNTIL NEXT ROUND", 400, 300);
			//startScreen.get();
		}
		if(start) {
			map.draw();
		}
		if(play) {
			
		}
	}
	
	/**
	 * executes certain buttons are pressed
	 */
	public void keyPressed() {
		
	}
	
	/**
	 * executes when mouse is pressed
	 */
	public void mousePressed() {
		
	}
}
