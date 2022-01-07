package co.com.client.webproject.test.controllers;

import co.com.client.webproject.test.models.Customer;
import co.com.client.webproject.test.page.CompraCarritoPage;
import co.com.sofka.test.actions.WebAction;
import co.com.sofka.test.evidence.reports.Report;
import co.com.sofka.test.exceptions.WebActionsException;

public class CompraCarritoDressesController {

    private WebAction webAction;
    private Customer customer;

    public Customer getCustomer() {
        return customer;
    }

    public void setWebAction(WebAction webAction) {
        this.webAction = webAction;
    }

    public void realizarUnaCompra(){
        try{


            CompraCarritoPage compraCarritoPage = new CompraCarritoPage(webAction.getDriver());
            webAction.click(compraCarritoPage.getDRESSES(), 2, true);
            webAction.scroll(800);
            webAction.click(compraCarritoPage.getVESTIDO1(), 2, true);
            webAction.click(compraCarritoPage.getANADIR(), 2, true);
            webAction.click(compraCarritoPage.getCARRITO(), 3, true);
            webAction.click(compraCarritoPage.getPROCEED(), 3, true);
            webAction.click(compraCarritoPage.getPROCEED_NEXT(), 2, true);
            webAction.scroll(700);
            webAction.click(compraCarritoPage.getPROCEED_NEXT_NEXT(), 2, true);
            webAction.click(compraCarritoPage.getTERMS(), 2, true);
            webAction.scroll(700);
            webAction.click(compraCarritoPage.getPROCEED_NEXT_NEXT_NEXT(), 2, true);
            webAction.click(compraCarritoPage.getBANK(), 2, true);
            webAction.click(compraCarritoPage.getFINAL_PROCEED(), 2, true);


        } catch (WebActionsException e)
        {
            Report.reportFailure("Ocurrio un error al intentar comprar el producto.", e);
        }
    }
}
