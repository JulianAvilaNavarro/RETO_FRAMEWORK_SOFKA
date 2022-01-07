package co.com.client.webproject.test.controllers;

import co.com.client.webproject.test.page.ConfirmacionCarritoCompraPage;
import co.com.client.webproject.test.page.MyAccountPage;
import co.com.sofka.test.actions.WebAction;
import co.com.sofka.test.evidence.reports.Report;
import co.com.sofka.test.exceptions.WebActionsException;

public class ConfirmacionCompraCarritoController {

    private WebAction webAction;

    public void setWebAction(WebAction webAction) {
        this.webAction = webAction;
    }

    public String obtenerConfirmacionCompra(){
        String usuario = "";
        try{
            ConfirmacionCarritoCompraPage confirmacionCarritoCompraPage = new ConfirmacionCarritoCompraPage(webAction.getDriver());
            usuario = webAction.getText(confirmacionCarritoCompraPage.getConfirmacion(), 2, true);

        } catch (WebActionsException e)
        {
            Report.reportFailure("Ocurrio un error al intentar validar la compra.", e);
        }

        return usuario;
    }
}
