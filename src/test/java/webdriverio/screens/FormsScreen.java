package webdriverio.screens;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;
import webdriverio.utils.basescreen.BaseScreen;

public class FormsScreen extends BaseScreen {

    public FormsScreen(AndroidDriver driver) {
        super(driver);
    }

    @AndroidFindBy(uiAutomator = "UiSelector().textContains(\"Form components\")")
    private WebElement formsTitle;
    @AndroidFindBy(accessibility = "Swipe")
    private WebElement swipeBtn;

    public boolean isFormsTitleDisplayed(){
        waitElementVisibility(formsTitle);
        return formsTitle.isDisplayed();
    }

    public SwipeScreen openSwipeScreen(){
        swipeBtn.click();
        return new SwipeScreen(super.getDriver());
    }

}
