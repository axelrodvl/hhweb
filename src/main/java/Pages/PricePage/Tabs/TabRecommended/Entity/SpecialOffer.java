package Pages.PricePage.Tabs.TabRecommended.Entity;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class SpecialOffer {
    public String giftTitle = null;
    public String giftDesc = null;
    public String actionTitle = null;
    public String specialOfferTitle = null;
    public String oldPrice = null;
    public String actualPrice = null;
    public String specialOfferPlus = null;

    public Integer oldCost = null;
    public Integer actualCost = null;

    By giftTitleLocator = By.cssSelector("div.price-spoffers__gift-title");
    By giftDescLocator = By.cssSelector("div.price-spoffers__gift-desc");
    By actionTitleLocator = By.cssSelector("div.price-spoffers__action-title");
    By specialOfferTitleLocator = By.cssSelector("div.price-spoffers__special-offer-title");
    By oldPriceLocator = By.cssSelector("span.price-spoffers__old-price");
    By actualPriceLocator = By.cssSelector("span.price-spoffers__actual-price");
    By specialOfferPlusLocator = By.cssSelector("div.price-spoffers__special-offer-plus");

    public SpecialOffer(WebElement offer) {
        giftTitle = offer.findElement(giftTitleLocator).getText();
        giftDesc = offer.findElement(giftDescLocator).getText();
        actionTitle = offer.findElement(actionTitleLocator).getText();
        specialOfferTitle = offer.findElement(specialOfferTitleLocator).getText();

        if(offer.findElements(oldPriceLocator).size() > 0)
            oldPrice = offer.findElement(oldPriceLocator).getText();

        actualPrice = offer.findElement(actualPriceLocator).getText();
        specialOfferPlus = offer.findElement(specialOfferPlusLocator).getText();

        if(oldPrice != null)
            oldCost = Integer.valueOf(oldPrice.replaceAll("\\D+",""));
        actualCost = Integer.valueOf(actualPrice.replaceAll("\\D+",""));
    }

    public void print() {
        System.out.println("OFFER:");
        System.out.println("__________________________________________________");
        System.out.println("giftTitle: " + giftTitle);
        System.out.println("giftDesc: " + giftDesc);
        System.out.println("actionTitle: " + actionTitle);
        System.out.println("specialOfferTitle: " + specialOfferTitle);
        System.out.println("oldPrice: " + oldPrice);
        System.out.println("actualPrice: " + actualPrice);
        System.out.println("specialOfferPlus: " + specialOfferPlus);
        System.out.println("__________________________________________________");
        System.out.println();
    }
}
