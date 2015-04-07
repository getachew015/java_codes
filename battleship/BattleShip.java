package battleship;

import java.util.Scanner;


@SuppressWarnings("resource")
public class BattleShip {

	
	public static void main(String[] args){
		int numofguess = 0;
		boolean ship = true;
		
				
		Scanner input = new Scanner(System.in);
		System.out.println("You are Prompted to define the size of the Play Board: \nMinimum size is 3x3");
		System.out.print("Enter the Width of the Board:- ");
		 int bwid = input.nextInt();
		 while(bwid<3){
				System.out.print("Minimum size is 3 Enter the Width of the Board:- ");
		 		bwid = input.nextInt();	}
		 System.out.print("Enter the Length of The Board:- ");
		 int blen= input.nextInt();
		 while(blen<3){
			 System.out.print("Minimum size is 3 Enter the Length of The Board:- ");
			 blen= input.nextInt();
		 }
		 ShipBoard battle = new ShipBoard(bwid,blen);
		 		battle.setUpBattleBoard();
		
		// An option for test to print location of the ships
		 	System.out.print("Enter 911 to get the Answer:- ");
			  blen= input.nextInt();		
			  if(blen==911){
		 		 System.out.println("Answer ");
				 battle.shiploc();}
		 		
		while(ship){
			
			System.out.print("Enter the X Cordinate: ");
			 int xcor = input.nextInt();
			 while(xcor>bwid){
				 System.out.print("Guesses must be in a range 0 and Board width ["+bwid+ "] Enter the X Cordinate: ");
				 	xcor = input.nextInt(); 
			 }
			 System.out.print("Enter the Y Cordinate: ");
			 int ycor= input.nextInt();
			 while(ycor>blen || ycor<0){
				 System.out.print("Guesses must be in a range 0 and Board length= ["+blen+"] Enter the Y Cordinate: ");
				 ycor= input.nextInt();
			 }
			 String status=(battle.checkGuess(xcor, ycor));
			
			 //print score
			 System.out.println("Score * * * * * * * * * * * * * * * * * *");
			 System.out.println(status);
				if(status.equals("Bullet Waste"))	{
					numofguess+=2;	
					
					System.out.println("Shots So far: "+numofguess);
					System.out.println("You Tried This Spot Before: ");
					System.out.println("* * * * * * * * * * * * * * * * * * * * *");}
				else if(status.equals("Hit")){
					numofguess++;	
//					System.out.println("Score * * * * * * * * * * * * * * * * * *");
					System.out.println("Shots So far: "+numofguess);
					System.out.println("* * * * * * * * * * * * * * * * * * * * *");
					}
				if((status.equals("Missed it, But it was Very Close"))||(status.equals("Missed it, But it was Close"))||(status.equals("Missed it !")))	{
					numofguess++;	
//					System.out.println("Score * * * * * * * * * * * * * * * * * *");
					System.out.println("Shots So far: "+numofguess);
					System.out.println("A New Spot Shot: ");
					System.out.println("* * * * * * * * * * * * * * * * * * * * *");}
				else if(status.equals("Sunk")){
						numofguess++;
						ship=false;}
		}//End of while loop
			System.out.println("* * * * * * * Congradulation You Won ! * * * * * * * * *");
			System.out.println("\n\tIt took you [" +numofguess+ "] Shots to sink the ship: " );
			System.out.println("\n* * * * * * * * * *  * * * * * * * * * * * * * * * * * *");
	}//end of main
	
}//end of BattleshipTest class
