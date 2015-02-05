package Dev;

import Pages.PricePage.Entity.Cart;
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
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);

        PagePrice pagePrice = new PagePrice(driver);

        System.out.println("hasContentsCountableService: " + pagePrice.cartForm().hasContentsCountableService());
        System.out.println("hasContentsResumeAccess: " + pagePrice.cartForm().hasContentsResumeAccess());
        System.out.println("hasContentsSpecialOffer: " + pagePrice.cartForm().hasContentsSpecialOffer());


        try {
            TimeUnit.MILLISECONDS.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        System.out.println("hasContentsCountableService: " + pagePrice.cartForm().hasContentsCountableService());
        System.out.println("hasContentsResumeAccess: " + pagePrice.cartForm().hasContentsResumeAccess());
        System.out.println("hasContentsSpecialOffer: " + pagePrice.cartForm().hasContentsSpecialOffer());

        /*
        try {
            TimeUnit.MILLISECONDS.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if(pagePrice.cartForm().isEmpty())
            System.out.println("CART IS EMPTY!");

        pagePrice.recommendedTab().addToCart(0).addToCart(1);

        Cart cart = new Cart();
        cart.add(pagePrice.recommendedTab().getOffer(0));
        cart.add(pagePrice.recommendedTab().getOffer(1));

        System.out.println(pagePrice.resumeBaseAccessTab().getAdviceText());
        System.out.println(pagePrice.resumeBaseAccessTab().getAdviceText());

        pagePrice.resumeBaseAccessTab().regionSelector().selectSaintPetersburg().close();
        pagePrice.resumeBaseAccessTab().regionSelector().selectRestOfRussia().close();

        pagePrice.resumeBaseAccessTab().addToCart().longAccessVariant(2);

        pagePrice.resumeBaseAccessTab().checkResumeAccessUnlimited();

        System.out.println("---------------------------------------------------");
        System.out.println("---------------------------------------------------");
        System.out.println("---------------------------------------------------");
        System.out.println("---------------------------------------------------");
        System.out.println("");

        System.out.println(pagePrice.resumeBaseAccessTab().getCost());
        System.out.println(pagePrice.resumeBaseAccessTab().getGift());
        System.out.println(pagePrice.resumeBaseAccessTab().getAdviceText());
        System.out.println(pagePrice.resumeBaseAccessTab().getAdvicePrice());

        System.out.println("---------------------------------------------------");
        System.out.println("---------------------------------------------------");
        System.out.println("---------------------------------------------------");
        System.out.println("---------------------------------------------------");
        System.out.println("");

        System.out.println("HAS ADVICE BEFORE = " + pagePrice.resumeBaseAccessTab().hasAdvice());
        pagePrice.resumeBaseAccessTab().checkAdvice();

        try {
            TimeUnit.MILLISECONDS.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("HAS ADVICE AFTER = " + pagePrice.resumeBaseAccessTab().hasAdvice());

        cart.add(pagePrice.resumeBaseAccessTab().getOfferLong(2));

        pagePrice.resumeBaseAccessTab().getOfferLong(2).print();

        System.out.println("Cart old price:" + pagePrice.cartForm().oldCost());
        System.out.println("Cart new price:" + pagePrice.cartForm().actualCost());
        System.out.println("hasContentsGifts:" + pagePrice.cartForm().hasContentsGifts());
        System.out.println("hasContentsCountableService:" + pagePrice.cartForm().hasContentsCountableService());
        System.out.println("hasContentsResumeAccess:" + pagePrice.cartForm().hasContentsResumeAccess());
        System.out.println("hasContentsSpecialOffer:" + pagePrice.cartForm().hasContentsSpecialOffer());

        pagePrice.cartForm().getSpecialOffer(0).print();
        pagePrice.cartForm().getSpecialOffer(1).print();
        pagePrice.cartForm().getResumeAccess(0).print();

        //pagePrice.cartForm().getCountableService(0).print();
        //pagePrice.cartForm().getCountableService(1).print();

        pagePrice.cartForm().getGift(0).print();
        pagePrice.cartForm().getGift(1).print();

        //pagePrice.recommendedTab().getOffer(0).print();
        //pagePrice.recommendedTab().getOffer(1).print();

        cart.addCart(pagePrice.cartForm());
        pagePrice.close();

        System.out.println("Cart equals = " + cart.cartEquals());*/
    }
}
