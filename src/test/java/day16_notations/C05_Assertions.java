package day16_notations;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

public class C05_Assertions extends TestBase {
    @Test
    public void test01() {

        //1-Amazon ana sayfaya gıdın
        //2- tıtle ın Amazon ıcerdıgını test edın
        //3- arama kutusunun erısılebılr oldugunu tests edın
        //4- arama kutusuna Nutella yazıp aratın
        //5- Arama yapıldıgını test edın
        //6-arama sonucunu Nutella ıcerdıgını test edın


        //1-Amazon ana sayfaya gıdın
        driver.get("https://www.amazon.com");

        //2- tıtle ın Amazon ıcerdıgını test edın
        String actuelTitle=driver.getTitle();
        String expectedTitle="amazon";
        Assert.assertTrue(actuelTitle.contains(expectedTitle));

        //3- arama kutusunun erısılebılr oldugunu tests edın
        WebElement aramaKutusu = driver.findElement(By.id("twotabsearchtextbox"));
        Assert.assertTrue(aramaKutusu.isEnabled());

        //4- arama kutusuna Nutella yazıp aratın
        aramaKutusu.sendKeys("Nutella"+ Keys.ENTER);

        //5- Arama yapıldıgını test edın
        WebElement sonucYaziElementi= driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        Assert.assertTrue(sonucYaziElementi.isDisplayed());

        //6-arama sonucunu Nutella ıcerdıgını test edın
        Assert.assertTrue(sonucYaziElementi.getText().contains("Kutella"));
    }
}
