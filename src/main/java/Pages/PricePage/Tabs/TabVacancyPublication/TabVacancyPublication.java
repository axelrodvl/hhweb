package Pages.PricePage.Tabs.TabVacancyPublication;

import Pages.PricePage.Tabs.TabVacancyPublication.Entity.VacancyPublication;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class TabVacancyPublication {
    private final WebDriver driver;
    private List<WebElement> offersList;
    public int offersCount;

    By offersLocator = By.cssSelector("li.flat-tabs__content.HH-PriceCart-Tab.g-expand div.price-countable-service");
    By countEditLocator = By.cssSelector("input");
    By addToCartButtonLocator = By.cssSelector("a");

    public TabVacancyPublication(WebDriver driver) {
        this.driver = driver;
        offersList = driver.findElements(offersLocator);
        offersCount = offersList.size();
    }

    public TabVacancyPublication addToCart(int count, int offerNumber) {
        offersList.get(offerNumber).findElement(countEditLocator).clear();
        offersList.get(offerNumber).findElement(countEditLocator).sendKeys(Integer.toString(count));
        offersList.get(offerNumber).findElement(addToCartButtonLocator).click();
        return this;
    }

    public VacancyPublication getOffer(int offerNumber) {
        return new VacancyPublication(offersList.get(offerNumber));
    }
}
