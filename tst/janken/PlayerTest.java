package janken;

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

}
