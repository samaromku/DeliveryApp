
package ru.savchenko.andrey.deliveryapp.entities.map;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class Step {

    @SerializedName("distance")
    private ru.savchenko.andrey.deliveryapp.entities.map.Distance Distance;
    @SerializedName("duration")
    private ru.savchenko.andrey.deliveryapp.entities.map.Duration Duration;
    @SerializedName("end_location")
    private ru.savchenko.andrey.deliveryapp.entities.map.EndLocation EndLocation;
    @SerializedName("html_instructions")
    private String HtmlInstructions;
    @SerializedName("polyline")
    private ru.savchenko.andrey.deliveryapp.entities.map.Polyline Polyline;
    @SerializedName("start_location")
    private ru.savchenko.andrey.deliveryapp.entities.map.StartLocation StartLocation;
    @SerializedName("travel_mode")
    private String TravelMode;

    public ru.savchenko.andrey.deliveryapp.entities.map.Distance getDistance() {
        return Distance;
    }

    public void setDistance(ru.savchenko.andrey.deliveryapp.entities.map.Distance distance) {
        Distance = distance;
    }

    public ru.savchenko.andrey.deliveryapp.entities.map.Duration getDuration() {
        return Duration;
    }

    public void setDuration(ru.savchenko.andrey.deliveryapp.entities.map.Duration duration) {
        Duration = duration;
    }

    public ru.savchenko.andrey.deliveryapp.entities.map.EndLocation getEndLocation() {
        return EndLocation;
    }

    public void setEndLocation(ru.savchenko.andrey.deliveryapp.entities.map.EndLocation endLocation) {
        EndLocation = endLocation;
    }

    public String getHtmlInstructions() {
        return HtmlInstructions;
    }

    public void setHtmlInstructions(String htmlInstructions) {
        HtmlInstructions = htmlInstructions;
    }

    public ru.savchenko.andrey.deliveryapp.entities.map.Polyline getPolyline() {
        return Polyline;
    }

    public void setPolyline(ru.savchenko.andrey.deliveryapp.entities.map.Polyline polyline) {
        Polyline = polyline;
    }

    public ru.savchenko.andrey.deliveryapp.entities.map.StartLocation getStartLocation() {
        return StartLocation;
    }

    public void setStartLocation(ru.savchenko.andrey.deliveryapp.entities.map.StartLocation startLocation) {
        StartLocation = startLocation;
    }

    public String getTravelMode() {
        return TravelMode;
    }

    public void setTravelMode(String travelMode) {
        TravelMode = travelMode;
    }

}
