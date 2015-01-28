package Pages;

import Forms.FormCart;
import Tabs.TabRecommended;
import Tabs.TabResumeBaseAccess;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PagePrice {
    private final WebDriver driver;
    private static final String PAGE_URI = "http://hh.ru/price";

    public PagePrice(WebDriver driver) {
        this.driver = driver;
        driver.get(PAGE_URI);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@id=\"js-disabled\"]/body/div[5]/div/div/div[2]/div[1]/ul/a[1]")
    private WebElement tabRecommended;

    @FindBy(xpath = "//*[@id=\"js-disabled\"]/body/div[5]/div/div/div[2]/div[1]/ul/a[2]")
    private WebElement tabResumeBaseAccess;

    @FindBy(xpath = "//*[@id=\"js-disabled\"]/body/div[5]/div/div/div[2]/div[1]/ul/a[3]")
    private WebElement tabVacancyPublication;

    @FindBy(xpath = "//*[@id=\"js-disabled\"]/body/div[5]/div/div/div[2]/div[1]/ul/a[4]")
    private WebElement tabAdditionalService;

    public TabRecommended recommendedTab() {
        tabRecommended.click();
        return new TabRecommended(driver);
    }

    public TabResumeBaseAccess resumeBaseAccessTab() {
        tabResumeBaseAccess.click();
        return new TabResumeBaseAccess(driver);
    }

    /*
    public TabVacancyPublication vacancyPublicationTab() {
        tabVacancyPublication.click();
        return new TabVacancyPublication(driver);
    }
    public TabAdditionalService additionalServiceTab() {
        tabAdditionalService.click();
        return new TabAdditionalService(driver);
    }
    */

    public FormCart cartForm() {
        return new FormCart(driver);
    }

    public void close() {
        driver.quit();
    }
}