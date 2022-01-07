package co.com.client.webproject.test.stepdefinition;

import co.com.client.webproject.test.controllers.*;
import co.com.client.webproject.test.controllers.openwebpage.StartBrowserWebController;
import co.com.client.webproject.test.data.objects.TestInfo;
import co.com.sofka.test.actions.WebAction;
import co.com.sofka.test.evidence.reports.Assert;
import co.com.sofka.test.evidence.reports.Report;
import co.com.sofka.test.exceptions.WebActionsException;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Dado;
import cucumber.api.java.es.Entonces;
import org.assertj.core.api.Assertions;

public class ContactUsStepDefinition extends GeneralSetup{
    private WebAction webAction;
    //private Customer comprar;

    @Before
    public void setUp(Scenario scenario) {
        testInfo = new TestInfo(scenario);
        webAction = new WebAction(testInfo.getFeatureName());
        webAction.setScenario(testInfo.getScenarioName());
    }

    @Dado("el cliente se encuentra en la pagina de inicio para escribir a servicio al cliente")
    public void elClienteSeEncuentraEnLaPaginaDeInicioParaEscribirAServicioAlCliente() {
        try {
        StartBrowserWebController startBrowserWebController = new StartBrowserWebController();
        startBrowserWebController.setBrowser(browser());
        startBrowserWebController.setWebAction(webAction);
        startBrowserWebController.setFeature(testInfo.getFeatureName());
        startBrowserWebController.abrirTiendaOnline();

        ContactUsPageWebController contactUsPageWebController= new ContactUsPageWebController();
        contactUsPageWebController.setWebAction(webAction);
        contactUsPageWebController.irHaciaContactUsPage();
        }catch (Exception e){
            Assertions.fail("Error en la configuracion incial");}
    }

    @Cuando("el cliente realizara envia un mensaje para conocer ofertas adicionales")
    public void elClienteRealizaraEnviaUnMensajeParaConocerOfertasAdicionales() {
        try {

            ContactUsCustomerServiceController contactUsCustomerServiceController = new ContactUsCustomerServiceController();
            contactUsCustomerServiceController.setWebAction(webAction);
            contactUsCustomerServiceController.enviarUnMensajeServicioCliente();
            contactUsCustomerServiceController.getCustomer();
        }catch (Exception e){Assertions.fail("Error en el envio del mensaje");}

    }

    @Entonces("el cliente  debera ver que ha recibido el mensaje de confirmacion de confirmacion consulta a servicio al cliente")
    public void elClienteDeberaVerQueHaRecibidoElMensajeDeConfirmacionDeConfirmacionConsultaAServicioAlCliente() {
        try {
            ConfirmacionContactUsOkController confirmacionContactUsOkController = new ConfirmacionContactUsOkController();
            confirmacionContactUsOkController.setWebAction(webAction);

            Assert.Hard
                    .thatString(confirmacionContactUsOkController.obtenerConfirmacionMensaje())
                    .isEqualTo("Your message has been successfully sent to our team.");
        }catch (Exception e){Assertions.fail("Error en la validacion");}


    }
// Scenario 2
    @Dado("el cliente se encuentra en la pagina de inicio para escribir al administrador")
    public void elClienteSeEncuentraEnLaPaginaDeInicioParaEscribirAlAdministrador() {
        try{
        StartBrowserWebController startBrowserWebController = new StartBrowserWebController();
        startBrowserWebController.setBrowser(browser());
        startBrowserWebController.setWebAction(webAction);
        startBrowserWebController.setFeature(testInfo.getFeatureName());
        startBrowserWebController.abrirTiendaOnline();

        ContactUsPageWebController contactUsPageWebController= new ContactUsPageWebController();
        contactUsPageWebController.setWebAction(webAction);
        contactUsPageWebController.irHaciaContactUsPage();}
        catch (Exception e){Assertions.fail("Error en la configuracion incial");}

    }

    @Cuando("el cliente realizara el proceso para enviar un mensaje vacio")
    public void elClienteRealizaraElProcesoParaEnviarUnMensajeVacio() {
        try{
        ContactUsWebMasterController contactUsWebMasterController= new ContactUsWebMasterController();
        contactUsWebMasterController.setWebAction(webAction);
        contactUsWebMasterController.enviarUnMensajeWebMaster();
        contactUsWebMasterController.getCustomer();}catch (Exception e){
            Assertions.fail("Error en el envio del mensaje");}


    }

    @Entonces("el cliente  debera ver que ha recibido el mensaje de error")
    public void elClienteDeberaVerQueHaRecibidoElMensajeDeError() {
        try {

            ConfirmationContactUsFailController confirmationContactUsFailController = new ConfirmationContactUsFailController();
            confirmationContactUsFailController.setWebAction(webAction);

            Assert.Hard
                    .thatString(confirmationContactUsFailController.obtenerConfirmacionMensaje())
                    .isEqualTo("The message cannot be blank.");
        }catch (Exception e){Assertions.fail("Error en la validacion");}


    }

    @After
    public void tearDown3() throws WebActionsException {
        //webAction.pause(5, false);

        if (webAction != null && webAction.getDriver() != null)
            webAction.closeBrowser();

        Report.reportInfo("***** HA FINALIZADO LA PRUEBA******"
                .concat(testInfo.getFeatureName())
                .concat("-")
                .concat(testInfo.getScenarioName()));
    }

}
