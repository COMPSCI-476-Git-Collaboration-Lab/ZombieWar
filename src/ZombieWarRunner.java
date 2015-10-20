import java.util.Random;
import zombiewar.impl.*;
//import zombiewar.intf.*;
import zombiewar.impl.Character;

public class ZombieWarRunner {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		
		Random randomNum = new Random();//implemented a thing -Sam
		Character[] arrayOfThings= new Character[20]; 
		for (int i=0; i<arrayOfThings.length;i++){
		    int generatedNumber = randomNum.nextInt(13);//might need to be re worked to make it more fair later
		    
		    switch (generatedNumber){
		    
		    //case 12: arrayOfThings[i] = new zombie();
		    
		    //case 11:arrayOfThings[i] = new zombie();
		    
		    case 10: arrayOfThings[i] = new Child(); break;
		    
		    case 9: arrayOfThings[i] = new Student(); break;
		    
		    //case 8: arrayOfThings[i] = new zombie(); break;  //standard zombies don't exist i noticed...
		    
		    case 7: arrayOfThings[i] = new Student(); break;
		    
		    case 6: arrayOfThings[i] = new Predator(); break;
		    
		    case 5: arrayOfThings[i] = new Student(); break;
		    
		    case 4: arrayOfThings[i] = new Teacher(); break;
		    
		    case 3: arrayOfThings[i] = new Predator(); break;
		    
		    case 2: arrayOfThings[i]= new Teacher(); break;
		    
		    case 1: arrayOfThings[i]=new Tank(); break;
		    
		    case 0: arrayOfThings[i]=new Soldier(); break;
		    
		   	default: arrayOfThings[i] = new Child();break;
		    
		    }
		       
		    
		}
		
	}
}
