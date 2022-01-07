package co.com.client.webproject.test.controllers;

import co.com.client.webproject.test.page.LandingPageContactUs;
import co.com.client.webproject.test.page.LandingPageSignin;
import co.com.sofka.test.actions.WebAction;
import co.com.sofka.test.evidence.reports.Report;
import co.com.sofka.test.exceptions.WebActionsException;

public class ContactUsPageWebController {

    private WebAction webAction;

    public void setWebAction(WebAction webAction) {
        this.webAction = webAction;
    }

    public void irHaciaContactUsPage(){
        try{
            LandingPageContactUs landingPageContactUs = new LandingPageContactUs(webAction.getDriver());
            webAction.click(landingPageContactUs.getContactUs(), 2, true);
        } catch (WebActionsException e){
            Report.reportFailure("Ocurrio un error al intentar ir a la página de login.", e);
        }
    }
}
