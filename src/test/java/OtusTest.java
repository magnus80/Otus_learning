import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class OtusTest {

    @Test(description = "I can open site Otus.ru")
    public void ICanOpenOtusSiteTest() {
        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver();
        driver.get("http://otus.ru");
        assertTrue(driver.findElementByXPath("//a[@class='header2__logo-img new-year']").isDisplayed());
        driver.quit();
    }
}
