
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

import static java.time.Duration.ofSeconds;

public class just_alternative {

    WebDriver driver;
    //   WebDriverWait wait;
    @FindBy(className = "wp-menu-name.wp-dark-mode-ignore")
    List<WebElement> wp_mood;

    @BeforeTest
    public void setUp() {

        driver = new ChromeDriver();
        driver.manage().window().maximize();

    }


    @Test(priority = 1)
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


    @Test(priority = 2)
    public void plugin() throws InterruptedException {
        driver.findElement(By.id("menu-plugins")).click();
        WebElement search = driver.findElement(By.id("plugin-search-input"));
        search.sendKeys("WP Dark Mode");


        WebElement addNewPluginLink = driver.findElement(By.xpath("//a[text()='Add New Plugin']"));
        addNewPluginLink.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement search_wp_plugin = driver.findElement(By.id("search-plugins"));
        search_wp_plugin.sendKeys("WP Dark Mode");

        WebDriverWait waits = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement pluginLink = waits.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(@href, 'plugin=wp-dark-mode')]")));
        pluginLink.click();
        Thread.sleep(10000);


    }

    public void add_new_plugin() throws InterruptedException {
/*  List<WebElement> installButtons = driver.findElements(By.cssSelector("a.install-now.button"));
        installButtons.get(0).click();
*/

        //  driver.findElement(By.id("plugin_install_from_iframe")).click();
        //   install.click();

    }

    @Test(priority = 3)
    public void WP_Dark_Mode() throws InterruptedException {

        driver.findElement(By.id("toplevel_page_wp-dark-mode")).click();
        WebElement customDiv = driver.findElement(By.cssSelector("div.flex.items-center.justify-between.cursor-pointer.py-3.px-4.focus\\:ring.rounded-lg.focus\\:ring-blue-400.transition"));
        customDiv.click();

        WebElement customizationHeader = driver.findElement(By.xpath("//h4[text()='Customization']"));
        customizationHeader.click();
        Thread.sleep(10000);

        WebElement switchSettingsLink = driver.findElement(By.linkText("Switch Settings"));
        switchSettingsLink.click();
        Thread.sleep(10000);

        //   WebElement divElement = driver.findElement(By.cssSelector("div.bg\\-\\[#F9FAFB\\].flex.flex-col.items-center.justify-center.transition.duration-75.rounded-lg.relative.cursor-pointer.w-36.h-36"));
        WebElement divElement = driver.findElement(By.xpath("//div[@class='bg-[#F9FAFB] flex flex-col items-center justify-center transition duration-75 rounded-lg relative cursor-pointer w-36 h-36']"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", divElement);
        divElement.click();

        //save mood button
        WebElement saveButton = driver.findElement(By.cssSelector("button.bg-blue-500.text-white.border-blue-500"));

        saveButton.click();

        //Select Custom Switch size & Scale it to 220.

        WebElement customSpan = driver.findElement(By.xpath("//span[text()='Custom']"));
        JavascriptExecutor jss = (JavascriptExecutor) driver;
        jss.executeScript("arguments[0].textContent = '200';", customSpan);
        String updatedText = customSpan.getText();
        System.out.println("Updated Text: " + updatedText);
        Thread.sleep(5000);

        //left position

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement spanElement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Left']")));
        spanElement.click();

        //accessibility
        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement accessibilityLink = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Accessibility")));
        JavascriptExecutor jst = (JavascriptExecutor) driver;
        jst.executeScript("arguments[0].scrollIntoView(true);", accessibilityLink);
        accessibilityLink.click();
        Thread.sleep(5000);

        //disable to sortcut

        WebElement divElements = driver.findElement(By.xpath("//div[contains(@class, 'relative') and contains(@class, 'w-10') and contains(@class, 'bg-blue-600')]"));
        divElements.click();

        //site Animation

        WebElement siteAnimationLink = driver.findElement(By.linkText("Site Animation"));
        siteAnimationLink.click();
        Thread.sleep(10000);

        //page transition Animation
        WebElement divElementt = driver.findElement(By.cssSelector("div.relative.w-10.h-full.rounded-full.transition.duration-100.bg-slate-200"));
        divElementt.click();

        //Change Animation
        WebElement spanElements = driver.findElement(By.cssSelector("span.flex.w-4.h-4.border.rounded-full.border-4.border-blue-600"));
        spanElements.click();

        //final Save
        WebElement finalsaveButton = driver.findElement(By.cssSelector("button.bg-blue-500.text-white.border-blue-500"));
        finalsaveButton.click();


        // Validate that dark mode is enabled by checking any UI element
        WebElement bodyFrontEnd = driver.findElement(By.tagName("body"));
        String backgroundColorFrontEnd = bodyFrontEnd.getCssValue("background-color");
        assert backgroundColorFrontEnd.equals("expected-dark-color-code");
    }


    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}


