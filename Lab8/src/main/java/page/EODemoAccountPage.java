package page;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import waiter.ExplicitWaiter;

import java.security.Key;
import java.util.concurrent.TimeUnit;

import static waiter.ExplicitWaiter.waitForElementLocatedBy;

public class EODemoAccountPage {
    private WebDriver driver;

    @FindBy(xpath = "//*[@class='input currency-once']/child::input")
    private WebElement sumField;

    public EODemoAccountPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    @SuppressWarnings("deprecation")
    public EODemoAccountPage inputSum(String text) {
        waitForElementLocatedBy(driver, By.xpath("//*[@class='input currency-once']/child::input"));
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        sumField.clear();
        waitForElementLocatedBy(driver, By.xpath("//*[@class='input currency-once']/child::input"));
        sumField.sendKeys(text);
        sumField.sendKeys(Keys.ENTER);
        return this;
    }

    public float getValue(){
        waitForElementLocatedBy(driver, By.xpath("//*[@class='input currency-once']/child::input"));
        WebElement fieldValue = driver.findElement(By.xpath("//*[@class='input currency-once']/child::input"));
        return Float.parseFloat(fieldValue.getAttribute("value"));
    }
}
