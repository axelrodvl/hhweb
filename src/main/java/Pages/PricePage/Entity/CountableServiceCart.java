package Pages.PricePage.Entity;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class CountableServiceCart {
    private final WebElement countableService;

    public String title = null;
    public Integer count = null;
    public Integer costForOne = null;
    public Integer oldCost = null;
    public Integer actualCost = null;

    By titleLocator = By.className("price-cart__item-title");
    By countLocator = By.xpath("label/span[1]/strong");
    By costForOneLocator = By.className("price-cart__cost-for-one");
    By oldCostLocator = By.xpath("label/span[2]");
    By actualCostLocator = By.xpath("label/span[3]");

    public CountableServiceCart(WebElement countableService) {
        this.countableService = countableService;

        title = countableService.findElement(titleLocator).getText();
        count = Integer.valueOf(countableService.findElement(countLocator).getText().replaceAll("\\D+",""));
        costForOne = Integer.valueOf(countableService.findElement(costForOneLocator).getText().replaceAll("\\D+",""));
        actualCost = Integer.valueOf(countableService.findElement(actualCostLocator).getText().replaceAll("\\D+",""));
        if(countableService.findElement(oldCostLocator).getText().replaceAll("\\D+", "").length() > 0)
            oldCost = Integer.valueOf(countableService.findElement(oldCostLocator).getText().replaceAll("\\D+", ""));
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
