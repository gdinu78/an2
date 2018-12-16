package com.social.model;


import com.social.enums.LifeCycle;
import javax.persistence.*;
import java.time.ZonedDateTime;

@Entity
@Table(name = "location")
public class Location {
    private Long id;
    private Users user_loc;
    private String country;
    private String regionName;
    private String city;
    private String zipCode;
    private Double lat;
    private Double lon;
    private String isp;
    private String org;
    private String asTxt;
    private String ipAddresss;
    private ZonedDateTime zonedDateTime;
    private LifeCycle lifecycle;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @ManyToOne
    public Users getUser_loc() {
        return user_loc;
    }

    public void setUser_loc(Users user_loc) {
        this.user_loc = user_loc;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public Double getLon() {
        return lon;
    }

    public void setLon(Double lon) {
        this.lon = lon;
    }

    public String getIsp() {
        return isp;
    }

    public void setIsp(String isp) {
        this.isp = isp;
    }

    public String getOrg() {
        return org;
    }

    public void setOrg(String org) {
        this.org = org;
    }

    public String getAsTxt() {
        return asTxt;
    }

    public void setAsTxt(String asTxt) {
        this.asTxt = asTxt;
    }

    public String getIpAddresss() {
        return ipAddresss;
    }

    public void setIpAddresss(String ipAddresss) {
        this.ipAddresss = ipAddresss;
    }

    public ZonedDateTime getZonedDateTime() {
        return zonedDateTime;
    }

    public void setZonedDateTime(ZonedDateTime zonedDateTime) {
        this.zonedDateTime = zonedDateTime;
    }

    public LifeCycle getLifecycle() {
        return lifecycle;
    }

    public void setLifecycle(LifeCycle lifecycle) {
        this.lifecycle = lifecycle;
    }
}
