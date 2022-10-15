import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TestPlan {
    private static final WebDriver driver = new ChromeDriver();

    @BeforeSuite
    public static void main(String[] args){
        System.setProperty("webdriver.chrome.driver", Utils.CHROME_DRIVER_LOCATION);
    }

    @Test(testName = "Caso 1: Intento de login sin nombre de usuario ni contrasena")
    public static void sinNombreDeUsuarioNiContra(){
        driver.get(Utils.BASE_URL);
        LoginForm loginForm = new LoginForm(driver);

        loginForm.pressLoginButton();

        Assert.assertEquals(loginForm.getEstado(), "Atención: Debe ingresar un nombre de usuario");
    }

    @Test(testName = "Caso 2: Intento de login sin contrasena")
    public static void sinContra(){
        driver.get(Utils.BASE_URL);
        LoginForm loginForm = new LoginForm(driver);

        loginForm.enterUsername("usuario");
        loginForm.pressLoginButton();

        Assert.assertEquals(loginForm.getEstado(), "Atención: El password no puede estar vacío");
    }

    @Test(testName = "Caso 3: Intento de login exitoso")
    public static void loginExitoso(){
        driver.get(Utils.BASE_URL);
        LoginForm loginForm = new LoginForm(driver);
        HomePage homePage = new HomePage(driver);

        loginForm.enterUsername("dumbridge");
        loginForm.enterPassword("tomriddle");
        loginForm.pressLoginButton();

        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

        Assert.assertEquals(homePage.getTitle(), "Bienvenido a OSTH On-Line");
    }

    @Test(testName = "Caso 4: Intento de login con contrasena incorrecta")
    public static void contraIncorrecta(){
        driver.get(Utils.BASE_URL);
        LoginForm loginForm = new LoginForm(driver);

        loginForm.enterUsername("dumbridge");
        loginForm.enterPassword("123");
        loginForm.pressLoginButton();

        Assert.assertEquals(loginForm.getEstado(), "Atención: El password ingresado no es válido");
    }

    @AfterSuite
    public static void cleanUp(){
        driver.manage().deleteAllCookies();
        driver.close();
    }
}
