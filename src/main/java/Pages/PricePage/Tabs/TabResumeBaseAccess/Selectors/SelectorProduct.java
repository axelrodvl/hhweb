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

    By shortAccessLocator = By.xpath("//*[@id=\"js-disabled\"]/body/div[5]/div/div/div[2]/div[1]/div/ul/li[2]/div/div/div[6]/div[1]/div/label/input");
    By mediumAccessLocator = By.xpath("//*[@id=\"js-disabled\"]/body/div[5]/div/div/div[2]/div[1]/div/ul/li[2]/div/div/div[6]/div[2]/div/label/input");
    By longAccessLocator = By.xpath("//*[@id=\"js-disabled\"]/body/div[5]/div/div/div[2]/div[1]/div/ul/li[2]/div/div/div[6]/div[3]/div/label/input");

    @FindBy(xpath = "//*[@id=\"js-disabled\"]/body/div[5]/div/div/div[2]/div[1]/div/ul/li[2]/div/div/div[7]/div[2]/button")
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
