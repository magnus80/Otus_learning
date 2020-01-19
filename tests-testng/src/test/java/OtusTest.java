import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class OtusTest extends BaseTest {



    @Test(description = "I can open site Otus.ru")
    public void ICanOpenOtusSiteTest() {
        ChromeDriver driver = new ChromeDriver();
        driver.get("http://otus.ru");
        assertTrue(driver.findElementByXPath("//a[@class='header2__logo-img new-year']").isDisplayed());
    }
}
