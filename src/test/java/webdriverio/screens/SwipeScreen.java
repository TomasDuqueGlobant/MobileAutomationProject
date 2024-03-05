package webdriverio.screens;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.checkerframework.checker.units.qual.A;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import webdriverio.utils.basescreen.BaseScreen;

import java.time.Duration;
import java.util.Arrays;

public class SwipeScreen extends BaseScreen {

    public SwipeScreen(AndroidDriver driver) {
        super(driver);
    }

    private int screenHeight = driver.manage().window().getSize().getHeight();
    private int screenWidth = driver.manage().window().getSize().getWidth();

    @AndroidFindBy(uiAutomator = "UiSelector().textContains(\"Swipe horizontal\")")
    private WebElement swipeTitle;

    @AndroidFindBy(accessibility = "Drag")
    private WebElement dragBtn;
    @AndroidFindBy(uiAutomator = "UiSelector().textContains(\"FULLY OPEN SOURCE\")")
    private  WebElement firstCardTitle;
    @AndroidFindBy(uiAutomator = "UiSelector().textContains(\"GREAT COMMUNITY\")")
    private  WebElement secondCardTitle;



    public boolean isSwipeTitleDisplayed(){
        waitElementVisibility(swipeTitle);
        return swipeTitle.isDisplayed();
    }

    public boolean isFirstCardDisplayed(){
        waitElementVisibility(firstCardTitle);
        return firstCardTitle.isDisplayed();
    }
    public boolean isSecondCardDisplayed(){
        waitElementVisibility(secondCardTitle);
        return secondCardTitle.isDisplayed();
    }

    public boolean isFirstCardNotDisplayed(){
        try{
            firstCardTitle.isDisplayed();
            return !firstCardTitle.isDisplayed();
        }catch (NoSuchElementException e){
            return true;
        }
    }    public boolean isSecondCardNotDisplayed(){
        try{
            secondCardTitle.isDisplayed();
            return !secondCardTitle.isDisplayed();
        }catch (NoSuchElementException e){
            return true;
        }
    }

    public DragScreen openDragScreen(){
        dragBtn.click();
        return new DragScreen(super.getDriver());
    }

    public void swipeRight(){
        swipe(screenWidth / 4, screenHeight / 2, (screenWidth * 3) / 4, screenHeight / 2);
    }

    public void swipeLeft() {
        int screenHeight = driver.manage().window().getSize().getHeight();
        int screenWidth = driver.manage().window().getSize().getWidth();

        swipe((screenWidth * 3) / 4, screenHeight / 2, screenWidth / 4, screenHeight / 2);
    }

    public void swipe(int startX, int startY, int endX, int endY) {
        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence swipe = new Sequence(finger, 1)
                .addAction(finger.createPointerMove(Duration.ofMillis(0), PointerInput.Origin.viewport(), startX, startY))
                .addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
                .addAction(finger.createPointerMove(Duration.ofMillis(600), PointerInput.Origin.viewport(), endX, endY))
                .addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        driver.perform(Arrays.asList(swipe));
    }

}
