package ru.savchenko.andrey.deliveryapp.entities;

/**
 * Created by Andrey on 18.12.2017.
 */

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MessageId {

    @SerializedName("message_id")
    @Expose
    private long messageId;

    public long getMessageId() {
        return messageId;
    }

    public void setMessageId(long messageId) {
        this.messageId = messageId;
    }

}
