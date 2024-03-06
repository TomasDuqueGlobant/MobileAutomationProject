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
        swipeScreen.swipeRight();
        Assert.assertTrue(swipeScreen.isFirstCardNotDisplayed());
        Assert.assertTrue(swipeScreen.isSecondCardDisplayed());
        swipeScreen.swipeToFurtherRightCard();
        Assert.assertTrue(swipeScreen.isLastCardDisplayed());
        Assert.assertTrue(swipeScreen.isSecondToLastCardNotDisplayed());
        swipeScreen.swipeToBottom();
        Assert.assertTrue(swipeScreen.isBottomPageTextDisplayed());
    }
}
