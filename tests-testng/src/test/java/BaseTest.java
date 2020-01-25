import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import ru.otus.Browsers;
import ru.stqa.selenium.factory.WebDriverPool;

import java.lang.reflect.Method;

import static java.util.Arrays.asList;

public class BaseTest {

    private static final Logger logger = LogManager.getLogger(BaseTest.class);

    @BeforeSuite
    public void setUp() {
        WebDriver driver = Browsers.CHROME.create();
        driver.navigate().to("http://ya.ru");
    }

    @BeforeMethod(alwaysRun = true)
    public void loggingSetUp(Method m, Object[] p) {
        logger.info("Start test: " + m.getName() + " with parameters " + asList(p));
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown(Method m) {
        logger.info("End test: " + m.getName());
    }

    @AfterSuite
    public void tearDown() {
        WebDriverPool.DEFAULT.dismissAll();
    }
}
