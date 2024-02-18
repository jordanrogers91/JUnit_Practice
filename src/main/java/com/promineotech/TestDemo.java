package com.promineotech;

import java.util.Random;

public class TestDemo {
	
	public int addPostive(int a, int b) {
		if (a > 0 && b > 0) {
			return a + b;
		} else {
			throw new IllegalArgumentException("Both parameters must be positive!");
		}
		
	}
	
	public int randomNumberSquared () {
		int x = getRandomInt();
		return x * x;
		}
	
	int getRandomInt() {
		// getting a random int
		Random random = new Random();
		return random.nextInt(10) + 1;
	}
	
	// My own method
	public boolean isItColdOutside(int temp) {
		if (temp < 30) {
			return true;
		} else {
			return false;
		}
			
	}
	
}

