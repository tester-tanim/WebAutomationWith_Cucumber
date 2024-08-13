package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import static drivers.DriverSetup.getDriver;


public class BasePage {

    public WebElement getElement(By locator){
        return getDriver().findElement(locator);
    }

    public void clickOnElement(By locator){
        getElement(locator).click();
    }

    public void writeOnAElement(By locator, String text){
        getElement(locator).sendKeys(text);
    }

    public void hoverOnElement(By locator){
        Actions actions = new Actions(getDriver());
        actions.clickAndHold(getElement(locator)).build().perform();
    }

    public void loadAWebPage(String url){
        getDriver().get(url);
    }

    public String getElementText(By locator){
        return getElement(locator).getText();
    }

}