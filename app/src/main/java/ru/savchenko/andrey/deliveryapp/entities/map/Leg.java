
package ru.savchenko.andrey.deliveryapp.entities.map;

import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class Leg {

    @SerializedName("distance")
    private ru.savchenko.andrey.deliveryapp.entities.map.Distance Distance;
    @SerializedName("duration")
    private ru.savchenko.andrey.deliveryapp.entities.map.Duration Duration;
    @SerializedName("end_address")
    private String EndAddress;
    @SerializedName("end_location")
    private ru.savchenko.andrey.deliveryapp.entities.map.EndLocation EndLocation;
    @SerializedName("start_address")
    private String StartAddress;
    @SerializedName("start_location")
    private ru.savchenko.andrey.deliveryapp.entities.map.StartLocation StartLocation;
    @SerializedName("steps")
    private List<Step> Steps;
    @SerializedName("traffic_speed_entry")
    private List<Object> TrafficSpeedEntry;
    @SerializedName("via_waypoint")
    private List<Object> ViaWaypoint;

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

    public String getEndAddress() {
        return EndAddress;
    }

    public void setEndAddress(String endAddress) {
        EndAddress = endAddress;
    }

    public ru.savchenko.andrey.deliveryapp.entities.map.EndLocation getEndLocation() {
        return EndLocation;
    }

    public void setEndLocation(ru.savchenko.andrey.deliveryapp.entities.map.EndLocation endLocation) {
        EndLocation = endLocation;
    }

    public String getStartAddress() {
        return StartAddress;
    }

    public void setStartAddress(String startAddress) {
        StartAddress = startAddress;
    }

    public ru.savchenko.andrey.deliveryapp.entities.map.StartLocation getStartLocation() {
        return StartLocation;
    }

    public void setStartLocation(ru.savchenko.andrey.deliveryapp.entities.map.StartLocation startLocation) {
        StartLocation = startLocation;
    }

    public List<Step> getSteps() {
        return Steps;
    }

    public void setSteps(List<Step> steps) {
        Steps = steps;
    }

    public List<Object> getTrafficSpeedEntry() {
        return TrafficSpeedEntry;
    }

    public void setTrafficSpeedEntry(List<Object> trafficSpeedEntry) {
        TrafficSpeedEntry = trafficSpeedEntry;
    }

    public List<Object> getViaWaypoint() {
        return ViaWaypoint;
    }

    public void setViaWaypoint(List<Object> viaWaypoint) {
        ViaWaypoint = viaWaypoint;
    }

}
