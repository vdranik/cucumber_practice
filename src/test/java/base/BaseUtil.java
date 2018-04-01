package base;

import org.openqa.selenium.WebDriver;

public class BaseUtil {

    private String stepInfo;
    private WebDriver webDriver;

    public WebDriver getWebDriver() {
        return webDriver;
    }

    public void setWebDriver(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public String getStepInfo() {
        return stepInfo;
    }

    public void setStepInfo(String stepInfo) {
        this.stepInfo = stepInfo;
    }
}
