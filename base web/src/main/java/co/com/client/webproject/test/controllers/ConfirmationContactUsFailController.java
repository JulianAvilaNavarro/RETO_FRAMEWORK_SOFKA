package co.com.client.webproject.test.controllers;

import co.com.client.webproject.test.page.ConfirmacionContactUsOkPage;
import co.com.client.webproject.test.page.ConfirmationContactUsFailPage;
import co.com.sofka.test.actions.WebAction;
import co.com.sofka.test.evidence.reports.Report;
import co.com.sofka.test.exceptions.WebActionsException;

public class ConfirmationContactUsFailController {
    private WebAction webAction;

    public void setWebAction(WebAction webAction) {
        this.webAction = webAction;
    }

    public String obtenerConfirmacionMensaje(){
        String usuario = "";
        try{
            ConfirmationContactUsFailPage confirmationContactUsFailPage = new ConfirmationContactUsFailPage(webAction.getDriver());
            usuario = webAction.getText(confirmationContactUsFailPage.getMensajeConfirmacionFail(), 2, true);

        } catch (WebActionsException e)
        {
            Report.reportFailure("Ocurrio un error al intentar validar el mensaje.", e);
        }

        return usuario;
    }
}
