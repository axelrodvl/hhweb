package Pages.PricePage.Tabs.TabResumeBaseAccess.Selectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SelectorProduct {
    private final WebDriver driver;
    private List<WebElement> shortAccess;
    private List<WebElement> mediumAccess;
    private List<WebElement> longAccess;

    By shortAccessLocator = By.xpath("//*[@id=\"js-disabled\"]/body/div[5]/div/div/div[2]/div[1]/div/ul/li[2]/div/div/div[6]/div[1]/div/label/input");
    By mediumAccessLocator = By.xpath("//*[@id=\"js-disabled\"]/body/div[5]/div/div/div[2]/div[1]/div/ul/li[2]/div/div/div[6]/div[2]/div/label/input");
    By longAccessLocator = By.xpath("//*[@id=\"js-disabled\"]/body/div[5]/div/div/div[2]/div[1]/div/ul/li[2]/div/div/div[6]/div[3]/div/label/input");

    public SelectorProduct(WebDriver driver) {
        this.driver = driver;

        shortAccess = driver.findElements(shortAccessLocator);
        mediumAccess = driver.findElements(mediumAccessLocator);
        longAccess = driver.findElements(longAccessLocator);
    }

    public void shortAccessVariant(int entryNumber) {
        shortAccess.get(entryNumber).click();
    }

    public void mediumAccessVariant(int entryNumber) {
        mediumAccess.get(entryNumber).click();
    }

    public void longAccessVariant(int entryNumber) {
        longAccess.get(entryNumber).click();
    }
}
