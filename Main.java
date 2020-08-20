/******************************************************************************

                            Online Java Compiler.
                Code, Compile, Run and Debug java program online.
Write your code in this editor and press "Run" button to execute it.

*******************************************************************************/
import java.util.Scanner;
import java.util.Random;

public class Main
{
	public static void main(String[] args) {
	    
	    Scanner reader = new Scanner(System.in);

    	int sticks = (int)(Math.random()*10) + 21;
    	System.out.println("There are " + sticks + " sticks.");
    	System.out.println("Enter 1 to go first, Enter 2 to go second.");
    	boolean turn; //true means player turn, false means computer turn
    	
    	if(reader.nextInt() == 1)
    	    turn = true;
	    else   
	        turn = false;
	        
	    //game stops when we get 0 sticks
	    //so the game must continue as long as number of sticks > 0
	    
	    while(sticks > 0) {
	        if (turn)
	            sticks = playerMove(sticks, reader);
	            
            if (!turn)
                sticks = computerMove(sticks);
   
            System.out.println("\nThere are " + sticks + " sticks left.");
            
            if (sticks == 0 && turn)
                System.out.println("\nYou win!\n");
            if (sticks == 0 && !turn)
                System.out.println("\nThe computer wins!");
	        
	        turn = !turn;
	    }
	}
	
	//this method must return an integer value
	public static int playerMove(int sticks, Scanner reader) {
	    System.out.println("\nSelect how many sticks to take");
	    int take = reader.nextInt();
	    if (take < 1)
	        take = 1;
	    if (take > 3)
	        take = 3;
	    if (take < 4 && take > sticks)
	        take = sticks;
	    System.out.println("\nYou took " + take + " sticks.");
	    
	    sticks = sticks - take;
	    return sticks; //how many left over
	}
	
	public static int computerMove(int sticks) {
	    int take;
	    if (sticks % 4 != 0)
	        take = sticks % 4;
        else    
            take = (int)(3*Math.random()) + 1;
        System.out.println("\nThe compputer took " + take + " sticks.");
        
        sticks = sticks - take;
        return sticks;
	}
}
