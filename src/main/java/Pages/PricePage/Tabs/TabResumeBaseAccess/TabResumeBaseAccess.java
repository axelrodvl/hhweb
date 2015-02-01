package Pages.PricePage.Tabs.TabResumeBaseAccess;

import Pages.PricePage.Tabs.TabRecommended.Entity.SpecialOffer;
import Pages.PricePage.Tabs.TabResumeBaseAccess.Entity.ResumeAccess;
import Pages.PricePage.Tabs.TabResumeBaseAccess.Selectors.SelectorProduct;
import Pages.PricePage.Tabs.TabResumeBaseAccess.Selectors.SelectorProfArea;
import Pages.PricePage.Tabs.TabResumeBaseAccess.Selectors.SelectorRegion;
import javafx.scene.control.Tab;
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

    @FindBy(xpath = "//*[@id=\"js-disabled\"]/body/div[5]/div/div/div[2]/div[1]/div/ul/li[2]/div/div/div[7]/label/input")
    private WebElement resumeAccessUnlimitedCheckbox;

    @FindBy(xpath = "//*[@id=\"js-disabled\"]/body/div[5]/div/div/div[2]/div[1]/div/ul/li[2]/div/div/div[7]/span")
    private WebElement costForm;

    @FindBy(xpath = "//*[@id=\"js-disabled\"]/body/div[5]/div/div/div[2]/div[1]/div/ul/li[2]/div/div/div[1]")
    private WebElement giftForm;

    @FindBy(xpath = "//*[@id=\"js-disabled\"]/body/div[5]/div/div/div[2]/div[1]/div/ul/li[2]/div/div/div[7]/div[1]")
    private WebElement adviceBlock;

    @FindBy(xpath = "//*[@id=\"js-disabled\"]/body/div[5]/div/div/div[2]/div[1]/div/ul/li[2]/div/div/div[7]/div[1]/span/span[1]/span[1]")
    private WebElement adviceRegion;

    @FindBy(xpath = "//*[@id=\"js-disabled\"]/body/div[5]/div/div/div[2]/div[1]/div/ul/li[2]/div/div/div[7]/div[1]/span/span[1]/span[2]")
    private WebElement adviceSeparator;

    @FindBy(xpath = "//*[@id=\"js-disabled\"]/body/div[5]/div/div/div[2]/div[1]/div/ul/li[2]/div/div/div[7]/div[1]/span/span[1]/span[3]")
    private WebElement adviceProfArea;

    @FindBy(xpath = "//*[@id=\"js-disabled\"]/body/div[5]/div/div/div[2]/div[1]/div/ul/li[2]/div/div/div[7]/div[1]/span/span[4]/span")
    private WebElement advicePrice;

    @FindBy(xpath = "//*[@id=\"js-disabled\"]/body/div[5]/div/div/div[2]/div[1]/div/ul/li[2]/div/div/div[7]/div[1]/span/span[1]")
    private WebElement adviceButton;


    public SelectorRegion regionSelector() {
        regionButton.click();
        return new SelectorRegion(driver);
    }

    public SelectorProfArea profAreaSelector() {
        profAreaButton.click();
        return new SelectorProfArea(driver);
    }

    public TabResumeBaseAccess checkResumeAccessUnlimited() {
        resumeAccessUnlimitedCheckbox.click();
        return this;
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

    public Integer getCost() {
        return Integer.valueOf(costForm.getText().replaceAll("\\D+",""));
    }

    // Can't be accessed now because of bad html
    public String getGift() {
        return giftForm.getText();
    }

    public String getAdviceText() {
        return adviceRegion.getText() + adviceSeparator.getText() + adviceProfArea.getText();
    }

    public Integer getAdvicePrice() {
        return Integer.valueOf(advicePrice.getText().replaceAll("\\D+", ""));
    }

    public TabResumeBaseAccess checkAdvice() {
        adviceButton.click();
        return this;
    }

    public boolean hasAdvice() {
        return adviceBlock.isDisplayed();
    }
}
