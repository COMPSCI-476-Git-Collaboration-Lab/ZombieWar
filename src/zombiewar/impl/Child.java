/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zombiewar.impl;

import zombiewar.intf.ISurvivor;
import zombiewar.intf.IZombie;

/**
 *
 *  a child is pure trash
 * 
 * @author thaoc
 */
public class Child extends Character implements ISurvivor{

	/**
	 * A soldier starts with 100 points of health
	 */
	public Child() {
		super(1);
	}

	//@Override
	public void attack(IZombie zombie) {
		zombie.decreaseHealth(-1);
	}
}