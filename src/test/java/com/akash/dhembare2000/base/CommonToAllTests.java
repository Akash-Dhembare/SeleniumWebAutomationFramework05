package com.akash.dhembare2000.base;

import com.akash.dhembare2000.driver.DriverManager;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

public class CommonToAllTests {
    @BeforeMethod
    public void setUp(){
        DriverManager.init();
    }

    @AfterMethod
    public void tearDown(){
        DriverManager.down();
    }
}
