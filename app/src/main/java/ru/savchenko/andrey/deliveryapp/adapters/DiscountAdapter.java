package ru.savchenko.andrey.deliveryapp.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;
import ru.savchenko.andrey.deliveryapp.R;
import ru.savchenko.andrey.deliveryapp.base.BaseAdapter;
import ru.savchenko.andrey.deliveryapp.base.BaseViewHolder;
import ru.savchenko.andrey.deliveryapp.entities.Discount;
import ru.savchenko.andrey.deliveryapp.interfaces.OnItemClickListener;
import ru.savchenko.andrey.deliveryapp.view.CircleTransform;


/**
 * Created by Andrey on 30.09.2017.
 */

public class DiscountAdapter extends BaseAdapter<Discount> {
    private Context context;

    public void setContext(Context context) {
        this.context = context;
    }

    @Override
    public BaseViewHolder<Discount> onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_discount, parent, false);
        return new DiscountViewHolder(view);
    }

    class DiscountViewHolder extends BaseViewHolder<Discount>{
        @BindView(R.id.tvTitle)TextView tvTitle;
        @BindView(R.id.tvCompanyName)TextView tvCompanyName;
        @BindView(R.id.tvBody)TextView tvBody;
        @BindView(R.id.ivDiscontImage)ImageView ivDiscontImage;

        @Override
        public void bind(Discount discount, OnItemClickListener clickListener) {
            super.bind(discount, clickListener);
            tvTitle.setText(discount.getTitle());
            tvBody.setText(discount.getBody());
            tvCompanyName.setText(discount.getCompany());
            Picasso.with(context).load(discount.getImageUrl())
                    .transform(new CircleTransform())
                    .into(ivDiscontImage);
        }

        public DiscountViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
