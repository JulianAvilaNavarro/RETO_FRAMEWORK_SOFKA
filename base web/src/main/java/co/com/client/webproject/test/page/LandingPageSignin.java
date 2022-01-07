package co.com.client.webproject.test.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPageSignin {

    @CacheLookup
    @FindBy(css = ".login")
    WebElement signIn;

    public WebElement getSignIn() {
        return signIn;
    }

    public LandingPageSignin(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

}
