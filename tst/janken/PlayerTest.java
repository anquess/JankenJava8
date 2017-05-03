package janken;

import static janken.HandEnum.*;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Test;

public class PlayerTest {

	@Test
	public void toStringTest() {
		// Arrange
		Player sut = new Player("せいのすけ");

		// Actual
		String actual	= sut.toString();
		String expected = "せいのすけ";

		// Assert
		assertThat(actual,is(expected));
	}

	@Test
	public void getWinCountTest1回も勝負していない場合は0(){
		// Arrange
		Player sut = new Player("せいのすけ");
		// Actual
		int actual		= sut.getWinCount();
		int expected 	= 0;

		// Assert
		assertThat(actual,is(expected));
	}

	@Test
	public void notifyWinTest勝ちを伝えてwinCountが1(){
		// Arrange
		Player sut = new Player("せいのすけ");
		// Actual
		sut.notifyWin();
		int actual		= sut.getWinCount();
		int expected 	= 1;

		// Assert
		assertThat(actual,is(expected));
	}

	@Test
	public void showHandTestグーだけの戦術(){
		// Arrange
		Player sut = new Player("せいのすけ");
		// Actual
		sut.setTactics( () -> グー);
		int expected 	= 100;
		int actual		= 0;
		for (int i = 0; i < expected; i++) {
			if(sut.showHand().judge(グー) == 0) actual++;
		}


		// Assert
		assertThat(actual,is(expected));

	}



}
