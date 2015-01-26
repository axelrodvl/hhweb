package Tabs;

import Selectors.ProfAreaSelector;
import Selectors.RegionSelector;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class TabResumeBaseAccess {
    private final WebDriver driver;
    private List<WebElement> offersList;
    public int offersCount;

    public TabResumeBaseAccess(WebDriver driver) {
        this.driver = driver;
        offersList = driver.findElements(offersLocator);
        offersCount = offersList.size();
    }

    By regionsButtonSelector = By.xpath("//*[@id=\"js-disabled\"]/body/div[5]/div/div/div[2]/div[1]/div/ul/li[2]/div/div/div[3]/div[2]");
    By profAreaButtonSelector = By.xpath("//*[@id=\"js-disabled\"]/body/div[5]/div/div/div[2]/div[1]/div/ul/li[2]/div/div/div[3]/div[2]");

    By offersLocator = By.xpath("//*[@id=\"js-disabled\"]/body/div[5]/div/div/div[2]/div[1]/div/ul/li[2]/div/div/div[5]/div");
    By addToBucketLocator = By.xpath("//*[@id=\"js-disabled\"]/body/div[5]/div/div/div[2]/div[1]/div/ul/li[2]/div/div/div[7]/div[2]/button");

    public RegionSelector regionSelector() {
        driver.findElement(regionsButtonSelector).click();
        return new RegionSelector(driver);
    }

    public ProfAreaSelector profAreaSelector() {
        driver.findElement(profAreaButtonSelector).click();
        return new ProfAreaSelector(driver);
    }


}
