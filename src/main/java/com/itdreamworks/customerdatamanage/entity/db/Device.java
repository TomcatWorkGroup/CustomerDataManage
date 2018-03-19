package com.itdreamworks.customerdatamanage.entity.db;

import java.io.Serializable;

public class Device implements Serializable {

    private int id;
    private String nickName;
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

}
