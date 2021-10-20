package tesPackageShaft;

import com.shaft.driver.DriverFactory;
import com.shaft.gui.browser.BrowserActions;
import com.shaft.gui.element.ElementActions;
import com.shaft.validation.Validations;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Test1 {
    private WebDriver driver;

    @Test
    public void Test11() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.navigate().to("https://www.google.com/");
        By googleLogo = By.xpath("//img[@alt = 'Google']");
        boolean isGoogleLogoDisplayed = driver.findElement(googleLogo).isDisplayed();
        Assert.assertTrue(isGoogleLogoDisplayed);
        driver.quit();
    }

    @Test
    public void test2() {
        By googleLogo = By.xpath("//img[@alt = 'Google']");
        Validations.assertThat().element(driver, googleLogo).exists().withCustomReportMessage("AssertGoogleLogo").perform();
    }

    @Test
    public void test3() {
        By Search_Box = By.name("q");
        By Result_test = By.xpath("//*[@id= 'result-stats']");
        (new ElementActions(driver)).type(Search_Box, "Shaft_Engien").keyPress(Search_Box, Keys.ENTER);
        Validations.assertThat().element(driver, Result_test).text().doesNotEqual("").withCustomReportMessage("Search Text is no tEmpty").perform();
    }

    @BeforeMethod
    public void beforeMethod() {
        driver = DriverFactory.getDriver();
        BrowserActions.navigateToURL(driver, "https://www.google.com/");
    }

    @AfterMethod
    public void afterMethod() {
        BrowserActions.closeCurrentWindow(driver);

    }
}
