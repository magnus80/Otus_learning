package ru.otus;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public enum Browsers {
    CHROME {
        public WebDriver create() {
            return new ChromeDriver();
        }
    },
    IE {
        public WebDriver create() {
            return new EdgeDriver();
        }
    },
    FIREFOX {
        public WebDriver create() {
            return new FirefoxDriver();
        }
    };

    public WebDriver create() {
        return null;
    }
}
