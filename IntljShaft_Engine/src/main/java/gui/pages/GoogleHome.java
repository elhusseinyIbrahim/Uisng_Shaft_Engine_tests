package gui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GoogleHome {
    // variables
    private WebDriver driver;

    // locators
    By googleLogo = By.xpath("//img[@alt = 'Google']");
    By Search_Box = By.name("q");

    //constructors
    public void GoogleHome(WebDriver driver){
        this.driver = driver;

    }
    //Keywords


}
