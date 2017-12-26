
package ru.savchenko.andrey.deliveryapp.entities.map;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class Southwest {

    @SerializedName("lat")
    private Double Lat;
    @SerializedName("lng")
    private Double Lng;

    public Double getLat() {
        return Lat;
    }

    public void setLat(Double lat) {
        Lat = lat;
    }

    public Double getLng() {
        return Lng;
    }

    public void setLng(Double lng) {
        Lng = lng;
    }

}
