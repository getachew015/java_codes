/* The Hanoi Towers program takes parameters Number of Discs , Startup and Destination locations
 * Checks if the values inserted are valid start and destination must be 1,2 or 3 
 * Number of discs should be greater than one
 * If Start and Destination are the same location there will be no movement
 */
package towerspackage;

import java.util.Scanner;

public class Towers {

	private int freeTower=0; //the free tower which will be used as a temporary storage during transfer
	
	public Towers(int n){
		// constructor method
		
	}
	
	public  void solve(int discs, int startTower, int destinationTower) {
		// accept three parameters the number of Discs to move the start and destination location
	if (discs<=0){
		/*This will stop The recursive call/execution of the solve method 
		 * when all the discs have completely moved to destination and returns to the method 
		*/		
		return;
		}
	//Check if Start and destination are valid and are separate location
		
	if (startTower==destinationTower)
    	System.out.println("No Moves Are Necessary");
	else if (startTower<=0 || startTower>3|| destinationTower<=0 || destinationTower>3)
		System.out.println("Invalid Start or Destination value: Start or Destination Value Must be between 1 and 3");
	else { 
		/*Assign the value of the free tower based on start and destination towers 
		 * so that it can be used as a temporary storage during transfer
		 */
	if ((startTower==1 && destinationTower==3) || (startTower==3 && destinationTower==1))
    	freeTower=2;
    if ((startTower==2 && destinationTower==3)||(startTower==3 && destinationTower==2))
    	freeTower=1;
    if ((startTower==1 && destinationTower==2) || (startTower==2 && destinationTower==1))
    	freeTower=3;
    
  /*Recursively move the upper Discs(discs-1) from the start to the free tower for temporary storage
   * Then  recursively move discs-1 from temporary tower to final destination
   *  and print out each move
   */
    	solve(discs-1, startTower, freeTower); //first recursion to move the top most (discs-1) to the free tower 
    	System.out.println("Moving Disc-" +discs+ " from tower " + startTower+ " to tower " +destinationTower); //print each move
    	solve(discs-1, startTower, destinationTower);//second recursion to finally move the (discs-1) to the destination tower
    	
	}
	
	}// End of Solve Method
	
	
	public static void main(String[] args)  {
		Towers hanoi= new Towers(1); //instance of Towers
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter number of Discs to move: ");
		int numofDiscs = sc.nextInt();
		System.out.print("Enter start up location Tower1 = 1, Tower2 = 2, Tower3 = 3: ");
		int startLoc = sc.nextInt();
		System.out.print("Enter Destination Tower1 = 1, Tower2 = 2, Tower3 = 3: ");
		int destinLoc = sc.nextInt();
		if (numofDiscs<=0||startLoc<0||startLoc>3||destinLoc<0||destinLoc>3){
			System.out.println("There is an Input Error \nNumber Of Discs should be greater than o \nStart and Destination locations should be between 1 and 3");
			
		}
		
		else {
		System.out.print("\nMoving The Discs ... \n");
		hanoi.solve(numofDiscs, startLoc, destinLoc);
		System.out.println("All the Discs Moved sucessfully");
		}
		sc.close();
	}
	
}//End of Class
