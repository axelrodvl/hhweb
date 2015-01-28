package Dev;

import Pages.PricePage.PagePrice;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Main {
    private static final String CHROME_DRIVER_NAME = "chromedriver.exe";
    private static final String CHROME_DRIVER_PROPERTY = "webdriver.chrome.driver";
    protected static WebDriver driver = null;

    public static void main(String[] args) {
        System.setProperty(CHROME_DRIVER_PROPERTY, CHROME_DRIVER_NAME);
        driver = new ChromeDriver();

        PagePrice pagePrice = new PagePrice(driver);

        try {
            TimeUnit.MILLISECONDS.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if(pagePrice.cartForm().isEmpty())
            System.out.println("CART IS EMPTY!");

        pagePrice.recommendedTab().addToCart(0).addToCart(1);

        System.out.println("Cart old price:" + pagePrice.cartForm().oldCost());
        System.out.println("Cart new price:" + pagePrice.cartForm().actualCost());
        System.out.println("hasContentsGifts:" + pagePrice.cartForm().hasContentsGifts());
        System.out.println("hasContentsCountableService:" + pagePrice.cartForm().hasContentsCountableService());
        System.out.println("hasContentsResumeAccess:" + pagePrice.cartForm().hasContentsResumeAccess());
        System.out.println("hasContentsSpecialOffer:" + pagePrice.cartForm().hasContentsSpecialOffer());

        pagePrice.cartForm().getSpecialOffer(0).print();
        pagePrice.cartForm().getSpecialOffer(1).print();

        pagePrice.recommendedTab().getOffer(0).print();
        pagePrice.recommendedTab().getOffer(1).print();

        pagePrice.cartForm();

        pagePrice.resumeBaseAccessTab().regionSelector().selectSaintPetersburg().close();
        pagePrice.resumeBaseAccessTab().regionSelector().selectRestOfRussia().close();

        pagePrice.close();

    }
}
