package ru.savchenko.andrey.deliveryapp.viewholders;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;
import ru.savchenko.andrey.deliveryapp.R;
import ru.savchenko.andrey.deliveryapp.base.BaseViewHolder;
import ru.savchenko.andrey.deliveryapp.entities.Discount;
import ru.savchenko.andrey.deliveryapp.interfaces.OnItemClickListener;
import ru.savchenko.andrey.deliveryapp.view.CircleTransform;

/**
 * Created by Andrey on 07.10.2017.
 */

public class DiscountViewHolder extends BaseViewHolder<Discount> {
    @BindView(R.id.tvTitle)TextView tvTitle;
    @BindView(R.id.tvCompanyName)TextView tvCompanyName;
    @BindView(R.id.tvBody)TextView tvBody;
    @BindView(R.id.ivDiscontImage)ImageView ivDiscontImage;
    private Context context;
    private OnItemClickListener clickListener;

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

    public DiscountViewHolder(View itemView, Context context, OnItemClickListener clickListener) {
        super(itemView);
        ButterKnife.bind(this, itemView);
        this.context = context;
        this.clickListener = clickListener;
        itemView.setOnClickListener(this);
    }
}
