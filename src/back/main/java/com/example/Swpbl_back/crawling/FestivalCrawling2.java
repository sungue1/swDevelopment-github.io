package com.example.Swpbl_back.crawling;

import com.example.Swpbl_back.domain.Fstvl;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.JavascriptExecutor;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class FestivalCrawling2 {
    final WebDriver driver;
    private WebElement element;
    private WebElement element2;
    
    private List<Fstvl> fstvl_list;

    final String url;

    public static String WEB_DRIVER_ID = "webdriver.chrome.driver";
    public static String WEB_DRIVER_PATH = "C:/chromedriver_win32/chromedriver.exe";

    public FestivalCrawling2() {
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
            //월에 맞는 축제를 가져온다.

            JavascriptExecutor js = (JavascriptExecutor) driver;
            Thread.sleep(1000);
            //for(int k= 0; k<5;k++) {
            //    js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
            //    Thread.sleep(500);
            //}
            element2 = driver.findElement(By.id("fstvlList"));
            List<WebElement> el3 = element2.findElements(By.tagName("li"));
            for (WebElement element : el3){
                System.out.println(element.getText());
            }

            for (WebElement element : el3) {
                driver.manage().timeouts().implicitlyWait(100000, TimeUnit.MILLISECONDS);
                String url = element.findElement(By.tagName("a")).getAttribute("href");
                driver.navigate().to(url); //url로 이동
                Thread.sleep(1000);

                //content 조회
                WebElement ele11  =driver.findElement(By.id("festival_head"));
                System.out.println(ele11.getText());
                WebElement ele1= driver.findElement(By.className("img_info_box"));
                List<WebElement> ele3 = ele1.findElements(By.tagName("p"));
                for(WebElement ele:ele3) {
                    System.out.println("content = " + ele.getText());
                }
                WebElement ee = driver.findElement(By.className("m_img_fst"));
                WebElement e2 = ee.findElement(By.tagName("div"));
                System.out.println(e2.getText());
                driver.navigate().to("https://korean.visitkorea.or.kr/kfes/list/wntyFstvlList.do");
            }


        }
        catch (InterruptedException e){ //sleep 잡아주기
                e.printStackTrace();
            }
    }

}