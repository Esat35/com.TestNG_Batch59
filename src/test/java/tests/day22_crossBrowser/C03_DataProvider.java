package tests.day22_crossBrowser;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.AmazonPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C03_DataProvider {


    @Test
    public void test01() {
        AmazonPage amazonPage=new AmazonPage();
        //amazon anasayfaya gıdelım
        Driver.getDriver().get(ConfigReader.getProperty("amazonUrl"));

        //nutella için arama yapalım
        amazonPage.aramaKutusu.sendKeys("Nutella"+ Keys.ENTER);

        //sonucların nutella ıcerdıgını test edelım
        String expectedKelime="Nutella";
        String actualSonucYazisi=amazonPage.aramaSonucElementi.getText();
        Assert.assertTrue(actualSonucYazisi.contains(expectedKelime));

        //sayfayı kapatalim
        Driver.closeDriver();

    }




    @DataProvider
    public static Object[][] AranacakKelimeler() {
        Object [][] arananKelimeArrayi={{"Nutella"}, {"Java"}, {"cigdem"},{"Netherlands"}};
        return arananKelimeArrayi;
    }

    @Test(dataProvider = "AranacakKelimeler")
    //arayacagımız kelımelerı bır lıste gıbı tutup
    //bana yollayacak bır verı saglayıcısı olusturacagız.
    public void dataProviderTesti(String arananKelime) {
        AmazonPage amazonPage=new AmazonPage();
        //amazon anasayfaya gıdelım
        Driver.getDriver().get(ConfigReader.getProperty("amazonUrl"));

        //Nutella, Java, cigdem ve Netherlands icin arama yapalim
        amazonPage.aramaKutusu.sendKeys("arananKelime"+ Keys.ENTER);

        //sonuclarin aradıgımız kelıme ıcerdıgını test edelım sayfayı kapatalım.
        String expectedKelime="arananKelime";
        String actualSonucYazisi=amazonPage.aramaSonucElementi.getText();
        Assert.assertTrue(actualSonucYazisi.contains(expectedKelime));

        //sayfayı kapatalim
        Driver.closeDriver();
    }
}
