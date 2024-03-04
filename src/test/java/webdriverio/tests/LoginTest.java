package webdriverio.tests;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import webdriverio.screens.HomeScreen;
import webdriverio.screens.LoginScreen;
import webdriverio.utils.basetest.BaseTest;

public class LoginTest extends BaseTest {

    @Test
    @Parameters({"email","password"})
    public void successfullyLogin(String email, String password){
        HomeScreen homeScreen = getHomeScreen();

        LoginScreen loginScreen = homeScreen.openLoginScreen();
        loginScreen.fillSignUpInputs(email,password);
        loginScreen.clickOkPopUpbtn();
        loginScreen.fillLoginInputs(email,password);
        Assert.assertTrue(loginScreen.isLoginSuccessful());
        loginScreen.clickOkPopUpbtn();

    }
}
