package ru.savchenko.andrey.deliveryapp.entities;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by Andrey on 11.09.2017.
 */

public class Company extends RealmObject{
    @PrimaryKey
    private int id;
    private String companyName;
    private String url;

    public Company(int id, String companyName, String url) {
        this.id = id;
        this.companyName = companyName;
        this.url = url;
    }

    public Company() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "Company{" +
                "id=" + id +
                ", companyName='" + companyName + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
