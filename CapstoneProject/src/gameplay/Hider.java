/**
 * Hider represents hider in the game
 * @version 5/10/22
 * 
 * @author Joshua Lee & Jacob Tang
 *
 */
package gameplay;

import java.util.ArrayList;

import processing.core.PImage;

/**
 * 
 * Instantiates a hider that inherits the qualities of a Sprite
 *
 */
public class Hider extends Sprite {
	
	public static final int HIDER_WIDTH = 30;
	public static final int HIDER_HEIGHT = 30;
	
	private ArrayList<String> powers;
	
	private boolean speedBoost;
	private boolean wallPhase;
	private boolean taserStun;
	private boolean invisibility;
	
	private double xVel;
	private double yVel;
	
	public Hider(PImage img, int x, int y) {
		super(img, x, y, HIDER_WIDTH, HIDER_HEIGHT);
		
		
	}

/**
 * Overrides the move method and describes how the hider moves
 * 
 */
	public void move(int dirX, int dirY) {
		if (dirX == 1) {
			x+=1.5;
		}
		if (dirX == -1) {
			x-=1.5;
		}
		if (dirY == 1) {
			y+=1.5;
		}
		if (dirY == -1) {
			y-=1.5;
		}
	}
	
	public void usePowers() {
		powers.add(1, "speedboost");
		powers.add(2, "taserstun");
		powers.add(3, "wallphase");
		powers.add(4, "invisibility");
		
		int i = (int)(Math.random()*powers.size());
		if(powers.get(i) == "speedboost") {
			speedBoost = true;
			powers.remove(i);
				
		}
		if(powers.get(i) == "taserstun") {
			taserStun = true;
			powers.remove(i);
			
		}
		if(powers.get(i) == "wallphase") {
			wallPhase = true;
			powers.remove(i);
		}
		if(powers.get(i) == "invisibility") {
			invisibility = true;
			powers.remove(i);
		}
		
	}
	
	public void act() {
		if(speedBoost) {
			xVel+=2;
			yVel+=2;
			
			x+=xVel;
			y+=yVel;
		}
		if(taserStun) {
			
		}
		if(wallPhase) {
			
		}
		if(invisibility) {
			
		}
		
		
	}
}
