package com.Prestashop;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class InputLoginAndPassword extends Settings {

    private String[] subMenu = {
            "subtab-AdminParentOrders",//1
            "subtab-AdminCatalog",//2
            "subtab-AdminParentCustomer",//3
            "subtab-AdminParentCustomerThreads",//4
            "subtab-AdminStats"//5
    };

    //    @Test
    public void scriptA() {

        driver.get("http://prestashop-automation.qatestlab.com.ua/admin147ajyvk0/");

        driver.findElementById("email").sendKeys("webinar.test@gmail.com");
        driver.findElementById("passwd").sendKeys("Xcg7299bnSmMuRLp9ITw");
        driver.findElementByName("submitLogin").click();

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.findElementById("employee_infos").click();
        driver.findElementById("header_logout").click();
    }

    @Test
    public void scriptB() throws InterruptedException {

        driver.get("http://prestashop-automation.qatestlab.com.ua/admin147ajyvk0/");
        driver.findElementById("email").sendKeys("webinar.test@gmail.com");
        driver.findElementById("passwd").sendKeys("Xcg7299bnSmMuRLp9ITw");
        driver.findElementByName("submitLogin").click();
        driver.findElementById("tab-AdminDashboard").click();

        Actions actions = new Actions(driver);
        for (String subMenuItem : subMenu) {
            WebElement element = driver.findElementById(subMenuItem);
            actions.moveToElement(element).click().build().perform();
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.MINUTES);
//            Thread.sleep(5000);
            String firstLoadChapterTitle = driver.findElementByClassName("page-title").getText();
            driver.navigate().refresh();
            String secondLoadChapterTitle = driver.findElementByClassName("page-title").getText();
            System.out.println("Title is correct: " + (firstLoadChapterTitle.equals(secondLoadChapterTitle)));
        }
    }
}
