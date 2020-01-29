import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.lang.reflect.Method;

import static java.util.Arrays.asList;
import static java.util.concurrent.TimeUnit.SECONDS;

public class BaseYandexTest {

    private static final Logger logger = LogManager.getLogger(BaseTest.class.getName());
    private WebDriver driver;


    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
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
