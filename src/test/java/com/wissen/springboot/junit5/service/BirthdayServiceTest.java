package com.wissen.springboot.junit5.service;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.time.Month;

import org.junit.Before;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.wissen.springboot.junit5.exception.InvalidDateFormatException;

@SpringBootTest
class BirthdayServiceTest {
	String birthdate;
	@Autowired
	private BirthdayService service;
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}
	@BeforeEach
	void setUp() throws Exception {
		System.out.println("Before executing each test!!");
		birthdate = "2022-10-05";
		
	}

	@AfterEach
	void tearDown() throws Exception {
		System.out.println("After executing each test!!");
	}

	@Test
	void testGetBirthDOW() {
		assertEquals(service.getBirthDOW(service.getValidBirthday(birthdate)), "WEDNESDAY");
	}

	@Test
	void testBirthdayServiceException() {
		assertThrows(InvalidDateFormatException.class,() -> service.getValidBirthday(null));
	}
	
	@Test
	void testIsBirthDatesSameStarSign() {
		LocalDate localdate1 = LocalDate.now();
		LocalDate localdate2 = localdate1.plusDays(1);
		assertTrue(service.isBirthDatesSameStarSign(localdate1, localdate2));
	}

	@ParameterizedTest
	@EnumSource(value = Month.class, names = {"APRIL", "JUNE", "SEPTEMBER", "NOVEMBER"})
	void checkTheseMonthsHave30Days(Month month) {
	    final boolean isALeapYear = true;
	    assertEquals(30, month.length(isALeapYear));
	}

	
}
