package grid;


import java.awt.event.KeyEvent;

import gameplay.Hider;

import gameplay.Seeker;
import gameplay.SpecialPowers;
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
	private Hider hider;
	private Seeker seeker;
	private SpecialPowers power;
	
	private String powerName;

	private boolean play;
	private boolean start;
	private boolean gameOver;
	private boolean help;
	private boolean back;
	
	private long timer;
	private long timerStart;
	private String timerMessage;

	private PImage title;
	private PImage playButton;
	private PImage helpButton;
	private PImage howToPlay;
	private PImage backButton;
	private PImage picOfHider;
	private PImage playAgain;

	private Map map;

	/**
	 * Creates a new DrawingSurface and sets primitive data type fields to default values
	 */
	public DrawingSurface() {
		start = true;
		play = false;
		gameOver = false;
		help = false;
		back = false;
		timerMessage = "";

	}

	/**
	 * Loads images and instantiates hiders and seekers to be added on drawing surface in draw() method
	 */
	public void setup() {
		timerStart = System.currentTimeMillis();
		hider = new Hider(loadImage("img/hider.png"), 30, 70);
		seeker = new Seeker(loadImage("img/seeker.png"), width-60, height-70);
		title = loadImage("img/title.png");
		playButton = loadImage("img/playbutton.png");
		helpButton = loadImage("img/helpbutton.png");
		howToPlay = loadImage("img/howtoplay.png");
		backButton = loadImage("img/backbutton.png");
		picOfHider = loadImage("img/picofhider.png");
		playAgain = loadImage("img/playagain.png");
		map = new Map(this);
	}

	/**
	 * The statements in draw() are executed until the program is stopped. 
	 * Switches between screens and adds hiders and seekers to the map
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

			// pic of hider
			image(picOfHider, width / 2, height - height / 2, width / 2, height / 3);

		}
		
		//switches to screen with instructions
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

		//returns back to start screen if back button is clicked
		if (back) {
			start = true;
			help = false;
		}

		//switches to play screen if play now button is clicked
		if (play) {
			background(255);
			
			if (map != null) {
				map.draw(this);
				hider.draw(this);
				seeker.draw(this);
			}
			
			fill(0, 0, 0);
			textSize(15);
			textAlign(LEFT);
			text("POINTS: " + hider.getScore(), width / 40, height / 28);
			textAlign(RIGHT);
			text("SPECIAL POWER: " , width - width / 40, height / 28);
			
			if (hider.getX() >= 10 && hider.getX() <= width && hider.getY() >= 50 && hider.getY() <= height) {
				timer = 120 - (System.currentTimeMillis() - timerStart) / 1000;
			} else {
				timer = 120;
				timerStart = System.currentTimeMillis();
			}
			
			timerMessage = "TIME LEFT: " + timer + " seconds";
			
			
			text(timerMessage, (float)0.9*width, (float)0.95*height);
			
			
			if (hider.isTagged(seeker)) {
				if(hider.getLives() == 0) {
					gameOver = true;
					timer = 120;
					timerStart = System.currentTimeMillis();
					hider.x = 30;
					hider.y = 70;
					seeker.x = width - 70;
					seeker.y = height - 70;
					seeker.setScore(100);
				}
			} else if(timer == 0) {
				gameOver = true;
				timer = 120;
				timerStart = System.currentTimeMillis();
				hider.x = 30;
				hider.y = 70;
				seeker.x = width - 70;
				seeker.y = height - 70;
				hider.setScore(50);
			}
				
		}	
			
		//switches to game over screen when all lives are lost
		if (gameOver) {
			play = false;
			background(150);

			textAlign(CENTER);
			textSize(50);
			fill(240, 190, 15);
			text("GAME OVER", width / 2, height / 4);
			
			image(playAgain, width / 2, height / 2 + height / 3, width / 3, height / 7);
			
			if(seeker.getScore()>hider.getScore()) {
				fill(0);
				text("SEEKER WINS! SCORE = " + seeker.getScore(), width / 2, height / 3 + height / 5);
			}
			if(hider.getScore()>seeker.getScore()) {
				fill(0);
				text("HIDERS WIN! SCORE = " + hider.getScore(), width / 2, height / 3 + height / 5);
			}
			if(hider.getScore()==seeker.getScore()) {
				fill(0);
				text("There is a tie! Scores = " + hider.getScore(), width / 2, height / 3 + height / 5);
			}
		}
		
	}

	/**
	 * Moves hider and seeker when either WASD or arrow keys are pressed
	 * Hider uses special powers when space bar is pressed
	 */
	public void keyPressed() {
		//moves hider using arrow keys if game is on play screen
		if (play) {
//			if(map.withinBound(hider)==false) {
//				
////				hider.move(0,0);
//				System.out.println("hit boundary");
//				
//			}
//			if (keyCode == KeyEvent.VK_SPACE && hider.getY()<=height-70 && hider.getY()>=62 && hider.getX() >=20 && hider.getX() <= width-50) {
//				hider.usePower();
//			} else if (keyCode == KeyEvent.VK_DOWN && hider.getY()<height-70 && map.isNextValid(hider.getX(), hider.getY()+10) == true) {
//				hider.move(0, 10);
//				hider.setDirection(180);
//			} else if (keyCode == KeyEvent.VK_UP && hider.getY()>62 && map.isNextValid(hider.getX(), hider.getY()-10) == true) {
//				hider.move(0, -10);
//				hider.setDirection(0);
//			} else if (keyCode == KeyEvent.VK_LEFT && hider.getX() >20 && map.isNextValid(hider.getX()-10, hider.getY()) == true) {
//				hider.move(-10, 0);
//				hider.setDirection(270);
//			} else if (keyCode == KeyEvent.VK_RIGHT && hider.getX() < width-50 && map.isNextValid(hider.getX()+10, hider.getY()) == true) {
//				hider.move(10, 0);
//				hider.setDirection(90);
//			} else if (keyCode == KeyEvent.VK_S && seeker.getY()<height-69 && map.isNextValid(seeker.getX(), seeker.getY()+10) == true) {
//				seeker.move(0, 10);
//				seeker.setDirection(180);
//			} else if (keyCode == KeyEvent.VK_W && seeker.getY()>60 && map.isNextValid(seeker.getX(), seeker.getY()-10) == true ) {
//				seeker.move(0, -10);
//				seeker.setDirection(0);
//			} else if (keyCode == KeyEvent.VK_A && seeker.getX() >20 && map.isNextValid(seeker.getX()-10, seeker.getY()) == true) {
//				seeker.move(-10, 0);
//				seeker.setDirection(270);
//			} else if (keyCode == KeyEvent.VK_D && seeker.getX() < width-60 && map.isNextValid(seeker.getX()+10, seeker.getY()) == true) {
//				seeker.move(10, 0);
//				seeker.setDirection(90);
//			}
			
			if (keyCode == KeyEvent.VK_SPACE && map.inBounds(hider.getX(), hider.getY()) == true) {
				hider.usePower();
			} else if (keyCode == KeyEvent.VK_DOWN && map.inBounds(hider.getX(), hider.nextY(10)) == true && map.isNextValid(hider.getX(), hider.nextY(10)) == true) {
				hider.move(0, 10);
				hider.setDirection(180);
			} else if (keyCode == KeyEvent.VK_UP && map.inBounds(hider.getX(), hider.nextY(-10)) == true && map.isNextValid(hider.getX(), hider.nextY(-10)) == true) {
				hider.move(0, -10);
				hider.setDirection(0);
			} else if (keyCode == KeyEvent.VK_LEFT && map.inBounds(hider.nextX(-10), hider.getY()) == true && map.isNextValid(hider.nextX(-10), hider.getY()) == true) {
				hider.move(-10, 0);
				hider.setDirection(270);
			} else if (keyCode == KeyEvent.VK_RIGHT && map.inBounds(hider.nextX(10), hider.getY()) == true && map.isNextValid(hider.nextX(10), hider.getY()) == true) {
				hider.move(10, 0);
				hider.setDirection(90);
			} else if (keyCode == KeyEvent.VK_S && map.inBounds(seeker.getX(), seeker.getY()+10) == true && map.isNextValid(seeker.getX(), seeker.getY()+10) == true) {
				seeker.move(0, 10);
				seeker.setDirection(180);
			} else if (keyCode == KeyEvent.VK_W && map.inBounds(seeker.getX(), seeker.getY()-10) == true && map.isNextValid(seeker.getX(), seeker.getY()-10) == true ) {
				seeker.move(0, -10);
				seeker.setDirection(0);
			} else if (keyCode == KeyEvent.VK_A && map.inBounds(seeker.getX()-10, seeker.getY()) == true && map.isNextValid(seeker.getX()-10, seeker.getY()) == true) {
				seeker.move(-10, 0);
				seeker.setDirection(270);
			} else if (keyCode == KeyEvent.VK_D && map.inBounds(seeker.getX()+10, seeker.getY()) == true && map.isNextValid(seeker.getX()+10, seeker.getY()) == true) {
				seeker.move(10, 0);
				seeker.setDirection(90);
			}
		}
	}

	/**
	 * Switches between screens when mouse is pressed on buttons
	 */
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
				start = false;

			}
			
		}
		// return back to main screen
		if (help) {
			if (mouseX > width/70 && mouseX < width/9 && mouseY > height/22 && mouseY < height/7) {
				help = false;
				start = true;	
			}
		}
		
		// play again button
		if(gameOver) {
			if(mouseX > width/2 - width/3 && mouseX < width/2 + width/3 && mouseY > height/2 + height/3 - height/7 && mouseY < height/2 + height/3 + height/7){
				gameOver = false;
				start = true;
				
			}
		}

	}


}
