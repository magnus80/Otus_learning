import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import static java.util.concurrent.TimeUnit.SECONDS;
import static org.apache.logging.log4j.LogManager.getLogger;
import static org.openqa.selenium.By.cssSelector;
import static org.openqa.selenium.By.xpath;
import static org.testng.Assert.assertEquals;

public class YandexTests extends BaseYandexTest {

    private static final Logger logger = getLogger(YandexTests.class);

    private WebDriver driver;
    private static final int DEFAULT_WAIT_TIME = 5;
    private static final String YA_RU = "http://ya.ru";
    private static final String MARKET_YANDEX_RU = "https://market.yandex.ru";
    private static final String MOBILE_PHONES = "/catalog--mobilnye-telefony/54726/list?hid=91491&glfilter=7893318%3A7701962&glfilter=12782797%3A14357428&local-offers-first=0&onstock=1";
    private static final String REDMI8 = "img[title='Смартфон Xiaomi Redmi 8 4/64GB']";
    private static final String ADD_TO_COMPARE_LIST = "//div[contains(@class,'n-product-toolbar__item link link_theme_minor hint n-user-lists_type_compare i-bem n-user-lists_type_compare_in-list_yes n-user-lists_type_compare_js_inited hint_js_inited _popup2-destructor _popup2-destructor_js_inited link_js_inited link_hovered_yes')]";
    private static final String DIV_POPUP_INFORMER_CONTENT = "div.popup-informer__content";
    private static final String DIV_CONTAINS_CLASS_POPUP_INFORMER_TITLE = "//div[contains(@class,'popup-informer__title')]";

    @Test(description = "Написать автотест для каталога Яндекс.Маркет")
    public void testYandexSearch() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(DEFAULT_WAIT_TIME, SECONDS);
        driver.navigate().to(YA_RU);
        driver.get(MARKET_YANDEX_RU + MOBILE_PHONES);
        hover(REDMI8);
        driver.findElement(xpath(ADD_TO_COMPARE_LIST)).click();
        waitForElementVisibility(DIV_POPUP_INFORMER_CONTENT);
        assertEquals(driver.findElement(xpath(DIV_CONTAINS_CLASS_POPUP_INFORMER_TITLE)).getText().trim(),
                "Товар Смартфон Xiaomi Redmi 8 4/64GB добавлен к сравнению");
    }

    public void waitForElementVisibilityX(String element) {
        WebDriverWait wait = new WebDriverWait(driver, DEFAULT_WAIT_TIME);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(xpath(element)));
    }

    private void waitForElementVisibility(String element) {
        WebDriverWait wait = new WebDriverWait(driver, DEFAULT_WAIT_TIME);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(cssSelector(element)));
    }

    private void hover(String element) {
        Actions action = new Actions(driver);
        WebElement elem = driver.findElement(By.cssSelector(element));
        action.moveToElement(elem);
        action.perform();
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null)
            driver.quit();
    }
}
