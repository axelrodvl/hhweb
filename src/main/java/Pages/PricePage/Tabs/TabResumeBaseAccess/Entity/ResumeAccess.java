package Pages.PricePage.Tabs.TabResumeBaseAccess.Entity;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ResumeAccess {
    public Integer price = null;
    public String title = null;

    By priceLocator = By.className("price-resume-access__item-cost");

    public ResumeAccess(WebElement resumeAccess) {
        price = Integer.valueOf(resumeAccess.findElement(priceLocator).getText().replaceAll("\\D+", ""));
        title = resumeAccess.getText();
    }

    public void print() {
        System.out.println("RESUME ACCESS OFFER:");
        System.out.println("__________________________________________________");
        System.out.println("title: " + title);
        System.out.println("price: " + price);
        System.out.println("__________________________________________________");
        System.out.println();
    }
}
