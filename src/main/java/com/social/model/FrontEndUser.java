package com.social.model;
import com.social.enums.*;
import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.Set;

public class FrontEndUser {
    private int userID;
    private String username;
    private String name;
    private Gender gender;
    private Set<Roles> roles;
    private LifeCycle lifecycle;
    private ZonedDateTime memberSince;
    private ZonedDateTime lastActive;
    private String heading;
    private LocalDate birthDate;
    private Lifestyle lifestyle;
    private Worth netWorth;
    private Income annualIncome;
    private int height;
    private BodyType bodyType;
    private Ethnicity ethnicity;
    private HairColor hairColor;
    private Occupation occupation;
    private Education education;
    private Relationship relationship;
    private int children;
    private Smoking smoking;
    private Dinking drinking;
    private Language language;
    private Set<Picture> pics;
    private String location;
    private String descrAboutME;
    private String descrLookingFor;
    private String descrLookingForMore;

    public FrontEndUser(Users u){
        this.userID = u.getUserID();
        this.annualIncome=u.getAnnualIncome();
        this.birthDate=u.getBirthDate();
        this.bodyType=u.getBodyType();
        this.children=u.getChildren();
        this.descrAboutME=u.getDescrAboutME();
        this.descrLookingFor=u.getDescrLookingFor();
        this.drinking=u.getDrinking();
        this.education=u.getEducation();
        this.ethnicity=u.getEthnicity();
        this.gender=u.getGender();
        this.hairColor=u.getHairColor();
        this.heading=u.getHeading();
        this.height=u.getHeight();
        this.language=u.getLanguage();
        this.lastActive=u.getLastActive();
        this.lifecycle=u.getLifecycle();
        this.location=u.getLocation();
        this.lifestyle=u.getLifestyle();
        this.memberSince=u.getMemberSince();
        this.name=u.getName();
        this.netWorth=u.getNetWorth();
        this.occupation=u.getOccupation();
        this.pics=u.getPics();
        this.relationship=u.getRelationship();
        this.roles=u.getRoles();
        this.smoking=u.getSmoking();
        this.username=u.getUsername();
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Set<Roles> getRoles() {
        return roles;
    }

    public void setRoles(Set<Roles> roles) {
        this.roles = roles;
    }

    public LifeCycle getLifecycle() {
        return lifecycle;
    }

    public void setLifecycle(LifeCycle lifecycle) {
        this.lifecycle = lifecycle;
    }

    public ZonedDateTime getMemberSince() {
        return memberSince;
    }

    public void setMemberSince(ZonedDateTime memberSince) {
        this.memberSince = memberSince;
    }

    public ZonedDateTime getLastActive() {
        return lastActive;
    }

    public void setLastActive(ZonedDateTime lastActive) {
        this.lastActive = lastActive;
    }

    public String getHeading() {
        return heading;
    }

    public void setHeading(String heading) {
        this.heading = heading;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public Lifestyle getLifestyle() {
        return lifestyle;
    }

    public void setLifestyle(Lifestyle lifestyle) {
        this.lifestyle = lifestyle;
    }

    public Worth getNetWorth() {
        return netWorth;
    }

    public void setNetWorth(Worth netWorth) {
        this.netWorth = netWorth;
    }

    public Income getAnnualIncome() {
        return annualIncome;
    }

    public void setAnnualIncome(Income annualIncome) {
        this.annualIncome = annualIncome;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public BodyType getBodyType() {
        return bodyType;
    }

    public void setBodyType(BodyType bodyType) {
        this.bodyType = bodyType;
    }

    public Ethnicity getEthnicity() {
        return ethnicity;
    }

    public void setEthnicity(Ethnicity ethnicity) {
        this.ethnicity = ethnicity;
    }

    public HairColor getHairColor() {
        return hairColor;
    }

    public void setHairColor(HairColor hairColor) {
        this.hairColor = hairColor;
    }

    public Occupation getOccupation() {
        return occupation;
    }

    public void setOccupation(Occupation occupation) {
        this.occupation = occupation;
    }

    public Education getEducation() {
        return education;
    }

    public void setEducation(Education education) {
        this.education = education;
    }

    public Relationship getRelationship() {
        return relationship;
    }

    public void setRelationship(Relationship relationship) {
        this.relationship = relationship;
    }

    public int getChildren() {
        return children;
    }

    public void setChildren(int children) {
        this.children = children;
    }

    public Smoking getSmoking() {
        return smoking;
    }

    public void setSmoking(Smoking smoking) {
        this.smoking = smoking;
    }

    public Dinking getDrinking() {
        return drinking;
    }

    public void setDrinking(Dinking drinking) {
        this.drinking = drinking;
    }

    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }

    public Set<Picture> getPics() {
        return pics;
    }

    public void setPics(Set<Picture> pics) {
        this.pics = pics;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDescrAboutME() {
        return descrAboutME;
    }

    public void setDescrAboutME(String descrAboutME) {
        this.descrAboutME = descrAboutME;
    }

    public String getDescrLookingFor() {
        return descrLookingFor;
    }

    public void setDescrLookingFor(String descrLookingFor) {
        this.descrLookingFor = descrLookingFor;
    }

    public String getDescrLookingForMore() {
        return descrLookingForMore;
    }

    public void setDescrLookingForMore(String descrLookingForMore) {
        this.descrLookingForMore = descrLookingForMore;
    }
}
