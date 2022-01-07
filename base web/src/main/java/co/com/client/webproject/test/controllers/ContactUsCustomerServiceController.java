package co.com.client.webproject.test.controllers;

import co.com.client.webproject.test.models.Customer;
import co.com.client.webproject.test.page.CompraCarritoPage;
import co.com.client.webproject.test.page.ContactUsPage;
import co.com.sofka.test.actions.WebAction;
import co.com.sofka.test.evidence.reports.Report;
import co.com.sofka.test.exceptions.WebActionsException;

import static co.com.client.webproject.test.helpers.Dictionary.*;
import static co.com.client.webproject.test.helpers.Helper.generateCustomer;

public class ContactUsCustomerServiceController {

    private WebAction webAction;
    private Customer customer;

    public Customer getCustomer() {
        return customer;
    }

    public void setWebAction(WebAction webAction) {
        this.webAction = webAction;
    }

    public void enviarUnMensajeServicioCliente(){
        try{
            customer = generateCustomer(SPANISH_CODE_LANGUAGE, COUNTRY_CODE, EMAIL_DOMAIN);
            ContactUsPage contactUsPage = new ContactUsPage(webAction.getDriver());
            webAction.click(contactUsPage.getSubjectHeadingCustumer(), 2, true);
            webAction.sendText(contactUsPage.getEmail(), customer.getEmail(), true);
            webAction.sendText(contactUsPage.getOrderReference(), customer.getPassword(), true);
            webAction.sendText(contactUsPage.getMessage(), customer.getAddress(), true);
            webAction.click(contactUsPage.getSubmitMessageBotton(), 2, true);


        } catch (WebActionsException e)
        {
            Report.reportFailure("Ocurrio un error al intentar enviar el mensaje.", e);
        }
    }


}
