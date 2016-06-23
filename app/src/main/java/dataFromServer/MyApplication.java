package dataFromServer;

import android.app.Application;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Neven on 16.6.2016..
 */
public class MyApplication extends Application {

    private static MyApplication instance;

    public static MyApplication getInstance() {
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
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
    List<String> AllSportsBookTabNames;
    List<String> AllSportsBookTabLogos;
    List<String> AllSportsBookTabWebSitesURLS;
    List<String> listOfAllHomeTabFirstSectionLogos;
    List<String> listOfAllHomeTabSecondSectionLogos;
    List<String> listOfAllHomeTabFirstSectionNames;
    List<String> listOfAllHomeTabSecondSectionPromotions;
    List<String> AllLogosForHomeTab;
    List<String> AllCatchesForFirstSection;
    List<String> AllPromotionsDetailsForSecondSection;
    List<String> listOfAllRatings;
    List<String> listOfAllRatingsNeeded;
    List<String> listOfAllRatingsNames;

    public List<String> getListOfAllRatingsNames() {
        return listOfAllRatingsNames;
    }

    public void setListOfAllRatingsNames(List<String> listOfAllRatingsNames) {
        this.listOfAllRatingsNames = listOfAllRatingsNames;
    }

    public List<String> getListOfAllRatingsNeeded() {
        return listOfAllRatingsNeeded;
    }

    public void setListOfAllRatingsNeeded(List<String> listOfAllRatingsNeeded) {
        this.listOfAllRatingsNeeded = listOfAllRatingsNeeded;
    }

    public List<String> getListOfAllRatings() {
        return listOfAllRatings;
    }

    public void setListOfAllRatings(List<String> listOfAllRatings) {
        this.listOfAllRatings = listOfAllRatings;
    }

    public List<String> getAllPromotionsDetailsForSecondSection() {
        return AllPromotionsDetailsForSecondSection;
    }

    public void setAllPromotionsDetailsForSecondSection(List<String> allPromotionsDetailsForSecondSection) {
        AllPromotionsDetailsForSecondSection = allPromotionsDetailsForSecondSection;
    }

    public List<String> getAllCatchesForFirstSection() {
        return AllCatchesForFirstSection;
    }

    public void setAllCatchesForFirstSection(List<String> allCatchesForFirstSection) {
        AllCatchesForFirstSection = allCatchesForFirstSection;
    }

    public List<String> getAllLogosForHomeTab() {
        return AllLogosForHomeTab;
    }

    public void setAllLogosForHomeTab(List<String> allLogosForHomeTab) {
        AllLogosForHomeTab = allLogosForHomeTab;
    }

    public List<String> getListOfAllHomeTabSecondSectionPromotions() {
        return listOfAllHomeTabSecondSectionPromotions;
    }

    public void setListOfAllHomeTabSecondSectionPromotions(List<String> listOfAllHomeTabSecondSectionPromotions) {
        this.listOfAllHomeTabSecondSectionPromotions = listOfAllHomeTabSecondSectionPromotions;
    }

    public List<String> getListOfAllHomeTabFirstSectionLogos() {
        return listOfAllHomeTabFirstSectionLogos;
    }

    public void setListOfAllHomeTabFirstSectionLogos(List<String> listOfAllHomeTabFirstSectionLogos) {
        this.listOfAllHomeTabFirstSectionLogos = listOfAllHomeTabFirstSectionLogos;
    }

    public List<String> getListOfAllHomeTabFirstSectionNames() {
        return listOfAllHomeTabFirstSectionNames;
    }

    public void setListOfAllHomeTabFirstSectionNames(List<String> listOfAllHomeTabFirstSectionNames) {
        this.listOfAllHomeTabFirstSectionNames = listOfAllHomeTabFirstSectionNames;
    }

    public List<String> getListOfAllHomeTabSecondSectionLogos() {
        return listOfAllHomeTabSecondSectionLogos;
    }

    public void setListOfAllHomeTabSecondSectionLogos(List<String> listOfAllHomeTabSecondSectionLogos) {
        this.listOfAllHomeTabSecondSectionLogos = listOfAllHomeTabSecondSectionLogos;
    }



    public List<String> getAllSportsBookTabWebSitesURLS() {
        return AllSportsBookTabWebSitesURLS;
    }

    public void setAllSportsBookTabWebSitesURLS(List<String> allSportsBookTabWebSitesURLS) {
        AllSportsBookTabWebSitesURLS = allSportsBookTabWebSitesURLS;
    }

    public List<String> getAllSportsBookTabLogos() {
        return AllSportsBookTabLogos;
    }

    public void setAllSportsBookTabLogos(List<String> allSportsBookTabLogos) {
        AllSportsBookTabLogos = allSportsBookTabLogos;
    }

    public List<String> getAllSportsBookTabNames() {
        return AllSportsBookTabNames;
    }

    public void setAllSportsBookTabNames(List<String> allSportsBookTabNames) {
        AllSportsBookTabNames = allSportsBookTabNames;
    }

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












