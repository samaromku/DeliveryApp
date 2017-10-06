package ru.savchenko.andrey.deliveryapp.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import java.util.List;

import ru.savchenko.andrey.deliveryapp.entities.Review;
import ru.savchenko.andrey.deliveryapp.fragments.review.ReviewViewHolderFactory;
import ru.savchenko.andrey.deliveryapp.interfaces.OnItemClickListener;

/**
 * Created by savchenko on 12.09.17.
 */

public class ReviewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<Review> reviewList;
    private OnItemClickListener clickListener;
    private ReviewViewHolderFactory factory;

    public ReviewAdapter(List<Review> reviewList, ReviewViewHolderFactory factory) {
        this.reviewList = reviewList;
        this.factory = factory;
    }

//    public ReviewAdapter(OnItemClickListener clickListener) {
//        this.clickListener = clickListener;
//    }

//    public void setData(List<Review> reviews) {
//        this.reviewList = reviews;
//    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return factory.createReviewHolder(parent);
//        return new ReviewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_review, parent, false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Review review = reviewList.get(position);
        ((ReviewHolder) holder).bind(review);
    }

    @Override
    public int getItemCount() {
        return reviewList.size();
    }

//    private class ReviewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
//        TextView tvTitle;
//        TextView tvDate;
//        TextView tvUserName;
//        TextView tvReviewBody;
//        Button btnReview;
//
//        ReviewHolder(View itemView) {
//            super(itemView);
//            tvDate = itemView.findViewById(R.id.tvDate);
//            tvTitle = itemView.findViewById(R.id.tvTitle);
//            tvUserName = itemView.findViewById(R.id.tvUserName);
//            tvReviewBody = itemView.findViewById(R.id.tvReviewBody);
//            btnReview = itemView.findViewById(R.id.btnReview);
//            itemView.setOnClickListener(this);
//        }
//
//        @Override
//        public void onClick(View v) {
//            clickListener.onClick(getAdapterPosition());
//        }
//
//        void bind(Review review) {
//            DateTime date = review.getDateTime();
//            tvDate.setText(date.getDayOfMonth() + ":" + date.getMonthOfYear() + ":" + date.getYear());
//            tvTitle.setText(review.getTitle());
//            tvReviewBody.setText(review.getBody());
//            tvUserName.setText(review.getUserName());
//            btnReview.setText(getBtnText(review.getRating()));
//        }
//
//        String getBtnText(int rating) {
//            switch (rating) {
//                case 1:
//                    setBackBtnColor(R.color.colorRed);
//                    return "Ужс";
//                case 2:
//                    setBackBtnColor(R.color.colorLightRed);
//                    return "Плх";
//                case 3:
//                    setBackBtnColor(R.color.colorYellow);
//                    return "Нрм";
//                case 4:
//                    setBackBtnColor(R.color.colorAccent);
//                    return "Хор";
//                case 5:
//                    setBackBtnColor(R.color.colorPrimary);
//                    return "Отл";
//                default:
//                    return "";
//            }
//        }
//
//        private void setBackBtnColor(@ColorRes int color){
//            btnReview.setBackgroundResource(color);
//        }
//    }
}
