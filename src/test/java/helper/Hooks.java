// Hooks help manage the driver lifecycle before and after each scenario in Cucumber.
package helper;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {

	@Before
	public void setUp() {
		BaseClass.initializeDriver();
		System.out.println("Driver Initialized.");
	}

	@After
	public void tearDown() {
		BaseClass.closeDriver();
		System.out.println("Driver Closed.");
	}
}
