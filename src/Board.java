import java.io.*;
public class Board {
	char [][]gameboard;
	char PlayerOne;
	char PlayerTwo;
	public Board () {
		gameboard = new char [6][7];
		for (int i = 0; i < gameboard.length; i++){
			for (int j = 0; j < gameboard[i].length; j++){
				gameboard[i][j] =' '; 
			}
		}
	}
	public Board(int row, int col) {
		gameboard = new char [row][col];
		for (int i = 0; i < gameboard.length; i++){
			for (int j = 0; j < gameboard[i].length; j++){
				gameboard[i][j] =' '; 
				}
			}
	} //creates a board of size row x col
	public int getNumRows() {
		return gameboard.length;
	} //returns the number of rows in board 
	public int getNumCols() {
		return gameboard[0].length;
	} //returns the number of cols in board 
	public char getPlayerOne() {
		return PlayerOne;
	} //returns char representing player 1 
	public char getPlayerTwo() {
		return PlayerTwo;
	} //returns char representing player 2 
	public void setPlayerOne(char o) {
		PlayerOne=o;
	} //sets char representing player 1 
	public void setPlayerTwo(char t) {
		PlayerTwo=t;
	} //sets char representing player 2 
	public char getToken(int row, int col) {
		if ((row < 0 || row>=gameboard.length) || (col < 0 || col >= gameboard[0].length )) {
			return '\0';
			}
		else
		return gameboard[row][col];
	} //returns the char representing token at location row,col, returns '\0' if indices are invalid 
	public boolean canPlay() {
		
		for (int i = 0; i < gameboard.length; i++)
		{ for (int j = 0; j < gameboard[i].length; j++)
			{ if (gameboard[i][j] == ' ')
		return true;}
		}
		return false;
	} //returns true if a token is still able to placed onto the board, false otherwise 

	public boolean play(int p, int c) {
		if(p != 1 && p!= 2){
			return false;
		}
		if(c < 0 || c >= gameboard[0].length){
			return false;
		}
		for (int i = gameboard.length-1; i >= 0; i--) {
		if (gameboard[i][c] == ' ') {
			if(p==1) {
				gameboard[i][c] = getPlayerOne();
				return true;
			} else if (p==2) {
				gameboard[i][c] = getPlayerTwo();
				return true; } 
			} 
		}
		return false;}
	 //places the appropriate token for player p in column c. returns true if successful, false otherwise. 

	public int isFinished() {
		for(int r = 0; r < gameboard.length; r++) {
			for(int c = 0; c < gameboard[0].length - 3; c++) {
				if(gameboard[r][c]==getPlayerOne() && gameboard[r][c+1]==getPlayerOne()
						&& gameboard[r][c+2]==getPlayerOne() &&  gameboard[r][c+3]==getPlayerOne()) {

					return 1;
			}
				else
				{
					if(gameboard[r][c]==getPlayerTwo() && gameboard[r][c+1]==getPlayerTwo()
							&& gameboard[r][c+2]==getPlayerTwo() &&  gameboard[r][c+3]==getPlayerTwo())
					{
						return 2;
					}
				}
			}
		}	
		for (int c = 0; c < gameboard[0].length; c++) {
			for (int r = 0; r < gameboard.length - 3; r++) {
				if(gameboard[r][c]==getPlayerOne() && gameboard[r+1][c]==getPlayerOne() && gameboard[r+2][c]==getPlayerOne() 
						&& gameboard[r+3][c]==getPlayerOne() )
				{
					
					return 1;
				}
				else
				{
					if(gameboard[r][c]==getPlayerTwo() && gameboard[r+1][c]==getPlayerTwo() && gameboard[r+2][c]==getPlayerTwo() 
							&& gameboard[r+3][c]==getPlayerTwo() ) {
						
						return 2;
					}
				}
			}
		}
	    for (int row = gameboard.length - 1; row > 0; row--) {
	        for (int col = 0; col < gameboard[0].length - 1; col++) {

	            if (gameboard[row][col]==getPlayerOne()) {
	                if (!(((row - 1) < 0) || ((col + 1) > gameboard[0].length - 1))) {
	                    if (gameboard[row-1][col+1]==getPlayerOne()) {
	                        if (!(((row - 2) < 0) || ((col + 2) > gameboard[0].length - 1))) {
	                            if (gameboard[row-2][col+2]==getPlayerOne()) {
	                                if (!(((row - 3) < 0) || ((col + 3) > gameboard[0].length - 1))) {
	                                    if (gameboard[row-3][col+3]==getPlayerOne()) 
	                                    {
	                                    	
	                    					return 1;
	                                    }
	                                }
	                            }
	                        }
	                    }
	                }
	            }
	            if (gameboard[row][col]==getPlayerOne()) {
	                if (!(((row - 1) < 0) || ((col - 1) < 0))) {
	                    if (gameboard[row-1][col-1]==getPlayerOne()) {
	                        if (!(((row - 2) < 0) || ((col - 2)) < 0)) {
	                            if (gameboard[row-2][col-2]==getPlayerOne()) {
	                                if (!(((row - 3) < 0) || ((col - 3) < 0))) {
	                                    if (gameboard[row-3][col-3]==getPlayerOne())
	                                    {
	                                    	
	                    					return 1;
	                                    }
	                                }
	                            }
	                        }
	                    }
	                }
	            }
	            if (gameboard[row][col]==getPlayerTwo()) {
	                if (!(((row - 1) < 0) || ((col + 1) > gameboard[0].length - 1))) {
	                    if (gameboard[row-1][col+1]==getPlayerTwo()) {
	                        if (!(((row - 2) < 0) || ((col + 2) > gameboard[0].length - 1))) {
	                            if (gameboard[row-2][col+2]==getPlayerTwo()) {
	                                if (!(((row - 3) < 0) || ((col + 3) > gameboard[0].length - 1))) {
	                                    if (gameboard[row-3][col+3]==getPlayerTwo()) 
	                                    {
	                                    	
	                						return 2;
	                                    }
	                                }
	                            }
	                        }
	                    }
	                }
	            }
	            if (gameboard[row][col]==getPlayerTwo()) {
	                if (!(((row - 1) < 0) || ((col - 1) < 0))) {
	                    if (gameboard[row-1][col-1]==getPlayerTwo()) {
	                        if (!(((row - 2) < 0) || ((col - 2)) < 0)) {
	                            if (gameboard[row-2][col-2]==getPlayerTwo()) {
	                                if (!(((row - 3) < 0) || ((col - 3) < 0))) {
	                                    if (gameboard[row-3][col-3]==getPlayerTwo()) 
	                                    {
	                                    	
	                						return 2;
	                                    }
	                                }
	                            }
	                        }
	                    }
	                }
	            }
	        }
	    } if(!canPlay())
		{
			
			return 0;
		}
		else
			return -1;
	}
	
	public String toString(){
		String connectFourBoard = "";
		for(int i = 0; i < gameboard.length; i++){
			connectFourBoard = connectFourBoard + "\n";
			for(int j =0; j < gameboard[0].length; j++){
				connectFourBoard = connectFourBoard + "(";
				if(gameboard[i][j] == 0){
					connectFourBoard = connectFourBoard + " ";
				}else{
					connectFourBoard = connectFourBoard + gameboard[i][j];
				}
				connectFourBoard = connectFourBoard + ")";
			}
			
		}
		
		return connectFourBoard;
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Board Connect4= new Board();
		System.out.println(Connect4.toString());
		Connect4.setPlayerOne('o');
		Connect4.setPlayerTwo('t');
		int playerSwitch = 1;
		while(Connect4.isFinished() == -1){
			if(playerSwitch %2 == 1){
				System.out.println("PLAYER ONE GO");
				int col = IO.readInt();
				if(Connect4.play(1, col) == false){
					
				}else{
					System.out.println(Connect4.toString());
				}
			}else{
				System.out.println("PLAYER TWO GO");
				int col = IO.readInt();
				if(Connect4.play(2, col) == false){
					
				}else{
					System.out.println(Connect4.toString());
					
				}
			}
		playerSwitch ++; 
		}
		
		System.out.println(Connect4.isFinished());
	}
} //returns either the ID of the player who has won (1 or 2) OR 0 if the game has ended in a tie OR -1 if nobody has won yet
	