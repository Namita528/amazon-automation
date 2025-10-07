package PageObject;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class AmazonSearchPage {
    private WebDriver driver;

    private By categoryDropdown = By.id("searchDropdownBox");
    private By searchBox = By.id("twotabsearchtextbox");
    private By searchButton = By.id("nav-search-submit-button");
    private By productList = By.cssSelector("div.s-main-slot div[data-component-type='s-search-result']");

    public AmazonSearchPage(WebDriver driver) {
        this.driver = driver;
    }

    public void navigateToHomePage() {
        driver.get("https://www.amazon.in");
    }

    public void searchProduct(String category, String productName) {
        Select dropdown = new Select(driver.findElement(categoryDropdown));
        dropdown.selectByVisibleText(category);

        driver.findElement(searchBox).clear();
        driver.findElement(searchBox).sendKeys(productName);
        driver.findElement(searchButton).click();
    }

    public List<WebElement> getAllProductsOnScreen() {
        return driver.findElements(productList);
    }

    public WebElement getNthProduct(int n) {
        List<WebElement> products = getAllProductsOnScreen();
        if (n <= products.size()) {
            return products.get(n - 1);
        }
        return null;
    }

    public void scrollPage(int times) throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        for (int i = 0; i < times; i++) {
            js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
            Thread.sleep(3000); // wait for lazy load
        }
    }
}
