package Pages.PricePage.Entity;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class GiftCart {
    private final WebElement gift;

    public String title = null;

    public GiftCart(WebElement gift) {
        this.gift = gift;

        title = gift.getText();
    }

    public void print() {
        System.out.println("GIFT IN CART:");
        System.out.println("__________________________________________________");
        System.out.println("title: " + title);
        System.out.println("__________________________________________________");
        System.out.println();
    }
}
