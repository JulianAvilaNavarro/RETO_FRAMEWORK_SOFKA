package co.com.client.webproject.test.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ConfirmacionCarritoCompraPage {

    @FindBy(xpath= "//*[@id=\"center_column\"]/div/p/strong")
    WebElement confirmacion;

    public WebElement getConfirmacion() {
        return confirmacion;
    }

    public ConfirmacionCarritoCompraPage(WebDriver webDriver) {
        PageFactory.initElements(webDriver, this);
    }
}
