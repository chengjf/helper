package com.chengjf.uxinhelper.entity;

public class MD5Data {
    private String password;
    private int count;

    public MD5Data() {
    }

    public MD5Data(String password, int count) {
        this.password = password;
        this.count = count;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "MD5Data{" +
                "password='" + password + '\'' +
                ", count=" + count +
                '}';
    }
}
