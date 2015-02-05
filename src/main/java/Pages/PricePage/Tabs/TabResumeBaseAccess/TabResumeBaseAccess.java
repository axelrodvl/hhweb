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

    By offersLocatorShort = By.cssSelector("div.price-resume-access__period-group_bottom.HH-Price-ResumeAccess-Period-Group_short > div > label");
    By offersLocatorMedium = By.cssSelector("div.price-resume-access__period-group_bottom.HH-Price-ResumeAccess-Period-Group_medium > div > label");
    By offersLocatorLong = By.cssSelector("div.price-resume-access__period-group_bottom.HH-Price-ResumeAccess-Period-Group_long > div > label");

    @FindBy(css = "div.HH-Price-ResumeAccess-ChangeRegion.price-resume-access__change-item")
    private WebElement regionButton;

    @FindBy(css = "div.HH-Price-ResumeAccess-ChangeProfArea.price-resume-access__change-item")
    private WebElement profAreaButton;

    @FindBy(css = "div.price-resume-access__summary > label > input")
    private WebElement resumeAccessUnlimitedCheckbox;

    @FindBy(css = "div.price-resume-access__summary > span > span")
    private WebElement costForm;

    @FindBy(css = "div.price-resume-access-gift.HH-Price-ResumeAccess-Gift")
    private WebElement giftForm;

    @FindBy(css = "div.HH-Price-ResumeAccess-Advice")
    private WebElement adviceBlock;

    @FindBy(css = "span.HH-Price-ResumeAccess-Advice-Region")
    private WebElement adviceRegion;

    @FindBy(css = "span.HH-Price-ResumeAccess-Advice-Separator")
    private WebElement adviceSeparator;

    @FindBy(css = "span.HH-Price-ResumeAccess-Advice-ProfArea")
    private WebElement adviceProfArea;

    @FindBy(css = "span.HH-Price-ResumeAccess-Advice-DifferentCost > span")
    private WebElement advicePrice;

    @FindBy(css = "span.HH-Price-ResumeAccess-Advice-Options")
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
