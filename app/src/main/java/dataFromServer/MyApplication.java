package dataFromServer;

import android.app.Application;
import android.widget.ImageView;

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

    List<String> names;
    List<String> ids;
    String logo;
    List<String> catchPhrase;
    String promotion;
    String promotionDetails;
    String sectionType;

    public List<String> getNames() {
        return names;
    }

    public void setNames(List<String> names) {
        this.names = names;
    }

    public List<String> getIds() {
        return ids;
    }

    public void setIds(List<String> ids) {
        this.ids = ids;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public List<String> getCatchPhrase() {
        return catchPhrase;
    }

    public void setCatchPhrase(List<String> catchPhrase) {
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
}












