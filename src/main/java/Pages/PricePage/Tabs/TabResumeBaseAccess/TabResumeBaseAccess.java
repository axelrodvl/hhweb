package Pages.PricePage.Tabs.TabResumeBaseAccess;

import Pages.PricePage.Tabs.TabRecommended.Entity.SpecialOffer;
import Pages.PricePage.Tabs.TabResumeBaseAccess.Entity.ResumeAccess;
import Pages.PricePage.Tabs.TabResumeBaseAccess.Selectors.SelectorProduct;
import Pages.PricePage.Tabs.TabResumeBaseAccess.Selectors.SelectorProfArea;
import Pages.PricePage.Tabs.TabResumeBaseAccess.Selectors.SelectorRegion;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class TabResumeBaseAccess {
    private final WebDriver driver;
    private List<WebElement> offersListShort;
    private List<WebElement> offersListMedium;
    private List<WebElement> offersListLong;

    public TabResumeBaseAccess(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);

        offersListShort = driver.findElements(offersLocatorShort);
        offersListMedium = driver.findElements(offersLocatorMedium);
        offersListLong = driver.findElements(offersLocatorLong);
    }

    By offersLocatorShort = By.xpath("//*[@id=\"js-disabled\"]/body/div[5]/div/div/div[2]/div[1]/div/ul/li[2]/div/div/div[6]/div[1]/div/label");
    By offersLocatorMedium = By.xpath("//*[@id=\"js-disabled\"]/body/div[5]/div/div/div[2]/div[1]/div/ul/li[2]/div/div/div[6]/div[2]/div/label");
    By offersLocatorLong = By.xpath("//*[@id=\"js-disabled\"]/body/div[5]/div/div/div[2]/div[1]/div/ul/li[2]/div/div/div[6]/div[3]/div/label");

    @FindBy(xpath = "//*[@id=\"js-disabled\"]/body/div[5]/div/div/div[2]/div[1]/div/ul/li[2]/div/div/div[3]/div[2]")
    private WebElement regionButton;

    @FindBy(xpath = "//*[@id=\"js-disabled\"]/body/div[5]/div/div/div[2]/div[1]/div/ul/li[2]/div/div/div[3]/div[2]")
    private WebElement profAreaButton;


    public SelectorRegion regionSelector() {
        regionButton.click();
        return new SelectorRegion(driver);
    }

    public SelectorProfArea profAreaSelector() {
        profAreaButton.click();
        return new SelectorProfArea(driver);
    }

    public SelectorProduct addToCart() {
        return new SelectorProduct(driver);
    }

    public ResumeAccess getOfferShort(int offerNumber) {
        return new ResumeAccess(offersListShort.get(offerNumber));
    }

    public ResumeAccess getOfferMedium(int offerNumber) {
        return new ResumeAccess(offersListMedium.get(offerNumber));
    }

    public ResumeAccess getOfferLong(int offerNumber) {
        return new ResumeAccess(offersListLong.get(offerNumber));
    }
}
