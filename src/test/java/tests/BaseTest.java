package tests;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pages.HomePage;
import utils.DriverFactory;
import utils.PropertyReader;

public class BaseTest {
    protected static WebDriver driver;
    protected static HomePage homePage;

    @Before
    public void setup() {
        driver = new DriverFactory().getDriver();
        System.out.print("Driver"+driver);
        launchApplicationUnderTest();
    }

    @After
    public void teardown() {
        new DriverFactory().destroyDriver();
    }

    private void launchApplicationUnderTest() {
        String applicationURL = new PropertyReader().readProperty("applicationURL");
        driver.get(applicationURL);
        homePage = PageFactory.initElements(driver, HomePage.class);
    }

}
