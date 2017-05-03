package janken;

import static janken.HandEnum.*;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

@RunWith(Enclosed.class)
public class HandEnumTest {

	public static class toStringTest{
		@Test
		public void ToStringTestGU() {
			// Arrange
			HandEnum sut = GU;

			// Actual
			String actual	= sut.toString();
			String expected	= "GU";

			// Assert
			assertThat(actual,is(expected));
		}

		@Test
		public void toStringTestCHOKI() {
			// Arrange
			HandEnum sut = CHOKI;

			// Actual
			String actual	= sut.toString();
			String expected	= "CHOKI";

			// Assert
			assertThat(actual,is(expected));
		}
		@Test
		public void toStringTestPAH() {
			// Arrange
			HandEnum sut = PAH;

			// Actual
			String actual	= sut.toString();
			String expected	= "PAH";

			// Assert
			assertThat(actual,is(expected));
		}
	}

	public static class JudgeTest{
		@Test
		public void judgeTestGU_GU(){
			// Arrange
			HandEnum sut = GU;

			// Actual
			int actual		= sut.judge(GU);
			int expected	= 0;

			// Assert
			assertThat(actual,is(expected));
		}
		@Test
		public void judgeTestGU_CHOKI(){
			// Arrange
			HandEnum sut = GU;

			// Actual
			int actual		= sut.judge(CHOKI);
			int expected	= 1;

			// Assert
			assertThat(actual,is(expected));

		}
	}
}
