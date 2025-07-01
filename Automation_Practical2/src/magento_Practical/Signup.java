package magento_Practical;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Signup {
    public static void main(String[] args) {
        // Set the path to chromedriver
        System.setProperty("webdriver.chrome.driver", "C:/Windows/chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        try {
            driver.manage().window().maximize();
            driver.get("https://magento.softwaretestingboard.com/customer/account/create/");

            // Enter valid details
            WebElement firstName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("firstname")));
            WebElement lastName = driver.findElement(By.id("lastname"));
            WebElement email = driver.findElement(By.id("email_address"));
            WebElement password = driver.findElement(By.id("password"));
            WebElement confirmPassword = driver.findElement(By.id("password-confirmation"));

            firstName.sendKeys("Rahul");
            lastName.sendKeys("Suthar");
            email.sendKeys("rahul" + System.currentTimeMillis() + "@testmail.com"); // Unique email
            password.sendKeys("Test@1234");
            confirmPassword.sendKeys("Test@1234");

            WebElement createAccountButton = driver.findElement(By.cssSelector("button[title='Create an Account']"));
            createAccountButton.click();

            // Wait for confirmation
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".message-success")));

            System.out.println("Test Passed: Account created successfully.");
            
            Thread.sleep(60000);

        } catch (Exception e) {
            System.out.println("Test Failed: " + e.getMessage());
        } finally {
            driver.quit();
        }
    }
}
