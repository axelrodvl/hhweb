package Pages;

/*
import Abstract.Page;
import Forms.PriceMainForm;
import Forms.FormPage;
*/

/*
public class PricePage extends Page {
    protected static final String PAGE_URI = "/price";

    @Override
    public void open() {
        driver.get(ROOT_URI + PAGE_URI);

    }

    @Override
    public FormPage getHeader() {
        return null;
    }

    @Override
    public PriceMainForm getMainForm() {
        return null;
    }

    @Override
    public FormPage getFooter() {
        return null;
    }
}

*/

import Tabs.TabRecommended;
import Tabs.TabResumeBaseAccess;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PricePage {
    private final WebDriver driver;
    private static final String PAGE_URI = "http://hh.ru/price";

    public PricePage(WebDriver driver) {
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

    public void close() {
        driver.quit();
    }
}