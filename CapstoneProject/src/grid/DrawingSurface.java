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
	
	private PImage title;
	private PImage playButton;
	
	private Map map;

		
	
	
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
		hider = new Hider(loadImage("img/hider.png"), 60, 420);
		seeker = new Seeker(loadImage("img/seeker.png"), 65, 360);
		title = loadImage("title.png");
		
	}
	
	/**
	 * draws the program when it is executed
	 */
	public void draw() {
		imageMode(CENTER);
		
//		if(hider.isTagged(seeker)) {
//			gameOver=true;
//		}
		if(start) {
			//sets title screen color and uploads title
			background(255);
			image(title, width/2, height/8, width/3, height/9);
			
			//play button
			image(playButton, width/2, height-height/8, width/5, height/10);
			hider = new Hider(loadImage("img/hider.png"), 45, 45);
			seeker = new Seeker(loadImage("img/seeker.png"), 0, 0);
		}
		if(play) {
			
		}
		if(gameOver) {
			
		}

	}
	
}
