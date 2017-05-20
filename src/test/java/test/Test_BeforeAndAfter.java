package test;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import ru.yandex.qatools.allure.annotations.Attachment;
import ru.yandex.qatools.allure.annotations.Step;

public class Test_BeforeAndAfter {

	WebDriver driver;
	WebDriverWait wait;
	private static final long VISIBILITY_TIMEOUT = 30;

	// ????????????????????????
	private final String URL = "https://www.google.com/";
	// ????????????????????????

	@Step("Method - openBrowserAndGetURL")
	private void openBrowserAndGetURL() {
		System.setProperty("webdriver.gecko.driver",
				"/Users/admin/Documents/DevS-iOS/tools/selenium/geckodriver/mozilla/geckodriver-v0.16.0/geckodriver");
		driver = new FirefoxDriver();
		wait = new WebDriverWait(driver, VISIBILITY_TIMEOUT);
		driver.get(URL);
	}

	@Step("Method - goToCalc")
	private void goToCalc() {
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("lst-ib")))).sendKeys("2+2" + Keys.ENTER);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("_fZl")))).click();

		try {
			Thread.sleep(2000);
		} catch (Exception e) {
			// wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//button[@class
			// = 'lsb']")))).click();
		}
	}

	@Step("@BeforeMethod - This method would execute once the test would complete")
	@BeforeMethod // This method would execute once the test would complete
	public void setUpBeforeMethod() {
		openBrowserAndGetURL();
	}

	//////////////////////////////////////////////////////////////
	//////////////////////////////////////////////////////////////
	//////////////////////////////////////////////////////////////
	@Attachment(value = "--------", type = "image/png")
	public byte[] makeScreenShot() {
		return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
	}

	@Attachment(value = "{0}", type = "image/png")
	public byte[] makeScreenShot(String tmp) {
		return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
	}
	//////////////////////////////////////////////////////////////
	//////////////////////////////////////////////////////////////
	//////////////////////////////////////////////////////////////

	// @Step("@AfterMethod - This method would execute once after run")
	@AfterMethod // This method would execute once after run
	public void setDownAfterMethod() {
		driver.quit();
	}
}