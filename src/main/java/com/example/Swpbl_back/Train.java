package com.example.Swpbl_back;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Train {
    final WebDriver driver;
    private WebElement element;
    private WebElement element2;
    final String url;

    public static String WEB_DRIVER_ID = "webdriver.chrome.driver";
    public static String WEB_DRIVER_PATH = "C:/chromedriver_win32/chromedriver.exe";

    private String query_dep = "포항";
    private String query_arr = "대전";

    public Train() {
        System.setProperty(WEB_DRIVER_ID, WEB_DRIVER_PATH);

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("--disable-popup-blocking");

        driver = new ChromeDriver(options);

        url = "https://www.letskorail.com/ebizprd/prdMain.do";
    }
    public void activateBot() {
        try {
            driver.get(url);
            Thread.sleep(1000);

            driver.findElement(By.id("txtGoStart")).click();
            element = driver.findElement(By.id("txtGoStart"));
            element.clear();
            element.sendKeys(query_dep);
            element.sendKeys(Keys.RETURN);

            driver.findElement(By.id("txtGoEnd")).click();
            element2 = driver.findElement(By.id("txtGoEnd"));
            element2.clear();
            element2.sendKeys(query_arr);
            element2.sendKeys(Keys.RETURN);

            driver.findElement(By.className("btn_res")).click();

            String main = driver.getWindowHandle();
            for (String handle : driver.getWindowHandles()) {
                if(!handle.equals(main)) {
                    driver.switchTo().window(handle).close();
                }
            }

            Thread.sleep(100);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        //finally {
        //    driver.close(); // 5. 브라우저 종료
        //}
    }
}
