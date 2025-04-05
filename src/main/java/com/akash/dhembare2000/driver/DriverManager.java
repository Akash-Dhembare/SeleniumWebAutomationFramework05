package com.akash.dhembare2000.driver;


import com.akash.dhembare2000.utils.PropertyReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class DriverManager {
    public static WebDriver driver;

    public static WebDriver getDriver() {
        return driver;
    }

    public static void setDriver(WebDriver driver) {
        DriverManager.driver = driver;
    }

    public static void init(){
        String browser = null;
        browser = PropertyReader.readkey("browser");
        browser= browser.toLowerCase();

        if(driver==null){
            switch (browser){
                case "edge":
                    EdgeOptions edgeOptions = new EdgeOptions();
                    edgeOptions.addArguments("--start-maximized");
                    edgeOptions.addArguments("--InPrivate");
                    driver = new EdgeDriver(edgeOptions);
                    break;

                case "chrome":
                    ChromeOptions chromeOptions= new ChromeOptions();
                    chromeOptions.addArguments("--start-maximized");
                    chromeOptions.addArguments("--incognito");
                    driver = new ChromeDriver(chromeOptions);
                    break;

                case "firefox":
                    FirefoxOptions firefoxOptions = new FirefoxOptions();
                    firefoxOptions.addArguments("--start-maximized");
                    firefoxOptions.addArguments("--InPrivate");
                    driver = new FirefoxDriver(firefoxOptions);
                    break;

                default:
                    System.out.println("Browser not found!!");

            }
        }
    }

    public static void down(){
        if(driver!=null){
            driver.quit();
            driver=null;
        }
    }
}
