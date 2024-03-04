package webdriverio.screens;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.checkerframework.checker.units.qual.A;
import org.openqa.selenium.WebElement;
import webdriverio.utils.basescreen.BaseScreen;

public class SwipeScreen extends BaseScreen {

    public SwipeScreen(AndroidDriver driver) {
        super(driver);
    }

    @AndroidFindBy(uiAutomator = "UiSelector().textContains(\"Swipe horizontal\")")
    private WebElement swipeTitle;

    @AndroidFindBy(accessibility = "Drag")
    private WebElement dragBtn;


    public boolean isSwipeTitleDisplayed(){
        waitElementVisibility(swipeTitle);
        return swipeTitle.isDisplayed();
    }

    public DragScreen openDragScreen(){
        dragBtn.click();
        return new DragScreen(super.getDriver());
    }

}
