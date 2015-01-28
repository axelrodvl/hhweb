package Dev;

import Pages.PagePrice;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/*
Вид модели:
Форма - Вкладка/Корзина - Сущность - Опция/количество
*/

/*
Сущности:
1. Вкладки
    1.1 Рекомендуемое
    1.2 Доступ к базе резюме
    1.3 Публикации вакансий
    1.4 Дополнительные услуги
2. Корзина

*/

/*
2. Доступ к базе резюме
    2.1 Тригеры
        1.1.1 Регион
        1.1.2 Профобласть
        1.1.3 С безлимитными публикациями вакансий "Стандарт" (только для 1.2.2 и 1.2.3)
    2.2 Опции
        1.2.1 Экспресс-подбор (2 опции)
        1.2.2 Поиск специалиста (1 опция) + 1 триггер
        1.2.3 Регулярный подбор (3 опции) + 1 триггер
    2.3 Действия
        1.3.1 В корзину
        1.3.2 Пересчитать
 */

public class Main {
    private static final String CHROME_DRIVER_NAME = "chromedriver";
    private static final String CHROME_DRIVER_PROPERTY = "webdriver.chrome.driver";
    protected static WebDriver driver = null;

    public static void main(String[] args) {

        System.setProperty(CHROME_DRIVER_PROPERTY, CHROME_DRIVER_NAME);
        driver = new ChromeDriver();

        PagePrice pagePrice = new PagePrice(driver);

        if(pagePrice.cartForm().isEmpty())
            System.out.println("CART IS EMPTY!");

        pagePrice.recommendedTab().addToCart(0).addToCart(1);

        System.out.println("Cart old price:" + pagePrice.cartForm().oldCost());
        System.out.println("Cart new price:" + pagePrice.cartForm().actualCost());
        System.out.println("hasContentsGifts:" + pagePrice.cartForm().hasContentsGifts());
        System.out.println("hasContentsCountableService:" + pagePrice.cartForm().hasContentsCountableService());
        System.out.println("hasContentsResumeAccess:" + pagePrice.cartForm().hasContentsResumeAccess());
        System.out.println("hasContentsSpecialOffer:" + pagePrice.cartForm().hasContentsSpecialOffer());

        pagePrice.recommendedTab().getOffer(0).printOffer();
        pagePrice.recommendedTab().getOffer(1).printOffer();

        pagePrice.cartForm();

        //pagePrice.resumeBaseAccessTab().regionSelector().selectMoscow().selectSaintPetersburg().selectRestOfRussia().close();

        pagePrice.resumeBaseAccessTab().regionSelector().selectSaintPetersburg().close();
        pagePrice.resumeBaseAccessTab().regionSelector().selectRestOfRussia().close();

        //pagePrice.close();

    }
}
