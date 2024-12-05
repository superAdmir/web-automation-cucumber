// This class contains the logic to initialize and close the WebDriver instance
package helper;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class BaseClass {

	public static WebDriver driver;

	// Initialize WebDriver based on the selected browser
	public static void initializeDriver() {
		if (driver == null) {
			// Get the browser type from system properties or default to Chrome
			String browser = System.getProperty("browser", "chrome").toLowerCase();

			switch (browser) {
			case "chrome":
				System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver");
				ChromeOptions chromeOptions = new ChromeOptions();
				chromeOptions.addArguments("--start-maximized"); // Open browser in maximized mode
				driver = new ChromeDriver(chromeOptions);
				break;

			case "firefox":
				System.setProperty("webdriver.gecko.driver", "src/test/resources/drivers/geckodriver");
				FirefoxOptions firefoxOptions = new FirefoxOptions();
				driver = new FirefoxDriver(firefoxOptions);
				driver.manage().window().maximize(); // Maximize the Firefox window
				break;

			default:
				throw new IllegalArgumentException("Browser \"" + browser + "\" isn't supported.");
			}
		}
	}

	// Quit and cleanup WebDriver instance
	public static void closeDriver() {
		if (driver != null) {
			driver.quit();
			driver = null;
		}
	}

	// Get the WebDriver instance
	public static WebDriver getDriver() {
		if (driver == null) {
			initializeDriver();
		}
		return driver;
	}
}
