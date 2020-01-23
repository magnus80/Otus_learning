import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import ru.otus.Browsers;
import ru.stqa.selenium.factory.WebDriverPool;

import java.lang.reflect.Method;

import static java.util.Arrays.asList;

public class BaseTest {

    private static final Logger logger = LogManager.getLogger(BaseTest.class.getName());

    @BeforeSuite
    public void setUp() {
        Browsers.CHROME.create();
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
