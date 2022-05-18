package grid;

import java.awt.Color;
import java.awt.Point;
import java.awt.Rectangle;

//import screens.ScreenSwitcher;

/**
 * Menu Screen represents the loading screen/where you choose to play
 * @version 5/10/22
 * 
 * @author Joshua Lee & Jacob Tang
 *
 */

public class MenuScreen extends Screen{
	private DrawingSurface surface;
	private Rectangle helpButton;
	private Rectangle playButton;
	/*
	 * creates a menu screen that is used as introductory/starting screen
	 */
	public MenuScreen(DrawingSurface surface) {
		super(800,600);
		this.surface = surface;
		
		//helpButton = new Rectangle(800/2-100,600/2+50,200,100);
		playButton = new Rectangle(800/2-100,600/2-50,200,100);
	}
	
	public void draw() {
		surface.background(102,255,102);
		surface.rect(playButton.x, playButton.y, playButton.width, playButton.height, 10, 10, 10, 10);
		surface.fill(0);
		String str1 = "Play";
		float w = surface.textWidth(str1);
		surface.text(str1, playButton.x+playButton.width/2-w/2, playButton.y+playButton.height/2);
		
		surface.rect(helpButton.x, helpButton.y, helpButton.width, helpButton.height, 10, 10, 10, 10);
		surface.fill(0);
		String str2 = "Play";
		float x = surface.textWidth(str2);
		surface.text(str2, helpButton.x+helpButton.width/2-w/2, helpButton.y+helpButton.height/2);
		
		
	}
	
	public void mousePressed() {
		Point p = surface.actualCoordinatesToAssumed(new Point(surface.mouseX,surface.mouseY));
		if (playButton.contains(p))
			surface.switchScreen(ScreenSwitcher.GAME_SCREEN);
		if (helpButton.contains(p))
			System.out.println("Use wasd to move around, use space for superpower, and try to get away from the seeker");
	}
	
}
