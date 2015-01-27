package Tabs;

import Entity.Offer;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class TabRecommended {
    private final WebDriver driver;
    private List<WebElement> offersList;
    public int offersCount;

    By offersLocator = By.xpath("//*[@id=\"js-disabled\"]/body/div[5]/div/div/div[2]/div[1]/div/ul/li[1]/div/div/div[script[@data-name=\"HH/Cart/SpecialOffer\"]]");
    By addToCartButtonLocator = By.xpath("form/div/button");

    public TabRecommended(WebDriver driver) {
        this.driver = driver;
        offersList = driver.findElements(offersLocator);
        offersCount = offersList.size();
    }

    public void addToCart(int offerNumber) {
        offersList.get(offerNumber).findElement(addToCartButtonLocator).click();
    }

    public Offer getOffer(int offerNumber) {
        return new Offer(offersList.get(offerNumber));
    }
}
