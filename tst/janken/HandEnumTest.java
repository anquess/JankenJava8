package janken;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Test;

public class HandEnumTest {

	@Test
	public void toStringTestGU() {
		// Arrange
		HandEnum sut = HandEnum.GU;


		// Actual
		String actual	= sut.toString();
		String expected	= "GU";

		// Assert
		assertThat(actual,is(expected));

	}

}
