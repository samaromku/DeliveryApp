package ru.savchenko.andrey.deliveryapp.adapters;

import android.support.annotation.ColorRes;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import org.joda.time.DateTime;

import butterknife.BindView;
import butterknife.ButterKnife;
import ru.savchenko.andrey.deliveryapp.R;
import ru.savchenko.andrey.deliveryapp.base.BaseAdapter;
import ru.savchenko.andrey.deliveryapp.base.BaseViewHolder;
import ru.savchenko.andrey.deliveryapp.entities.Review;
import ru.savchenko.andrey.deliveryapp.interfaces.OnItemClickListener;

/**
 * Created by savchenko on 12.09.17.
 */

public class ReviewAdapter extends BaseAdapter<Review> {
    @Override
    public BaseViewHolder<Review> onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_review, parent, false);
        return new ReviewViewHolder(view);
    }

    class ReviewViewHolder extends BaseViewHolder<Review>{

        @BindView(R.id.tvTitle) TextView tvTitle;
        @BindView(R.id.tvDate) TextView tvDate;
        @BindView(R.id.tvUserName) TextView tvUserName;
        @BindView(R.id.tvReviewBody) TextView tvReviewBody;
        @BindView(R.id.btnReview) Button btnReview;

        ReviewViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            ButterKnife.bind(this, itemView);
        }
        @Override
        public void bind(Review review, OnItemClickListener clickListener) {
            super.bind(review, clickListener);
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
}
