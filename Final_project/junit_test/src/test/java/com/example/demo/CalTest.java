package com.example.demo;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class CalTest {

	private Cal cal;
	
	@BeforeAll
	static void setupAll() {
		System.out.println("Before All");
	}
	
	@BeforeEach
	void setup(){
		cal = new Cal();
		System.out.println("Before Each");
	}
	
	@RepeatedTest(3)
	@DisplayName("Addition test")
	void runTest() {
		System.out.println("run Test");
		assertEquals(2,cal.add(1,1));
	}
	
	@Test
	@DisplayName("Addition test negative")
	void runTest_ne() {
		System.out.println("run Test");
		assertEquals(2,cal.add(1,0));
	}
	
	@AfterEach
	void tearDown() {
		System.out.println("After Each");
	}
	
	@AfterAll
	void tearDownAll() {
		System.out.println("After All");
	}
}
