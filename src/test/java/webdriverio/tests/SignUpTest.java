package webdriverio.tests;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import webdriverio.screens.HomeScreen;
import webdriverio.screens.LoginScreen;
import webdriverio.utils.basetest.BaseTest;

public class SignUpTest extends BaseTest {

    @Test
    @Parameters({"email","password"})
    public void successfullySignUpTest(String email, String password){
        HomeScreen homeScreen = getHomeScreen();

        LoginScreen loginScreen = homeScreen.openLoginScreen();
        loginScreen.fillSignUpInputs(email,password);
        Assert.assertTrue(loginScreen.isSignUpSuccessful());
        loginScreen.clickOkPopUpBtn();

    }
}
