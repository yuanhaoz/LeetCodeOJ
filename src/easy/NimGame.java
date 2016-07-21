package easy;

public class NimGame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NimGame nm = new NimGame();
		nm.canWinNim(8);
	}
	
	public boolean canWinNim(int n) {
        return n % 4 > 0;
    }

}
