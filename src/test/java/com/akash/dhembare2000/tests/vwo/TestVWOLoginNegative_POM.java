package com.akash.dhembare2000.tests.vwo;

import com.akash.dhembare2000.base.CommonToAllTests;
import com.akash.dhembare2000.driver.DriverManager;
import com.akash.dhembare2000.pages.pageObjectModel.LoginPage_POM;
import com.akash.dhembare2000.utils.PropertyReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestVWOLoginNegative_POM extends CommonToAllTests {

    private static final Logger logger = LogManager.getLogger(TestVWOLoginNegative_POM.class);

    @Test
    public void testLoginInvalidCreds(){

        logger.info("Staring the testcase");
        LoginPage_POM loginPagePom = new LoginPage_POM(DriverManager.getDriver());

        logger.info("staring the browser");
        String errorMsgText = loginPagePom.loginToVWOInvalidCreds(PropertyReader.readkey("invalid_username"), PropertyReader.readkey("invalid_password"));

        logger.info("Validating the results");
        Assert.assertEquals(errorMsgText, PropertyReader.readkey("error_message"));
        System.out.println(errorMsgText);
    }

}
