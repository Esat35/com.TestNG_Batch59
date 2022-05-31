package tests.practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilities.TestBase;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Q3_SoftAssert extends TestBase {

    /*
     * Navigate to  https://www.saucedemo.com/
     * Enter the user name  as standard_user
     * Enter the password as   secret_sauce
     * Click on login button
     *     T1 : Choose price low to high with soft Assert
     *     T2 : Verify item prices are sorted from low to high with hard Assert
     */




    // Verify item prices are sorted from low to high with hard Assert


    @Test
    public void SoftAssertTest() {
        driver.navigate().to("https://www.saucedemo.com/");
        WebElement userNameKutusu=driver.findElement(By.id("user-name"));
        userNameKutusu.sendKeys("standard_user");

        WebElement passwordKutusu=driver.findElement(By.xpath("//input[@id='password']"));
        passwordKutusu.sendKeys("secret_sauce");

        WebElement clickButonu=driver.findElement(By.id("login-button"));
        clickButonu.click();


        List<WebElement> fiyatlarListesi=driver.findElements(By.xpath("//div[@class='inventory_item_price']"));
        List<Double> doubleFiyatlarListesi=fiyatlarListesi.stream().
                map(WebElement::getText).
                map(t->t.replaceAll("[^.0-9]","")).
                map(Double::parseDouble).
                collect(Collectors.toList());

        SoftAssert softAsser=new SoftAssert();

        Collections.sort(doubleFiyatlarListesi);
        double highPrice=doubleFiyatlarListesi.get(doubleFiyatlarListesi.size()-1);
        double lowPrice=doubleFiyatlarListesi.get(0);
        softAsser.assertTrue(highPrice>lowPrice);

        System.out.println("doubleFiyatlarListesi = " + doubleFiyatlarListesi);
    }
}
