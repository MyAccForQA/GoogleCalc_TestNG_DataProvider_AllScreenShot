package pom_pf;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.qatools.allure.annotations.Step;

public class CalcPage {

	private WebDriver driver;
	private WebDriverWait wait;

	@FindBy(id = "cwos")
	private WebElement cwos;

	public CalcPage(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
		PageFactory.initElements(this.driver, this);
	}

	@Step("clickButton String num = [{0}]")
	public void clickButton(final String num) {
		if (num != null) {
			char[] ch = num.toCharArray();
			for (char c : ch)
				clickButton(c);
		}
		if (num.equals("="))
			try {
				Thread.sleep(500);
			} catch (Exception e) {
			}
	}

	@Step("clickButton char num = [{0}]")
	public void clickButton(final char num) {
		String number = String.format("//span[@class = 'cwbts' and contains(text(), '%s')]", String.valueOf(num));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(number))).click();
	}

	@Step("clickButton int num = [{0}]")
	public void clickButton(final int num) {
		clickButton(String.valueOf(num));
	}

	@Step("clickButton long num = [{0}]")
	public void clickButton(final long num) {
		clickButton(String.valueOf(num));
	}

	@Step("clickButton float num = [{0}]")
	public void clickButton(final float num) {
		clickButton(String.valueOf(num));
	}

	@Step("find_cwos")
	public String find_cwos() {
		return wait.until(ExpectedConditions.visibilityOf(cwos)).getText();
	}
}