package dataFromServer;

import android.app.Application;

import java.util.List;

/**
 * Created by Neven on 14.6.2016..
 */
public class HomeTab  {

    List<Section> listOfSections;


    public List<Section> getListOfSections() {
        return listOfSections;
    }

    public void setListOfSections(List<Section> listOfSections) {
        this.listOfSections = listOfSections;
    }


    public static class Section {

        String sectionType;
        String name;
        List<String> sportsBookID;

        public String getSectionType() {
            return sectionType;
        }

        public void setSectionType(String sectionType) {
            this.sectionType = sectionType;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public List<String> getSportsBookID() {
            return sportsBookID;
        }

        public void setSportsBookID(List<String> sportsBookID) {
            this.sportsBookID = sportsBookID;
        }
    }


}