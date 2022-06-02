package tests.day21_reusableMethods_HtmlReports;

import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.io.IOException;

public class C02_ScrenShotReusableMethod {
    @Test
    public void test01() throws IOException {
        //amazon sayfasına gıdıp fotografını cekelım
        Driver.getDriver().get(ConfigReader.getProperty("amazonUrl"));
        ReusableMethods.getScreenshot("amazon");
        Driver.closeDriver();
    }
}
