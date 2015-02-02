import Pages.PricePage.Entity.Cart;
import Pages.PricePage.PagePrice;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;

/*
1. Покупка услуг
        1.1 Положительные тесты
            1.1.1 Покупка всех специальных предложений и доступа к базе резюме
*/

public class TestPositive {
    private static final String CHROME_DRIVER_NAME = "chromedriver.exe";
    private static final String CHROME_DRIVER_PROPERTY = "webdriver.chrome.driver";
    private static WebDriver driver = null;
    private static PagePrice pagePrice = null;

    @BeforeClass
    public static void openBrowser() throws Exception {
        System.setProperty(CHROME_DRIVER_PROPERTY, CHROME_DRIVER_NAME);
        driver = new ChromeDriver();

        pagePrice = new PagePrice(driver);
        TimeUnit.MILLISECONDS.sleep(2000);
    }

    /**
     * 1.1.1 Покупка всех специальных предложений и доступа к базе резюме
     */
    @Test
    public void setNameFull() throws Exception {
        // Test data
        Cart cart = new Cart();

        // Test actions
        pagePrice.recommendedTab().addToCart(0).addToCart(1);
        cart.add(pagePrice.recommendedTab().getOffer(0));
        cart.add(pagePrice.recommendedTab().getOffer(1));
        pagePrice.resumeBaseAccessTab().regionSelector().selectSaintPetersburg().close();
        pagePrice.resumeBaseAccessTab().regionSelector().selectRestOfRussia().close();
        pagePrice.resumeBaseAccessTab().addToCart().longAccessVariant(2);
        cart.add(pagePrice.resumeBaseAccessTab().getOfferLong(2));
        cart.addCart(pagePrice.cartForm());

        // Test assertions
        assertTrue(cart.cartEquals());
    }

    @AfterClass
    public static void closePage() {
        pagePrice.close();
    }
}
