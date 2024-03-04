package webdriverio.screens;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;
import webdriverio.utils.basescreen.BaseScreen;

public class HomeScreen extends BaseScreen {

    public HomeScreen(AndroidDriver driver) {
        super(driver);
    }

    @AndroidFindBy(accessibility = "Webview")
    private WebElement webView;

    public WebViewScreen openWebView(){
        webView.click();
        return new WebViewScreen(super.getDriver());
    }


}
