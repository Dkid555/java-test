package com.sel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.List;

import static java.lang.Thread.sleep;

public class SetEmail {

    static void setEmail(List<List<String>> records, WebDriver driver) throws InterruptedException {
//        int i = 0;
        try {
            for (List<String> cutomer : records
            ) {

                driver.findElement(By.xpath("/html/body/div[7]/div[3]/div/div[2]/div[1]/div[1]/div/div")).click();

                //                 нашли кнопку написать
                sleep(5000);

                driver.findElement(By.xpath("/html/body/div[24]/div/div/div/div[1]/div[2]/div[1]/div[1]/div/div/div/div[3]/div/div/div[4]/table/tbody/tr/td[2]/form/div[1]/table/tbody/tr[1]/td[2]/div/div/div[1]/div/div[3]/div/div/div/div/div/input")).sendKeys(cutomer.get(1));
                //                 нашли строку кому отправить
                driver.findElement(By.xpath("/html/body/div[24]/div/div/div/div[1]/div[2]/div[1]/div[1]/div/div/div/div[3]/div/div/div[4]/table/tbody/tr/td[2]/table/tbody/tr[1]/td/div/div[1]/div[2]/div[3]/div/table/tbody/tr/td[2]/div[2]/div")).sendKeys(cutomer.get(3) + " " + cutomer.get(2));
                //                заполнили тело сообщения
                sleep(5000);
//                if(i == 0){
//                    try {
//                        driver.findElement(By.id("link_enable_notifications_hide")).click();
//                    }catch (Exception exception){
//                        System.out.println(exception);
//                    }
//                i++;
//                }
                driver.findElement(By.xpath("/html/body/div[24]/div/div/div/div[1]/div[2]/div[1]/div[1]/div/div/div/div[3]/div/div/div[4]/table/tbody/tr/td[2]/table/tbody/tr[2]/td/div/div/div[4]/table/tbody/tr/td[1]/div/div[2]/div[1]")).click();
                ////                нажимаем кнопку отправить
                sleep(7000);

            }
            System.out.println("Succes, all emails were send");
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("Error, wait for one hour");
            sleep(3600000);
            setEmail(records, driver);
        }
    }
}
