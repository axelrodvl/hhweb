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
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PricePage {
    private final WebDriver driver;
    private static final String PAGE_URI = "http://hh.ru/price";

    By tabRecommendedLocator = By.xpath("//*[@id=\"js-disabled\"]/body/div[5]/div/div/div[2]/div[1]/ul/a[1]");
    By tabSpecialistBaseLocator = By.xpath("");
    By tabVacancyPublicationLocator = By.xpath("");
    By tabAdditionalServiceLocator = By.xpath("");

    public PricePage(WebDriver driver) {
        this.driver = driver;
        driver.get(PAGE_URI);
    }

    public TabRecommended getTabRecommended() {
        driver.findElement(tabRecommendedLocator).click();
        return new TabRecommended(driver);
    }

    /*
    public TabSpecialistBase getTabSpecialistBase() {
        driver.findElement(tabSpecialistBaseLocator).click();
        return new TabSpecialistBase(driver);
    }

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