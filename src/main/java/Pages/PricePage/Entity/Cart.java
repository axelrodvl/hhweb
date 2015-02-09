package Pages.PricePage.Entity;

import Pages.PricePage.Forms.FormCart;
import Pages.PricePage.Tabs.TabRecommended.Entity.SpecialOffer;
import Pages.PricePage.Tabs.TabResumeBaseAccess.Entity.ResumeAccess;
import Pages.PricePage.Tabs.TabVacancyPublication.Entity.VacancyPublication;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;

public class Cart {
    public ArrayList<SpecialOfferCart> specialOffers = new ArrayList<SpecialOfferCart>();
    public ArrayList<ResumeAccessCart> resumeAccesses = new ArrayList<ResumeAccessCart>();
    public ArrayList<CountableServiceCart> vacancyPublications = new ArrayList<CountableServiceCart>();

    public ArrayList<SpecialOfferCart> specialOffersCart = new ArrayList<SpecialOfferCart>();
    public ArrayList<ResumeAccessCart> resumeAccessCart = new ArrayList<ResumeAccessCart>();
    public ArrayList<CountableServiceCart> countableServicesCart = new ArrayList<CountableServiceCart>();

    public void add(SpecialOffer specialOffer) {
        specialOffers.add(new SpecialOfferCart(specialOffer));
    }

    public void add(ResumeAccess resumeAccess) {
        resumeAccesses.add(new ResumeAccessCart(resumeAccess));
    }

    public void add(VacancyPublication vacancyPublication, Integer count) {
        vacancyPublications.add(new CountableServiceCart(vacancyPublication, count));
    }

    public void addCart(FormCart formCart) {
        if(formCart.specialOffersList != null)
            for(WebElement entry : formCart.specialOffersList)
                specialOffersCart.add(new SpecialOfferCart(entry));
        if(formCart.resumeAccessList != null)
            for(WebElement entry : formCart.resumeAccessList)
                resumeAccessCart.add(new ResumeAccessCart(entry));
        if(formCart.countableServiceList != null)
            for(WebElement entry : formCart.countableServiceList)
                countableServicesCart.add(new CountableServiceCart(entry));
    }

    public boolean cartEquals() {
        if(specialOffers.size() != specialOffersCart.size())
            return false;
        if(resumeAccesses.size() != resumeAccessCart.size())
            return false;
        if(vacancyPublications.size() != countableServicesCart.size())
            return false;

        // Objects can't be compared to be equal because of possible difference of object.title value.
        // Instead, checking equals of costs in cart
        // It's possible, that first object.oldCost can be null, but second is not
        for(int i = 0; i < specialOffers.size(); i++) {
            if (!specialOffers.get(i).actualCost.equals(specialOffersCart.get(i).actualCost)) {
                System.out.println("EXPECTED:");
                specialOffers.get(i).print();

                System.out.println("ACTUAL:");
                specialOffersCart.get(i).print();
                return false;
            }

            if((specialOffers.get(i).oldCost != null) && (specialOffersCart.get(i).oldCost != null))
                if (!specialOffers.get(i).oldCost.equals(specialOffersCart.get(i).oldCost)) {
                    System.out.println("EXPECTED:");
                    specialOffers.get(i).print();
                    System.out.println("ACTUAL:");
                    specialOffersCart.get(i).print();
                    return false;
                }
        }

        for(int i = 0; i < resumeAccesses.size(); i++) {
            if (!resumeAccesses.get(i).actualCost.equals(resumeAccessCart.get(i).actualCost)) {
                System.out.println("EXPECTED:");
                resumeAccesses.get(i).print();
                System.out.println("ACTUAL:");
                resumeAccessCart.get(i).print();
                return false;
            }
            if((resumeAccesses.get(i).oldCost != null) && (resumeAccessCart.get(i).oldCost != null))
                if (!resumeAccesses.get(i).oldCost.equals(resumeAccessCart.get(i).oldCost)) {
                    System.out.println("EXPECTED:");
                    resumeAccesses.get(i).print();
                    System.out.println("ACTUAL:");
                    resumeAccessCart.get(i).print();
                    return false;
                }
        }

        for(int i = 0; i < vacancyPublications.size(); i++) {
            if (!vacancyPublications.get(i).count.equals(countableServicesCart.get(i).count)) {
                System.out.println("EXPECTED:");
                vacancyPublications.get(i).print();
                System.out.println("ACTUAL:");
                countableServicesCart.get(i).print();
                return false;
            }

            if (!vacancyPublications.get(i).actualCost.equals(countableServicesCart.get(i).actualCost)) {
                System.out.println("EXPECTED:");
                vacancyPublications.get(i).print();
                System.out.println("ACTUAL:");
                countableServicesCart.get(i).print();
                return false;
            }
            if((vacancyPublications.get(i).oldCost != null) && (countableServicesCart.get(i).oldCost != null))
                if (!vacancyPublications.get(i).oldCost.equals(countableServicesCart.get(i).oldCost)) {
                    System.out.println("EXPECTED:");
                    vacancyPublications.get(i).print();
                    System.out.println("ACTUAL:");
                    countableServicesCart.get(i).print();
                    return false;
                }
        }

        return true;
    }
}
