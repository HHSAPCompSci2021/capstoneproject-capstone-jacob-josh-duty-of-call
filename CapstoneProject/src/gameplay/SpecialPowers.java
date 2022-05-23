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

	private String powerName;

	long lastAbility = 0;
	long cooldownTime = 30000;

	public SpecialPowers() {
		powerName = "";
	}

	public void cooldown() {
		long time = System.currentTimeMillis();
		if (time > lastAbility + cooldownTime) {
			hider.usePower();
			lastAbility = time;
		}
	}

	/*
	 * stuns seeker
	 */
	public void taserStun() {
		new java.util.Timer().schedule(new java.util.TimerTask() {
			@Override
			public void run() {
				seeker.move(0, 0);
			}
		}, 3000);

	}

	/*
	 * makes hider "invincible"
	 */
	public void invincible() {

		new java.util.Timer().schedule(new java.util.TimerTask() {
			@Override
			public void run() {
				if (hider.isTagged(seeker)) {
					hider.extraLife();
					// hider.isTagged(seeker) = false;
				}
			}
		}, 5000);

	}

	/*
	 * gives seeker faster movement speed
	 */
	public void speedBoost() {
		new java.util.Timer().schedule(new java.util.TimerTask() {
			@Override
			public void run() {
				hider.accelerate(2, 2);
			}
		}, 5000);

	}

	/*
	 * allows for hider to pass through walls
	 */
	public void wallPhase() {
		new java.util.Timer().schedule(new java.util.TimerTask() {
			@Override
			public void run() {
//		        		if (hider.intersects(obstacles)) {
//		        			hider.intersects(obstacles) = false;
//		        		}
			}
		}, 5000);

	}

//	public String choosePower() {
//		int i =  (int)((Math.random() * 3)+1);
//		
//			if (i == 1) {
//				powerName = "speed boost";
//				//return "speed boost
//			} else if (i == 2) {
//				powerName = "taser stun";
//			} else if (i == 3) {
//				powerName = "invincible";
//			}
//		
//		return powerName;
//	}
}
