import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import java.lang.reflect.Method;

import static java.util.Arrays.asList;
import static java.util.concurrent.TimeUnit.SECONDS;

public class BaseTest {

    private WebDriver driver;
    private static final Logger logger = LogManager.getLogger(BaseTest.class.getName());

    @BeforeTest
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver.manage().timeouts().implicitlyWait(10, SECONDS);
    }

    @BeforeMethod(alwaysRun = true)
    public void loggingSetUp(Method m, Object[] p) {
        logger.info("Start test: " + m.getName() + " with parameters " + asList(p));
        driver.get("http://otus.ru");
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown(Method m) {
        logger.info("End test: " + m.getName());
    }

    @AfterTest
    public void tearDown() {
        if (driver != null)
            driver.quit();
    }
}
