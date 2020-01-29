import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.lang.reflect.Method;

import static java.util.Arrays.asList;
import static java.util.concurrent.TimeUnit.SECONDS;
import static ru.otus.Browsers.CHROME;

public class BaseYandexTest {

    private static final Logger logger = LogManager.getLogger(BaseTest.class.getName());
    private static final int DEFAULT_WAIT_TIME = 5;

    @BeforeClass
    public void setUp() {
        WebDriver driver = CHROME.create();
        driver.manage().timeouts().implicitlyWait(DEFAULT_WAIT_TIME, SECONDS);
    }

    @BeforeMethod(alwaysRun = true)
    public void loggingSetUp(Method m, Object[] p) {
        logger.info("Start test: {} with parameters {}", m.getName(), asList(p));
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown(Method m) {
        logger.info("End test: {}", m.getName());
    }
}
