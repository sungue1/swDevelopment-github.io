package com.example.Swpbl_back.crawling;

import com.example.Swpbl_back.domain.Fstvl;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.JavascriptExecutor;

import java.util.List;

public class FestivalCrawling {
    final WebDriver driver;
    private WebElement element;
    private WebElement element2;
    private WebElement element3;

    private String title;
    private String date;



    private String loc;

    final String url;

    public static String WEB_DRIVER_ID = "webdriver.chrome.driver";
    public static String WEB_DRIVER_PATH = "C:/chromedriver_win32/chromedriver.exe";

    public FestivalCrawling() {
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

            JavascriptExecutor js = (JavascriptExecutor) driver;
            Thread.sleep(1000);
            for(int k= 0; k<5;k++) {
                js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
                Thread.sleep(500);
            }

            //js.executeScript("window.scrollBy(0,10000)");
            //String sText =  js.executeScript("return document.documentElement.innerText;").toString();
            //System.out.println(sText);

            String url = element3.findElement(By.tagName("a")).getAttribute("href");
            List<WebElement> el3 = element2.findElements(By.tagName("li"));
            Fstvl fstvl = new Fstvl();
            for (int i = 0; i < el3.size(); i++) {
                //String title = el3.get(i).findElement(By.tagName("strong")).getText();
                //String date = el3.get(i).findElement(By.className("date")).getText();
                //String loc = el3.get(i).findElement(By.className("loc")).getText();
                //System.out.println(title+date+loc);

                fstvl.setTitle(title);
                fstvl.setDate(date);
                fstvl.setLocation(loc);
                System.out.println(fstvl.getTitle());

            }


        }
        catch (Exception e) {
            e.printStackTrace();


        }
    }

}
