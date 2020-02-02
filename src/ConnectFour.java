
public class ConnectFour{
	
	
	public static void main(String[] args){
		
			
		
		//Create new board object
		
		//Set player tokens for player 1 and player 2
		
		//Create Player objects
		//Note, the code below works because of the interface Player. All classes that "implement" Player can be
		// typed as Player. Makes switching from Human to AI Players really easy. For a challenge, you might
		// consider:
		//		1. asking the user whether he/she wants to play against a human or a computer
		//		2. implementing multiple AI players (easy, med, hard) that the user can choose to play against
		Board Connect4= new Board();
		CFGUI Connect5 = new CFGUI(Connect4, ChipColor.RED, ChipColor.BLUE);
		Connect5.redraw();
		Connect4.setPlayerOne('r');
		Connect4.setPlayerTwo('b');
		Player p1 = new HumanPlayer(Connect4.getPlayerOne(), Connect4.getNumRows(), Connect4.getNumCols(), ChipColor.RED);
		Player p2 = new HumanPlayer(Connect4.getPlayerTwo(), Connect4.getNumRows(), Connect4.getNumCols(), ChipColor.BLUE);
		int playerSwitch = 1;
	//	System.out.println(p1.toString());
		//System.out.println(p2.toString());
		
		while(Connect4.isFinished() == -1){
			if(playerSwitch %2 == 1){
				System.out.println("PLAYER ONE GO");
				//int col = IO.readInt();
				String prompt = "";
				int col = GIO.readInt(prompt);
				Connect5.redraw();
				//col = p1.playToken();
				
				//System.out.println(col);
				while(Connect4.play(1, col) == false){
					System.out.println("PLAYER ONE GO");
					col = GIO.readInt(prompt);
				//	col = p1.playToken();
					Connect5.redraw();
				}
				p2.lastMove(col);	
				System.out.println(Connect4.toString());
			}else{
				System.out.println("PLAYER 2 GO");
				String prompt = "";
				int col = GIO.readInt(prompt);
				//col = p2.playToken();
				Connect5.redraw();
				while(Connect4.play(2, col) == false){
					col = GIO.readInt(prompt);
					//col = p2.playToken();
					Connect5.redraw();
				}
				p1.lastMove(col);
				System.out.println(Connect4.toString());
				/*System.out.println("PLAYER TWO GO");
				//int col = IO.readInt();
				int col = p2.playToken();
				System.out.println(col);
				while(Connect4.play(2, col) == false){
					System.out.println("PLAYER TWO GO");
					col = p2.playToken();
				}
					p1.lastMove(col);
					System.out.println(Connect4.toString());*/
				
			}
		playerSwitch ++; 
		}
		
		if(Connect4.isFinished() == 1){
			Connect5.gameOver(1);
		}
		if(Connect4.isFinished() == 2){
			Connect5.gameOver(2);
		}
		if(Connect4.isFinished() == 0){
			Connect5.gameOver(0);
		}
		
	//	Player p1 = new HumanPlayer(1,6,7);
	//	Player p2 = new HumanPlayer(1,6,7); //comment this line when testing AIPlayer
		
		/*Player p2 = new AIPlayer(2,6,7);*/ //uncomment this line when testing AIPlayer
		
		
		//Print your empty board
		
		
		//WHILE the board is still playable
		//	get a column to play from player 1
		//	play that token on the board
		//  print the board
		//		has anyone won yet?
		// do the above for player 2
		
		// Get the status code from the board (isFinished())
		
		// Print out the results of the game
		
		
	}
	
}