import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends PageObject{

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(tagName = "h3")
    private WebElement bienvenido_label;

    public String getTitle(){
        return this.bienvenido_label.getText();
    }


}
