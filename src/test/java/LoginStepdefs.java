import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginStepdefs {

  //  WebDriver driver;
    String url = "https://www.saucedemo.com/";
    String username;

   // private WebDriver driver;
    public LoginStepdefs(){
        PageFactory.initElements(Hooks.driver, this);
       // driver = Hooks.driver;
    }
    @FindBy(css = ".error-message-container")
    private WebElement errorContainer;
    @FindBy(css = "#user-name")
    private WebElement userName;

    @FindBy(css = "#password")
    private WebElement pwd;

    @FindBy(id = "login-button")
    private WebElement loginButton;

    @Given("Je ouvre la page de authentification")
    public void jeOuvreLaPageDeAuthentification() {

        Hooks.driver.get(url);
    }

    @When("Je saisis le {string} dans le champs Username")
    public void jeSaisisLeDansLeChampsUsername(String username) {
        //driver.findElement(By.cssSelector("#user-name")).sendKeys(username);
        this.username= username;
        userName.sendKeys(username);
    }

    @And("Je saisis le {string} dans le champs Password")
    public void jeSaisisLeDansLeChampsPassword(String password) {
        pwd.sendKeys(password);
    }

    @And("Je clique sur le bouton Login")
    public void jeCliqueSurLeBoutonLogin() {
        loginButton.click();
    }

    @Then("Je verifie l echec de connexion")
    public void jeVerifieLEchecDeConnexion() {
        Assert.assertTrue(loginButton.isDisplayed());
        
    }

    @And("Je verifie l affcihage du message d erreur {string}")
    public void jeVerifieLAffcihageDuMessageDErreur(String arg0) {
        if (this.username.equals("locked_out_user")){
            Assert.assertEquals("", "Epic sadface: Sorry, this user has been locked out.", arg0);
        }
        else {
            Assert.assertEquals("", "Epic sadface: Username and password do not match any user in this service", arg0);
        }

    }
}
