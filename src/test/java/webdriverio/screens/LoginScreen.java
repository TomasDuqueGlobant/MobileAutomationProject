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
    @AndroidFindBy(accessibility = "button-SIGN UP")
    private WebElement submitSignUpBtn;
    @AndroidFindBy(accessibility = "Forms")
    private WebElement formsBtn;
    @AndroidFindBy(id = "android:id/button1")
    private WebElement successfullySignedUpBtn;
    @AndroidFindBy(uiAutomator = "UiSelector().textContains(\"You successfully signed up!\")")
    private WebElement successfullySignedUpTitle;

    public boolean isLoginBtnDisplayed(){
        waitElementVisibility(submitLoginBtn);
        return submitLoginBtn.isDisplayed();
    }

    public boolean isSignUpSuccessful(){
        waitElementVisibility(successfullySignedUpTitle);
        return successfullySignedUpTitle.isDisplayed();
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
        waitElementVisibility(successfullySignedUpBtn);
        successfullySignedUpBtn.click();
    }


    public FormsScreen openFormsScreen(){
        formsBtn.click();
        return new FormsScreen(super.getDriver());
    }




}
