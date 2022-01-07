package co.com.client.webproject.test.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ConfirmacionContactUsOkPage {
    @FindBy(xpath= "//*[@id=\"center_column\"]/p")

    WebElement mensajeConfirmacion;

    public WebElement getMensajeConfirmacion() {
        return mensajeConfirmacion;
    }

    public ConfirmacionContactUsOkPage(WebDriver webDriver) {
        PageFactory.initElements(webDriver, this);
    }
}
