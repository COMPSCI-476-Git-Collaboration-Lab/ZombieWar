package zombiewar;

import zombiewar.impl.CharacterFactory;
import zombiewar.intf.ICharacter;
import zombiewar.intf.ICharacterFactory;
import zombiewar.intf.ISurvivor;
import zombiewar.intf.IZombie;

/**
 *
 * @author thaoc
 */
public class Main {
  
  private static final ICharacterFactory factory = CharacterFactory.instance;
  
  public static IZombie[] randomZombies() {
    int numZombies = (int) (Math.random() * 10);
    IZombie[] zombies = new IZombie[numZombies];
    for (int i = 0; i < zombies.length; i++) {
      int zombieType = (int) (Math.random() * 2);
      switch(zombieType){
        case 0: zombies[i] = (IZombie) factory.make("common"); break;
        case 1: zombies[i] = (IZombie) factory.make("tank"); break;
        case 2: zombies[i] = (IZombie) factory.make("predator"); break;
      }
    }
    return zombies;
  }


//changing multiplication in here to modulus -K
  public static ISurvivor[] randomSurvivors() {
    int numZombies = (int) (Math.random() % 20);
    ISurvivor[] survivors = new ISurvivor[numZombies];
    for (int i = 0; i < survivors.length; i++) {
      int type = (int) (Math.random() % 3);
      switch(type){
        case 0: survivors[i] = (ISurvivor) factory.make("solider"); break;
        case 1: survivors[i] = (ISurvivor) factory.make("teacher"); break;
        case 2: survivors[i] = (ISurvivor) factory.make("student"); break;
        case 3: survivors[i] = (ISurvivor) factory.make("child"); break;
      }
    }
    return survivors;
  }

  public static boolean allDead(ICharacter[] characters){
    boolean allDead = true;
    for(int i=0; i<characters.length; i++){
      allDead &= !characters[i].isAlive();
    }
    return allDead;
  }

  /**
   * @param args the command line arguments
   */
  public static void main(String[] args) {

    IZombie[] zombies = randomZombies();
    ISurvivor[] survivors = randomSurvivors();

    System.out.println("We have " + survivors.length + " survivors trying to make it to safety.");
    System.out.println("But there are " + zombies.length + " zombies waiting for them.");
    
    //TODO: the survivors attack first.  One characte attack each zombie.
    //      When all the survivors have done attacking, it's the zombies' 
    //      turn to attack.  For each zombie that is still alive, attack
    //      each suvivor that is still alive.  Repeat this cycle until
    //      all the zombies are all dead or all the survivors are all dead.
    

//Begin attacking thingers -K

/* The idea here is that we loop through each survivor and assign a zombie
target for each one. We randomly pick a zombie by rolling the zombie
array until we find a living one or all the zombies are dead.

Do same for zombies. Hypothetically, we could make this its own function
as combat(attackers[], targets[]). 

 */
bool loopflag = 0;
int nexttarget = -1;
//int dead = 0; 

while (allDead(survivors) == 0 && allDead(zombies) == 0)
    {
	for (int k = 0; k < survivors.length; k++)
	{
	    loopflag = 0;
	    while ((loopflag == 0) && (allDead(zombies) == 0))
		{
		nexttarget = Math.random() % zombies.length;
		if (zombies[nexttarget].isAlive() == 1)
		    loopflag = 1;
		} //end zombie target assignment loop

	    //bust outta attacking if the zombeners got ded
	    if (allDead(zombies) == 0)
		break;

	    //Otherwise do glorious combat before Valhalla
		if (survivors[k].isAlive() == true)
		    survivors[k].attack(zombies[nexttarget]);
	}//End human combat

	for (int q = 0; q < zombies.length; q++)
	    { //begin zombie combat
	    loopflag = 0;
	    while ((loopflag == 0) && (allDead(survivors) == 0))
		{
		nexttarget = Math.random() % survivors.length;
		if (survivors[nexttarget].isAlive() == 1)
		    loopflag = 1;
		} //end human target assignment loop

	    //If the meat is sufficiently pulverized, done
	    if (allDead(survivors) == 0)
		break;

	    //Otherwise present the meats before the zombeners
		if (zombies[q].isAlive() == true)
		    zombies[q].attack(survivors[nexttarget]);
	}//End zombie combat
    }	


    if (allDead(survivors)) {
      System.out.println("None of the survivors made it.");
    } else {
      int count = 0;
      for(int i=0; i<survivors.length; i++) {
        if (survivors[i].isAlive()) count++;
      }
      System.out.println("It seems " + count + " have made it to safety.");
    }
  }

}
