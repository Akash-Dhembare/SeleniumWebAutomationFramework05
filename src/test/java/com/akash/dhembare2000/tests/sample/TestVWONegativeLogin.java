package com.akash.dhembare2000.tests.sample;

import com.akash.dhembare2000.utils.PropertyReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestVWONegativeLogin {
    @Test
    public void testVWOLogin(){
        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.addArguments("--start-maximized");
        edgeOptions.addArguments("--InPrivate");

        WebDriver driver = new EdgeDriver(edgeOptions);
        driver.get("https://app.vwo.com/#/login");

        WebElement username = driver.findElement(By.xpath("//input[@id='login-username']"));
        WebElement password = driver.findElement(By.xpath("//input[@id='login-password']"));
        WebElement signInBtn = driver.findElement(By.xpath("//button[@id='js-login-btn']"));
        WebElement errorMsg = driver.findElement(By.xpath("//div[@id='js-notification-box-msg']"));

        username.sendKeys(PropertyReader.readkey("invalid_username"));
        password.sendKeys(PropertyReader.readkey("invalid_password"));
        signInBtn.click();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        Assert.assertEquals(PropertyReader.readkey("error_message"), errorMsg.getText());
        System.out.println(errorMsg.getText());

        driver.quit();


    }
}
