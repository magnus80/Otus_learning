package ru.otus;

import helpers.ChromeDriverProvider;
import helpers.EdgeDriverProvider;
import helpers.FirefoxDriverProvider;
import helpers.HeadlessChromeDriverProvider;
import org.openqa.selenium.WebDriver;

public enum Browsers {

    CHROME {
        @Override
        public WebDriver create() {
            return new ChromeDriverProvider().createWebDriver();
        }
    },
    HEADLESS_CHROME {
        @Override
        public WebDriver create() {
            return new HeadlessChromeDriverProvider().createWebDriver();
        }
    },
    EDGE {
        @Override
        public WebDriver create() {
            return new EdgeDriverProvider().createWebDriver();
        }
    },
    FIREFOX {
        @Override
        public WebDriver create() {
            return new FirefoxDriverProvider().createWebDriver();
        }
    };

    public WebDriver create() {
        return null;
    }
}
