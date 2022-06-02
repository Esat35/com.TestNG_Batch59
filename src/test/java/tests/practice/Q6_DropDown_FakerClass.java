package tests.practice;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilities.Driver;
import utilities.TestBase;

public class Q6_DropDown_FakerClass extends TestBase {
    //twitter a faker class kullanarak mail ile kayit olmaya calisiniz
    //actions class kullanmayin twitteri deneyen instagram i denesin

    @Test
    public void twitter() {
        Driver.getDriver().get("https://www.twitter.com");
        Driver.getDriver().findElement(By.xpath("(//span[@class='css-901oao css-16my406 r-poiln3 r-bcqeeo r-qvutc0'])[5]")).click();
        WebElement isimKutusu=Driver.getDriver().findElement(By.xpath("(//div[@class='css-1dbjc4n r-18u37iz r-16y2uox r-1wbh5a2 r-1wzrnnt r-1udh08x r-xd6kpl r-1pn2ns4 r-ttdzmv'])[1]"));
        Actions actions=new Actions(Driver.getDriver());
        Faker faker=new Faker();

        isimKutusu.sendKeys(faker.name().firstName());
        actions.sendKeys(Keys.TAB)
                .sendKeys(faker.phoneNumber().cellPhone())
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .perform();

    }

}
