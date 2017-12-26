
package ru.savchenko.andrey.deliveryapp.entities.map;

import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class RouteResponse {

    @SerializedName("geocoded_waypoints")
    private List<GeocodedWaypoint> GeocodedWaypoints;
    @SerializedName("routes")
    private List<Route> Routes;
    @SerializedName("status")
    private String Status;

    public List<GeocodedWaypoint> getGeocodedWaypoints() {
        return GeocodedWaypoints;
    }

    public void setGeocodedWaypoints(List<GeocodedWaypoint> geocodedWaypoints) {
        GeocodedWaypoints = geocodedWaypoints;
    }

    public List<Route> getRoutes() {
        return Routes;
    }

    public void setRoutes(List<Route> routes) {
        Routes = routes;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

}
