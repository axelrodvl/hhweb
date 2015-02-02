package Pages.PricePage.Entity;

import Pages.PricePage.Forms.FormCart;
import Pages.PricePage.Tabs.TabRecommended.Entity.SpecialOffer;
import Pages.PricePage.Tabs.TabResumeBaseAccess.Entity.ResumeAccess;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;

public class Cart {
    public ArrayList<SpecialOfferCart> specialOffers = new ArrayList<SpecialOfferCart>();
    public ArrayList<ResumeAccessCart> resumeAccesses = new ArrayList<ResumeAccessCart>();

    public ArrayList<SpecialOfferCart> specialOffersCart = new ArrayList<SpecialOfferCart>();
    public ArrayList<ResumeAccessCart> resumeAccessCart = new ArrayList<ResumeAccessCart>();

    public void add(SpecialOffer specialOffer) {
        specialOffers.add(new SpecialOfferCart(specialOffer));
    }

    public void add(ResumeAccess resumeAccess) {
        resumeAccesses.add(new ResumeAccessCart(resumeAccess));
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

        // Objects can't be compared to be equal because of possible difference of object.title value.
        // Instead, checking equals of costs in cart
        // It's possible, that first object.oldCost can be null, but second is not
        for(int i = 0; i < specialOffers.size(); i++) {
            if (!specialOffers.get(i).actualCost.equals(specialOffersCart.get(i).actualCost))
                return false;
            if((specialOffers.get(i).oldCost != null) && (specialOffersCart.get(i).oldCost != null))
                if (!specialOffers.get(i).oldCost.equals(specialOffersCart.get(i).oldCost))
                    return false;
        }

        for(int i = 0; i < resumeAccesses.size(); i++) {
            if (!resumeAccesses.get(i).actualCost.equals(resumeAccessCart.get(i).actualCost))
                return false;
            if((resumeAccesses.get(i).oldCost != null) && (resumeAccessCart.get(i).oldCost != null))
                if (!resumeAccesses.get(i).oldCost.equals(resumeAccessCart.get(i).oldCost))
                    return false;
        }

        return true;
    }
}
