package ru.savchenko.andrey.deliveryapp.entities;
import org.joda.time.DateTime;

/**
 * Created by savchenko on 12.09.17.
 */

public class Review {
    private int id;
    private String title;
    private String body;
    private DateTime dateTime;
    private int rating;
    private String userName;

    @Override
    public String toString() {
        return "Review{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", body='" + body + '\'' +
                ", dateTime=" + dateTime +
                ", rating=" + rating +
                ", userName='" + userName + '\'' +
                '}';
    }

    public Review(int id, String title, String body, DateTime dateTime, int rating, String userName) {
        this.id = id;
        this.title = title;
        this.body = body;
        this.dateTime = dateTime;
        this.rating = rating;
        this.userName = userName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public DateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(DateTime dateTime) {
        this.dateTime = dateTime;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
