package co.com.client.webproject.test.controllers;

import co.com.client.webproject.test.page.ConfirmacionCarritoCompraPage;
import co.com.client.webproject.test.page.ConfirmacionContactUsOkPage;
import co.com.sofka.test.actions.WebAction;
import co.com.sofka.test.evidence.reports.Report;
import co.com.sofka.test.exceptions.WebActionsException;

public class ConfirmacionContactUsOkController {
    private WebAction webAction;

    public void setWebAction(WebAction webAction) {
        this.webAction = webAction;
    }

    public String obtenerConfirmacionMensaje(){
        String usuario = "";
        try{
            ConfirmacionContactUsOkPage confirmacionContactUsOkPage = new ConfirmacionContactUsOkPage(webAction.getDriver());
            usuario = webAction.getText(confirmacionContactUsOkPage.getMensajeConfirmacion(), 2, true);

        } catch (WebActionsException e)
        {
            Report.reportFailure("Ocurrio un error al intentar validar el mensaje.", e);
        }

        return usuario;
    }
}
