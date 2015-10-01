package zombiewar.impl;

import zombiewar.intf.ISurvivor;
import zombiewar.intf.IZombie;

/**
 *Initially copied from tank template
 *
 * Predator gon' do 1.5x damage but have Zombie health.
 * 
 * @author thaoc
 */
public class Predator extends Character implements IZombie{

	/**
	 * A tank starts with 150 points of health
	 */
	public Predator() {
		super(50);
	}

	/**
	 * An attack from the tank decrease a survivor's health by 20 points.
	 * @param survivor 
	 */
	//@Override
	public void attack(ISurvivor survivor) {
	    survivor.decreaseHealth(10)
	}
	
}
