package com.example.sqllitedemo;

public class userInfo {
    private int id;
    private String username;
    private String paswd;

    public userInfo(int id, String username, String paswd) {
        this.id=id;
        this.username = username;
        this.paswd = paswd;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPaswd(String paswd) {
        this.paswd = paswd;
    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPaswd() {
        return paswd;
    }
    @Override
    public String toString() {
        return "userInfo{" + "id=" + id + ", username='" + username + '\'' +
                ", paswd='" + paswd + '}';
    }
}


