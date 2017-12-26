
package ru.savchenko.andrey.deliveryapp.entities.map;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class Duration {

    @SerializedName("text")
    private String Text;
    @SerializedName("value")
    private Long Value;

    public String getText() {
        return Text;
    }

    public void setText(String text) {
        Text = text;
    }

    public Long getValue() {
        return Value;
    }

    public void setValue(Long value) {
        Value = value;
    }

}
