package co.com.client.webproject.test.controllers;

import co.com.client.webproject.test.models.Customer;
import co.com.client.webproject.test.page.ContactUsPage;
import co.com.sofka.test.actions.WebAction;
import co.com.sofka.test.evidence.reports.Report;
import co.com.sofka.test.exceptions.WebActionsException;

import static co.com.client.webproject.test.helpers.Dictionary.*;
import static co.com.client.webproject.test.helpers.Helper.generateCustomer;

public class ContactUsWebMasterController {

    private WebAction webAction;
    private Customer customer;

    public Customer getCustomer() {
        return customer;
    }

    public void setWebAction(co.com.sofka.test.actions.WebAction webAction) {
        this.webAction = webAction;
    }

    public void enviarUnMensajeWebMaster(){
        try{
            customer = generateCustomer(SPANISH_CODE_LANGUAGE, COUNTRY_CODE, EMAIL_DOMAIN);
            ContactUsPage contactUsPage = new ContactUsPage(webAction.getDriver());
            webAction.click(contactUsPage.getSubjectHeadingWebMaster(), 2, true);
            webAction.sendText(contactUsPage.getEmail(), customer.getEmail(), true);
            webAction.sendText(contactUsPage.getOrderReference(), customer.getPassword(), true);
            webAction.click(contactUsPage.getSubmitMessageBotton(), 2, true);
        } catch (WebActionsException e)
        {
            Report.reportFailure("Ocurrio un error al intentar enviar el mensaje.", e);
        }
    }

}
