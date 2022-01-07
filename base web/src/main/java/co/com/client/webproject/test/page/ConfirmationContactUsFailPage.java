package co.com.client.webproject.test.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ConfirmationContactUsFailPage {
    @FindBy(xpath= "//*[@id=\"center_column\"]/div/ol")
    WebElement mensajeConfirmacionFail;

    public WebElement getMensajeConfirmacionFail() {
        return mensajeConfirmacionFail;
    }

    public ConfirmationContactUsFailPage(WebDriver webDriver) {
        PageFactory.initElements(webDriver, this);
    }
}
