package webdriverio.screens;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import webdriverio.utils.basescreen.BaseScreen;

public class WebViewScreen extends BaseScreen {

    public WebViewScreen(AndroidDriver driver) {
        super(driver);
    }

    @AndroidFindBy(accessibility = "Get Started")
    private WebElement getStartedBtn;
    @AndroidFindBy(uiAutomator="UiSelector().className(android.widget.Button)")
    private WebElement crossBtn;
    @AndroidFindBy(accessibility = "Login")
    private WebElement login;

    public void closeBanner(){
        crossBtn.click();

    }

    public boolean isWebviewDisplayed(){
        waitElementVisibility(getStartedBtn);
        return getStartedBtn.isDisplayed();
    }

    public LoginScreen openLogin(){
        login.click();
        return new LoginScreen(super.getDriver());
    }
}
