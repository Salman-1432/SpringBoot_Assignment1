package com.UserServiceAppi.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="User_Service_info")
//@ApiModel(description="This table holds user service information.")
public class User {
    @Id
    private  String userId;
    private  String userName;
    private String userAddress;
    private  String userPhoneNum;
    public User()
    {
        super();
    }

    public User(String userId, String userName, String userAddress, String userPhoneNum) {
        this.userId = userId;
        this.userName = userName;
        this.userAddress = userAddress;
        this.userPhoneNum = userPhoneNum;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }

    public String getUserPhoneNum() {
        return userPhoneNum;
    }

    public void setUserPhoneNum(String userPhoneNum) {
        this.userPhoneNum = userPhoneNum;
    }
}
