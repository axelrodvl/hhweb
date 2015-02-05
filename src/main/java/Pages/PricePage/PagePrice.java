package Pages.PricePage;

import Pages.PricePage.Forms.FormCart;
import Pages.PricePage.Tabs.TabRecommended.TabRecommended;
import Pages.PricePage.Tabs.TabResumeBaseAccess.TabResumeBaseAccess;
import Pages.PricePage.Tabs.TabVacancyPublication.TabVacancyPublication;
import org.openqa.selenium.By;
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

    @FindBy(css = "a[href=\"#recommended\"]")
    private WebElement tabRecommended;

    @FindBy(css = "a[href=\"#dbaccess\"]")
    private WebElement tabResumeBaseAccess;

    @FindBy(css = "a[href=\"#publications\"]")
    private WebElement tabVacancyPublication;


    public TabRecommended recommendedTab() {
        tabRecommended.click();
        return new TabRecommended(driver);
    }

    public TabResumeBaseAccess resumeBaseAccessTab() {
        tabResumeBaseAccess.click();
        return new TabResumeBaseAccess(driver);
    }

    public TabVacancyPublication vacancyPublicationTab() {
        tabVacancyPublication.click();
        return new TabVacancyPublication(driver);
    }

    public FormCart cartForm() {
        return new FormCart(driver);
    }

    public void close() {
        driver.quit();
    }
}