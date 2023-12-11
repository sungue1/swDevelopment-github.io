package com.example.SW_PBL.Festival;

import org.openqa.selenium.*;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class FestivalCrawling {
    public int lock = 0;
    public int length = 0;
    final WebDriver driver;
    private WebElement element;
    private WebElement element2;

    final String url;

    public static String WEB_DRIVER_ID = "webdriver.chrome.driver";
    public static String WEB_DRIVER_PATH = "C:/Users/PC/Desktop/InteliJ Project/chromedriver_win32/chromedriver.exe";

    public FestivalCrawling() {
        System.setProperty(WEB_DRIVER_ID, WEB_DRIVER_PATH);

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        //options.addArguments("--disable-popup-blocking");

        driver = new ChromeDriver(options);
        url = "https://korean.visitkorea.or.kr/kfes/list/wntyFstvlList.do";
    }

    public List<Fstvl> Run() {
        List<Fstvl> FstvlList = new ArrayList<>();
        try {
            driver.get(url);
            Thread.sleep(1000);

            element = driver.findElement(By.id("searchDate"));
            List<WebElement> ele = element.findElements(By.tagName("option"));
            //입력받은 월에 따라 크롤링
            //3개의 더미 데이터 존재 4번째 부터 1월
            int dateinfo = 1;
            ele.get(dateinfo+2).click();
            element2 = driver.findElement(By.id("fstvlList"));

            String first = "1";
            String second = "2";
            while (Integer.parseInt(first) != Integer.parseInt(second)) {
                element = driver.findElement(By.className("list_more_btn"));
                String x = element.getText();
                int one = x.indexOf("/");
                int two = x.indexOf(")");
                first = x.substring(5, one);
                second = x.substring(one + 1, two);
                element.sendKeys(Keys.PAGE_DOWN);
            }

            List<WebElement> el3 = element2.findElements(By.tagName("li"));
            for (int i = 0; i < el3.size(); i++) {
                String title = el3.get(i).findElement(By.tagName("strong")).getText();
                String date = el3.get(i).findElement(By.className("date")).getText();
                String loc = el3.get(i).findElement(By.className("loc")).getText();
                String photo = (el3.get(i).findElement(By.tagName("img")).getAttribute("src"));
                //System.out.println(title+date+loc+photo);
                Fstvl fstvl2 = new Fstvl();
                fstvl2.setTitle(title);
                fstvl2.setDate(date);
                fstvl2.setLocation(loc);
                fstvl2.setPhoto(photo);
                fstvl2.setPrice("1");
                fstvl2.setPhone("1");
                fstvl2.setText("1");
                FstvlList.add(fstvl2);
                length++;
            }
            lock = 1;


        } catch (Exception e) {
            e.printStackTrace();


        } finally {
            return FstvlList;

        }
    }

    public List<Fstvl> seletedDateRun(String day) {
        List<Fstvl> FstvlList = new ArrayList<>();
        try {
            int Date1 = Integer.parseInt(day.substring(5, 7));
            int Date2 = Integer.parseInt(day.substring(16, 18));
            if (Date1 != Date2) {
                driver.get(url);
                Thread.sleep(1000);
                element = driver.findElement(By.id("searchDate"));
                element.sendKeys(Keys.DOWN);
                element.sendKeys(Keys.DOWN);
                for (int i = 0; i < Date1; i++) {
                    element.sendKeys(Keys.DOWN);
                }
                driver.findElement(By.id("btnSearch")).click();
                element2 = driver.findElement(By.id("fstvlList"));

                Thread.sleep(1000);

                String first = "1";
                String second = "2";
                while (Integer.parseInt(first) != Integer.parseInt(second)) {
                    element = driver.findElement(By.className("list_more_btn"));
                    String x = element.getText();
                    int one = x.indexOf("/");
                    int two = x.indexOf(")");
                    first = x.substring(5, one);
                    second = x.substring(one + 1, two);
                    element.sendKeys(Keys.PAGE_DOWN);
                }

                List<WebElement> el3 = element2.findElements(By.tagName("li"));
                for (int i = 0; i < el3.size(); i++) {
                    String title = el3.get(i).findElement(By.tagName("strong")).getText();
                    String date = el3.get(i).findElement(By.className("date")).getText();
                    String loc = el3.get(i).findElement(By.className("loc")).getText();
                    String photo = (el3.get(i).findElement(By.tagName("img")).getAttribute("src"));
                    Fstvl fstvl2 = new Fstvl();
                    fstvl2.setTitle(title);
                    fstvl2.setDate(date);
                    fstvl2.setLocation(loc);
                    fstvl2.setPhoto(photo);
                    fstvl2.setPrice("1");
                    fstvl2.setPhone("1");
                    fstvl2.setText("1");
                    if (Integer.parseInt(date.substring(16, 18)) == Integer.parseInt(day.substring(5, 7)) + 1) {
                        FstvlList.add(fstvl2);
                        //System.out.println("다음달");
                        length++;
                    } //2023.03.25~2023.04.05
                    else if (Integer.parseInt(day.substring(8, 10)) <= Integer.parseInt(date.substring(19, 21))) {
                        FstvlList.add(fstvl2);
                        length++;
                    }
                    else if (Integer.parseInt(date.substring(0, 4)) == 2022) {
                        //System.out.println(fstvl2.getTitle() + "is neglected");
                    }
                    else {
                        //System.out.println(fstvl2.getTitle() + " is neglected! " + Integer.parseInt(day.substring(8, 10)) + " <= " + Integer.parseInt(date.substring(19, 21)));
                        if (Integer.parseInt(date.substring(16, 18)) == Integer.parseInt(day.substring(5, 7)) + 1) {
                            //System.out.println("달 문제 아님");
                        }
                        else {
                            //System.out.println(Integer.parseInt(date.substring(5, 7)) + " == " + (Integer.parseInt(day.substring(16, 18)) + 1));
                        }
                    }
                }

                driver.get(url);
                Thread.sleep(1000);
                element = driver.findElement(By.id("searchDate"));
                element.sendKeys(Keys.DOWN);
                element.sendKeys(Keys.DOWN);
                for (int i = 0; i < Date2; i++) {
                    element.sendKeys(Keys.DOWN);
                }
                driver.findElement(By.id("btnSearch")).click();
                element2 = driver.findElement(By.id("fstvlList"));

                Thread.sleep(1000);
                String third = "1";
                String fourth = "2";
                while (Integer.parseInt(third) != Integer.parseInt(fourth)) {
                    element = driver.findElement(By.className("list_more_btn"));
                    String x = element.getText();
                    int one = x.indexOf("/");
                    int two = x.indexOf(")");
                    third = x.substring(5, one);
                    fourth = x.substring(one + 1, two);
                    element.sendKeys(Keys.PAGE_DOWN);
                }

                List<WebElement> el4 = element2.findElements(By.tagName("li"));
                for (int i = 0; i < el4.size(); i++) {
                    String title = el4.get(i).findElement(By.tagName("strong")).getText();
                    String date = el4.get(i).findElement(By.className("date")).getText();
                    String loc = el4.get(i).findElement(By.className("loc")).getText();
                    String photo = (el4.get(i).findElement(By.tagName("img")).getAttribute("src"));
                    Fstvl fstvl3 = new Fstvl();
                    fstvl3.setTitle(title);
                    fstvl3.setDate(date);
                    fstvl3.setLocation(loc);
                    fstvl3.setPhoto(photo);
                    fstvl3.setPrice("1");
                    fstvl3.setPhone("1");
                    fstvl3.setText("1");
                    if (Integer.parseInt(date.substring(8, 10)) <= Integer.parseInt(day.substring(19, 21))) {
                        FstvlList.add(fstvl3);
                        length++;
                    }
                }
            }

            else {
                driver.get(url);
                Thread.sleep(1000);
                element = driver.findElement(By.id("searchDate"));
                element.sendKeys(Keys.DOWN);
                element.sendKeys(Keys.DOWN);
                for (int i = 0; i < Date1; i++) {
                    element.sendKeys(Keys.DOWN);
                }
                driver.findElement(By.id("btnSearch")).click();
                element2 = driver.findElement(By.id("fstvlList"));

                Thread.sleep(1000);
                String first = "1";
                String second = "2";
                while (Integer.parseInt(first) != Integer.parseInt(second)) {
                    element = driver.findElement(By.className("list_more_btn"));
                    String x = element.getText();
                    int one = x.indexOf("/");
                    int two = x.indexOf(")");
                    first = x.substring(5, one);
                    second = x.substring(one + 1, two);
                    element.sendKeys(Keys.PAGE_DOWN);
                }

                List<WebElement> el3 = element2.findElements(By.tagName("li"));
                for (int i = 0; i < el3.size(); i++) {
                    String title = el3.get(i).findElement(By.tagName("strong")).getText();
                    String date = el3.get(i).findElement(By.className("date")).getText();
                    String loc = el3.get(i).findElement(By.className("loc")).getText();
                    String photo = (el3.get(i).findElement(By.tagName("img")).getAttribute("src"));
                    Fstvl fstvl2 = new Fstvl();
                    fstvl2.setTitle(title);
                    fstvl2.setDate(date);
                    fstvl2.setLocation(loc);
                    fstvl2.setPhoto(photo);
                    fstvl2.setPrice("1");
                    fstvl2.setPhone("1");
                    fstvl2.setText("1");
                    if (Integer.parseInt(date.substring(8, 10)) < Integer.parseInt(day.substring(8, 10)) && Integer.parseInt(day.substring(19, 21)) < Integer.parseInt(date.substring(19, 21))) {
                        FstvlList.add(fstvl2);
                        length++;
                    }
                }
            }
            lock = 1;

        } catch (Exception e) {
            e.printStackTrace();


        } finally {
            return FstvlList;

        }
    }

    public Fstvl detailRun(String photo) throws NullPointerException{
        System.out.println(photo);
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

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        finally {
            driver.close();
        }
        return fstvl;
    }

}
