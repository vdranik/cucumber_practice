package steps;

import base.BaseUtil;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.chrome.ChromeDriver;

public class Hook extends BaseUtil{

    private BaseUtil base;

    public Hook(BaseUtil base) {
        this.base = base;
    }

    @Before
    public void initializeTest(){
        System.out.println("++++++Opening the browser\n");

        //Passing a dummy webdriver instance
        base.setStepInfo("Chrome driver");
        ClassLoader classLoader = getClass().getClassLoader();
        String path  = classLoader.getResource("chromedriver.exe").getPath();
        System.setProperty("webdriver.chrome.driver",path);
        //DI simulation
        base.setWebDriver(new ChromeDriver());
    }

    @After
    public void tearDownTest(Scenario scenario){
        if(scenario.isFailed()){
            //Take screenshot
            System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!"+scenario.getName());
        }
        System.out.println("++++++Closing the browser\n\n");
    }
}
