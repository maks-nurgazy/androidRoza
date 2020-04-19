package com.example.rozaga.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Example {

    @SerializedName("coachId")
    @Expose
    private Integer coachId;
    @SerializedName("coachKod")
    @Expose
    private String coachKod;
    @SerializedName("coachName")
    @Expose
    private String coachName;
    @SerializedName("coachSurname")
    @Expose
    private String coachSurname;
    @SerializedName("userInfo")
    @Expose
    private UserInfo userInfo;

    public Integer getCoachId() {
        return coachId;
    }

    public void setCoachId(Integer coachId) {
        this.coachId = coachId;
    }

    public String getCoachKod() {
        return coachKod;
    }

    public void setCoachKod(String coachKod) {
        this.coachKod = coachKod;
    }

    public String getCoachName() {
        return coachName;
    }

    public void setCoachName(String coachName) {
        this.coachName = coachName;
    }

    public String getCoachSurname() {
        return coachSurname;
    }

    public void setCoachSurname(String coachSurname) {
        this.coachSurname = coachSurname;
    }

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

    @Override
    public String toString() {
        return "Example{" +
                "coachId=" + coachId +
                ", coachKod='" + coachKod + '\'' +
                ", coachName='" + coachName + '\'' +
                ", coachSurname='" + coachSurname + '\'' +
                ", userInfo=" + userInfo +
                '}';
    }
}