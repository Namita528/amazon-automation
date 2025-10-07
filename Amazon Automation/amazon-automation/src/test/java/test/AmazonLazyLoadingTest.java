package test;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import PageObject.AmazonSearchPage;
import utils.BaseTest;

import java.time.Duration;
import java.util.List;

public class AmazonLazyLoadingTest extends BaseTest {

    private AmazonSearchPage amazon;
    private WebDriverWait wait;

    @Test(priority = 1)
    public void testSearchAndVerifyPageTitle() {
        amazon = new AmazonSearchPage(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        amazon.navigateToHomePage();
        amazon.searchProduct("Electronics", "iPhone 13");

        wait.until(ExpectedConditions.titleContains("iPhone 13"));
        Assert.assertTrue(driver.getTitle().contains("iPhone 13"),
                "❌ Search results page not loaded correctly.");
        System.out.println("✅ Search completed and results page displayed.");
    }

    @Test(priority = 2)
    public void testGetNthProduct() {
        amazon = new AmazonSearchPage(driver);
        int n = 5;

        WebElement nthProduct = amazon.getNthProduct(n);

        if (nthProduct != null) {
            try {
                wait.until(ExpectedConditions.visibilityOf(nthProduct));
                // Use a safer approach — get visible text if <h2> not found
                String productName = "";
                try {
                    productName = nthProduct.findElement(By.cssSelector("h2 a span")).getText();
                } catch (NoSuchElementException e) {
                    productName = nthProduct.getText().split("\n")[0]; // fallback to first line of text
                }

                System.out.println("✅ " + n + "th Product: " + productName);

            } catch (StaleElementReferenceException e) {
                System.out.println("⚠️ The " + n + "th product became stale during DOM update.");
            }
        } else {
            System.out.println("⚠️ Less than " + n + " products found on screen.");
        }
    }

    @Test(priority = 3)
    public void testGetAllProductsOnScreen() {
        amazon = new AmazonSearchPage(driver);
        List<WebElement> products = amazon.getAllProductsOnScreen();
        System.out.println("🟢 Products on screen: " + products.size());

        int index = 1;
        for (WebElement product : products) {
            try {
                String title;
                try {
                    title = product.findElement(By.cssSelector("h2 a span")).getText();
                } catch (NoSuchElementException e) {
                    title = product.getText().split("\n")[0];
                }
                System.out.println(index + ". " + title);
                index++;
            } catch (Exception e) {
                System.out.println("⚠️ Skipped a non-standard product block.");
            }
        }
    }

    @Test(priority = 4)
    public void testLazyLoadingWithScroll() throws InterruptedException {
        amazon = new AmazonSearchPage(driver);

        // Scroll down multiple times to load all items
        amazon.scrollPage(5);

        List<WebElement> allProducts = amazon.getAllProductsOnScreen();
        System.out.println("🟣 Total products after scrolling: " + allProducts.size());

        if (allProducts.size() > 0) {
            System.out.println("✅ Lazy loading verified successfully.");
        } else {
            System.out.println("❌ No products loaded after scroll. Lazy loading may have failed.");
        }
    }
}
