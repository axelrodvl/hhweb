package Entity;

import Abstract.Page;
import org.openqa.jetty.html.Element;

public class Price extends Page {
    protected static final String PAGE_URI = "/price";

    @Override
    public void open() {
        driver.get(ROOT_URI + PAGE_URI);

    }
}
