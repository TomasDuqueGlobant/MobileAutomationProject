package webdriverio.screens;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;
import webdriverio.utils.basescreen.BaseScreen;

public class LoginScreen extends BaseScreen {

    public LoginScreen(AndroidDriver driver) {
        super(driver);
    }

    @AndroidFindBy(accessibility = "input-email")
    private WebElement inputEmail;
    @AndroidFindBy(accessibility = "input-password")
    private WebElement inputPassword;
    @AndroidFindBy(accessibility = "input-repeat-password")
    private WebElement inputRepeatPassword;
    @AndroidFindBy(accessibility = "button-LOGIN")
    private WebElement loginBtn;
    @AndroidFindBy(accessibility = "button-sign-up-container")
    private WebElement signinBtn;

    @AndroidFindBy(accessibility = "Forms")
    private WebElement formsBtn;


    public boolean isLoginBtnDisplayed(){
        waitElementVisibility(loginBtn);
        return loginBtn.isDisplayed();
    }


    public FormsScreen openFormsScreen(){
        formsBtn.click();
        return new FormsScreen(super.getDriver());
    }




}
