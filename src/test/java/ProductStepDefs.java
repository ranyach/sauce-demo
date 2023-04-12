import cucumber.api.java.en.Then;
import org.openqa.selenium.support.PageFactory;

public class ProductStepDefs {

    public ProductStepDefs(){
        PageFactory.initElements(Hooks.driver, this);
    }
    @Then("Authentification avec succès")
    public void authentificationAvecSuccès() {
    }
}
