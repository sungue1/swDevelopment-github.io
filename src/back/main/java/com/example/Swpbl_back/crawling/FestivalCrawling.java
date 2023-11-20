package com.example.Swpbl_back.crawling;

import com.example.Swpbl_back.domain.Fstvl;
import com.example.Swpbl_back.repository.FstvlRepositoryImp;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.JavascriptExecutor;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class FestivalCrawling {
    final WebDriver driver;
    private WebElement element;
    private WebElement element2;



    final String url;

    public static String WEB_DRIVER_ID = "webdriver.chrome.driver";
    public static String WEB_DRIVER_PATH = "C:/chromedriver_win32/chromedriver.exe";

    public FestivalCrawling() {
        System.setProperty(WEB_DRIVER_ID, WEB_DRIVER_PATH);

        ChromeOptions options = new ChromeOptions();
        //options.addArguments("--headless");
        options.addArguments("--start-maximized");
        options.addArguments("--disable-popup-blocking");


        driver = new ChromeDriver(options);
        url = "https://korean.visitkorea.or.kr/kfes/list/wntyFstvlList.do";

    }

    public List<Fstvl> Run() {
        List<Fstvl> FstvlList = null;
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
            for (int k = 0; k < 5; k++) {
                js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
                Thread.sleep(500);
            }

            List<WebElement> el3 = element2.findElements(By.tagName("li"));
            FstvlList = new ArrayList<>();
            for (int i = 0; i < el3.size(); i++) {
                String title = el3.get(i).findElement(By.tagName("strong")).getText();
                String date = el3.get(i).findElement(By.className("date")).getText();
                String loc = el3.get(i).findElement(By.className("loc")).getText();
                String photo = (el3.get(i).findElement(By.tagName("img")).getAttribute("src"));
                System.out.println(title+date+loc+photo);
                Fstvl fstvl = new Fstvl();
                fstvl.setTitle(title);
                fstvl.setDate(date);
                fstvl.setLocation(loc);
                fstvl.setPhoto(photo);
                fstvl.setPrice("1");
                fstvl.setPhone("1");
                fstvl.setText("1");
                fstvl.setFstvl_keyword("1");
                FstvlList.add(fstvl);

            }

        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            return FstvlList;
        }
    }

    public Fstvl detailRun(String photo) {
        //String photo = "https://cdn.visitkorea.or.kr/kfes/upload/contents/db/300_268ee267-d483-4e3b-9e27-3594f6d9c5f6_1.jpg";
        String detailURL = "https://korean.visitkorea.or.kr/kfes/detail/fstvlDetail.do?fstvlCntntsId=";
        StringTokenizer st = new StringTokenizer(photo, "_");
        String URL = "";
        for (int i = 0; i < 2; i++) {
            URL = st.nextToken();
        }
        detailURL = detailURL + URL;
        System.out.println(detailURL);
        Fstvl fstvl;
        try {
            driver.get(detailURL);
            Thread.sleep(1000);
            element = driver.findElement(By.className("img_info_box")).findElement(By.tagName("ul"));
            List<WebElement> ele3 = element.findElements(By.tagName("p"));
            String price = ele3.get(2).getText();
            String phone = ele3.get(4).getText();
            String text = driver.findElement(By.className("m_img_fst")).findElement(By.tagName("div")).getText();

            System.out.println(price);
            System.out.println(phone);
            System.out.println(text);

            fstvl = new Fstvl();
            fstvl.setTitle("1");
            fstvl.setDate("1");
            fstvl.setLocation("1");
            fstvl.setPhoto("1");
            fstvl.setPrice(price);
            fstvl.setPhone(phone);
            fstvl.setText(text);
            fstvl.setFstvl_keyword("1");

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return fstvl;
    }

    public Fstvl detailRun2(String photo) {
        //String photo = "https://cdn.visitkorea.or.kr/kfes/upload/contents/db/300_268ee267-d483-4e3b-9e27-3594f6d9c5f6_1.jpg";
        String detailURL = "https://korean.visitkorea.or.kr/kfes/detail/fstvlDetail.do?fstvlCntntsId=";
        StringTokenizer st = new StringTokenizer(photo, "_");
        String URL = "";
        for (int i = 0; i < 2; i++) {
            URL = st.nextToken();
        }
        detailURL = detailURL + URL;
        System.out.println(detailURL);
        Fstvl fstvl;
        try {
            driver.get(detailURL);
            Thread.sleep(1000);
            element = driver.findElement(By.className("img_info_box")).findElement(By.tagName("ul"));
            List<WebElement> ele3 = element.findElements(By.tagName("p"));
            String price = ele3.get(2).getText();
            String phone = ele3.get(4).getText();
            String text = driver.findElement(By.className("m_img_fst")).findElement(By.tagName("div")).getText();

            System.out.println(price);
            System.out.println(phone);
            System.out.println(text);

            fstvl = new Fstvl();
            fstvl.setTitle("1");
            fstvl.setDate("1");
            fstvl.setLocation("1");
            fstvl.setPhoto("1");
            fstvl.setPrice(price);
            fstvl.setPhone(phone);
            fstvl.setText(text);
            fstvl.setFstvl_keyword("1");

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return fstvl;
    }
}
