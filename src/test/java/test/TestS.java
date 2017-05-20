package test;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pom_pf.HomePage;
import pom_pf.CalcPage;
import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.Title;

@Title("TestS_Start")
@Description("Description")
public class TestS extends Test_BeforeAndAfter {

	// #1
	@Title("test_HP_Title")
	@Test(groups = { "ff", "ok" })
	public void test_HP_Title() {

		// ????????????????????????
		String exp = "Google";
		// ????????????????????????
		try {
			String act = driver.getTitle();

			// Assert.assertEquals(actual, expected, message);
			Assert.assertEquals(act, exp, String.format("Message - Error must be - '%s'", exp));
		} finally {
			// in any case
			makeScreenShot("test_HP_Title - " + exp);
		}
	}

	// #2
	@Title("test_HP_ToGo_freeTrial")
	@Test(groups = { "ff", "ok" })
	public void test_HP_ToGo_Calc() {

		// ????????????????????????
		String exp = "2+2 - Google Search";
		// ????????????????????????
		try {
			new HomePage(driver, wait).goTo_Calc();

			String act = driver.getTitle();

			// Assert.assertEquals(actual, expected, message);
			Assert.assertEquals(act, exp, String.format("Message - Error must be - '%s'", exp));
		} finally {
			// in any case
			makeScreenShot("test_HP_ToGo_freeTrial " + exp);
		}
	}

	@DataProvider(name = "CalcAdd")
	public static String[][] calcAdd() {
		String[][] str = { { "1", "1", "2" }, { "123", "123", "246" } };
		return str;
	}

	// #3
	@Title("test_HP_ToGo_Calc_Add")
	@Test(groups = { "ff", "ok" }, dataProvider = "CalcAdd")
	public void test_HP_ToGo_Calc_Add(String x, String y, String must) {

		String exp = must;
		try {
			new HomePage(driver, wait).goTo_Calc();

			CalcPage calc = new CalcPage(driver, wait);
			calc.clickButton(x);
			calc.clickButton("+");
			calc.clickButton(y);
			calc.clickButton("=");

			String act = calc.find_cwos();

			// Assert.assertEquals(actual, expected, message);
			Assert.assertEquals(act, exp, String.format("Message - Error must be - '%s'", exp));
		} finally {
			// in any case
			makeScreenShot("test_HP_ToGo_LogIn_WrongEmail_ErrorValid - " + x + ":" + y + " = " + exp);
		}
	}

	@DataProvider(name = "CalcSub")
	public static String[][] calcSub() {
		String[][] str = { { "3", "1", "2" }, { "369", "123", "246" } };
		return str;
	}

	// #4
	@Title("test_HP_ToGo_Calc_Sub")
	@Test(groups = { "ff", "ok" }, dataProvider = "CalcSub")
	public void test_HP_ToGo_Calc_Sub(String x, String y, String must) {

		String exp = must;
		try {
			new HomePage(driver, wait).goTo_Calc();

			CalcPage calc = new CalcPage(driver, wait);
			calc.clickButton(x);
			calc.clickButton("−");
			calc.clickButton(y);
			calc.clickButton("=");

			String act = calc.find_cwos();

			// Assert.assertEquals(actual, expected, message);
			Assert.assertEquals(act, exp, String.format("Message - Error must be - '%s'", exp));
		} finally {
			// in any case
			makeScreenShot("test_HP_ToGo_LogIn_WrongPass_ErrorValid - " + x + ":" + y + " = " + exp);
		}
	}

}