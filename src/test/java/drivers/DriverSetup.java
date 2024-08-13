package drivers;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class DriverSetup {

    private static final ThreadLocal<WebDriver> LOCAL_DRIVER = new ThreadLocal<>();
    public static void setDriver(WebDriver browser) {
        DriverSetup.LOCAL_DRIVER.set(browser);
    }

    public static WebDriver getDriver() {
        return LOCAL_DRIVER.get();
    }


    public static WebDriver getBrowser(String browserName){
        if (browserName.equalsIgnoreCase("Chrome"))
            return new ChromeDriver();
        else if (browserName.equalsIgnoreCase("Edge"))
            return new EdgeDriver();
        else if (browserName.equalsIgnoreCase("Firefox"))
            return new FirefoxDriver();
        else {
            throw new RuntimeException("Browser is not available with the given name: " + browserName);
        }
    }

    public static void openABrowser(String browserName){
        WebDriver browser = getBrowser(browserName);
        browser.manage().window().maximize();
        browser.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        setDriver(browser);
    }

    public static void quiteBrowser(Scenario scenario){
        takeScreenShootOnFailedCase(scenario);
        getDriver().quit();
    }

    public static void takeScreenShootOnFailedCase(Scenario scenario){
        if (scenario.isFailed()){
            String name = scenario.getName().replaceAll(" ", "_");
            byte[] source =  ((TakesScreenshot)getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(source, "image/png", name);
        }

    }
}