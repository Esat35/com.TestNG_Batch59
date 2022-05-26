package day16_natations;

import org.testng.annotations.Test;
import utilities.TestBase;

public class C01_BeforeMethod_AfterMethod extends TestBase {

    //------------------------

    @Test
    public void amazonTesti() {
        driver.get("https://www.amazon.com");
    }

    @Test
    public void test02() {
        driver.get("https://www.bestbuy.com");
    }

    @Test
    public void techproedTest() {
        driver.get("https://www.techproeducation.com");
    }
}
