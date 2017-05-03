package janken;

public class Player {
	private String name;
	private int	wincount;

	public Player(String name) {
		this.name		= name;
	}
	@Override
	public String toString(){
		return this.name;
	}
	public int getWinCount() {
		return this.wincount;
	}
	public void notifyWin() {
		this.wincount++;
	}

}
