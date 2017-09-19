package ru.savchenko.andrey.deliveryapp.entities;

import org.joda.time.DateTime;

/**
 * Created by Andrey on 09.09.2017.
 */

public class Order {
    private int id;
    private String title;
    private String body;
    private DateTime created;
    private DateTime deadLine;
    private double way;
    private int status;
    private int rating;
    private String url;

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", body='" + body + '\'' +
                ", created=" + created +
                ", deadLine=" + deadLine +
                ", way=" + way +
                ", status=" + status +
                ", rating=" + rating +
                ", url=" + url +
                '}';
    }

    public Order(int id, String title, String body, DateTime created, DateTime deadLine, double way) {
        this.id = id;
        this.title = title;
        this.body = body;
        this.created = created;
        this.deadLine = deadLine;
        this.way = way;
    }

    public Order(int id, String title, String body, DateTime created, DateTime deadLine, double way, String url) {
        this.id = id;
        this.title = title;
        this.body = body;
        this.created = created;
        this.deadLine = deadLine;
        this.way = way;
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public double getWay() {
        return way;
    }

    public void setWay(double way) {
        this.way = way;
    }

    public DateTime getCreated() {
        return created;
    }

    public void setCreated(DateTime created) {
        this.created = created;
    }

    public DateTime getDeadLine() {
        return deadLine;
    }

    public void setDeadLine(DateTime deadLine) {
        this.deadLine = deadLine;
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


}
