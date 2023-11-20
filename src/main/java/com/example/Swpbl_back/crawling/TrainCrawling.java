package com.example.Swpbl_back.crawling;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.Keys;

public class TrainCrawling {

    final WebDriver driver;
    private WebElement element;
    private WebElement element2;
    private WebElement element3;
    private WebElement element4;
    private WebElement table;
    private WebElement tbody;
    final String url;
    Date Date = new Date();
    public String date = Date.td;
    public String[][] DataTable = new String[1000][4];
    public int size = 0;

    public static String WEB_DRIVER_ID = "webdriver.chrome.driver";
    public static String WEB_DRIVER_PATH = "C:/chromedriver_win32/chromedriver.exe";

    String query_dep = "";
    String query_arr = "";

    public TrainCrawling () {
        System.setProperty(WEB_DRIVER_ID, WEB_DRIVER_PATH);

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        options.addArguments("--disable-popup-blocking");

        driver = new ChromeDriver(options);

        url = "https://www.letskorail.com/ebizprd/prdMain.do";

    }

    public void Run() {
        try {
            driver.get(url);
            Thread.sleep(1000);

            // 팝업 제거
            String parentHandle = driver.getWindowHandle();
            for (String handle : driver.getWindowHandles()) {
                if( !handle.equals(parentHandle)) {
                    driver.switchTo().window(handle).close();
                }
            }
            driver.switchTo().window(parentHandle);

            // 출발지 입력
            driver.findElement(By.id("txtGoStart")).click();
            element = driver.findElement(By.id("txtGoStart"));
            element.clear();
            element.sendKeys(query_dep);
            element.sendKeys(Keys.RETURN);

            // 목적지 입력
            driver.findElement(By.id("txtGoEnd")).click();
            element2 = driver.findElement(By.id("txtGoEnd"));
            element2.clear();
            element2.sendKeys(query_arr);
            element2.sendKeys(Keys.RETURN);

            element3 = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div[1]/div[1]/div/div[1]/div/form/div/fieldset/ul[2]/li[1]/a"));
            element3.click();

            // 달력 팝업으로 전환
            String pop = driver.getWindowHandle();
            for (String handle : driver.getWindowHandles()) {
                if( !handle.equals(pop)) {
                    driver.switchTo().window(handle);
                }
            }

            Thread.sleep(1000);

            // 메인 화면으로 전환
            element4 = driver.findElement(By.id(date));
            ((ChromeDriver) driver).executeScript("arguments[0].click();", element4);
            driver.switchTo().window(parentHandle);

            // 검색
            element3 = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div[1]/div[1]/div/div[1]/div/form/div/fieldset/p"));
            element3.click();

            Thread.sleep(1000);

            // 팝업 제거
            String newpop = driver.getWindowHandle();
            for (String handle : driver.getWindowHandles()) {
                if( !handle.equals(newpop)) {
                    driver.switchTo().window(handle).close();
                }
            }
            driver.switchTo().window(newpop);

            Thread.sleep(1000);

            // KTX만 조회
            element = driver.findElement(By.id("selGoTrainRa00"));
            element.click();
            element2 = driver.findElement(By.className("btn_inq"));
            element2.click();

            // 팝업 제거
            for (String handle : driver.getWindowHandles()) {
                if( !handle.equals(newpop)) {
                    driver.switchTo().window(handle).close();
                }
            }
            driver.switchTo().window(newpop);

            Thread.sleep(2000);

            int dep_len = query_dep.length();
            int arr_len = query_arr.length();

            int i = 0;

            while (true) {
                table = driver.findElement(By.id("tableResult"));
                tbody = table.findElement(By.tagName("tbody"));
                java.util.List<WebElement> trList = tbody.findElements(By.tagName("tr"));
                for (WebElement tr : trList) {
                    java.util.List<WebElement> tdList = tr.findElements(By.tagName("td"));

                    String dist = tdList.get(1).getText();
                    if (dist.indexOf("KTX") == 0) {
                        String etd = tdList.get(2).getText();
                        etd = etd.substring(dep_len + 1);
                        String eta = tdList.get(3).getText();
                        eta = eta.substring(arr_len + 1);
                        String prc = tdList.get(8).getText();
                        prc = prc.substring(0, 6);
                        String dur = tdList.get(13).getText();
                        dur = dur.substring(0, 5);

                        DataTable[size][0] = etd;
                        DataTable[size][1] = eta;
                        DataTable[size][2] = prc;
                        DataTable[size][3] = dur;
                        size++;
                    }
                    i++;
                }
                if (i == 10) {
                    element = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div[1]/form[1]/div/div[4]/table[2]/tbody/tr/td/a"));
                    String x = element.findElement(By.tagName("img")).getAttribute("alt");
                    if (x.equals("다음")) {
                        element.click();
                    }
                    else {
                        break;
                    }
                }
                else {
                    try {
                        element2 = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div[1]/form[1]/div/div[4]/table[2]/tbody/tr/td/a[2]"));
                        String x = element2.findElement(By.tagName("img")).getAttribute("alt");
                        if (x.equals("다음")) {
                            element2.click();
                        } else {
                            break;
                        }
                    }
                    catch (Exception e) {
                        break;
                    }
                }
                Thread.sleep(3000);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            driver.close();
        }
    }
}
