package webdriverio.screens;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;
import webdriverio.utils.basescreen.BaseScreen;

public class DragScreen extends BaseScreen {
    public DragScreen(AndroidDriver driver) {
        super(driver);
    }

    @AndroidFindBy(uiAutomator = "UiSelector().textContains(\"Drag and Drop\")")
    private WebElement dragTitle;

    public boolean isDragTitleDisplayed(){
        waitElementVisibility(dragTitle);
        return dragTitle.isDisplayed();
    }

}
