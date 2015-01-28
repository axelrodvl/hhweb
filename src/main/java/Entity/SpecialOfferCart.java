package Entity;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class SpecialOfferCart {
    private final WebElement specialOffer;

    public String title = null;
    public Integer oldCost = null;
    public Integer actualCost = null;

    By titleLocator = By.className("price-cart__item-title");
    By oldCostLocator = By.xpath("label/span[2]");
    By actualCostLocator = By.xpath("label/span[3]");

    public SpecialOfferCart(WebElement specialOffer) {
        this.specialOffer = specialOffer;

        title = specialOffer.findElement(titleLocator).getText();
        actualCost = Integer.valueOf(specialOffer.findElement(actualCostLocator).getText().replaceAll("\\D+",""));
        if(specialOffer.findElement(oldCostLocator).getText().replaceAll("\\D+", "").length() > 0)
            oldCost = Integer.valueOf(specialOffer.findElement(oldCostLocator).getText().replaceAll("\\D+", ""));
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
