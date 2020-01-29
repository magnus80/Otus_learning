import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import ru.otus.Browsers;

import static org.apache.logging.log4j.LogManager.getLogger;

public class YandexTests extends BaseYandexTest {

    private static final Logger logger = getLogger(YandexTests.class);
    private WebDriver driver;

    @Test(description = "Открыть сайт, ввести фразу для поиска и увидеть результаты поиска")
    public void testYandexSearch() {
        driver = Browsers.CHROME.create();
        String baseUrl = "http://yandex.ru";
        String MOBILE_PHONES = "/catalog--mobilnye-telefony/54726/list?hid=91491&local-offers-first=0&onstock=1";

        driver.get(baseUrl + MOBILE_PHONES);

/*        driver.findElement(cssSelector("#text")).sendKeys("Автоматизация Java");
        driver.findElement(cssSelector(".button[type='submit']")).click();
        WebDriverWait wait = new WebDriverWait(driver, 3);
        List<WebElement> results = driver.findElements(cssSelector("li.serp-item"));
        wait.until(presenceOfAllElementsLocatedBy(cssSelector("li.serp-item")));
        assertFalse(results.isEmpty());*/
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null)
            driver.quit();
    }
}
