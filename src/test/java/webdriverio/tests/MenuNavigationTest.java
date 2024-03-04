package webdriverio.tests;

import io.appium.java_client.android.AndroidDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import webdriverio.screens.*;
import webdriverio.utils.basetest.BaseTest;

public class MenuNavigationTest extends BaseTest {


    @Test
    public void tryMenuNavigation(){
        HomeScreen homescreen = getHomeScreen();

        WebViewScreen webViewScreen = homescreen.openWebView();
        webViewScreen.closeBanner();
        Assert.assertTrue(webViewScreen.isWebviewDisplayed());

        LoginScreen loginScreen = webViewScreen.openLogin();
        Assert.assertTrue(loginScreen.isLoginBtnDisplayed());

        FormsScreen formsScreen = loginScreen.openFormsScreen();
        Assert.assertTrue(formsScreen.isFormsTitleDisplayed());

        SwipeScreen swipeScreen = formsScreen.openSwipeScreen();
        Assert.assertTrue(swipeScreen.isSwipeTitleDisplayed());

        DragScreen dragScreen = swipeScreen.openDragScreen();
        Assert.assertTrue(dragScreen.isDragTitleDisplayed());

    }

}
