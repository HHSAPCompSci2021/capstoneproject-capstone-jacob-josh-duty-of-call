package grid;

import java.awt.Point;
import java.awt.event.KeyEvent;
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
			background(255);
			
			if(map != null) {
				map.draw(this, 0, 0, width/3, height);
			}
			
			textSize(10);
			textAlign(LEFT);
			text("POINTS: " + hider.getScore(), width/40, height/28);
			
			textAlign(RIGHT);
			text("SPECIAL POWER: "+ hider.getPowers(), width - width/40, height/28);
			
			
			if(hider.isTagged(seeker)) {
				hider.loseLife();
				gameOver=true;
			}
		}
		if(gameOver) {
			start = true;
			play = false;
		}

	}
	public void keyPressed() {
		if (keyCode == KeyEvent.VK_SPACE) {
			hider.usePower();
		}else if (keyCode == KeyEvent.VK_DOWN) {
			hider.move(0, 1);
		} else if (keyCode == KeyEvent.VK_UP) {
			hider.move(0, -1);
		} else if (keyCode == KeyEvent.VK_LEFT) {
			hider.move(-1,0);
		} else if (keyCode == KeyEvent.VK_RIGHT) {
			hider.move(1, 0);
		}
	}	
}
