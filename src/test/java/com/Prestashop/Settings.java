package com.Prestashop;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

public class Settings {

    public ChromeDriver driver;

    @BeforeTest

    public void setUp() {

        System.setProperty("webdriver.chrome.driver", "/home/victoria/Загрузки/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);




    }

    @AfterTest

    public void close(){
    driver.quit();
    }

}
