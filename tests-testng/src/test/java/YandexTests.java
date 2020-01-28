import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import ru.otus.Browsers;

import java.util.List;

import static org.openqa.selenium.By.cssSelector;
import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfAllElementsLocatedBy;
import static org.testng.Assert.assertFalse;

public class YandexTests extends BaseTest {

    private static final Logger logger = LogManager.getLogger(BaseTest.class);
    private WebDriver driver = Browsers.CHROME.create();
    private String baseUrl = "http://yandex.ru";

    @Test(description = "Открыть сайт, ввести фразу для поиска и увидеть результаты поиска")
    public void testYandexSearch() {

        driver.navigate().to(baseUrl);
        driver.findElement(cssSelector("#text")).sendKeys("Автоматизация Java");
        driver.findElement(cssSelector(".button[type='submit']")).click();
        WebDriverWait wait = new WebDriverWait(driver, 3);
        List<WebElement> results = driver.findElements(cssSelector("li.serp-item"));
        wait.until(presenceOfAllElementsLocatedBy(cssSelector("li.serp-item")));
        assertFalse(results.isEmpty());
    }

}
