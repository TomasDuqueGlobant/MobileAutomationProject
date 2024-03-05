package webdriverio.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import webdriverio.screens.HomeScreen;
import webdriverio.screens.SwipeScreen;
import webdriverio.utils.basetest.BaseTest;

public class SwipeTest extends BaseTest {

    @Test
    public void trySwipe(){
        HomeScreen homeScreen = getHomeScreen();

        SwipeScreen swipeScreen = homeScreen.openSwipeScreen();
        swipeScreen.swipeLeft();
        Assert.assertTrue(swipeScreen.isSecondCardDisplayed());
        Assert.assertTrue(swipeScreen.isFirstCardNotDisplayed());
        swipeScreen.swipeRight();
        Assert.assertTrue(swipeScreen.isFirstCardDisplayed());
        Assert.assertTrue(swipeScreen.isSecondCardNotDisplayed());
    }
}
