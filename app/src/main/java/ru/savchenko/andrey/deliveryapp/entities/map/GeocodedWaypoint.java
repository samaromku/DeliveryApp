
package ru.savchenko.andrey.deliveryapp.entities.map;

import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class GeocodedWaypoint {

    @SerializedName("geocoder_status")
    private String GeocoderStatus;
    @SerializedName("place_id")
    private String PlaceId;
    @SerializedName("types")
    private List<String> Types;

    public String getGeocoderStatus() {
        return GeocoderStatus;
    }

    public void setGeocoderStatus(String geocoderStatus) {
        GeocoderStatus = geocoderStatus;
    }

    public String getPlaceId() {
        return PlaceId;
    }

    public void setPlaceId(String placeId) {
        PlaceId = placeId;
    }

    public List<String> getTypes() {
        return Types;
    }

    public void setTypes(List<String> types) {
        Types = types;
    }

}
