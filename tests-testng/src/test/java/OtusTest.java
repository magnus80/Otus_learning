import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import ru.otus.Browsers;

import static org.openqa.selenium.By.cssSelector;
import static org.testng.Assert.assertTrue;
import static ru.otus.Browsers.CHROME;

public class OtusTest extends BaseTest {

    private static final Logger logger = LogManager.getLogger(OtusTest.class.getName());
    private WebDriver driver;

    @Test(description = "I can open site Otus.ru")
    public void testCanOpenOtusSite() {
        driver = CHROME.create();
        driver.get("http://otus.ru");
        logger.info("Opening http://otus.ru");
        assertTrue(driver.findElement(cssSelector("div.header2__logo")).isDisplayed());
        assertTrue(driver.getTitle().contains("Онлайн‑курсы для профессионалов"));
    }

    @AfterClass
    public void tearDown() {
        if (driver != null)
            driver.quit();
    }
}
