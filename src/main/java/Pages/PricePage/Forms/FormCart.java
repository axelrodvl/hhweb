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

    @FindBy(xpath = "//*[@id=\"js-disabled\"]/body/div[5]/div/div/div[2]/div[2]/div/div[2]")
    private WebElement formCartEmpty;

    @FindBy(xpath = "//*[@id=\"js-disabled\"]/body/div[5]/div/div/div[2]/div[2]/div/div[1]")
    private WebElement formCartNotEmpty;

    @FindBy(xpath = "//*[@id=\"js-disabled\"]/body/div[5]/div/div/div[2]/div[2]/div/div[1]/div[2]")
    private WebElement cartContents;

    @FindBy(xpath = "//*[@id=\"js-disabled\"]/body/div[5]/div/div/div[2]/div[2]/div/div[1]/div[2]/ol[1]")
    private WebElement cartContentsResumeAccess;

    @FindBy(xpath = "//*[@id=\"js-disabled\"]/body/div[5]/div/div/div[2]/div[2]/div/div[1]/div[2]/ol[2]")
    private WebElement cartContentsCountableService;

    @FindBy(xpath = "//*[@id=\"js-disabled\"]/body/div[5]/div/div/div[2]/div[2]/div/div[1]/div[2]/ol[3]")
    private WebElement cartContentsSpecialOffer;

    By resumeAccessLocator = By.xpath("//*[@id=\"js-disabled\"]/body/div[5]/div/div/div[2]/div[2]/div/div[1]/div[2]/ol[1]/li");
    By countableServiceLocator = By.xpath("//*[@id=\"js-disabled\"]/body/div[5]/div/div/div[2]/div[2]/div/div[1]/div[2]/ol[2]/li");
    By specialOfferLocator = By.xpath("//*[@id=\"js-disabled\"]/body/div[5]/div/div/div[2]/div[2]/div/div[1]/div[2]/ol[3]/li");
    By giftLocator = By.xpath("//*[@id=\"js-disabled\"]/body/div[5]/div/div/div[2]/div[2]/div/div[1]/div[4]/div");

    @FindBy(xpath = "//*[@id=\"js-disabled\"]/body/div[5]/div/div/div[2]/div[2]/div/div[1]/div[3]")
    private WebElement cartTotal;

    @FindBy(xpath = "//*[@id=\"js-disabled\"]/body/div[5]/div/div/div[2]/div[2]/div/div[1]/div[3]/div[1]/span[2]/span")
    private WebElement cartTotalOldCost;

    @FindBy(xpath = "//*[@id=\"js-disabled\"]/body/div[5]/div/div/div[2]/div[2]/div/div[1]/div[3]/div[1]/span[2]/strong/span")
    private WebElement cartTotalActualCost;

    @FindBy(xpath = "//*[@id=\"js-disabled\"]/body/div[5]/div/div/div[2]/div[2]/div/div[1]/div[4]")
    private WebElement cartGifts;

    @FindBy(xpath = "//*[@id=\"js-disabled\"]/body/div[5]/div/div/div[2]/div[2]/div/div[1]/div[5]")
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
