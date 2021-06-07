package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pageobjects.ProductsPage;
import pageobjects.LoginPage;

public class DefinicionDePasos extends BaseTest {
    private LoginPage loginPage = new LoginPage(driver);
    private ProductsPage productsPage = new ProductsPage(driver);

    @Given("el usuario abre la pagina de login")
    public void elUsuarioAbreLaPaginaDeLogin() {
        loginPage.goToPage();
        Assert.assertTrue("No se mostró la página de login", loginPage.isPage());
    }

    @When("el usuario ingresa credenciales correctas")
    public void elUsuarioIngresaCredencialesCorrectas() {
        String username = CONFIG.getString("username");
        String password = CONFIG.getString("password");
        loginPage.typeCredentials(username, password);
    }

    @And("el usuario hace click en Login")
    public void elUsuarioHaceClickEnLogin() {
        loginPage.clickLogin();
    }

    @Then("se muestra la pagina de productos")
    public void seMuestraLaPaginaDeProductos() {
        Assert.assertTrue("La pagina de productos no fue mostrada", productsPage.isPage());
    }

    @When("el usuario ingresa credenciales incorrectas")
    public void elUsuarioIngresaCredencialesIncorrectas() {
        String username = "usuario invalido";
        String password = "contraseña invalida";
        loginPage.typeCredentials(username, password);
    }

    @Then("se muestra un mensaje de error de credenciales")
    public void seMuestraUnMensajeDeErrorDeCredenciales() {
        Assert.assertTrue("El mensaje de error de logueo no fue mostrado", loginPage.isLoginErrorDisplayed());
    }

    @And("el mensaje de error contiene el texto {string}")
    public void elMensajeDeErrorContieneElTexto(String mensajeEsperado) {
        String mensajeMostrado = loginPage.getLoginErrorMessage();
        Assert.assertTrue("El mensaje de error no coincide", mensajeMostrado.contains(mensajeEsperado));
    }
}
