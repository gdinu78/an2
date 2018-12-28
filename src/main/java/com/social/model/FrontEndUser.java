package com.social.model;
import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.Set;
import java.util.stream.Collectors;

public class FrontEndUser {
    private int userID;
    private String username;
    private String name;
    private String gender;
    private Set<String> roles;
    private Set<String> favourite;
    private String lifecycle;
    private ZonedDateTime memberSince;
    private ZonedDateTime lastActive;
    private String heading;
    private LocalDate birthDate;
    private String lifestyle;
    private String netWorth;
    private String annualIncome;
    private int height;
    private String bodyType;
    private String ethnicity;
    private String hairColor;
    private String occupation;
    private String education;
    private String relationship;
    private int children;
    private String smoking;
    private String drinking;
    private String language;
    private Set<String> pics;
    private String location;
    private String descrAboutME;
    private String descrLookingFor;
    private String descrLookingForMore;

    public FrontEndUser(Users u){
        this.userID = u.getUserID();
        this.annualIncome=u.getAnnualIncome()==null ? "" : u.getAnnualIncome().name();
        this.birthDate=u.getBirthDate();
        this.bodyType=u.getBodyType()==null ? "" : u.getBodyType().getType();
        this.children=u.getChildren();
        this.descrAboutME=u.getDescrAboutME();
        this.descrLookingFor=u.getDescrLookingFor();
        this.drinking=u.getDrinking()==null ? "" : u.getDrinking().name();
        this.education=u.getEducation()==null ? "" : u.getEducation().name();
        this.ethnicity=u.getEthnicity()==null ? "" : u.getEthnicity().name();
        this.gender=u.getGender().name();
        this.hairColor=u.getHairColor()==null ? "" : u.getHairColor().name();
        this.heading=u.getHeading();
        this.height=u.getHeight();
        this.language=u.getLanguage()==null ? "" : u.getLanguage().name();
        this.lastActive=u.getLastActive();
        this.lifecycle=u.getLifecycle()==null ? "" : u.getLifecycle().name();
        this.location=u.getLocation();
        this.lifestyle=u.getLifestyle()==null ? "" : u.getLifestyle().name();
        this.memberSince=u.getMemberSince();
        this.name=u.getName();
        this.netWorth=u.getNetWorth()==null ? "" : u.getNetWorth().name();
        this.occupation=u.getOccupation()==null ? "" : u.getOccupation().name();
        this.pics=u.getPics().stream().filter(a->a!=null).map(a->a.getUrl()).collect(Collectors.toSet());
        this.relationship=u.getRelationship()==null ? "" : u.getRelationship().name();
//        this.favourite=u.getFavourite().stream().filter(a->a!=null && a.getFavUser()!=null).map(a->String.valueOf(a.getFavUser().getUserID()))
//                .collect(Collectors.toSet());
        this.roles=u.getRoles().stream().map(a->a.getRoleName().name()).collect(Collectors.toSet());
        this.smoking=u.getSmoking()==null ? "" : u.getSmoking().name();
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

    public Set<String> getFavourite() {
        return favourite;
    }

    public void setFavourite(Set<String> favourite) {
        this.favourite = favourite;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Set<String> getRoles() {
        return roles;
    }

    public void setRoles(Set<String> roles) {
        this.roles = roles;
    }

    public String getLifecycle() {
        return lifecycle;
    }

    public void setLifecycle(String lifecycle) {
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

    public String getLifestyle() {
        return lifestyle;
    }

    public void setLifestyle(String lifestyle) {
        this.lifestyle = lifestyle;
    }

    public String getNetWorth() {
        return netWorth;
    }

    public void setNetWorth(String netWorth) {
        this.netWorth = netWorth;
    }

    public String getAnnualIncome() {
        return annualIncome;
    }

    public void setAnnualIncome(String annualIncome) {
        this.annualIncome = annualIncome;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public String getBodyType() {
        return bodyType;
    }

    public void setBodyType(String bodyType) {
        this.bodyType = bodyType;
    }

    public String getEthnicity() {
        return ethnicity;
    }

    public void setEthnicity(String ethnicity) {
        this.ethnicity = ethnicity;
    }

    public String getHairColor() {
        return hairColor;
    }

    public void setHairColor(String hairColor) {
        this.hairColor = hairColor;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getRelationship() {
        return relationship;
    }

    public void setRelationship(String relationship) {
        this.relationship = relationship;
    }

    public int getChildren() {
        return children;
    }

    public void setChildren(int children) {
        this.children = children;
    }

    public String getSmoking() {
        return smoking;
    }

    public void setSmoking(String smoking) {
        this.smoking = smoking;
    }

    public String getDrinking() {
        return drinking;
    }

    public void setDrinking(String drinking) {
        this.drinking = drinking;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public Set<String> getPics() {
        return pics;
    }

    public void setPics(Set<String> pics) {
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
