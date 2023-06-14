package com.sel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

/**
 * Hello world!
 */
public class App {
    final static String email = "yourgmail@gmail.com";
    final static String password = "your_password";
    final static String PATH = "C:\\Chrome-driver\\chromedriver.exe";

    public static void main(String[] args) {
        try {
            System.setProperty("webdriver.chrome.driver", PATH);

            Map<String, Object> prefs = new HashMap<String, Object>();
            prefs.put("profile.default_content_setting_values.notifications", 2);

            ChromeOptions options = new ChromeOptions();
            options.setExperimentalOption("prefs", prefs);
            WebDriver driver = new ChromeDriver(options);


            driver.get("https://accounts.google.com/v3/signin/identifier?dsh=S-1694431074%3A1683865624021785&continue=https%3A%2F%2Fmail.google.com%2Fmail%2F&ifkv=Af_xneGYhuRG6vvS4sopX_WekR6F13aj3tDJkLERhB42FDYhUWShCz7UCnaTVE72WaxB-33hglNw&rip=1&sacu=1&service=mail&flowName=GlifWebSignIn&flowEntry=ServiceLogin");

            Stack<WebElement> elements = new Stack<>();
            elements.push(driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/div/c-wiz/div/div[2]/div/div[1]/div/form/span/section/div/div/div[1]/div/div[1]/div/div[1]/input")));
//            WebElement element = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/div/c-wiz/div/div[2]/div/div[1]/div/form/span/section/div/div/div[1]/div/div[1]/div/div[1]/input"));
            elements.peek().sendKeys(email);
            elements.pop();

            elements.push(driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/div/c-wiz/div/div[2]/div/div[2]/div/div[1]/div/div/button/span")));
            elements.pop().click();

            Thread.sleep(5000);


            elements.push(driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/div/c-wiz/div/div[2]/div/div[1]/div/form/span/section[2]/div/div/div[1]/div[1]/div/div/div/div/div[1]/div/div[1]/input")));
            elements.pop().sendKeys(password);

            driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/div/c-wiz/div/div[2]/div/div[2]/div/div[1]/div/div/button/span")).click();

            Thread.sleep(5000);

            List<List<String>> records = ReadCSV.readcsv("C:\\Chrome-driver\\lol.csv");

            SetEmail.setEmail(records, driver);

            driver.close();

        } catch (Exception e) {
            System.out.println(e);
        }

    }


}

