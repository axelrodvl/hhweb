package Pages.PricePage.Forms;

import Pages.PricePage.Entity.CountableServiceCart;
import Pages.PricePage.Entity.GiftCart;
import Pages.PricePage.Entity.ResumeAccessCart;
import Pages.PricePage.Entity.SpecialOfferCart;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class FormCart {
    private final WebDriver driver;
    public List<WebElement> specialOffersList;
    public List<WebElement> countableServiceList;
    public List<WebElement> resumeAccessList;
    public List<WebElement> giftList;

    @FindBy(css = "div.HH-PriceCart-Empty")
    private WebElement formCartEmpty;

    @FindBy(css = "div.HH-PriceCart")
    private WebElement formCartNotEmpty;

    @FindBy(css = "div.price-cart__contents")
    private WebElement cartContents;

    @FindBy(css = "ol.HH-PriceCart-Items_resumeAccess")
    private WebElement cartContentsResumeAccess;

    @FindBy(css = "ol.HH-PriceCart-Items_countableService")
    private WebElement cartContentsCountableService;

    @FindBy(css = "ol.HH-PriceCart-Items_specialOffer")
    private WebElement cartContentsSpecialOffer;

    By resumeAccessLocator = By.cssSelector("ol.price-cart__items.HH-PriceCart-Items_resumeAccess > li");
    By countableServiceLocator = By.cssSelector("ol.price-cart__items.HH-PriceCart-Items_countableService > li");
    By specialOfferLocator = By.cssSelector("ol.price-cart__items.HH-PriceCart-Items_specialOffer > li");
    By giftLocator = By.cssSelector("div.price-cart__gifts.HH-PriceCart-Gifts > div");

    @FindBy(css = "span.price-cart__total-cost > span")
    private WebElement cartTotalOldCost;

    @FindBy(css = "span.price-cart__total-cost > strong > span")
    private WebElement cartTotalActualCost;

    @FindBy(css = "div.price-cart__gifts.HH-PriceCart-Gifts")
    private WebElement cartGifts;

    @FindBy(css = "div.price-cart__proceed > a")
    private WebElement cartProceed;

    public FormCart(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);

        if(!isEmpty()) {
            if(hasContentsSpecialOffer())
                specialOffersList = driver.findElements(specialOfferLocator);
            if(hasContentsCountableService())
                countableServiceList = driver.findElements(countableServiceLocator);
            if(hasContentsResumeAccess())
                resumeAccessList = driver.findElements(resumeAccessLocator);
            if(hasContentsGifts())
                giftList = driver.findElements(giftLocator);
        }
    }

    public boolean isEmpty() {
        return formCartEmpty.isDisplayed();
    }

    public Integer oldCost() {
        if(!isEmpty())
            return Integer.valueOf(cartTotalOldCost.getText().replaceAll("\\D+", ""));
        else
            return null;
    }

    public Integer actualCost() {
        if(!isEmpty())
            return Integer.valueOf(cartTotalActualCost.getText().replaceAll("\\D+",""));
        else
            return null;
    }

    public boolean hasContentsGifts() {
        return cartGifts.isDisplayed();
    }

    public boolean hasContentsResumeAccess() {
        return cartContentsResumeAccess.isDisplayed();
    }

    public boolean hasContentsCountableService() {
        return cartContentsCountableService.isDisplayed();
    }

    public boolean hasContentsSpecialOffer() {
        return cartContentsSpecialOffer.isDisplayed();
    }

    public SpecialOfferCart getSpecialOffer(int entryNumber) {
        return new SpecialOfferCart(specialOffersList.get(entryNumber));
    }

    public CountableServiceCart getCountableService(int entryNumber) {
        return new CountableServiceCart(countableServiceList.get(entryNumber));
    }

    public ResumeAccessCart getResumeAccess(int entryNumber) {
        return new ResumeAccessCart(resumeAccessList.get(entryNumber));
    }

    public GiftCart getGift(int entryNumber) {
        return new GiftCart(giftList.get(entryNumber));
    }

    public FormCart checkout() {
        cartProceed.click();
        return this;
    }
}
