import java.io.*;
public class HumanPlayer implements Player{
//do not change the line above	
	
	//Define your fields here
	int IDofPlayer; 
	int numRows; 
	int numCols;
	int counter;
	int Humancount;
	int [][] checker;
	ChipColor chipcol; 
	//constructor takes the player id for this player, and the number of 
	// rows and columns of the board we're playing on
	public HumanPlayer(int playerID, int row, int col, ChipColor color){
		IDofPlayer = playerID; 
		numRows = row;
		numCols = col;
		Humancount = -1;
		checker = new int[row][col];
		chipcol = color;
		for(int i =0 ; i < checker.length; i++){
			for(int j = 0; j < checker[0].length; j++){
				checker[i][j] = 0;
			}
		}
		this.counter = 1;
	}
	 public int movecalc(int k){
		 int x = k;
		 for(int i = (checker.length - 1); i >= 0; i--){
			 if(checker[i][x] == 0){ 
				 return 1;
			 }
		 }
		 return -1;
	 }
	//used to notify your AI player of the other players last move
	public void lastMove(int c) {
		 for(int i = checker.length - 1; i >= 0; i--){
			 if(checker[i][c] == 0){
				 //System.out.println("COUNTER" + counter);
				 checker[i][c] = this.counter;
				 this.counter = this.counter + 1;
				 break;
			 }
		 }
		 for(int i = 0; i < checker.length; i++){
			 //System.out.println();
			 for(int j = 0; j < checker[0].length; j++){
				//System.out.print("[" + checker[i][j] +"]");
			 }
		 }
	}
	
	//returns column of where to play a token
	public int playToken(){
		int col = IO.readInt();
		
		while (col < 0 || col >= this.numCols) {	
			IO.reportBadInput(); 
			col = IO.readInt();
		}
		while(movecalc(col) == -1){
			IO.reportBadInput();
			col = IO.readInt();
		}
		for(int i = checker.length - 1; i >= 0; i--){
			if(checker[i][col] == 0){
				checker[i][col] = this.Humancount;
				this.Humancount = this.Humancount - 1;
				break;
			}
		}

		return col;
		
	}
	
	//get this player's id
	public int getPlayerID(){
		return this.IDofPlayer;
		
	}
		
	//resets the state of the player in preparation for a new game
	public void reset(){
		this.IDofPlayer = 0;
		this.numCols = 0;
		this.numRows = 0;
		this.counter = 0;
		this.Humancount = 0;
		for(int i =0 ; i < this.checker.length; i++){
			for(int j = 0; j < this.checker[0].length; j++){
				checker[i][j] = 0;
			}
		}
		
	}

	
}