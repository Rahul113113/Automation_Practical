package magento_Practical;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Login {
    public static void main(String[] args) {
        // Set the path to chromedriver if necessary
        // System.setProperty("webdriver.chrome.driver", "path_to_chromedriver");

        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30)); // Increased wait time

        try {
            driver.manage().window().maximize();
            driver.get("https://magento.softwaretestingboard.com/customer/account/login/");

            // Locate input fields
            WebElement emailInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email")));
            WebElement passwordInput = driver.findElement(By.id("pass"));

            // Provide valid credentials (must be an existing account)
            emailInput.sendKeys("rahul1751205011257@testmail.com");
            passwordInput.sendKeys("Test@12348");

            // Click Login button
            WebElement loginButton = driver.findElement(By.id("send2"));
            loginButton.click();

            // Wait for redirection or dashboard
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".greet.welcome")));

            System.out.println("Test Passed: Logged in successfully.");

            // Keep browser open for an additional 1 minute for manual inspection
            Thread.sleep(2000); // 60,000 ms = 1 minute

        } catch (Exception e) {
            System.out.println("Test Failed: " + e.getMessage());
        } finally {
            driver.quit();
        }
    }
}
