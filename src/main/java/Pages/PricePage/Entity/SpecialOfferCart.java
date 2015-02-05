package Pages.PricePage.Entity;

import Pages.PricePage.Tabs.TabRecommended.Entity.SpecialOffer;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class SpecialOfferCart {
    public String title = null;
    public Integer oldCost = null;
    public Integer actualCost = null;

    By titleLocator = By.cssSelector("span.price-cart__item-title");
    By oldCostLocator = By.cssSelector("span.HH-PriceCart-Item-OldPrice");
    By actualCostLocator = By.cssSelector("span.HH-PriceCart-Item-ActualCost");

    public SpecialOfferCart(WebElement specialOffer) {
        title = specialOffer.findElement(titleLocator).getText();
        actualCost = Integer.valueOf(specialOffer.findElement(actualCostLocator).getText().replaceAll("\\D+",""));
        if(specialOffer.findElement(oldCostLocator).getText().replaceAll("\\D+", "").length() > 0)
            oldCost = Integer.valueOf(specialOffer.findElement(oldCostLocator).getText().replaceAll("\\D+", ""));
    }

    public SpecialOfferCart(SpecialOffer specialOffer) {
        title = specialOffer.specialOfferTitle;
        oldCost = specialOffer.oldCost;
        actualCost = specialOffer.actualCost;
    }

    public void print() {
        System.out.println("SPECIAL OFFER IN CART:");
        System.out.println("__________________________________________________");
        System.out.println("title: " + title);
        System.out.println("oldCost: " + oldCost);
        System.out.println("actualCost: " + actualCost);
        System.out.println("__________________________________________________");
        System.out.println();
    }
}
