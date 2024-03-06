package webdriverio.screens;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import webdriverio.utils.basescreen.BaseScreen;


public class SwipeScreen extends BaseScreen {

    public SwipeScreen(AndroidDriver driver) {
        super(driver);
    }

    protected Dimension screenSize = driver.manage().window().getSize();
    protected int screenWidth = screenSize.getWidth();
    protected int screenHeight = screenSize.getHeight();




    @AndroidFindBy(uiAutomator = "UiSelector().textContains(\"Swipe horizontal\")")
    private WebElement swipeTitle;

    @AndroidFindBy(accessibility = "Drag")
    private WebElement dragBtn;
    @AndroidFindBy(uiAutomator = "UiSelector().textContains(\"FULLY OPEN SOURCE\")")
    private  WebElement firstCardTitle;
    @AndroidFindBy(uiAutomator = "UiSelector().textContains(\"GREAT COMMUNITY\")")
    private  WebElement secondCardImage;
    @AndroidFindBy(uiAutomator = "UiSelector().textContains(\"You found me!!!\")")
    private  WebElement bottomPageText;
    @AndroidFindBy(uiAutomator = "UiSelector().textContains(\"\uDB82\uDDBE\")")
    private  WebElement lastCardImage;
    @AndroidFindBy(uiAutomator = "UiSelector().textContains(\"EXTENDABLE\")")
    private  WebElement secondToLastCardTitle;




    public boolean isSwipeTitleDisplayed(){
        waitElementVisibility(swipeTitle);
        return swipeTitle.isDisplayed();
    }

    public boolean isSecondCardDisplayed(){
        waitElementVisibility(secondCardImage);
        return secondCardImage.isDisplayed();
    }

    public boolean isLastCardDisplayed(){
        waitElementVisibility(lastCardImage);
        return lastCardImage.isDisplayed();
    }

    public boolean isBottomPageTextDisplayed(){
        waitElementVisibility(bottomPageText);
        return bottomPageText.isDisplayed();
    }

    public boolean isFirstCardNotDisplayed(){
        try{
            firstCardTitle.isDisplayed();
            return !firstCardTitle.isDisplayed();
        }catch (NoSuchElementException e){
            return true;
        }
    }

    public boolean isSecondToLastCardNotDisplayed(){
        try{
            secondToLastCardTitle.isDisplayed();
            return !secondToLastCardTitle.isDisplayed();
        }catch(NoSuchElementException e){
            return true;
        }
    }

    public boolean isFurtherRightCardNotDisplayed(){
        try{
            lastCardImage.isDisplayed();
            return !lastCardImage.isDisplayed();
        }catch (NoSuchElementException e ){
            return true;
        }
    }
    public boolean isBottomTextNotDisplayed(){
        try{
            bottomPageText.isDisplayed();
            return !bottomPageText.isDisplayed();
        }catch (NoSuchElementException e){
            return true;
        }
    }

    public void swipeRight() {
        swipe((screenWidth * 3) / 4, screenHeight / 2, screenWidth / 4, screenHeight / 2);
    }

    public void swipeToBottom() {

        int startX = screenWidth / 2;
        int startY = (int) (screenHeight * 0.9);
        int endY = (int) (screenHeight * 0.2);

        swipe(startX, startY, startX, endY);

        while(isBottomTextNotDisplayed()){
            swipeToBottom();
        }
    }
    public void swipeToFurtherRightCard(){
        while(isFurtherRightCardNotDisplayed()){
            swipeRight();
        }
    }

    public DragScreen openDragScreen(){
        dragBtn.click();
        return new DragScreen(super.getDriver());
    }


}
