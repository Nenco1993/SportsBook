package dataFromServer;

import android.app.Application;
import android.widget.ImageView;

import java.util.List;

/**
 * Created by Neven on 14.6.2016..
 */
public class AllSportsBooks extends Application {


    String id;
    String name;
    ImageView logo;
    List<String> catchPhrase;
    String promotion;
    String promotionDetails;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ImageView getLogo() {
        return logo;
    }

    public void setLogo(ImageView logo) {
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
}
