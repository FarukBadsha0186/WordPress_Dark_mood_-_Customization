import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Plugin_page {


    WebDriver driver;
    WebDriverWait wait;

    //plugin page
    @FindBy(id = "plugin-search-input")
    WebElement search;
    @FindBy(xpath = "//a[text()='Add New Plugin']")
    WebElement addNewPluginLink;
    @FindBy(id ="search-plugins")
    WebElement search_wp_plugin;

    //customaize page

    @FindBy(id = "toplevel_page_wp-dark-mode")
    WebElement wp_mood_click;
    @FindBy(css ="div.flex.items-center.justify-between.cursor-pointer.py-3.px-4.focus\\:ring.rounded-lg.focus\\:ring-blue-400.transition")
    WebElement customDiv;

    @FindBy(xpath = "//h4[text()='Customization']")
    WebElement customizationHeader;

    @FindBy(linkText = "Switch Settings")
    WebElement switchSettingsLink;

    @FindBy(xpath = "//div[@class='bg-[#F9FAFB] flex flex-col items-center justify-center transition duration-75 rounded-lg relative cursor-pointer w-36 h-36']")
    WebElement divElement;

    @FindBy( css = "button.bg-blue-500.text-white.border-blue-500")
    WebElement saveButton;

    @FindBy( xpath = "//span[text()='Custom']")
    WebElement customSpan;
    @FindBy(xpath = "//span[text()='Left']")
    WebElement spanElement;

    @FindBy(linkText = "Accessibility")
    WebElement accessibilityLink;

    @FindBy(xpath = "//div[contains(@class, 'relative') and contains(@class, 'w-10') and contains(@class, 'bg-blue-600')]")
    WebElement divElements;

    @FindBy(linkText = "Site Animation")
    WebElement siteAnimationLink;


    public Plugin_page(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    public void plugin() throws InterruptedException {
        driver.findElement(By.id("menu-plugins")).click();
        //Check whether the “WP Dark Mode”
        search.sendKeys("WP Dark Mode");
        addNewPluginLink.click();
        //Navigate to the WP Dark Mode.
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        search_wp_plugin.sendKeys("WP Dark Mode");
    }

    public void WP_Dark_Mode() throws InterruptedException {

        wp_mood_click.click();
        //From Customization → Switch Settings
        customDiv.click();
        customizationHeader.click();
        Thread.sleep(10000);
        switchSettingsLink.click();
        Thread.sleep(10000);

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", divElement);
        divElement.click();


        //save mood button
        saveButton.click();



        //Select Custom Switch size & Scale it to 220.
        JavascriptExecutor jss = (JavascriptExecutor) driver;
        jss.executeScript("arguments[0].textContent = '200';", customSpan);
        String updatedText = customSpan.getText();
        System.out.println("Updated Text: " + updatedText);
        Thread.sleep(5000);



        //left position
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        spanElement.click();



        //accessibility
        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));
        JavascriptExecutor jst = (JavascriptExecutor) driver;
        jst.executeScript("arguments[0].scrollIntoView(true);", accessibilityLink);
        accessibilityLink.click();
        Thread.sleep(5000);


        //disable to sortcut
        //Already Disable

        // WebElement divElements = driver.findElement(By.xpath("//div[contains(@class, 'relative') and contains(@class, 'w-10') and contains(@class, 'bg-blue-600')]"));
      //  divElements.click();

        //site Animation
        siteAnimationLink.click();
        Thread.sleep(10000);


        //page transition Animation
        Thread.sleep(10000);
        driver.findElement(By.xpath("//span[contains(@class, 'flex') and contains(@class, 'w-4') and contains(@class, 'h-4') and contains(@class, 'border') and contains(@class, 'rounded-full') and contains(@class, 'border-gray-400')]")).click();


        //final Save
          WebElement finalsaveButton = driver.findElement(By.cssSelector("button.bg-blue-500.text-white.border-blue-500"));
        finalsaveButton.click();


    }


}
