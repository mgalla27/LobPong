
public class Player {

	
	public int score;
	public int x_pos; 			// x position of the player 
	public int y_pos;			// y position of the player
	
	public Player(int x_pos, int y_pos) {
		this.x_pos = x_pos;
		this.y_pos = y_pos;
		this.score = 0;
	}

	public void increment_score() {
		this.setScore(this.getScore() + 1);
	}
	
	public void decrement_score() {
		this.setScore(this.getScore() - 1);
	}
	
	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public int getX_pos() {
		return x_pos;
	}
	
	public int getY_pos() {
		return y_pos;
	}

	public void setY_pos(int y_pos) {
		this.y_pos = y_pos;
	}
	
	
	
	
}
