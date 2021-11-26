package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import waiter.ExplicitWaiter;

import java.time.Duration;

import static waiter.ExplicitWaiter.waitForElementLocatedBy;

public class EOHomePage {

    private WebDriver driver;
    private static String HOMEPAGE_URL = "https://expertoption.com/";

    @FindBy(xpath = "//*[@class='css-1o8rkmr']")
    private WebElement linkTryDemo;

    public EOHomePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public EOHomePage openPage(){
        driver.get(HOMEPAGE_URL);
        return this;
    }

    public EODemoAccountPage getDemo(){
        waitForElementLocatedBy(driver, By.xpath("//*[@class='css-1o8rkmr']"));
        linkTryDemo.click();
        return new EODemoAccountPage(driver);
    }

}
