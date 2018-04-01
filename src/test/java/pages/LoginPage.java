package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    public LoginPage(WebDriver webDriver) {
        PageFactory.initElements(webDriver, this);
    }

    @FindBy(how = How.NAME, using = "UserName")
    private WebElement txtUserName;

    @FindBy(how = How.NAME, using = "Password")
    private WebElement txtPassword;

    @FindBy(how = How.NAME, using = "Login")
    private WebElement btnLogin;

    public void login(String userName, String password){
        System.out.println("LOGIN WITH USERNAME: "+userName + " and PASSWORD: " + password + "\n");
        txtUserName.sendKeys(userName);
        txtPassword.sendKeys(password);
    }

    public void clickLogin(){
        btnLogin.submit();
    }
}
