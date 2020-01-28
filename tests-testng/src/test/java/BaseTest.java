import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import ru.otus.Browsers;

import java.lang.reflect.Method;

import static java.util.Arrays.asList;

public class BaseTest {

    private WebDriver driver;
    private static final Logger logger = LogManager.getLogger(BaseTest.class.getName());

    @BeforeClass
    public void setUp() {
        Browsers.CHROME.create();
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
