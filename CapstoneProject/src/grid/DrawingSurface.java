package grid;

import java.util.ArrayList;

import gameplay.Hider;


import gameplay.Seeker;
import gameplay.Sprite;
import processing.core.PApplet;
import processing.core.PImage;
import screens.FirstScreen;
import screens.Screen;
import screens.SecondScreen;

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
//	private Map map;
	
	private Screen activeScreen;
	private ArrayList<Screen> screens;
	
	
	
	/**
	 * creates a surface to be drawn on and extends PApplet
	 */
	public DrawingSurface() {
		play = false;
		start = true;
		gameOver = false;
		
		screens = new ArrayList<Screen>();
		
		MenuScreen screen1 = new MenuScreen(this);
		screens.add(screen1);
		
		Map screen2 = new Map(this);
		screens.add(screen2);
		
		activeScreen = screens.get(0);

	}
	
	/**
	 * set up function that sets up the drawingsurface
	 */
	public void setup() {
		for (Screen s : screens)
			s.setup();
	}
	
	/**
	 * draws the program when it is executed
	 */
	public void draw() {
		if(hider.getLives()==0) {
			gameOver = true;
			textSize(50);
			text("GAME OVER. PLEASE WAIT UNTIL NEXT ROUND", 400, 300);
			
		}
		if(start) {
			screens.get(0).draw();
		}
		if(play) {
			screens.get(1).draw();
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
