package zombiewar.impl;

import zombiewar.intf.ISurvivor;
import zombiewar.intf.IZombie;

public class Teacher extends Character implements ISurvivor{

	public Teacher() {
		super(80);
		// TODO Auto-generated constructor stub
	}

	//@Override
	public void attack(IZombie zombie) {
		// TODO Auto-generated method stub
		zombie.decreaseHealth(8);
		
	}
}
