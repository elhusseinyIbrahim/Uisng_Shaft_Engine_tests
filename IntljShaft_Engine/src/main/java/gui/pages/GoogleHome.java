package gui.pages;

import com.shaft.gui.browser.BrowserActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GoogleHome {
    // variables
    private WebDriver driver;
    private final String url = "https://www.google.com/";

    // locators
    By googleLogo = By.xpath("//img[@alt = 'Google']");
    By Search_Box = By.name("q");


    //constructors
    public  GoogleHome(WebDriver driver){
        this.driver = driver;

    }
    //Keywords
    public void navgatieToGoogle (){
        BrowserActions.navigateToURL(driver, url);
    }


}
