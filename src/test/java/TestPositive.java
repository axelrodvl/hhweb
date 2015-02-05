import Pages.PricePage.Entity.Cart;
import Pages.PricePage.PagePrice;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;

/*
1. Покупка услуг
        1.1 Положительные тесты
            1.1.1 Покупка первого специального предложения
            1.1.2 Покупка второго специального предложения
            1.1.3 Покупка всех специальных предложений
            1.1.4 Покупка доступа к базе резюме
            1.1.5 Отображение подсказки о более выгодном предложении (по регионам)
            1.1.6 Покупка двух специальных предложений и базы резюме
*/

public class TestPositive {
    private static final String CHROME_DRIVER_NAME = "chromedriver.exe";
    private static final String CHROME_DRIVER_PROPERTY = "webdriver.chrome.driver";
    private static WebDriver driver = null;
    private static PagePrice pagePrice = null;

    @Before
    public void openBrowser() throws Exception {
        System.setProperty(CHROME_DRIVER_PROPERTY, CHROME_DRIVER_NAME);
        driver = new ChromeDriver();

        pagePrice = new PagePrice(driver);
        TimeUnit.MILLISECONDS.sleep(2000);
    }

    /**
     * 1.1.1 Покупка первого специального предложения
     */
    @Test
    public void buyFirstSpecialOffer() throws Exception {
        // Test data
        Cart cart = new Cart();

        // Test actions
        pagePrice.recommendedTab().addToCart(0);
        cart.add(pagePrice.recommendedTab().getOffer(0));
        cart.addCart(pagePrice.cartForm());

        // Test assertions
        assertTrue("Cart contents is not equal to chosen at page: ", cart.cartEquals());
    }

    /**
     * 1.1.2 Покупка второго специального предложения
     */
    @Test
    public void buySecondSpecialOffer() throws Exception {
        // Test data
        Cart cart = new Cart();

        // Test actions
        pagePrice.recommendedTab().addToCart(1);
        cart.add(pagePrice.recommendedTab().getOffer(1));
        cart.addCart(pagePrice.cartForm());

        // Test assertions
        assertTrue("Cart contents is not equal to chosen at page: ", cart.cartEquals());
    }

    /**
     * 1.1.3 Покупка всех специальных предложений
     */
    @Test
    public void buyAllSpecialOffers() throws Exception {
        // Test data
        Cart cart = new Cart();

        // Test actions
        pagePrice.recommendedTab().addToCart(0).addToCart(1);
        cart.add(pagePrice.recommendedTab().getOffer(0));
        cart.add(pagePrice.recommendedTab().getOffer(1));
        cart.addCart(pagePrice.cartForm());

        // Test assertions
        assertTrue("Cart contents is not equal to chosen at page: ", cart.cartEquals());
    }

    /**
     * 1.1.4 Покупка доступа к базе резюме
     */
    @Test
    public void buyResumeBaseAccess() throws Exception {
        // Test data
        Cart cart = new Cart();

        // Test actions
        pagePrice.resumeBaseAccessTab().addToCart().longAccessVariant(2);
        cart.add(pagePrice.resumeBaseAccessTab().getOfferLong(2));
        cart.addCart(pagePrice.cartForm());

        // Test assertions
        assertTrue("Cart contents is not equal to chosen at page: ", cart.cartEquals());
    }

    /**
     * 1.1.5 Отображение подсказки о более выгодном предложении (по регионам)
     */
    @Test
    public void buyResumeBaseAccessRegionAdvice() throws Exception {
        // Test data
        Cart cart = new Cart();

        // Test actions
        pagePrice.recommendedTab().addToCart(0).addToCart(1);
        cart.add(pagePrice.recommendedTab().getOffer(0));
        cart.add(pagePrice.recommendedTab().getOffer(1));
        pagePrice.resumeBaseAccessTab().regionSelector().selectSaintPetersburg().close();
        pagePrice.resumeBaseAccessTab().regionSelector().selectRestOfRussia().close();

        // Additional test assertion
        assertTrue("Region advice is not visible: ", pagePrice.resumeBaseAccessTab().hasAdvice());

        pagePrice.resumeBaseAccessTab().checkAdvice();

        try {
            TimeUnit.MILLISECONDS.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Additional test assertion
        assertFalse("Region advice is visible after click: ", pagePrice.resumeBaseAccessTab().hasAdvice());

        pagePrice.resumeBaseAccessTab().addToCart().longAccessVariant(2);
        cart.add(pagePrice.resumeBaseAccessTab().getOfferLong(2));
        cart.addCart(pagePrice.cartForm());

        // Test assertions
        assertTrue("Cart contents is not equal to chosen at page: ", cart.cartEquals());
    }

    /**
     * 1.1.6 Покупка двух специальных предложений и базы резюме
     */
    @Test
    public void buyAllSpecialOffersAndResumeBaseAccess() throws Exception {
        // Test data
        Cart cart = new Cart();

        // Test actions
        pagePrice.recommendedTab().addToCart(0).addToCart(1);
        cart.add(pagePrice.recommendedTab().getOffer(0));
        cart.add(pagePrice.recommendedTab().getOffer(1));
        pagePrice.resumeBaseAccessTab().addToCart().longAccessVariant(2);
        cart.add(pagePrice.resumeBaseAccessTab().getOfferLong(2));
        cart.addCart(pagePrice.cartForm());

        // Test assertions
        assertTrue("Cart contents is not equal to chosen at page: ", cart.cartEquals());
    }

    @After
    public void closePage() {
        pagePrice.close();
    }
}
