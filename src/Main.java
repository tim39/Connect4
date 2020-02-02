
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Board Connect4= new Board();
		Connect4.setPlayerOne('o');
		Connect4.setPlayerTwo('t');
		Connect4.play(1,0);
		Connect4.play(2,1);
		Connect4.play(1,0);
		Connect4.play(2,1);
		Connect4.play(1,0);
		Connect4.play(2,1);
		Connect4.play(1,0);
		Connect4.play(2,1);
		
		System.out.println(Connect4.canPlay());
		System.out.println(Connect4.isFinished());
		System.out.println(Connect4.getToken(5,0));
		
		Board Connect5= new Board(10,10);
		Connect5.setPlayerOne('o');
		Connect5.setPlayerTwo('t');
		Connect5.play(1,0);
		Connect5.play(2,1);
		Connect5.play(1,0);
		Connect5.play(2,1);
		Connect5.play(1,0);
		Connect5.play(2,1);
		Connect5.play(1,0);
		//Connect5.play(2,1);
		System.out.println(Connect5.toString());
		System.out.println(Connect5.canPlay());
		System.out.println(Connect5.isFinished());
		System.out.println(Connect5.getToken(9,1));
	}

}
