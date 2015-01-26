package Entity;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Offer {
    private final WebElement offer;

    public String giftTitle = null;
    public String giftDesc = null;
    public String actionTitle = null;
    public String specialOfferTitle = null;
    public String oldPrice = null;
    public String actualPrice = null;
    public String specialOfferPlus = null;

    By giftTitleLocator = By.className("price-spoffers__gift-title");
    By giftDescLocator = By.className("price-spoffers__gift-desc");
    By actionTitleLocator = By.className("price-spoffers__action-title");
    By specialOfferTitleLocator = By.className("price-spoffers__special-offer-title");
    By oldPriceLocator = By.className("price-spoffers__old-price");
    By actualPriceLocator = By.className("price-spoffers__actual-price");
    By specialOfferPlusLocator = By.className("price-spoffers__special-offer-plus");

    /*
    <div class="price-spoffers__gift-title">День доступа к базе резюме бесплатно</div>
    <div class="price-spoffers__gift-desc">при покупке вакансии</div>
    <div class="price-spoffers__action-title">быстрый старт:</div>
    <div class="price-spoffers__special-offer-title">Вакансия Стандарт+</div>
    <span class="price-spoffers__old-price">3000</span>
    <span class="price-spoffers__actual-price">2100 руб.</span>
    <div class="price-spoffers__special-offer-plus">
                +День доступа к базе резюме бесплатно</div>

     */

    public Offer(WebElement offer) {
        this.offer = offer;

        giftTitle = offer.findElement(giftTitleLocator).getText();
        giftDesc = offer.findElement(giftDescLocator).getText();
        actionTitle = offer.findElement(actionTitleLocator).getText();
        specialOfferTitle = offer.findElement(specialOfferTitleLocator).getText();

        if(offer.findElements(oldPriceLocator).size() > 0)
            oldPrice = offer.findElement(oldPriceLocator).getText();

        actualPrice = offer.findElement(actualPriceLocator).getText();
        specialOfferPlus = offer.findElement(specialOfferPlusLocator).getText();
    }

    public void printOffer() {
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
    }
}
