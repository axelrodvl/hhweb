package Dev;

import Abstract.Page;
import Entity.Price;
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
    public static void main(String[] args) {
        Price pricePage = new Price();
        pricePage.open();
        pricePage.close();

        // FormBucket formBucket = pricePage.getMainForm.getBucket();

        // FormRecommended formRecommended = pricePage.getMainForm.getTabsSwitcher.getTab(0);
        // FormSpecialist formSpecialist = pricePage.getMainForm.getTabsSwitcher.getTab(1);
        // FormVacancyPublication formVacancyPublication = pricePage.getMainForm.getTabsSwitcher.getTab(2);
        // FormAdditionalService formAdditionalService = pricePage.getMainForm.getTabsSwitcher.getTab(3);

        // tabSpecialist.getRegionElement.chooseRegion("Москва и область");
        // tabSpecialist.getProfessionElement.chooseProfession("Информационные технологии, интернет, телеком");
        // tabSpecialist.getForm("Экспресс-подбор").getOption(0);


    }


}
