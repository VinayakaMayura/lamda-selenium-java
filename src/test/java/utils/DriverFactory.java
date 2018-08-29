package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;


public class DriverFactory {

    private static WebDriver driver;


    public DriverFactory() {

        initialize();
    }

    synchronized public void initialize() {
        System.out.println("LAMBDA_TASK_ROOT : " + System.getenv("LAMBDA_TASK_ROOT"));
        if (driver == null) {
            String logname = System.getenv("LOGNAME");
            //if (logname != null && !logname.equals("varunas"))
            System.setProperty("webdriver.chrome.driver", getClass().getResource("/lib/chromedriver").getPath());
//               System.setProperty("webdriver.chrome.driver", getLibLocation("chromedriver"));
            createNewDriverInstance();
        }
    }

    private void createNewDriverInstance() {
        String browser = new PropertyReader().readProperty("browser");
        if (browser.equals("chrome")) {
            driver = createLambdaChromeDriver();
        } else if (browser.equals("firefox")) {
            driver = new FirefoxDriver();
        } else
            System.out.println("can't read browser type");
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void destroyDriver() {
        driver.quit();
        driver = null;
    }

    private String getLibLocation(String lib) {
        return String.format("%s/lib/%s", System.getenv("LAMBDA_TASK_ROOT"), lib);
    }

    public ChromeDriver createLambdaChromeDriver() {

        ChromeOptions options = new ChromeOptions();

        // Set the location of the chrome binary from the resources folder
        String logname = System.getenv("LOGNAME");
        //if (logname != null && !logname.equals("varunas"))
        options.setBinary(getClass().getResource("/lib/chrome").getPath());
//        options.setBinary(getLibLocation("chrome"));
        options.addArguments("--disable-gpu");
        options.addArguments("--headless");
        options.addArguments("--window-size=1366,768");
        options.addArguments("--single-process");
        options.addArguments("--no-sandbox");
        options.addArguments("--user-data-dir=/tmp/user-data");
        options.addArguments("--data-path=/tmp/data-path");
        options.addArguments("--homedir=/tmp");
        options.addArguments("--disk-cache-dir=/tmp/cache-dir");
        DesiredCapabilities desiredCapabilities = DesiredCapabilities.chrome();
        desiredCapabilities.setCapability(ChromeOptions.CAPABILITY, options);

        ChromeDriver chromeDriver = new ChromeDriver(desiredCapabilities);
        return chromeDriver;
    }
}