package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GoogleSearchPage {

	private WebDriver driver;
	private By searchBox = By.name("q");

	public GoogleSearchPage(WebDriver driver) {
		this.driver = driver;
	}

	public void navigateToGoogle() {
		driver.navigate().to("https://google.com");
	}

	public void enterSearchText(String searchText) {
		driver.findElement(searchBox).sendKeys(searchText);
	}

	public void submitSearch() {
		driver.findElement(searchBox).submit();
	}

	public boolean isResultPageContainsText(String expectedText) {
		return driver.getPageSource().contains(expectedText);
	}
}
