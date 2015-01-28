package Forms;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FormCart {
    private final WebDriver driver;

    @FindBy(xpath = "//*[@id=\"js-disabled\"]/body/div[5]/div/div/div[2]/div[2]/div/div[2]")
    private WebElement formCartEmpty;

    @FindBy(xpath = "//*[@id=\"js-disabled\"]/body/div[5]/div/div/div[2]/div[2]/div/div[1]")
    private WebElement formCartNotEmpty;

    @FindBy(xpath = "//*[@id=\"js-disabled\"]/body/div[5]/div/div/div[2]/div[2]/div/div[1]/div[2]")
    private WebElement cartContents;

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

    public FormCart checkout() {
        cartProceed.click();
        return this;
    }
}