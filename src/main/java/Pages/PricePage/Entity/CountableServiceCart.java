package Pages.PricePage.Entity;

import Pages.PricePage.Tabs.TabVacancyPublication.Entity.VacancyPublication;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class CountableServiceCart {
    public String title = null;
    public Integer count = null;
    public Integer costForOne = null;
    public Integer oldCost = null;
    public Integer actualCost = null;

    By titleLocator = By.cssSelector("span.price-cart__item-title");
    By countLocator = By.cssSelector("span.price-cart__item-title > strong");
    By costForOneLocator = By.cssSelector("span.price-cart__cost-for-one");
    By oldCostLocator = By.cssSelector("span.HH-PriceCart-Item-OldPrice");
    By actualCostLocator = By.cssSelector("span.HH-PriceCart-Item-ActualCost");

    public CountableServiceCart(WebElement countableService) {
        title = countableService.findElement(titleLocator).getText();
        count = Integer.valueOf(countableService.findElement(countLocator).getText().replaceAll("\\D+",""));
        costForOne = Integer.valueOf(countableService.findElement(costForOneLocator).getText().replaceAll("\\D+",""));
        actualCost = Integer.valueOf(countableService.findElement(actualCostLocator).getText().replaceAll("\\D+",""));
        if(countableService.findElement(oldCostLocator).getText().replaceAll("\\D+", "").length() > 0)
            oldCost = Integer.valueOf(countableService.findElement(oldCostLocator).getText().replaceAll("\\D+", ""));
    }

    public CountableServiceCart(VacancyPublication vacancyPublication, Integer count) {
        title = vacancyPublication.title;
        this.count = count;
        costForOne = vacancyPublication.price;
        oldCost = count * costForOne;

        if(count < 5)
            actualCost = count * vacancyPublication.price;
        else if(count < 10)
            actualCost = count * vacancyPublication.priceFrom5;
        else if(count < 50)
            actualCost = count * vacancyPublication.priceFrom10;
        else actualCost = count * vacancyPublication.priceFrom50;
        //
    }

    public void print() {
        System.out.println("COUNTABLE OFFER IN CART:");
        System.out.println("__________________________________________________");
        System.out.println("title: " + title);
        System.out.println("count: " + count);
        System.out.println("costForOne: " + costForOne);
        System.out.println("oldCost: " + oldCost);
        System.out.println("actualCost: " + actualCost);
        System.out.println("__________________________________________________");
        System.out.println();
    }
}
