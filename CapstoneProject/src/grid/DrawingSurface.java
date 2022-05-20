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
 * 
 * @version 5/10/22
 * 
 * @author Joshua Lee & Jacob Tang
 *
 */

public class DrawingSurface extends PApplet {

	// private Sprite sprite;
	private ArrayList<Hider> hiders;
	private Hider hider;
	private Seeker seeker;

	private boolean play;
	private boolean start;
	private boolean gameOver;
	private boolean help;
	private boolean back;

	private PImage title;
	private PImage playButton;
	private PImage helpButton;
	private PImage howToPlay;
	private PImage backButton;
	private PImage picOfHider;

	private Map map;

	/**
	 * creates a surface to be drawn on and extends PApplet
	 */
	public DrawingSurface() {
		start = true;
		play = false;
		gameOver = false;
		help = false;
		back = false;
		hiders = new ArrayList<Hider>();
		// map = new Map(map.txt);

	}

	/**
	 * set up function that sets up the drawingsurface
	 */
	public void setup() {
		hider = new Hider(loadImage("img/hider.png"), 60, 420);
		seeker = new Seeker(loadImage("img/seeker.png"), 65, 360);
		title = loadImage("img/title.png");
		playButton = loadImage("img/playbutton.png");
		helpButton = loadImage("img/helpbutton.png");
		howToPlay = loadImage("img/howtoplay.png");
		backButton = loadImage("img/backbutton.png");
		picOfHider = loadImage("img/picofhider.png");
		map = new Map();
	}

	/**
	 * draws the program when it is executed
	 */
	public void draw() {
		imageMode(CENTER);

		if (start) {
			// sets title screen color and uploads title
			background(255);
			image(title, width / 2, height / 8, width, height / 3);

			// play button
			image(playButton, width / 2, height - height / 8, width / 4, height / 5);
			// help button
			image(helpButton, width - width / 10, height - height / 10, width / 10, height / 10);

			hider = new Hider(loadImage("img/hider.png"), 45, 45);
//			seeker = new Seeker(loadImage("img/seeker.png"), 0, 0);

			// pic of hider
			image(picOfHider, width / 2, height - height / 2, width / 2, height / 3);

		}

		if (help) {
			background(0);

			image(howToPlay, width / 2, height / 8, width / 3, height / 9);
			image(backButton, 50, 50, width / 10, height / 10);

			textSize(20);
			textAlign(LEFT);
			text("- As a seeker, the objective of the game is to tag all the hiders.\n- The objective of the hiders is to avoid getting tagged until the 5 minute\ntimer is up.\n- Each hider receives one superpower that can be used multiple times\nper game, but has a cooldown after every use.",
					20, height / 4);
			text("\n\n\n\n\n- Use the WASD keys to move around.\n- Press space bar to use special powers\n- If tagged, hider will return to a game over screen which will serve as a\nwaiting room until the next game can be played.",
					20, height / 4);
		}

		if (back) {
			start = true;
			help = false;

		}

		if (play) {
			background(0);

			if (map != null) {
				map.draw(this);
			}

			textSize(10);

			if (play) {
				background(255);

				if (map != null) {
					map.draw(this);
					hider.draw(this);
				}

				fill(0, 0, 0);
				textSize(15);
				textAlign(LEFT);
				text("POINTS: " + hider.getScore(), width / 40, height / 28);

				textAlign(RIGHT);
				text("SPECIAL POWER: " + hider.getPowers(), width - width / 40, height / 28);

				if (hider.isTagged(seeker)) {
					hider.loseLife();
					hiders.remove(hider);
					gameOver = true;
				}
			}	
			if (gameOver) {
				background(0);

				textAlign(CENTER);
				textSize(50);
				text("GAME OVER", width / 2, height / 2);
			}
		}

	}

	public void keyPressed() {
		if (play) {
			if (keyCode == KeyEvent.VK_SPACE) {
				hider.usePower();
			} else if (keyCode == KeyEvent.VK_DOWN) {
				hider.move(0, 1);
			} else if (keyCode == KeyEvent.VK_UP) {
				hider.move(0, -1);
			} else if (keyCode == KeyEvent.VK_LEFT) {
				hider.move(-1, 0);
			} else if (keyCode == KeyEvent.VK_RIGHT) {
				hider.move(1, 0);
			}
		}
	}

	public void mousePressed() {
		if (start) {
			// play screen
			if (mouseX > width / 2 - width / 8 && mouseX < width / 2 + width / 8
					&& mouseY > height - height / 8 - height / 10 && mouseY < height - height / 8 + height / 9) {
				start = false;
				play = true;
			}
			// help screen
			if (mouseX > width - width / 13 - width / 13 && mouseX < width - width / 20
					&& mouseY > height - height / 13 - height / 13 && mouseY < height - height / 21) {
				help = true;

			}
			if (help) {
				if (mouseX > width/70 && mouseX < width/9 && mouseY > height/22
						&& mouseY < height/7) {
					help = false;
					start = true;
				}
			} else {

			}
		}

		// back to menu screen
//		

	}

}
