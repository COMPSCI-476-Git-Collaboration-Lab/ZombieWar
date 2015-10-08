package zombiewar.impl;


import zombiewar.intf.ISurvivor;
import zombiewar.intf.IZombie;

/**
 * 
 * 
 * A student is almost worthless but not quite yet
 * 
 * @author Sam
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