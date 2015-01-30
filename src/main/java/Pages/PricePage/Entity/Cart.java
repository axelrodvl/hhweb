package Pages.PricePage.Entity;

import Pages.PricePage.Forms.FormCart;
import Pages.PricePage.Tabs.TabRecommended.Entity.SpecialOffer;
import Pages.PricePage.Tabs.TabResumeBaseAccess.Entity.ResumeAccess;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;

public class Cart {
    public ArrayList<SpecialOffer> specialOffers = new ArrayList<SpecialOffer>();
    public ArrayList<ResumeAccess> resumeAccesses = new ArrayList<ResumeAccess>();

    public ArrayList<SpecialOfferCart> specialOffersCart = new ArrayList<SpecialOfferCart>();
    public ArrayList<ResumeAccessCart> resumeAccessCart = new ArrayList<ResumeAccessCart>();

    public void add(SpecialOffer specialOffer) {
        specialOffers.add(specialOffer);
    }

    public void add(ResumeAccess resumeAccess) {
        resumeAccesses.add(resumeAccess);
    }

    public void addCart(FormCart formCart) {
        for(WebElement entry : formCart.specialOffersList)
            specialOffersCart.add(new SpecialOfferCart(entry));

        for(WebElement entry : formCart.resumeAccessList)
            resumeAccessCart.add(new ResumeAccessCart(entry));
    }

    public boolean cartEquals() {
        if(specialOffers.size() != specialOffersCart.size())
            return false;
        if(resumeAccesses.size() != resumeAccessCart.size())
            return false;
        return true;
    }
}
