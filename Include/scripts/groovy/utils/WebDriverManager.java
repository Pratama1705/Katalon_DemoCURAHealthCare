package utils;

import com.kms.katalon.core.webui.driver.DriverFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class WebDriverManager {
    private static WebDriver driver = null;
    
    public WebDriverManager() {
    	// Empty Constructor
    }

    public static WebDriver startDriver(String browserType) {
    	System.out.println("Starting Driver...");
    	
        if (driver != null) {
            return driver;
        }

        switch(browserType.toLowerCase()) {
            case "chrome":
            	System.setProperty("webdriver.chrome.driver", DriverFactory.getChromeDriverPath());

                ChromeOptions options = new ChromeOptions();
                options.addArguments("--start-maximized");


                driver = new ChromeDriver(options);
                break;

            default:
                throw new IllegalArgumentException("Unsupported browser: " + browserType);
        }

        DriverFactory.changeWebDriver(driver);
        return driver;
    }

    public static WebDriver getDriver() {
    	System.out.println("Getting Driver...");
    	
        if (driver == null) {
            throw new IllegalStateException("WebDriver not initialized. Call startDriver() first.");
        }
        
        return driver;
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
