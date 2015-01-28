package Pages.PricePage.Entity;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ResumeAccessCart {
    private final WebElement resumeAccess;

    public String title = null;
    public Integer oldCost = null;
    public Integer actualCost = null;

    By titleLocator = By.className("price-cart__item-title");
    By oldCostLocator = By.xpath("label/span[2]");
    By actualCostLocator = By.xpath("label/span[3]");

    public ResumeAccessCart(WebElement resumeAccess) {
        this.resumeAccess = resumeAccess;

        title = resumeAccess.findElement(titleLocator).getText();
        actualCost = Integer.valueOf(resumeAccess.findElement(actualCostLocator).getText().replaceAll("\\D+",""));
        if(resumeAccess.findElement(oldCostLocator).getText().replaceAll("\\D+", "").length() > 0)
            oldCost = Integer.valueOf(resumeAccess.findElement(oldCostLocator).getText().replaceAll("\\D+", ""));
    }

    public void print() {
        System.out.println("RESUME BASE ACCESS IN CART:");
        System.out.println("__________________________________________________");
        System.out.println("title: " + title);
        System.out.println("oldCost: " + oldCost);
        System.out.println("actualCost: " + actualCost);
        System.out.println("__________________________________________________");
        System.out.println();
    }
}
