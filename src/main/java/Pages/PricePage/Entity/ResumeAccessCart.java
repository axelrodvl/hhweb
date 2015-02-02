package Pages.PricePage.Entity;

import Pages.PricePage.Tabs.TabResumeBaseAccess.Entity.ResumeAccess;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ResumeAccessCart {
    public String title = null;
    public Integer oldCost = null;
    public Integer actualCost = null;

    By titleLocator = By.className("price-cart__item-title");
    By oldCostLocator = By.xpath("label/span[2]");
    By actualCostLocator = By.xpath("label/span[3]");

    public ResumeAccessCart(WebElement resumeAccess) {
        title = resumeAccess.findElement(titleLocator).getText();
        actualCost = Integer.valueOf(resumeAccess.findElement(actualCostLocator).getText().replaceAll("\\D+",""));
        if(resumeAccess.findElement(oldCostLocator).getText().replaceAll("\\D+", "").length() > 0)
            oldCost = Integer.valueOf(resumeAccess.findElement(oldCostLocator).getText().replaceAll("\\D+", ""));
    }

    public ResumeAccessCart(ResumeAccess resumeAccess) {
        title = resumeAccess.title;
        actualCost = resumeAccess.price;
        oldCost = null;
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
