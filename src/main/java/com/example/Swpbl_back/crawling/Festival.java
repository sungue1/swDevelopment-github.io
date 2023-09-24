package com.example.Swpbl_back.crawling;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebElement;

import java.util.Date;
import java.util.List;

public class Festival {
    final WebDriver driver;
    private WebElement element;
    private WebElement element2;

    private List<WebElement> el3;

    final String url;

    public static String WEB_DRIVER_ID = "webdriver.chrome.driver";
    public static String WEB_DRIVER_PATH = "C:/chromedriver_win32/chromedriver.exe";

    public Festival() {
        System.setProperty(WEB_DRIVER_ID, WEB_DRIVER_PATH);

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("--disable-popup-blocking");


        driver = new ChromeDriver(options);

        url = "https://korean.visitkorea.or.kr/kfes/list/wntyFstvlList.do";
    }

    public void activateBot() {
        try {
            driver.get(url);
            Thread.sleep(1000);
            element = driver.findElement(By.id("searchDate"));
            element.sendKeys(Keys.DOWN);
            element.sendKeys(Keys.DOWN);
            element.sendKeys(Keys.DOWN);
            element.sendKeys(Keys.DOWN);
            element.sendKeys(Keys.DOWN);
            driver.findElement(By.id("btnSearch")).click();
            element2 = driver.findElement(By.id("fstvlList"));
            List<WebElement> el3 = element2.findElements(By.tagName("li"));
            for (int i = 0; i < el3.size(); i++) {
                String title = el3.get(i).findElement(By.tagName("strong")).getText();
                System.out.println(title);
            }
        } catch (Exception e) {
            e.printStackTrace();


        }
    }
}
