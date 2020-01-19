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

public class BaseTest {

    private final ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
    private static final Logger logger = LogManager.getLogger(BaseTest.class.getName());

    @BeforeTest
    public void setUp() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod(alwaysRun = true)
    public void loggingSetUp(Method m, Object[] p) {
        logger.info("Start test: " + m.getName() + " with parameters " + asList(p));
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown(Method m) {
        logger.info("End test: " + m.getName());
    }

    @AfterTest
    public void tearDown() {
        if (driver.get() != null)
            driver.get().quit();
    }
}
