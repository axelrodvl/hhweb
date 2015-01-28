package Pages.PricePage.Tabs.TabResumeBaseAccess.Selectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

class Locations {
    public static String russia = "2000233";
    public static String moscow = "2000231";
    public static String saintPetersburg = "2000232";
    public static String restOfRussia = "2000002";

    public static String ukraine = "5";
    public static String kyiv = "115";

    public static String belarus = "16";

    public static String kazakhstanWithAlmatyAstana = "10000040";
    public static String restOfKazakhstanAndAsia = "2000003";

    public static String azerbaijanAndCaucasia = "1000009";

}

public class SelectorRegion {
    private final WebDriver driver;
    private List<WebElement> regionsList;
    public int regionCount;

    By regionsListLocator = By.xpath("//*[@id=\"js-disabled\"]/body/div[1]/div[2]/div/div[2]/label");
    By regionCheckboxLocator = By.xpath("input");
    By regionNameLocator = By.xpath("text()");
    By buttonCloseLocator = By.xpath("//*[@id=\"js-disabled\"]/body/div[1]/div[2]/div/div[3]/input");

    String regionLocatorMainXpathBegin = "//*[@id=\"js-disabled\"]/body/div[1]/div[2]/div/div[2]/label/input[@value=\"";
    String regionLocatorMainXpathEnd = "\"]";

    By russiaCheckboxLocator = By.xpath(regionLocatorMainXpathBegin + Locations.russia + regionLocatorMainXpathEnd);
    By moscowCheckboxLocator = By.xpath(regionLocatorMainXpathBegin + Locations.moscow + regionLocatorMainXpathEnd);
    By saintPetersburgCheckboxLocator = By.xpath(regionLocatorMainXpathBegin + Locations.saintPetersburg + regionLocatorMainXpathEnd);
    By restOfRussiaCheckboxLocator = By.xpath(regionLocatorMainXpathBegin + Locations.restOfRussia + regionLocatorMainXpathEnd);
    // Rest of main locations here...

    public SelectorRegion(WebDriver driver) {
        this.driver = driver;

        regionsList = driver.findElements(regionsListLocator);
        regionCount = regionsList.size();
    }

    public SelectorRegion selectRussia() {
        if (!driver.findElement(russiaCheckboxLocator).isSelected())
            driver.findElement(russiaCheckboxLocator).click();
        return this;
    }

    public SelectorRegion selectMoscow() {
        if (!driver.findElement(moscowCheckboxLocator).isSelected())
            driver.findElement(moscowCheckboxLocator).click();
        return this;
    }

    public SelectorRegion selectSaintPetersburg() {
        if (!driver.findElement(saintPetersburgCheckboxLocator).isSelected())
        driver.findElement(saintPetersburgCheckboxLocator).click();
        return this;
    }

    public SelectorRegion selectRestOfRussia() {
        if (!driver.findElement(restOfRussiaCheckboxLocator).isSelected())
            driver.findElement(restOfRussiaCheckboxLocator).click();
        return this;
    }

    public void close() {
        driver.findElement(buttonCloseLocator).click();
    }
}
