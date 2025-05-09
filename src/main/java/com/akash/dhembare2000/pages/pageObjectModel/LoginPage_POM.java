package com.akash.dhembare2000.pages.pageObjectModel;

import com.akash.dhembare2000.base.CommonToAllPages;
import com.akash.dhembare2000.utils.PropertyReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage_POM extends CommonToAllPages {
    WebDriver driver;

    public LoginPage_POM(WebDriver driver) {
        this.driver = driver;
    }

    // Page Locators
    private By username = By.xpath("//input[@id='login-username']");
    private By password = By.xpath("//input[@id='login-password']");
    private By signInBtn = By.xpath("//button[@id='js-login-btn']");
    private By errorMsg = By.xpath("//div[@id='js-notification-box-msg']");


    // Page Actions
    public String loginToVWOInvalidCreds(String user, String pwd){
        driver.get(PropertyReader.readkey("url"));
        driver.findElement(username).sendKeys(user);
        driver.findElement(password).sendKeys(pwd);
        driver.findElement(signInBtn).click();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        String errorMsgText = driver.findElement(errorMsg).getText();


        return errorMsgText;
    }
}
