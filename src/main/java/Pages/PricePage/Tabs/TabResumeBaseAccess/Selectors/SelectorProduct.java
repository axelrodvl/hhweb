package Pages.PricePage.Tabs.TabResumeBaseAccess.Selectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SelectorProduct {
    private final WebDriver driver;
    private List<WebElement> shortAccess;
    private List<WebElement> mediumAccess;
    private List<WebElement> longAccess;

    By shortAccessLocator = By.cssSelector("div.price-resume-access__period-group_bottom.HH-Price-ResumeAccess-Period-Group_short > div > label > input");
    By mediumAccessLocator = By.cssSelector("div.price-resume-access__period-group_bottom.HH-Price-ResumeAccess-Period-Group_medium > div > label > input");
    By longAccessLocator = By.cssSelector("div.price-resume-access__period-group_bottom.HH-Price-ResumeAccess-Period-Group_long > div > label > input");

    @FindBy(css = "div.price-resume-access__summary > div.price-spoffers__button > button")
    private WebElement addToCartButton;

    public SelectorProduct(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);

        shortAccess = driver.findElements(shortAccessLocator);
        mediumAccess = driver.findElements(mediumAccessLocator);
        longAccess = driver.findElements(longAccessLocator);
    }

    public void shortAccessVariant(int entryNumber) {
        shortAccess.get(entryNumber).click();
        addToCartButton.click();
    }

    public void mediumAccessVariant(int entryNumber) {
        mediumAccess.get(entryNumber).click();
        addToCartButton.click();
    }

    public void longAccessVariant(int entryNumber) {
        longAccess.get(entryNumber).click();
        addToCartButton.click();
    }
}
