package dataFromServer;

import android.app.Application;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Neven on 16.6.2016..
 */
public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        MySingleton.getInstance();
    }


    String logo;
    String names;
    String ids;
    String catchPhrase;
    String promotion;
    String promotionDetails;
    String sectionType;
    List<String> listOfAllCatches;


    public List<String> getListOfAllCatches() {
        return listOfAllCatches;
    }

    public void setListOfAllCatches(List<String> listOfAllCatches) {
        this.listOfAllCatches = listOfAllCatches;
    }



    public String getIds() {
        return ids;
    }

    public void setIds(String ids) {
        this.ids = ids;
    }

    public String getNames() {
        return names;
    }

    public void setNames(String names) {
        this.names = names;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getCatchPhrase() {
        return catchPhrase;
    }

    public void setCatchPhrase(String catchPhrase) {
        this.catchPhrase = catchPhrase;
    }

    public String getPromotion() {
        return promotion;
    }

    public void setPromotion(String promotion) {
        this.promotion = promotion;
    }

    public String getPromotionDetails() {
        return promotionDetails;
    }

    public void setPromotionDetails(String promotionDetails) {
        this.promotionDetails = promotionDetails;
    }


    public String getSectionType() {
        return sectionType;
    }

    public void setSectionType(String sectionType) {
        this.sectionType = sectionType;
    }

    @Override
    public String toString() {
        return catchPhrase;
    }
}












