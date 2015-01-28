package Tabs;

import Selectors.SelectorProfArea;
import Selectors.SelectorRegion;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class TabResumeBaseAccess {
    private final WebDriver driver;
    private List<WebElement> offersList;

    public TabResumeBaseAccess(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);

        offersList = driver.findElements(offersLocator);
    }

    By offersLocator = By.xpath("//*[@id=\"js-disabled\"]/body/div[5]/div/div/div[2]/div[1]/div/ul/li[2]/div/div/div[5]/div");

    @FindBy(xpath = "//*[@id=\"js-disabled\"]/body/div[5]/div/div/div[2]/div[1]/div/ul/li[2]/div/div/div[3]/div[2]")
    private WebElement regionButton;

    @FindBy(xpath = "//*[@id=\"js-disabled\"]/body/div[5]/div/div/div[2]/div[1]/div/ul/li[2]/div/div/div[3]/div[2]")
    private WebElement profAreaButton;

    @FindBy(xpath = "//*[@id=\"js-disabled\"]/body/div[5]/div/div/div[2]/div[1]/div/ul/li[2]/div/div/div[7]/div[2]/button")
    private WebElement addToCartButton;

    public SelectorRegion regionSelector() {
        regionButton.click();
        return new SelectorRegion(driver);
    }

    public SelectorProfArea profAreaSelector() {
        profAreaButton.click();
        return new SelectorProfArea(driver);
    }

    public TabResumeBaseAccess addToCart() {
        addToCartButton.click();
        return this;
    }
}
