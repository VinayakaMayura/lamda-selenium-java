package tests;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.HomePage;
import utils.DriverFactory;
import utils.PropertyReader;
public class BaseTest {
    protected static WebDriver driver;
    protected static HomePage homePage;
    @BeforeMethod(alwaysRun = true)
    public void setup(){
        driver = new DriverFactory().getDriver();
        launchApplicationUnderTest();
        //driver.get("www.google.com");
        driver.manage().window().maximize();
    }

    @AfterMethod(alwaysRun = true)
    public void teardown(){
        new DriverFactory().destroyDriver();
    }

    private void launchApplicationUnderTest() {
        PropertyReader reader = new PropertyReader();
        String applicationURL = reader.readProperty("applicationURL");
        driver.get(applicationURL);
        homePage = PageFactory.initElements(driver, HomePage.class);
    }

}
