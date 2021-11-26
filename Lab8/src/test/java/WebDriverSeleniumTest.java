import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.EODemoAccountPage;
import page.EOHomePage;

public class WebDriverSeleniumTest {

    private WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void browserSetup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test(description = "Change Summ Of Deal")
    public void testCase() throws InterruptedException {
        Float getSumValueDefault = new EOHomePage(driver)
                .openPage()
                .getDemo()
                .getValue();

        Float getSumAfterInput = new EODemoAccountPage(driver)
                .inputSum("500")
                .getValue();
        System.out.println(getSumValueDefault);
        System.out.println(getSumAfterInput);
        Assert.assertNotSame(getSumValueDefault, getSumAfterInput);
    }

    @AfterMethod(alwaysRun = true)
    public void browserQuit() {
        driver.quit();
        driver = null;
    }
}
