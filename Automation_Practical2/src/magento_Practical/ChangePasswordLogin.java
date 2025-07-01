package magento_Practical;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ChangePasswordLogin {
    public static void main(String[] args) throws InterruptedException {
        // Set path to chromedriver
        //System.setProperty("webdriver.chrome.driver", "C:\\Path\\To\\chromedriver.exe");
       // WebDriver driver = new ChromeDriver();
    	
    	 WebDriver driver = new ChromeDriver();
         WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
         
        String baseUrl = "https://magento.softwaretestingboard.com";
        String email = "rahul1751205011257@testmail.com";
        String oldPassword = "Test@12347";
        String newPassword = "Test@12348";
       

        driver.manage().window().maximize();

        // Step 1: Login with old password
        driver.get(baseUrl + "/customer/account/login/referer/aHR0cHM6Ly9tYWdlbnRvLnNvZnR3YXJldGVzdGluZ2JvYXJkLmNvbS9jdXN0b21lci9hY2NvdW50L2xvZ291dFN1Y2Nlc3Mv/");
        driver.findElement(By.id("email")).sendKeys(email);
        driver.findElement(By.id("pass")).sendKeys(oldPassword);
        driver.findElement(By.id("send2")).click();
        Thread.sleep(2000);

        // Step 2: Navigate to Change Password
        driver.get(baseUrl + "/customer/account/edit/changepass/1/");
        Thread.sleep(2000);
       // driver.findElement(By.id("change-password")).click();

        //driver.findElement(By.id("current-password")).sendKeys(oldPassword);
        // Step 3: Click "Change Password" checkbox
        //WebElement checkbox = wait.until(ExpectedConditions.elementToBeClickable(By.id("change-password")));
        //checkbox.click();
        Thread.sleep(2000);
        // Step 4: Fill change password form
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#current-password"))).sendKeys(oldPassword);
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("#password")).sendKeys(newPassword);
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("#password-confirmation")).sendKeys(newPassword);
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("button[title='Save'] span")).click();

        // Step 5: Logout
        wait.until(ExpectedConditions.urlContains("account"));
        driver.get(baseUrl + "/customer/account/logout/");

        // Step 6: Login with new password
        driver.get(baseUrl + "/customer/account/login/");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email"))).sendKeys(email);
        driver.findElement(By.id("pass")).sendKeys(newPassword);
        driver.findElement(By.id("send2")).click();
        Thread.sleep(2000);

        // Check if login is successful
        if (driver.getCurrentUrl().contains("customer/account")) {
            System.out.println("Login successful with new password!");
        } else {
            System.out.println("Login failed with new password.");
        }

        driver.quit();
    }
}


