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
    List<String> AllCatchPhrases;
    List<String> AllSectionTypes;
    List<String> AllTinyImages;
    List<String> AllNames;
    List<String> Allids;
    List<String> AllPromotions;
    List<String> AllPromotionsDetails;
    List<String> AllNeededIds;
    List<String> AllNeededNames;
    List<String> AllHeaders;

    public List<String> getAllHeaders() {
        return AllHeaders;
    }

    public void setAllHeaders(List<String> allHeaders) {
        AllHeaders = allHeaders;
    }

    public List<String> getAllNeededNames() {
        return AllNeededNames;
    }

    public void setAllNeededNames(List<String> allNeededNames) {
        AllNeededNames = allNeededNames;
    }

    public List<String> getAllNeededIds() {
        return AllNeededIds;
    }

    public void setAllNeededIds(List<String> allNeededIds) {
        AllNeededIds = allNeededIds;
    }

    public List<String> getAllPromotionsDetails() {
        return AllPromotionsDetails;
    }

    public void setAllPromotionsDetails(List<String> allPromotionsDetails) {
        AllPromotionsDetails = allPromotionsDetails;
    }

    public List<String> getAllPromotions() {
        return AllPromotions;
    }

    public void setAllPromotions(List<String> allPromotions) {
        AllPromotions = allPromotions;
    }

    public List<String> getAllids() {
        return Allids;
    }

    public void setAllids(List<String> allids) {
        Allids = allids;
    }

    public List<String> getAllNames() {
        return AllNames;
    }

    public void setAllNames(List<String> allNames) {
        AllNames = allNames;
    }

    public List<String> getAllTinyImages() {
        return AllTinyImages;
    }

    public void setAllTinyImages(List<String> allTinyImages) {
        AllTinyImages = allTinyImages;
    }

    public List<String> getAllSectionTypes() {
        return AllSectionTypes;
    }

    public void setAllSectionTypes(List<String> allSectionTypes) {
        AllSectionTypes = allSectionTypes;
    }

    public List<String> getAllCatchPhrases() {
        return AllCatchPhrases;
    }

    public void setAllCatchPhrases(List<String> allCatchPhrases) {
        AllCatchPhrases = allCatchPhrases;
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












