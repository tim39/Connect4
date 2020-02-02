

public class AIPlayer implements Player{
//do not change the line above	
	
	//Define your fields here
	int IDofPlayer; 
	int numRows; 
	int numCols;
	int counter;
	int AIcount;
	int [][] checker;

	//constructor takes the player id for this player, and the number of 
	// rows and columns of the board we're playing on
	public AIPlayer(int playerID, int row, int col){
		IDofPlayer = playerID; 
		numRows = row;
		numCols = col;
		AIcount = -1;
		checker = new int[row][col];
		for(int i =0 ; i < checker.length; i++){
			for(int j = 0; j < checker[0].length; j++){
				checker[i][j] = 0;
			}
		}
		this.counter = 1;
	}
	
	 public int movecalc(int k){
		 int x = k;
		 //System.out.println(checker[0].length);
		 for(int i = (checker.length - 1); i >= 0; i--){
			 if(checker[i][x] == 0){ 
				 return 1;
			 }
		 }
		 return -1;
	 }
	 
	 public int isalmostFinished() {
			for(int r = checker.length - 1; r >= 0 ; r--) {
				for(int c = 0; c < checker[0].length - 3; c++) {
					if(checker[r][c] > 0 && checker[r][c+1] >0
							&& checker[r][c+2]>0 ) {
						if(checker[r][c+3] == 0){
                    		//System.out.println("HORIZ");
						return c+3;
						}
					}
				}
			}	
			for (int c = 0; c < checker[0].length; c++) {
				for (int r = checker.length -1 ; r > 2; r--) {
					//System.out.println("R" + r + " C" + c);
					if(checker[r][c]>0 && checker[r-1][c]>0 && checker[r-2][c]>0 )
					{
						if(checker[r-3][c] == 0){
                    		//System.out.println("VERT");
							return c;
							}
					}
				}
			}
		    for (int row = checker.length - 1; row >= 0; row--) {
		        for (int col = 0; col < checker[0].length - 3; col++) {

		            if (checker[row][col]>0) {
		                if (!(((row - 1) < 0) || ((col + 1) > checker[0].length - 1))) {
		                    if (checker[row-1][col+1]>0) {
		                        if (!(((row - 2) < 0) || ((col + 2) > checker[0].length - 1))) {
		                            if (checker[row-2][col+2]>0) {
		                                    if (checker[row-3][col+3]==0) 
		                                    {
	                                    		//System.out.println("DIAGR");
		                                    	return col+3;
		                                    }
		                            }
		                        }
		                    }
		                }
		            }
		            if (checker[row][col]>0) {
		                if (!(((row - 1) < 0) || ((col - 1) < 0))) {
		                    if (checker[row-1][col-1]>0) {
		                        if (!(((row - 2) < 0) || ((col - 2)) < 0)) {
		                            if (checker[row-2][col-2]>0) {
		                                    if (checker[row-3][col-3]>0)
		                                    {
		                                    		//System.out.println("DIAG");
			                    						return col-3;
		                                    }
		                            }
		                        }
		                    }
		                }
		            }
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
				// System.out.print("[" + checker[i][j] +"]");
			 }
		 }

	}
	
	//returns column of where to play a token
	public int playToken(){
		int col = (int)(Math.random() * this.numCols);
		
		while (col < 0 || col > this.numCols) {		
			col = (int)(Math.random() * this.numCols);
			}
		while(movecalc(col) == -1){
			col = (int)(Math.random() * this.numCols);
		}
		if(isalmostFinished() != -1){
			col = isalmostFinished();
		}
		for(int i = checker.length - 1; i >= 0; i--){
			if(checker[i][col] == 0){
				checker[i][col] = this.AIcount;
				this.AIcount = this.AIcount - 1;
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
		for(int i =0 ; i < this.checker.length; i++){
			for(int j = 0; j < this.checker[0].length; j++){
				checker[i][j] = 0;
			}
		}
	}
}