package janken;

import static janken.HandEnum.*;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

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
				new Fixture(グー,"グー"),
				new Fixture(チョキ, "チョキ"),
				new Fixture(パー, "パー")
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
				new Fixture(グー, グー, 0),
				new Fixture(チョキ, チョキ, 0),
				new Fixture(パー, パー, 0),
				new Fixture(グー, チョキ, 1),
				new Fixture(グー, パー, -1),
				new Fixture(チョキ, グー, -1),
				new Fixture(チョキ, パー, 1),
				new Fixture(パー, グー, 1),
				new Fixture(パー, チョキ, -1),
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
			assertThat(p.sut + "VS" + p.paramHand,actual,is(expected));

		}
	}
}
