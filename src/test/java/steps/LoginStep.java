package steps;

import base.BaseUtil;
import cucumber.api.DataTable;
import cucumber.api.Transform;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import model.User;
import org.junit.Assert;
import org.openqa.selenium.By;
import pages.LoginPage;
import transformation.EmailTransform;
import transformation.SalaryCountTranformer;

import java.util.List;

public class LoginStep extends BaseUtil {

    private BaseUtil base;

    public LoginStep(BaseUtil base) {
        this.base = base;
    }

    @Then("^I should see the userform page$")
    public void iShouldSeeTheUserformPage() throws Throwable {
        System.out.println("The driver is: " + base.getStepInfo());
        System.out.println("I should see userform page\n");

        Assert.assertEquals("It is not displayed", true, base.getWebDriver().findElement(By.id("Initial")).isDisplayed());
    }

    @Given("^I navigate to the login page$")
    public void iNavigateToTheLoginPage() throws Throwable {
        System.out.println("Navigate Login Page\n");
        base.getWebDriver().navigate().to("http://www.executeautomation.com/demosite/Login.html");
    }

    @And("^I enter the username as admin and password as admin$")
    public void iEnterTheUsernameAsAdminAndPasswordAsAdmin() throws Throwable {
        System.out.println("Enter username and password\n");

    }

    @And("^I click login button$")
    public void iClickLoginButton() throws Throwable {
        System.out.println("Click login button\n");

        //base.getWebDriver().findElement(By.name("Login")).submit();
        LoginPage page = new LoginPage(base.getWebDriver());
        page.clickLogin();
    }

    @And("^I enter the following Login$")
    public void iEnterTheFollowingLogin(DataTable table) throws Throwable {
/*        List<List<String>> data = table.raw();
        System.out.println(data.get(0).get(0));
        System.out.println(data.get(1).get(0));
        System.out.println(data.get(0).get(1));
        System.out.println(data.get(1).get(1)+"\n");*/

        List<User> users = table.asList(User.class);
//        users.stream().forEach(u -> System.out.println("User " + u.getUserName() + ", " + "Password " + u.getPassword()));
//        System.out.println("\n");

        LoginPage page = new LoginPage(base.getWebDriver());

        for(User user: users){
            System.out.println(user);

//            base.getWebDriver().findElement(By.name("UserName")).sendKeys(user.getUserName());
//            base.getWebDriver().findElement(By.name("Password")).sendKeys(user.getPassword());

            page.login(user.getUserName(), user.getPassword());
        }
    }

    @And("^I enter ([^\"]*) and ([^\"]*)$")
    public void iEnterUserNameAndPassword(String userName, String password) throws Throwable {
        System.out.println("Username: " + userName);
        System.out.println("Password: " + password);
        System.out.println("\n");
    }

    @And("^I enter the users email address as email:([^\"]*)$")
    public void iEnterTheUsersEmailAddressAsEmailAdmin(@Transform(EmailTransform.class) String email) throws Throwable {
        System.out.println("Email address is: " + email+"\n");
    }

    @And("^I verify the count of my salary digits for Rs (\\d+)$")
    public void iVerifyTheCountOfMySalaryDigitsForRs(@Transform(SalaryCountTranformer.class) int salary) throws Throwable {
        System.out.println("My salary digits count is: " +salary+"\n");
    }

}
