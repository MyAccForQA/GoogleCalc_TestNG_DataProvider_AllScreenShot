package pom_pf;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.qatools.allure.annotations.Step;

public class HomePage {

	private WebDriver driver;
	private WebDriverWait wait;

	@FindBy(id = "lst-ib")
	private WebElement searchField;

	@FindBy(id = "_fZl")
	private WebElement searchButtn;

	public HomePage(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
		PageFactory.initElements(this.driver, this);
	}

	@Step("goTo_Calc")
	public void goTo_Calc() {
		// wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("lst-ib")))).sendKeys("2+2" + Keys.ENTER);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("lst-ib")))).sendKeys("2+2" + Keys.ENTER);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("_fZl")))).click();

		try {
			Thread.sleep(2000);
		} catch (Exception e) {
			// wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//button[@class
			// = 'lsb']")))).click();
		}
	}
}