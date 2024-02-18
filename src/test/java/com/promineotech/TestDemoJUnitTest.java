package com.promineotech;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;

import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import static org.junit.jupiter.params.provider.Arguments.*;

import org.junit.jupiter.params.provider.MethodSource;

class TestDemoJUnitTest {
	
	private TestDemo testDemo;

	@BeforeEach
	//in setUp method create a testDemo object to ensure that a new testDemo object is created before each test
	void setUp() throws Exception {
		testDemo = new TestDemo();
	}

	@ParameterizedTest
	@MethodSource("com.promineotech.TestDemoJUnitTest#argumentsForAddPositive")
	void assertThatTwoPositiveNumbersAreAddedCorrectly(int a, int b, int expected, boolean expectException) {
		if (!expectException) {
			assertThat(testDemo.addPostive(a, b)).isEqualTo(expected);
		} else {
			assertThatThrownBy(() -> testDemo.addPostive(a, b)).isInstanceOf(IllegalArgumentException.class);
		}
		
		}
	// parameter source method
	static Stream<Arguments> argumentsForAddPositive(){
		// @formatter:off
			return Stream.of(arguments(2, 4, 6, false),
					arguments(0, 1, 1, true),
					arguments(-1, -7, -8, true),
					arguments(3, -5, -2, true),
					arguments(7, 10, 17, false)
					);
		// @formatter:on
		}
	@Test 
	 void assertThatPairsOfPositiveNumbersAreAddedCorrectly(){
		assertThat(testDemo.addPostive(4, 5)).isEqualTo(9);
		assertThat(testDemo.addPostive(40, 50)).isEqualTo(90);
		assertThat(testDemo.addPostive(10, 5)).isEqualTo(15); 
	}
	
	@Test
	void assertThatNumberSquaredIsCorrect() {
		//to mock the TestDemo class
		TestDemo mockDemo = spy(testDemo);
		//program the mocked TestDemo to return 5 when method is called
		doReturn(5).when(mockDemo).getRandomInt();
		//call the method randomNumberSquared on the mocked TestDemo. 
		int fiveSquared = mockDemo.randomNumberSquared();
		//use assertThat to test the value returned
		assertThat(fiveSquared).isEqualTo(25);
	}
	
	@Test
	void assertThatIsColdOutSideIsCorrect() {
		assertThat(testDemo.isItColdOutside(28)).isEqualTo(true);
		assertThat(testDemo.isItColdOutside(-12)).isEqualTo(true);
		assertThat(testDemo.isItColdOutside(0)).isEqualTo(true);
		assertThat(testDemo.isItColdOutside(88)).isEqualTo(false);
		
	}
	
	
	
	
	
}
