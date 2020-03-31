package com.yaao.entity;

import java.io.Serializable;

/**
 * UserBindingTable实体类
 *
 * @author GuTianHao
 */
public class User implements Serializable {
    private static final long serialVersionUID = 6634981916589840932L;

    private String LogName;
    private String Password;
    private Integer UserID;

    public String getLogName() {
        return LogName;
    }

    public void setLogName(String logName) {
        LogName = logName;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public Integer getUseID() {
        return UserID;
    }

    public void setUserID(Integer userID) {
        UserID = userID;
    }

    @Override
    public String toString() {
        return "User{" +
                "LogName='" + LogName + '\'' +
                ", Password='" + Password + '\'' +
                ", UserID='" + UserID + '\'' +
                '}';
    }
}
