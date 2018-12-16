package com.social.model;

import com.social.enums.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.Set;

@Entity
@Table(name = "usersDetails")
public class UsersDetails {
    private int usersDetailsId;
    private Users user;
    private ZonedDateTime memberSince;
    private ZonedDateTime lastActive;
    private Set<Location> locations;
    private Set<Logins> logins;
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


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int getUsersDetailsId() {
        return usersDetailsId;
    }

    public void setUsersDetailsId(int usersDetailsId) {
        this.usersDetailsId = usersDetailsId;
    }

    @OneToOne
    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
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

    @OneToMany(mappedBy = "user_loc")
    public Set<Location> getLocations() {
        return locations;
    }

    public void setLocations(Set<Location> locations) {
        this.locations = locations;
    }

    @OneToMany(mappedBy = "user_login")
    public Set<Logins> getLogins() {
        return logins;
    }

    public void setLogins(Set<Logins> logins) {
        this.logins = logins;
    }

    public String getHeading() {
        return heading;
    }

    public void setHeading(String heading) {
        this.heading = heading;
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

    @OneToMany(mappedBy="user")
    public Set<Picture> getPics() {
        return pics;
    }

    public void setPics(Set<Picture> pics) {
        this.pics = pics;
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
}
