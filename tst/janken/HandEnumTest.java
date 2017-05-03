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
	@RunWith(Theories.class)
	public static class JudgeTest{

		@DataPoints
		public static Fixture[] PARAMs ={
				new Fixture(GU, GU, 0),
				new Fixture(CHOKI, CHOKI, 0),
				new Fixture(PAH, PAH, 0),
				new Fixture(GU, CHOKI, 1),
				new Fixture(GU, PAH, -1),
				new Fixture(CHOKI, GU, -1),
				new Fixture(CHOKI, PAH, 1),
				new Fixture(PAH, GU, 1),
				new Fixture(PAH, CHOKI, -1),
		};

		static class Fixture{
			HandEnum	sut;
			HandEnum	paramHand;
			int			expected;
			Fixture(HandEnum sut, HandEnum paramHand, int expected) {
				this.sut = sut;
				this.paramHand = paramHand;
				this.expected = expected;
			}
		}

		@Theory
		public void judgeTest(Fixture p){
			// Arrange
			HandEnum sut = p.sut;

			// Actual
			int actual		= sut.judge(p.paramHand);
			int expected	= p.expected;

			// Assert
			assertThat(actual,is(expected));

		}

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
