package janken;

import static janken.HandEnum.*;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;

@RunWith(Enclosed.class)
public class HandEnumTest {

	@RunWith(Theories.class)
	public static class toStringTest{
		@DataPoints
		public static Fixture[] PARAMs = {
				new Fixture(GU,"GU"),
				new Fixture(CHOKI, "CHOKI"),
				new Fixture(PAH, "PAH")
		};
		static class Fixture{
			HandEnum	sut;
			String		expected;
			Fixture(HandEnum sut,String expected){
				this.sut		= sut;
				this.expected	= expected;
			}
		}
		@Theory
		public void ToStringTest(Fixture p) {
			// Arrange
			HandEnum sut = p.sut;

			// Actual
			String actual		= sut.toString();
			String expected	= p.expected;

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
