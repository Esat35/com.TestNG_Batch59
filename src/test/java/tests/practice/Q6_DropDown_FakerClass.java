package tests.practice;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.FacebookPage;
import pages.TwitterPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBase;

public class Q6_DropDown_FakerClass extends TestBase {
    //twitter a faker class kullanarak mail ile kayit olmaya calisiniz
    //actions class kullanmayin twitteri deneyen instagram i denesin

    @Test
    public void twitter() {
        TwitterPage twitterPage=new TwitterPage();
        Driver.getDriver().get(ConfigReader.getProperty("twitterUrl"));
        twitterPage.telVeyaEpostaIleKayitButonu.click();
        Actions actions=new Actions(Driver.getDriver());
        Faker faker=new Faker();
        twitterPage.kayitIsimKutusu.sendKeys(faker.name().firstName());


        actions.sendKeys(Keys.TAB)
                .sendKeys(faker.phoneNumber().cellPhone())
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .perform();

    }

}
