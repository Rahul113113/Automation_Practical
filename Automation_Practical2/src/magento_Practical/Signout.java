package magento_Practical;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Signout {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
       // Actions actions = new Actions(driver);

        try {
            driver.manage().window().maximize();
            driver.get("https://magento.softwaretestingboard.com/customer/account/login/");

            // Login first
            WebElement emailInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email")));
            WebElement passwordInput = driver.findElement(By.id("pass"));
            emailInput.sendKeys("rahul1751205011257@testmail.com");
            passwordInput.sendKeys("Test@12348");
            //WebElement loginButton = driver.findElement(By.id("send2"));
            //loginButton.click();
            
         // Check if the overlay is present and dismiss it
            try {
                WebElement overlay = driver.findElement(By.id("aswift_4_host"));
                ((JavascriptExecutor) driver).executeScript("arguments[0].style.display='none';", overlay);
                System.out.println("Overlay dismissed.");
            } catch (Exception e) {
                System.out.println("Overlay not found or already dismissed.");
            }
            Thread.sleep(2000); // Wait for overlay to be dismissed
            // Proceed with the login button click
            WebElement loginButton = driver.findElement(By.id("send2"));
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", loginButton);
            loginButton.click();

            Thread.sleep(2000);
            WebElement button = driver.findElement(By.cssSelector("div[class='panel header'] button[type='button']"));
            button.click();

            // Wait for Sign Out link to be visible and click it
            WebElement signOutLink = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Sign Out")));
            signOutLink.click();

            // Wait for the sign-out confirmation page
            wait.until(ExpectedConditions.urlContains("logout"));
            System.out.println("Test Passed: Signed out successfully.");

            Thread.sleep(2000); // 1 minute pause for manual verification

        } catch (Exception e) {
            System.out.println("Test Failed: " + e.getMessage());
        } finally {
            driver.quit();
        }
    }
}
