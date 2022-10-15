import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginForm extends PageObject{

    public LoginForm(WebDriver driver) {
        super(driver);
    }

    @FindBy(id= "username")
    private WebElement username;

    @FindBy(id = "password")
    private WebElement password;

    @FindBy(tagName = "button")
    private WebElement loginButton;

    @FindBy(id = "estado")
    private WebElement estado;

    public void enterUsername(String username){
        this.username.sendKeys(username);
    }

    public void enterPassword(String password){
        this.password.sendKeys(password);
    }

    public void pressLoginButton(){
        this.loginButton.click();
    }

    public String getEstado(){
        return this.estado.getText();
    }
}
