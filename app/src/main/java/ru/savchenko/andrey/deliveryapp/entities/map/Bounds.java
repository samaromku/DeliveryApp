
package ru.savchenko.andrey.deliveryapp.entities.map;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class Bounds {

    @SerializedName("northeast")
    private ru.savchenko.andrey.deliveryapp.entities.map.Northeast Northeast;
    @SerializedName("southwest")
    private ru.savchenko.andrey.deliveryapp.entities.map.Southwest Southwest;

    public ru.savchenko.andrey.deliveryapp.entities.map.Northeast getNortheast() {
        return Northeast;
    }

    public void setNortheast(ru.savchenko.andrey.deliveryapp.entities.map.Northeast northeast) {
        Northeast = northeast;
    }

    public ru.savchenko.andrey.deliveryapp.entities.map.Southwest getSouthwest() {
        return Southwest;
    }

    public void setSouthwest(ru.savchenko.andrey.deliveryapp.entities.map.Southwest southwest) {
        Southwest = southwest;
    }

}
