import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Plugin_Test_Runner extends Set_up{
    Plugin_page pluginPage;


    @BeforeClass
    public void loginTest() {
        driver.get("http://localhost/wppool/wp-login.php");

// Locate the username and password fields
        WebElement username = driver.findElement(By.id("user_login"));
        WebElement password = driver.findElement(By.id("user_pass"));

// Input credentials and submit
        username.sendKeys("admin");
        password.sendKeys("admin123");
        driver.findElement(By.id("wp-submit")).click();

    }

    @Test(priority = 1, description = "Go To PIM menu   ")
    public void Plugin_Test_Runner() throws InterruptedException {
        pluginPage = new Plugin_page(driver);
        pluginPage.plugin();

    }
    @Test(priority = 2, description = "Go To PIM menu   ")
    public void Customise_Test_Runner() throws InterruptedException {
        pluginPage = new Plugin_page(driver);
        pluginPage.WP_Dark_Mode();

    }

}
