package ru.savchenko.andrey.deliveryapp.adapters;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;

import java.util.List;

import ru.savchenko.andrey.deliveryapp.R;
import ru.savchenko.andrey.deliveryapp.entities.Order;
import ru.savchenko.andrey.deliveryapp.interfaces.OnItemClickListener;
import ru.savchenko.andrey.deliveryapp.interfaces.OnSetTime;
import ru.savchenko.andrey.deliveryapp.storage.Const;
import ru.savchenko.andrey.deliveryapp.storage.Utils;

import static ru.savchenko.andrey.deliveryapp.activities.main.DeliveryActivity.TAG;

/**
 * Created by Andrey on 09.09.2017.
 */

public class CurrentOrdersAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<Order> ordersList;
    private OnItemClickListener clickListener;
    private int DELIVERED_STATUS = 0;
    private int NOT_DELIVERED_STATUS = 1;


    public CurrentOrdersAdapter(OnItemClickListener clickListener){
        this.clickListener = clickListener;
    }

    public void setData(List<Order>ordersList){
        this.ordersList = ordersList;
    }

    public void addNewItems(List<Order> items) {
        ordersList.addAll(items);
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder (ViewGroup parent, int viewType) {
        View view;
        if(viewType==DELIVERED_STATUS){
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_delivered, parent, false);
            return new DeliveredHolder(view);
        }else {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_order, parent, false);
            return new NotDeliveredHolder(view);
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Order order = ordersList.get(position);
        if(holder instanceof NotDeliveredHolder){
            ((NotDeliveredHolder)holder).bind(order);
        }else
            ((DeliveredHolder)holder).bind(order);
    }

    @Override
    public int getItemCount() {
        if(ordersList ==null)return 0;
        return ordersList.size();
    }

    @Override
    public int getItemViewType(int position) {
        Order order = ordersList.get(position);
        if(order.getStatus()== Const.DELIVERED){
            return DELIVERED_STATUS;
        }else return NOT_DELIVERED_STATUS;
    }

    private class NotDeliveredHolder extends RecyclerView.ViewHolder implements View.OnClickListener, OnSetTime{
        TextView tvOrderBody;
        TextView tvTime;
        Button btnTime;
        OnSetTime onSetTime;
        TextView tvWay;

        NotDeliveredHolder(View itemView) {
            super(itemView);
            onSetTime = this;
            tvOrderBody = itemView.findViewById(R.id.tvOrderBody);
            tvTime = itemView.findViewById(R.id.tvTime);
            btnTime = itemView.findViewById(R.id.btnTime);
            tvWay = itemView.findViewById(R.id.tvWay);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            clickListener.onclick(getAdapterPosition());
        }

        void bind(Order order){
            Log.i(TAG, "bind: " + order);
            tvOrderBody.setText(order.getBody());
            tvWay.setText("Расстояние: " + order.getWay() + "км");
            Utils.getDifferenceString(order.getCreated(), order.getDeadLine(), onSetTime);
        }

        @Override
        public void setMinutes(int minutes, String text) {
            btnTime.setText(text);
            tvTime.setText(String.valueOf(minutes));
        }
    }

    private class DeliveredHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView tvOrderBody;
        RatingBar ratingOrder;


        DeliveredHolder(View itemView) {
            super(itemView);
            tvOrderBody = itemView.findViewById(R.id.tvOrderBody);
            ratingOrder = itemView.findViewById(R.id.ratingOrder);
            itemView.setOnClickListener(this);
        }

        void bind(Order order){
            tvOrderBody.setText(order.getBody());
            ratingOrder.setRating(order.getRating());
        }

        @Override
        public void onClick(View view) {
            clickListener.onclick(getAdapterPosition());
        }
    }
}