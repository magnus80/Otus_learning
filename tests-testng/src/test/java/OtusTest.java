import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class OtusTest extends BaseTest {

    private static final Logger logger = LogManager.getLogger(OtusTest.class.getName());
    private ChromeDriver driver = new ChromeDriver();

    @Test(description = "I can open site Otus.ru")
    public void ICanOpenOtusSiteTest() {
        driver.get("http://otus.ru");
        assertTrue(driver.findElementByXPath("//a[@class='header2__logo-img new-year']").isDisplayed());
    }
}
