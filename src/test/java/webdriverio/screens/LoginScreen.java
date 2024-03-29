package webdriverio.screens;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;
import webdriverio.utils.basescreen.BaseScreen;

public class LoginScreen extends BaseScreen {

    public LoginScreen(AndroidDriver driver) {
        super(driver);
    }
    private int cont = 0;

    @AndroidFindBy(accessibility = "input-email")
    private WebElement inputEmail;
    @AndroidFindBy(accessibility = "input-password")
    private WebElement inputPassword;
    @AndroidFindBy(accessibility = "input-repeat-password")
    private WebElement inputRepeatPassword;
    @AndroidFindBy(accessibility = "button-LOGIN")
    private WebElement submitLoginBtn;
    @AndroidFindBy(accessibility = "button-sign-up-container")
    private WebElement openSignUpFormBtn;
    @AndroidFindBy(accessibility = "button-login-container")
    private WebElement openLoginFormBtn;
    @AndroidFindBy(accessibility = "button-SIGN UP")
    private WebElement submitSignUpBtn;
    @AndroidFindBy(accessibility = "Forms")
    private WebElement formsBtn;
    @AndroidFindBy(id = "android:id/button1")
    private WebElement okPopUpBtn;
    @AndroidFindBy(uiAutomator = "UiSelector().textContains(\"You successfully signed up!\")")
    private WebElement successfullySignedUpTitle;

    @AndroidFindBy(uiAutomator = "UiSelector().textContains(\"You are logged in!\")")
    private WebElement successfullyLoginTitle;

    public boolean isLoginBtnDisplayed(){
        waitElementVisibility(submitLoginBtn);
        return submitLoginBtn.isDisplayed();
    }

    public boolean isSignUpSuccessful(){
        waitElementVisibility(successfullySignedUpTitle);
        return successfullySignedUpTitle.isDisplayed();
    }

    public boolean isLoginSuccessful(){
        waitElementVisibility(successfullyLoginTitle);
        return successfullyLoginTitle.isDisplayed();
    }

    public void clickOkPopUpBtn(){
        waitElementVisibility(okPopUpBtn);
        okPopUpBtn.click();
    }
    public void fillSignUpInputs(String email,String password){
        openSignUpFormBtn.click();
        inputEmail.click();
        inputEmail.sendKeys(cont + email);
        //cont helps to create unique emails for simulating different emails in order to execute the test multiple times
        cont += 1;
        inputPassword.click();
        inputPassword.sendKeys(password);
        inputRepeatPassword.click();
        inputRepeatPassword.sendKeys(password);
        submitSignUpBtn.click();

    }
    public void fillLoginInputs(String email,String password){
        openLoginFormBtn.click();
        inputEmail.click();
        inputEmail.sendKeys( email);
        inputPassword.click();
        inputPassword.sendKeys(password);
        submitLoginBtn.click();
    }


    public FormsScreen openFormsScreen(){
        formsBtn.click();
        return new FormsScreen(super.getDriver());
    }




}
