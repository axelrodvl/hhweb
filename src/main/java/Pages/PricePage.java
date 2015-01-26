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

public class PricePage {
    private final WebDriver driver;
    private static final String PAGE_URI = "http://hh.ru/price";

    By tabRecommendedLocator = By.xpath("//*[@id=\"js-disabled\"]/body/div[5]/div/div/div[2]/div[1]/ul/a[1]");
    By tabResumeBaseAccessLocator = By.xpath("//*[@id=\"js-disabled\"]/body/div[5]/div/div/div[2]/div[1]/ul/a[2]");
    By tabVacancyPublicationLocator = By.xpath("//*[@id=\"js-disabled\"]/body/div[5]/div/div/div[2]/div[1]/ul/a[3]");
    By tabAdditionalServiceLocator = By.xpath("//*[@id=\"js-disabled\"]/body/div[5]/div/div/div[2]/div[1]/ul/a[4]");

    public PricePage(WebDriver driver) {
        this.driver = driver;
        driver.get(PAGE_URI);
    }

    public TabRecommended recommendedTab() {
        driver.findElement(tabRecommendedLocator).click();
        return new TabRecommended(driver);
    }

    public TabResumeBaseAccess resumeBaseAccessTab() {
        driver.findElement(tabResumeBaseAccessLocator).click();
        return new TabResumeBaseAccess(driver);
    }

    /*
    public TabVacancyPublication getTabVacancyPublication() {
        driver.findElement(tabVacancyPublicationLocator).click();
        return new TabVacancyPublication(driver);
    }

    public TabAdditionalService getTabAdditionalService() {
        driver.findElement(tabAdditionalServiceLocator).click();
        return new TabAdditionalService(driver);
    }
    */

    public void close() {
        driver.quit();
    }
}