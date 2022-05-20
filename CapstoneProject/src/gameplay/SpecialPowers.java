/**
 * Special powers represents the abilities the hiders have
 * @version 5/10/22
 * 
 * @author Joshua Lee & Jacob Tang
 *
 */
package gameplay;

public class SpecialPowers {
	/*
	 * creates special powers that hiders can access
	 */
	
	private Seeker seeker;
	private Hider hider;
	
	public SpecialPowers() {
		
	}
	
	/*
	 * stuns seeker
	 */
	public void taserStun() {
		seeker.move(0, 0);
	}
	
	/*
	 * makes hider "invincible"
	 */
	public void invincible() {
		
	}
	
	/*
	 * gives seeker faster movement speed
	 */
	public void speedBoost() {
		hider.accelerate(2, 2);
	}
	
	/*
	 * allows for hider to pass through walls
	 */
	public void wallPhase() {
		
	}
}
