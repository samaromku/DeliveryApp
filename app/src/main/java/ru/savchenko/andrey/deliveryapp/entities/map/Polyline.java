
package ru.savchenko.andrey.deliveryapp.entities.map;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class Polyline {

    @SerializedName("points")
    private String Points;

    public String getPoints() {
        return Points;
    }

    public void setPoints(String points) {
        Points = points;
    }

}
