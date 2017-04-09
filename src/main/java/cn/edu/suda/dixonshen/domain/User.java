package cn.edu.suda.dixonshen.domain;


import java.io.Serializable;

/**
 * Created by Z003R98D on 4/5/2017.
 */
public class User implements Serializable {
    private String name;
    private String sex;
    private String loginId;
    private String pwd;
    private String duty;
    private int age;
    private String cellNumber;
    private String photoUrl;
    private boolean used = true;    // 是否可用，默认值是true

    public String getName(){
        return this.name;
    }

    public String getSex(){
        return this.sex;
    }

    public String getLoginId(){
        return this.loginId;
    }

    public String getPwd(){
        return this.pwd;
    }

    public String getDuty(){
        return this.duty;
    }

    public int getAge(){
        return this.age;
    }

    public String getCellNumber(){
        return this.cellNumber;
    }

    public String getPhotoUrl(){
        return this.photoUrl;
    }

    public boolean getUsed(){
        return this.used;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void setLoginId(String loginId) {
        this.loginId = loginId;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public void setDuty(String duty) {
        this.duty = duty;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setCellNumber(String cellNumber) {
        this.cellNumber = cellNumber;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    public void setUsed(boolean used) {
        this.used = used;
    }

    @Override
    public String toString(){
        return this.getName() + ", " + this.getSex() + ", " + this.getLoginId() + ", " + this.getPwd()
                + ", " + this.getDuty() + ", " + this.getAge() + ", " + this.getCellNumber()
                + ", " + this.getPhotoUrl() + ", " + this.getUsed();
    }
}
