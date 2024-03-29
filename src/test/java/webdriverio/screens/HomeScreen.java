package webdriverio.screens;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.checkerframework.checker.units.qual.A;
import org.openqa.selenium.WebElement;
import webdriverio.utils.basescreen.BaseScreen;

public class HomeScreen extends BaseScreen {

    public HomeScreen(AndroidDriver driver) {
        super(driver);
    }

    @AndroidFindBy(accessibility = "Webview")
    private WebElement webView;

    @AndroidFindBy(accessibility = "Login")
    private WebElement loginBtn;

    @AndroidFindBy(accessibility = "Swipe")
    private WebElement swipeBtn;

    public WebViewScreen openWebViewScreen(){
        webView.click();
        return new WebViewScreen(super.getDriver());
    }

    public LoginScreen openLoginScreen(){
        loginBtn.click();
        return new LoginScreen(super.getDriver());
    }

    public SwipeScreen openSwipeScreen(){
        swipeBtn.click();
        return new SwipeScreen(super.getDriver());
    }


}
