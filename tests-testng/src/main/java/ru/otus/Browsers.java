package ru.otus;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import ru.stqa.selenium.factory.WebDriverPool;

public enum Browsers {
    CHROME {
        @Override
        public WebDriver create() {
            WebDriverManager.chromedriver().setup();
            return WebDriverPool.DEFAULT.getDriver(new ChromeOptions());
        }
    },
    EDGE {
        @Override
        public WebDriver create() {
            WebDriverManager.edgedriver().setup();
            return WebDriverPool.DEFAULT.getDriver(new EdgeOptions());
        }
    },
    FIREFOX {
        @Override
        public WebDriver create() {
            WebDriverManager.firefoxdriver().setup();
            return WebDriverPool.DEFAULT.getDriver(new FirefoxOptions());
        }
    };

    public WebDriver create() {
        return null;
    }
}
