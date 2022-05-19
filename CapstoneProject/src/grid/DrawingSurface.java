package grid;

import java.awt.Point;

import java.util.ArrayList;

import gameplay.Hider;


import gameplay.Seeker;
import gameplay.Sprite;
import processing.core.PApplet;
import processing.core.PImage;
//import processing.core.PImage;

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
	
	private Map map;
	
	private PImage hider2;
	private PImage seeker2;
		
	
	
	/**
	 * creates a surface to be drawn on and extends PApplet
	 */
	public DrawingSurface() {
		start = true;
		play = false;
		gameOver = false;
		//map = new Map(map.txt);

	}
	
	/**
	 * set up function that sets up the drawingsurface
	 */
	public void setup() {
		hider2 = loadImage
		
	}
	
	/**
	 * draws the program when it is executed
	 */
	public void draw() {
		if(hider.isTagged(seeker)) {
			gameOver=true;
		}
		if(start) {
			
		}
		if(play) {
			
		}
		if(gameOver) {
			
		}

	}
	
}
