package com.akash.dhembare2000.tests.vwo;

import com.akash.dhembare2000.base.CommonToAllTests;
import com.akash.dhembare2000.driver.DriverManager;
import com.akash.dhembare2000.pages.pageObjectModel.LoginPage_POM;
import com.akash.dhembare2000.utils.PropertyReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestVWOLoginNegative_POM extends CommonToAllTests {
    @Test
    public void testLoginInvalidCreds(){
        LoginPage_POM loginPagePom = new LoginPage_POM(DriverManager.getDriver());
        String errorMsgText = loginPagePom.loginToVWOInvalidCreds(PropertyReader.readkey("invalid_username"), PropertyReader.readkey("invalid_password"));

        Assert.assertEquals(errorMsgText, PropertyReader.readkey("error_message"));
        System.out.println(errorMsgText);
    }

}
