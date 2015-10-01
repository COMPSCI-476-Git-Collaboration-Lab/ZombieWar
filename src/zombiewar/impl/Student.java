package zombiewar.impl;


import zombiewar.intf.ISurvivor;
import zombiewar.intf.IZombie;

/**
 * A soldier is one of the strongest survivor because he wears armor 
 * and carries a weapon.
 * 
 * @author thaoc
 */
public class Student extends Character implements ISurvivor{

	/**
	 * A soldier starts with 100 points of health
	 */
	public Student() {
		super(60);
	}

	//@Override
	public void attack(IZombie zombie) {
		zombie.decreaseHealth(6);
	}
}