package pages;

import org.openqa.selenium.By;

public class ProductPage extends BasePage{
    public String  productPageURL = "https://www.saucedemo.com/inventory.html";

    public  By bikeLight = By.xpath("//div[normalize-space()='Sauce Labs Bike Light']");

    public By productTitle = By.xpath("//div[@class='inventory_details_name large_size']");
    public  By addToChatButton = By.id("add-to-cart-sauce-labs-bike-light");

    public By removeButton = By.xpath("//button[@id='remove-sauce-labs-bike-light']");

    public By cartCount = By.xpath("//span[@class='shopping_cart_badge']");

    public By shoppingCart = By.xpath("//a[@class='shopping_cart_link']");


    public void addProductToCart(By locator){
        clickOnElement(locator);
        clickOnElement(addToChatButton);
    }

}