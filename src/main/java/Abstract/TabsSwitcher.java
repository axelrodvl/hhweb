package Abstract;

import java.util.ArrayList;
import org.openqa.selenium.WebElement;

public abstract class TabsSwitcher {
    private ArrayList<Form> tabs = new ArrayList<Form>();

    protected TabsSwitcher(WebElement tabsForm) {}

    private void createTab(WebElement tabForm) {
        // MAGIC
        //Form form = new Form();
        //tabs.add(form);
    }
}
