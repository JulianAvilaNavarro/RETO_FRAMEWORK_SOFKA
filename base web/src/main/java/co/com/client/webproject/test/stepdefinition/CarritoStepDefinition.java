package co.com.client.webproject.test.stepdefinition;

import co.com.client.webproject.test.controllers.*;
import co.com.client.webproject.test.controllers.openwebpage.StartBrowserWebController;
import co.com.client.webproject.test.data.objects.TestInfo;
import co.com.client.webproject.test.models.Customer;
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

import static co.com.client.webproject.test.helpers.Dictionary.SPACE_STRING;

public class CarritoStepDefinition extends GeneralSetup{

    private WebAction webAction;
    //private Customer comprar;

    @Before
    public void setUp(Scenario scenario) {
        testInfo = new TestInfo(scenario);
        webAction = new WebAction(testInfo.getFeatureName());
        webAction.setScenario(testInfo.getScenarioName());
    }

    //Scenario 1
    @Dado("el cliente esta logeado esta en la pagina y desea compar un producto")
    public void elClienteEstaLogeadoEstaEnLaPaginaYDeseaComparUnProducto() {
        try {

        StartBrowserWebController startBrowserWebController = new StartBrowserWebController();
        startBrowserWebController.setBrowser(browser());
        startBrowserWebController.setWebAction(webAction);
        startBrowserWebController.setFeature(testInfo.getFeatureName());
        startBrowserWebController.abrirTiendaOnline();

        LoginPageWebController loginPageWebController = new LoginPageWebController();
        loginPageWebController.setWebAction(webAction);
        loginPageWebController.irHaciaLoginPage();

        CreateAnAccountWebController createAnAccountWebController = new CreateAnAccountWebController();
        createAnAccountWebController.setWebAction(webAction);
        createAnAccountWebController.crearUnaCuenta();
        createAnAccountWebController.getCustomer();}
        catch (Exception e){ Assertions.fail("Error en el logeo");}

    }

    @Cuando("el cliente entra a la categoria women y agrega un producto")
    public void elClienteEntraALaCategoriaWomenYAgregaUnProducto() {
        try{
        CompraCarritoWomenController compraCarritoWomenController = new CompraCarritoWomenController();
        compraCarritoWomenController.setWebAction(webAction);
        compraCarritoWomenController.realizarUnaCompra();
        compraCarritoWomenController.getCustomer();}
        catch (Exception e){Assertions.fail("Error la compra del producto en Dresses");}

    }

    @Entonces("el cliente completa los pasos y debera ver el mensaje {string}")
    public void elClienteCompletaLosPasosYDeberaVerElMensaje(String mensajeConfirmacion) {
        try{

        ConfirmacionCompraCarritoController confirmacionCompraCarritoController = new ConfirmacionCompraCarritoController();
        confirmacionCompraCarritoController.setWebAction(webAction);

        Assert.Hard
                .thatString(confirmacionCompraCarritoController.obtenerConfirmacionCompra())
                .isEqualTo(mensajeConfirmacion);}
        catch (Exception e){Assertions.fail("Error en la validacion de compra");}

    }
    //Scenario 2

    @Dado("el cliente esta logeado esta en la pagina y desea compar dos productos")
    public void elClienteEstaLogeadoEstaEnLaPaginaYDeseaComparDosProductos() {
        try{
        StartBrowserWebController startBrowserWebController = new StartBrowserWebController();
        startBrowserWebController.setBrowser(browser());
        startBrowserWebController.setWebAction(webAction);
        startBrowserWebController.setFeature(testInfo.getFeatureName());
        startBrowserWebController.abrirTiendaOnline();

        LoginPageWebController loginPageWebController = new LoginPageWebController();
        loginPageWebController.setWebAction(webAction);
        loginPageWebController.irHaciaLoginPage();

        CreateAnAccountWebController createAnAccountWebController = new CreateAnAccountWebController();
        createAnAccountWebController.setWebAction(webAction);
        createAnAccountWebController.crearUnaCuenta();
        createAnAccountWebController.getCustomer();}
        catch (Exception e){Assertions.fail("Error en el logeo");}


    }

    @Cuando("el usuario entra a dresses y agrega dos productos")
    public void elUsuarioEntraADressesYAgregaDosProductos() {
        try{

        CompraCarritoDressesController compraCarritoDressesController = new CompraCarritoDressesController();
        compraCarritoDressesController.setWebAction(webAction);
        compraCarritoDressesController.realizarUnaCompra();
        compraCarritoDressesController.getCustomer();}
        catch (Exception e){Assertions.fail("Error la compra del producto en Dresses");}

    }

    @Entonces("el usuario completa la compra y deberia ver el mensaje {string}")
    public void elUsuarioCompletaLaCompraYDeberiaVerElMensaje(String mensajeConfirmacion) {
        try {
            ConfirmacionCompraCarritoController confirmacionCompraCarritoController = new ConfirmacionCompraCarritoController();
            confirmacionCompraCarritoController.setWebAction(webAction);

            Assert.Hard
                    .thatString(confirmacionCompraCarritoController.obtenerConfirmacionCompra())
                    .isEqualTo(mensajeConfirmacion);
        }catch (Exception e){Assertions.fail("Error en la validacion de compra");}

    }

    @After
    public void tearDown2() throws WebActionsException {
        //webAction.pause(4, false);

        if (webAction != null && webAction.getDriver() != null)
            webAction.closeBrowser();

        Report.reportInfo("***** HA FINALIZADO LA PRUEBA******"
                .concat(testInfo.getFeatureName())
                .concat("-")
                .concat(testInfo.getScenarioName()));
    }
}
