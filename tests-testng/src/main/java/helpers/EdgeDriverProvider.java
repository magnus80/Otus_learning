package helpers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import static java.lang.String.valueOf;
import static org.openqa.selenium.PageLoadStrategy.NORMAL;

public class EdgeDriverProvider implements WebDriverProvider {
    @Override
    public WebDriver createWebDriver() {
        EdgeOptions options = new EdgeOptions();
        options.setPageLoadStrategy(valueOf(NORMAL));
        WebDriverManager.edgedriver().setup();
        return new EdgeDriver(options);
    }
}
