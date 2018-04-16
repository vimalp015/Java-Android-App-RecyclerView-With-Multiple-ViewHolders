package com.au.vimalprakash.thenewsfeedapp.networking;

import java.util.Date;
import java.util.List;

public class NewsFeedResponse {

    private int id;

    private List<String> categories;

    private List<String> authors;

    private String url;

    private int lastModified;

    private int onTime;

    private boolean sponsored;

    private String displayName;

    private List<Assets> assets;

    private List<String> relatedAssets;

    private List<String> relatedImages;

    private String assetType;

    private Date timeStamp;

    public void setId(int id){
        this.id = id;
    }
    public int getId(){
        return this.id;
    }
    public void setCategories(List<String> categories){
        this.categories = categories;
    }
    public List<String> getCategories(){
        return this.categories;
    }
    public void setAuthors(List<String> authors){
        this.authors = authors;
    }
    public List<String> getAuthors(){
        return this.authors;
    }
    public void setUrl(String url){
        this.url = url;
    }
    public String getUrl(){
        return this.url;
    }
    public void setLastModified(int lastModified){
        this.lastModified = lastModified;
    }
    public int getLastModified(){
        return this.lastModified;
    }
    public void setOnTime(int onTime){
        this.onTime = onTime;
    }
    public int getOnTime(){
        return this.onTime;
    }
    public void setSponsored(boolean sponsored){
        this.sponsored = sponsored;
    }
    public boolean getSponsored(){
        return this.sponsored;
    }
    public void setDisplayName(String displayName){
        this.displayName = displayName;
    }
    public String getDisplayName(){
        return this.displayName;
    }
    public void setAssets(List<Assets> assets){
        this.assets = assets;
    }
    public List<Assets> getAssets(){
        return this.assets;
    }
    public void setRelatedAssets(List<String> relatedAssets){
        this.relatedAssets = relatedAssets;
    }
    public List<String> getRelatedAssets(){
        return this.relatedAssets;
    }
    public void setRelatedImages(List<String> relatedImages){
        this.relatedImages = relatedImages;
    }
    public List<String> getRelatedImages(){
        return this.relatedImages;
    }
    public void setAssetType(String assetType){
        this.assetType = assetType;
    }
    public String getAssetType(){
        return this.assetType;
    }
    public void setTimeStamp(Date timeStamp){
        this.timeStamp = timeStamp;
    }
    public Date getTimeStamp(){
        return this.timeStamp;
    }

    public class Categories
    {
        private String name;

        private String sectionPath;

        private int orderNum;

        public void setName(String name){
            this.name = name;
        }
        public String getName(){
            return this.name;
        }
        public void setSectionPath(String sectionPath){
            this.sectionPath = sectionPath;
        }
        public String getSectionPath(){
            return this.sectionPath;
        }
        public void setOrderNum(int orderNum){
            this.orderNum = orderNum;
        }
        public int getOrderNum(){
            return this.orderNum;
        }
    }

    public class Authors
    {
        private String name;

        private String title;

        private String email;

        private List<String> relatedAssets;

        private List<String> relatedImages;

        public void setName(String name){
            this.name = name;
        }
        public String getName(){
            return this.name;
        }
        public void setTitle(String title){
            this.title = title;
        }
        public String getTitle(){
            return this.title;
        }
        public void setEmail(String email){
            this.email = email;
        }
        public String getEmail(){
            return this.email;
        }
        public void setRelatedAssets(List<String> relatedAssets){
            this.relatedAssets = relatedAssets;
        }
        public List<String> getRelatedAssets(){
            return this.relatedAssets;
        }
        public void setRelatedImages(List<String> relatedImages){
            this.relatedImages = relatedImages;
        }
        public List<String> getRelatedImages(){
            return this.relatedImages;
        }
    }

    public class RelatedImages
    {
        private int id;

        private List<String> categories;

        private List<String> brands;

        private List<String> authors;

        private String url;

        private int lastModified;

        private boolean sponsored;

        private String description;

        private String photographer;

        private String type;

        private int width;

        private int height;

        private String assetType;

        private int timeStamp;

        public void setId(int id){
            this.id = id;
        }
        public int getId(){
            return this.id;
        }
        public void setCategories(List<String> categories){
            this.categories = categories;
        }
        public List<String> getCategories(){
            return this.categories;
        }
        public void setBrands(List<String> brands){
            this.brands = brands;
        }
        public List<String> getBrands(){
            return this.brands;
        }
        public void setAuthors(List<String> authors){
            this.authors = authors;
        }
        public List<String> getAuthors(){
            return this.authors;
        }
        public void setUrl(String url){
            this.url = url;
        }
        public String getUrl(){
            return this.url;
        }
        public void setLastModified(int lastModified){
            this.lastModified = lastModified;
        }
        public int getLastModified(){
            return this.lastModified;
        }
        public void setSponsored(boolean sponsored){
            this.sponsored = sponsored;
        }
        public boolean getSponsored(){
            return this.sponsored;
        }
        public void setDescription(String description){
            this.description = description;
        }
        public String getDescription(){
            return this.description;
        }
        public void setPhotographer(String photographer){
            this.photographer = photographer;
        }
        public String getPhotographer(){
            return this.photographer;
        }
        public void setType(String type){
            this.type = type;
        }
        public String getType(){
            return this.type;
        }
        public void setWidth(int width){
            this.width = width;
        }
        public int getWidth(){
            return this.width;
        }
        public void setHeight(int height){
            this.height = height;
        }
        public int getHeight(){
            return this.height;
        }
        public void setAssetType(String assetType){
            this.assetType = assetType;
        }
        public String getAssetType(){
            return this.assetType;
        }
        public void setTimeStamp(int timeStamp){
            this.timeStamp = timeStamp;
        }
        public int getTimeStamp(){
            return this.timeStamp;
        }
    }

    public class Companies
    {
        private int id;

        private String companyCode;

        private String companyName;

        private String abbreviatedName;

        private String exchange;

        private String companyNumber;

        public void setId(int id){
            this.id = id;
        }
        public int getId(){
            return this.id;
        }
        public void setCompanyCode(String companyCode){
            this.companyCode = companyCode;
        }
        public String getCompanyCode(){
            return this.companyCode;
        }
        public void setCompanyName(String companyName){
            this.companyName = companyName;
        }
        public String getCompanyName(){
            return this.companyName;
        }
        public void setAbbreviatedName(String abbreviatedName){
            this.abbreviatedName = abbreviatedName;
        }
        public String getAbbreviatedName(){
            return this.abbreviatedName;
        }
        public void setExchange(String exchange){
            this.exchange = exchange;
        }
        public String getExchange(){
            return this.exchange;
        }
        public void setCompanyNumber(String companyNumber){
            this.companyNumber = companyNumber;
        }
        public String getCompanyNumber(){
            return this.companyNumber;
        }
    }

    public class Sources
    {
        private String tagId;

        public void setTagId(String tagId){
            this.tagId = tagId;
        }
        public String getTagId(){
            return this.tagId;
        }
    }

    public class Overrides
    {
        private String overrideHeadline;

        private String overrideIdentifier;

        private String overrideAbstract;

        public void setOverrideHeadline(String overrideHeadline){
            this.overrideHeadline = overrideHeadline;
        }
        public String getOverrideHeadline(){
            return this.overrideHeadline;
        }
        public void setOverrideIdentifier(String overrideIdentifier){
            this.overrideIdentifier = overrideIdentifier;
        }
        public String getOverrideIdentifier(){
            return this.overrideIdentifier;
        }
        public void setOverrideAbstract(String overrideAbstract){
            this.overrideAbstract = overrideAbstract;
        }
        public String getOverrideAbstract(){
            return this.overrideAbstract;
        }
    }

    public class Assets
    {
        private int id;

        private List<Categories> categories;

        private List<Authors> authors;

        private String url;

        private int lastModified;

        private int onTime;

        private boolean sponsored;

        private String headline;

        private String indexHeadline;

        private String tabletHeadline;

        private String theAbstract;

        private String byLine;

        private boolean acceptComments;

        private int numberOfComments;

        private List<String> relatedAssets;

        private List<RelatedImages> relatedImages;

        private List<Companies> companies;

        private String legalStatus;

        private String identifier;

        private List<Sources> sources;

        private String assetType;

        private Overrides overrides;

        private int timeStamp;

        public void setId(int id){
            this.id = id;
        }
        public int getId(){
            return this.id;
        }
        public void setCategories(List<Categories> categories){
            this.categories = categories;
        }
        public List<Categories> getCategories(){
            return this.categories;
        }
        public void setAuthors(List<Authors> authors){
            this.authors = authors;
        }
        public List<Authors> getAuthors(){
            return this.authors;
        }
        public void setUrl(String url){
            this.url = url;
        }
        public String getUrl(){
            return this.url;
        }
        public void setLastModified(int lastModified){
            this.lastModified = lastModified;
        }
        public int getLastModified(){
            return this.lastModified;
        }
        public void setOnTime(int onTime){
            this.onTime = onTime;
        }
        public int getOnTime(){
            return this.onTime;
        }
        public void setSponsored(boolean sponsored){
            this.sponsored = sponsored;
        }
        public boolean getSponsored(){
            return this.sponsored;
        }
        public void setHeadline(String headline){
            this.headline = headline;
        }
        public String getHeadline(){
            return this.headline;
        }
        public void setIndexHeadline(String indexHeadline){
            this.indexHeadline = indexHeadline;
        }
        public String getIndexHeadline(){
            return this.indexHeadline;
        }
        public void setTabletHeadline(String tabletHeadline){
            this.tabletHeadline = tabletHeadline;
        }
        public String getTabletHeadline(){
            return this.tabletHeadline;
        }
        public void setTheAbstract(String theAbstract){
            this.theAbstract = theAbstract;
        }
        public String getTheAbstract(){
            return this.theAbstract;
        }
        public void setByLine(String byLine){
            this.byLine = byLine;
        }
        public String getByLine(){
            return this.byLine;
        }
        public void setAcceptComments(boolean acceptComments){
            this.acceptComments = acceptComments;
        }
        public boolean getAcceptComments(){
            return this.acceptComments;
        }
        public void setNumberOfComments(int numberOfComments){
            this.numberOfComments = numberOfComments;
        }
        public int getNumberOfComments(){
            return this.numberOfComments;
        }
        public void setRelatedAssets(List<String> relatedAssets){
            this.relatedAssets = relatedAssets;
        }
        public List<String> getRelatedAssets(){
            return this.relatedAssets;
        }
        public void setRelatedImages(List<RelatedImages> relatedImages){
            this.relatedImages = relatedImages;
        }
        public List<RelatedImages> getRelatedImages(){
            return this.relatedImages;
        }
        public void setCompanies(List<Companies> companies){
            this.companies = companies;
        }
        public List<Companies> getCompanies(){
            return this.companies;
        }
        public void setLegalStatus(String legalStatus){
            this.legalStatus = legalStatus;
        }
        public String getLegalStatus(){
            return this.legalStatus;
        }
        public void setIdentifier(String identifier){
            this.identifier = identifier;
        }
        public String getIdentifier(){
            return this.identifier;
        }
        public void setSources(List<Sources> sources){
            this.sources = sources;
        }
        public List<Sources> getSources(){
            return this.sources;
        }
        public void setAssetType(String assetType){
            this.assetType = assetType;
        }
        public String getAssetType(){
            return this.assetType;
        }
        public void setOverrides(Overrides overrides){
            this.overrides = overrides;
        }
        public Overrides getOverrides(){
            return this.overrides;
        }
        public void setTimeStamp(int timeStamp){
            this.timeStamp = timeStamp;
        }
        public int getTimeStamp(){
            return this.timeStamp;
        }
    }
}
