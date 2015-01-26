package Abstract;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public abstract class Page {
    // ChromeDriver
    private static final String CHROME_DRIVER_NAME = "chromedriver.exe";
    private static final String CHROME_DRIVER_PROPERTY = "webdriver.chrome.driver";
    protected static WebDriver driver = null;
    // Page constants
    protected static final String ROOT_URI = "http://hh.ru";

    protected Page() {
        System.setProperty(CHROME_DRIVER_PROPERTY, CHROME_DRIVER_NAME);
        driver = new ChromeDriver();
    }

    public abstract void open();

    public void close() {
        driver.quit();
    }

    public abstract void getHeader();
    public abstract void getMainForm();
    public abstract void getFooter();
}

