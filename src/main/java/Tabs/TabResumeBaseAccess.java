package Tabs;

import Selectors.RegionSelector;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TabResumeBaseAccess {
    private final WebDriver driver;

    public TabResumeBaseAccess(WebDriver driver) {
        this.driver = driver;
    }

    By regionsButtonSelector = By.xpath("//*[@id=\"js-disabled\"]/body/div[5]/div/div/div[2]/div[1]/div/ul/li[2]/div/div/div[3]/div[2]");

    public RegionSelector regionSelector() {
        driver.findElement(regionsButtonSelector).click();
        return new RegionSelector(driver);
    }
}
