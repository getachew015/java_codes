package battleship;

import java.util.Random;




public class ShipBoard {

private int boardwidth;
private int boardlength;
private int shipnum;
int[][] battleboard;


public ShipBoard(int m, int n){
	
	//Constracter starts by setting the board size
	boardwidth=m;
	boardlength=n;
	int[][] board = new int[boardwidth][boardlength];
	battleboard=board;
	
	for (int i = 0; i < boardwidth; i++) {
		for (int j = 0; j < boardlength; j++) {
		battleboard[i][j]=-1;
		}
	} //for loop to fill the battle board with -1

}
public void setUpBattleBoard(){
	
	if (boardwidth<=20 || boardlength<=20)
		shipnum=1;
	else if ((boardwidth>=20 && boardwidth<=30) && (boardlength>=20 && boardlength<=30))
		shipnum=2;
	else if((boardwidth>=30 && boardwidth<=40) && (boardlength>=30 && boardlength<=40))
		shipnum=3;
	else if (boardwidth>=40 && boardlength>=40)
		shipnum=4;
	Random locY = new Random();
	Random locX = new Random();
	
	switch (shipnum) { //swith to decide number of ships on board
	
	case 1:
		//only one ship on the battle board
		System.out.println("There is one Enemy Ship on Board\nYou need to hit three Times to sink it");
		int loc1Y = locY.nextInt(boardlength-2);
		int loc = locX.nextInt(boardwidth-2);
		int[] loc1= {loc,++loc,++loc};
		
		for (int i : loc1) {
			if(loc1Y>loc)
			battleboard[i][loc1Y]=1; //place Ship horizontally
			else if(loc1Y<loc)
				battleboard[i][loc1Y]=1;
		}
		
		break;
	case 2://two ships on the battle board
		System.out.println("There are two Enemy Ships on Board\nYou need to hit three Times each to sink them");
			loc1Y=locY.nextInt(boardlength-2);
		int loc2Y=locY.nextInt(boardlength-2);
			if(loc1Y==loc2Y)
			loc2Y=locY.nextInt(boardlength-2);
			loc=locX.nextInt(boardwidth-2);
		int[] loc2={loc, ++loc, ++loc};
		for (int i : loc2) {
			
			battleboard[i][loc1Y]=1; //place 1st Ship vertically
			battleboard[loc2Y][i]=1; //place 2nd ship horizontally
		}
		
		break;
	case 3://three ships on the battle board
		System.out.println("There are three Enemy Ships on Board\nYou need to hit three Times each to sink them");
		loc1Y=locY.nextInt(boardlength-2);		
		loc2Y=locY.nextInt(boardlength-2);
			if(loc1Y==loc2Y)
			loc2Y=locY.nextInt(boardlength-2);
		int loc3Y=locY.nextInt(boardlength-2);
			if(loc3Y==loc1Y || loc3Y==loc2Y)
			loc3Y=locY.nextInt(boardlength-2);
		loc= locX.nextInt(boardwidth-2);
		int[] loc3={loc,++loc, ++loc};
		for (int i : loc3) { //fill ship location
			
			battleboard[i][loc1Y]=1; //place 1st Ship vertically
			battleboard[loc2Y][i]=1; //place 2nd ship horizontally
			battleboard[i][loc3Y]=1; //place 3rd ship vertically
		}
		
		break;
	case 4://four ships on the battle board
		System.out.println("There are four Enemy Ships on Board\nYou need to hit three Times each to sink them");
		loc1Y=locY.nextInt(boardlength-2);		
		loc2Y=locY.nextInt(boardlength-2);
		loc3Y=locY.nextInt(boardlength-2);
	int loc4Y= locY.nextInt(boardlength-2);
			if(loc1Y==loc2Y)
			loc2Y=locY.nextInt(boardlength-2);
			if(loc3Y==loc1Y || loc3Y==loc2Y)
			loc3Y=locY.nextInt(boardlength-2);
			if(loc4Y==loc1Y || loc4Y==loc2Y || loc4Y==loc3Y)
				loc4Y=locY.nextInt(boardlength-2);
		loc= locX.nextInt(boardwidth-2);
		int[] loc4={loc,++loc, ++loc};
		for(int i=0;i< loc4.length;i++){
			battleboard[loc4[i]][loc1Y]=1; //place 1st Ship vertically
			battleboard[loc2Y][loc4[i]]=1; //place 2nd ship horizontally
			battleboard[loc4[i]][loc3Y]=1; //place 3rd ship vertically
			battleboard[loc3Y][loc4[i]]=1; //place 3rd ship vertically
		}
		break;

	default:
		break;
	}
}//end of setup method
	
	public String checkGuess(int gsx, int gsy){
		
		String guess ="Miss"; //initialize guess to miss since highest probability is missing
		int count=0;
		String chky="", chkx="";
		 
		
		if(battleboard[gsx][gsy]==1){
			battleboard[gsx][gsy]=0;
			for (int a = 0; a < boardwidth; a++) {
				for (int b = 0; b < boardlength; b++) {
				
						if(battleboard[a][b]==1)
							
							count++; 
						}
				}//end of for loop
			
			
			
			if (count>0)
				guess="Hit";
			else
				guess="Sunk";
		}//end of if 
		else if(battleboard[gsx][gsy]==0){guess="Bullet Waste";}	
		else if(battleboard[gsx][gsy]==-1){
				battleboard[gsx][gsy]=0;
			for (int i = 0; i < boardwidth; i++) {
				for (int j = 0; j < boardlength; j++) {
					
					if(battleboard[i][j]==1){
						int[] xloc={i};
						int[] yloc={j};
						
						for (int k :xloc) {//Array for X coordinates of ship
							if((Math.abs(gsx-k)==1))
								chkx ="A";
							else if ((Math.abs(gsx-k)==2))
								chkx ="B";
							
							}//for loop for X coordinates of ship
						
						for (int l :yloc) {//array for Y coordinates of ship
							if((Math.abs(gsy-l)==1))
								chky ="A";
							else if ((Math.abs(gsy-l)==2))
								chky ="B";
							
							}//for loop for Y coordinates of ship
						
					}//if condition to hold X and Y coordinates 

				}
		 }//for loop to hold location of the ship in array
			
			//return guess result
			if (chkx=="A"||chky=="A")
				guess="Missed it, But it was Very Close";
			else if (chkx=="B" || chky=="B")
				guess="Missed it, But it was Close";
			else
				guess="Missed it !";
				
	
		
		}//else condition
					

		return guess;
					
	}//end of checkGuess method
		

	public String shipstatus(){
		String status = "Active";
	 for (int i = 0; i < battleboard.length; i++) {
		for (int j = 0; j < battleboard.length; j++) {
			
			if(battleboard[i][j]==1)				
			status="Active";
			else
			status="Sunk";
		}
	}//end of for
	 return status;
	}//end of shipstatus method
		
	public void shiploc(){ //method to print location of the ships

	 for (int i = 0; i < boardwidth; i++) {
		for (int j = 0; j < boardlength; j++) {
			
			if(battleboard[i][j]==1){

			System.out.println("Hint: " + i +"   " +j);
	
			}

		}

	}//end of for
	
	}//end of shiploc method
	
}
