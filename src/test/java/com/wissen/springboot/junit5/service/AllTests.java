package com.wissen.springboot.junit5.service;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses({ BirthdayServiceTest.class })
public class AllTests {

}
