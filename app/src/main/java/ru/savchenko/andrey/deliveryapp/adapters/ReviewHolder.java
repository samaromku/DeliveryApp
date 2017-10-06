package ru.savchenko.andrey.deliveryapp.adapters;

import android.support.annotation.ColorRes;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.joda.time.DateTime;

import butterknife.BindView;
import butterknife.ButterKnife;
import ru.savchenko.andrey.deliveryapp.R;
import ru.savchenko.andrey.deliveryapp.entities.Review;
import ru.savchenko.andrey.deliveryapp.interfaces.OnItemClickListener;

/**
 * Created by Andrey on 06.10.2017.
 */

public class ReviewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    @BindView(R.id.tvTitle) TextView tvTitle;
    @BindView(R.id.tvDate) TextView tvDate;
    @BindView(R.id.tvUserName) TextView tvUserName;
    @BindView(R.id.tvReviewBody) TextView tvReviewBody;
    @BindView(R.id.btnReview) Button btnReview;
    private OnItemClickListener clickListener;

    public ReviewHolder(View itemView, OnItemClickListener clickListener) {
        super(itemView);
        this.clickListener = clickListener;
        itemView.setOnClickListener(this);
        ButterKnife.bind(this, itemView);
    }

    @Override
    public void onClick(View v) {
        clickListener.onClick(getAdapterPosition());
    }

    void bind(Review review) {
        DateTime date = review.getDateTime();
        tvDate.setText(date.getDayOfMonth() + ":" + date.getMonthOfYear() + ":" + date.getYear());
        tvTitle.setText(review.getTitle());
        tvReviewBody.setText(review.getBody());
        tvUserName.setText(review.getUserName());
        btnReview.setText(getBtnText(review.getRating()));
    }

    String getBtnText(int rating) {
        switch (rating) {
            case 1:
                setBackBtnColor(R.color.colorRed);
                return "Ужс";
            case 2:
                setBackBtnColor(R.color.colorLightRed);
                return "Плх";
            case 3:
                setBackBtnColor(R.color.colorYellow);
                return "Нрм";
            case 4:
                setBackBtnColor(R.color.colorAccent);
                return "Хор";
            case 5:
                setBackBtnColor(R.color.colorPrimary);
                return "Отл";
            default:
                return "";
        }
    }

    private void setBackBtnColor(@ColorRes int color){
        btnReview.setBackgroundResource(color);
    }
}
