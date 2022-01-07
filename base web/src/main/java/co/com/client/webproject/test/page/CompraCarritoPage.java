package co.com.client.webproject.test.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CompraCarritoPage {

    @CacheLookup
    @FindBy(xpath = "//*[@id=\"block_top_menu\"]/ul/li[1]/a")
    WebElement WOMEN;

    @CacheLookup
    @FindBy(xpath = "//*[@id=\"block_top_menu\"]/ul/li[2]/a")
    WebElement DRESSES;


    @CacheLookup
    @FindBy(xpath = " //*[@id=\"center_column\"]/ul/li[1]/div/div[2]/h5/a")
    WebElement VESTIDO1;

    @CacheLookup
    @FindBy(xpath = " //*[@id=\"quantity_wanted_p\"]/a[2]/span")
    WebElement ANADIR;

    @CacheLookup
    @FindBy(xpath = "subcategories")
    WebElement SUBCATEGORIAS;

    @CacheLookup
    @FindBy(xpath = "//*[@id=\"center_column\"]/ul/li[1]/div/div[2]/h5/a")
    WebElement ROPA_WOMEN;

    @CacheLookup
    @FindBy(id = "add_to_cart")
    WebElement CARRITO;


    @CacheLookup
    @FindBy(xpath = "//*[@id=\"layer_cart\"]/div[1]/div[2]/div[4]/a")
    WebElement PROCEED;

    @CacheLookup
    @FindBy(xpath = "//*[@id=\"layer_cart\"]/div[1]/div[2]/div[4]/span")
    WebElement CONTINUE_SHOPPING;



    @CacheLookup
    @FindBy(xpath = "//*[@id=\"center_column\"]/p[2]/a[1]")
    WebElement PROCEED_NEXT;

    @CacheLookup
    @FindBy(xpath = "//*[@id=\"center_column\"]/form/div/p/a")
    WebElement ADD_NEW_ADDRESS;

    @CacheLookup
    @FindBy(xpath = "//*[@id=\"center_column\"]/form/p/button")
    WebElement PROCEED_NEXT_NEXT;

    @CacheLookup
    @FindBy(id= "uniform-cgv")
    WebElement TERMS;

    @CacheLookup
    @FindBy(xpath = "/html/body/div/div[2]/div/div[3]/div/div/form/p/button/span")
    WebElement PROCEED_NEXT_NEXT_NEXT;



    @CacheLookup
    @FindBy(xpath = "//*[@id=\"order_step\"]/li[1]/a")
    WebElement STEPS;

    @CacheLookup
    @FindBy(className = "bankwire")
    WebElement BANK;

    @CacheLookup
    @FindBy(xpath = "//*[@id=\"cart_navigation\"]/button")
    WebElement FINAL_PROCEED;




    public WebElement getWOMEN() {
        return WOMEN;
    }
    public WebElement getSUBCATEGORIAS() {
        return SUBCATEGORIAS;
    }

    public WebElement getROPA_WOMEN() {
        return ROPA_WOMEN;
    }


    public WebElement getDRESSES() {
        return DRESSES;
    }
    public WebElement getVESTIDO1() {
        return VESTIDO1;
    }

    public WebElement getANADIR() {
        return ANADIR;
    }

    public WebElement getCONTINUE_SHOPPING() {
        return CONTINUE_SHOPPING;
    }


    public WebElement getCARRITO() {
        return CARRITO;
    }
    public WebElement getPROCEED() {
        return PROCEED;
    }
    public WebElement getPROCEED_NEXT() {
        return PROCEED_NEXT;
    }
    public WebElement getADD_NEW_ADDRESS() {
        return ADD_NEW_ADDRESS;
    }
    public WebElement getPROCEED_NEXT_NEXT() {
        return PROCEED_NEXT_NEXT;
    }
    public WebElement getTERMS() {
        return TERMS;
    }
    public WebElement getPROCEED_NEXT_NEXT_NEXT() {
        return PROCEED_NEXT_NEXT_NEXT;
    }
    public WebElement getSTEPS() {
        return STEPS;
    }
    public WebElement getBANK() {
        return BANK;
    }
    public WebElement getFINAL_PROCEED() {
        return FINAL_PROCEED;
    }


    public CompraCarritoPage(WebDriver webDriver) {
        PageFactory.initElements(webDriver, this);
    }
}
