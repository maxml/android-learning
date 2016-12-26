package com.maxml.expractice.asdfv;

/**
 * Created by maxml on 29.11.16.
 */

public class User {

    private String name;
    private boolean isFemale;
    private int age;
    private String town;

    public User() {
    }

    public User(String name, boolean isFemale, int age, String town) {
        this.name = name;
        this.isFemale = isFemale;
        this.age = age;
        this.town = town;
    }

    public static User createFromArrays(String[] fields) {
        User res = new User();

        res.setName(fields[0]);
        res.setFemale(Boolean.getBoolean(fields[1]));
        res.setAge(Integer.parseInt(fields[2]));
        res.setTown(fields[3]);

        return res;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isFemale() {
        return isFemale;
    }

    public void setFemale(boolean female) {
        isFemale = female;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", isFemale=" + isFemale +
                ", age=" + age +
                ", town='" + town + '\'' +
                '}';
    }
}
