package Pages.PricePage.Tabs.TabVacancyPublication.Entity;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class VacancyPublication {
    public String title = null;
    public Integer count = null;
    public Integer price = null;
    public Integer priceFrom5 = null;
    public Integer priceFrom10 = null;
    public Integer priceFrom50 = null;

    By titleLocator = By.cssSelector("h2.price-countable-service__title");
    By countLocator = By.cssSelector("input");
    By priceLocator = By.cssSelector("span.price-countable-service__cost-amount");
    By priceFrom5Locator = By.cssSelector("div.HH-Price-CountableService-DiscountRate[data-amount=\"5\"] span.price-countable-service__rate-cost");
    By priceFrom10Locator = By.cssSelector("div.HH-Price-CountableService-DiscountRate[data-amount=\"10\"] span.price-countable-service__rate-cost");
    By priceFrom50Locator = By.cssSelector("div.HH-Price-CountableService-DiscountRate[data-amount=\"50\"] span.price-countable-service__rate-cost");

    public VacancyPublication(WebElement offer) {
        title = offer.findElement(titleLocator).getText();
        count = Integer.valueOf(offer.findElement(countLocator).getAttribute("value").replaceAll("\\D+",""));

        // Checking price for one
        offer.findElement(countLocator).clear();
        offer.findElement(countLocator).sendKeys("1");
        price = Integer.valueOf(offer.findElement(priceLocator).getText().replaceAll("\\D+",""));
        offer.findElement(countLocator).clear();
        offer.findElement(countLocator).sendKeys(Integer.toString(count));

        priceFrom5 = Integer.valueOf(offer.findElement(priceFrom5Locator).getText().replaceAll("\\D+",""));
        priceFrom10 = Integer.valueOf(offer.findElement(priceFrom10Locator).getText().replaceAll("\\D+",""));
        priceFrom50 = Integer.valueOf(offer.findElement(priceFrom50Locator).getText().replaceAll("\\D+",""));
    }

    public void print() {
        System.out.println("OFFER:");
        System.out.println("__________________________________________________");
        System.out.println("title: " + title);
        System.out.println("count: " + count);
        System.out.println("price: " + price);
        System.out.println("priceFrom5: " + priceFrom5);
        System.out.println("priceFrom10: " + priceFrom10);
        System.out.println("priceFrom50: " + priceFrom50);
        System.out.println("__________________________________________________");
        System.out.println();
    }
}
