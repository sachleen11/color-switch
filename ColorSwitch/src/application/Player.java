package application;

public class Player {
	
	int star=0;
	
	public Player(int star) {
		this.star=star;
	}
	
	int getstar() {
		return star;
	}
	
	boolean checkStar(int stars) {
		if (stars>3) {
			return true;
		}
		return false;
		
	}
	
	int resumeGame() {
		return 1;
	}
	void exitGame(boolean b) {
		Game g=new Game();
		g.exit();
	}
	

}
