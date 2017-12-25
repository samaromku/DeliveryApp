package ru.savchenko.andrey.deliveryapp.adapters;

import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import ru.savchenko.andrey.deliveryapp.R;
import ru.savchenko.andrey.deliveryapp.base.BaseAdapter;
import ru.savchenko.andrey.deliveryapp.base.BaseViewHolder;
import ru.savchenko.andrey.deliveryapp.entities.Company;
import ru.savchenko.andrey.deliveryapp.interfaces.OnCircleSet;
import ru.savchenko.andrey.deliveryapp.interfaces.OnItemClickListener;

/**
 * Created by savchenko on 20.12.17.
 */

public class CompaniesAdapter extends BaseAdapter<Company> {
    private int widthScreen;
    private OnCircleSet onCircleSet;

    public void setOnCircleSet(OnCircleSet onCircleSet) {
        this.onCircleSet = onCircleSet;
    }

    public void setWidthScreen(int widthScreen) {
        this.widthScreen = widthScreen;
    }

    @Override
    public BaseViewHolder<Company> onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_company, parent, false);
        return new CompanyViewHolder(view);
    }

    class CompanyViewHolder extends BaseViewHolder<Company>{
        @BindView(R.id.tvCompanyName)TextView tvCompanyName;
        @BindView(R.id.cvCompany)CardView cvCompany;
        @BindView(R.id.ivCompanyLogo)ImageView ivCompanyLogo;

        CompanyViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        @Override
        public void bind(Company company, OnItemClickListener clickListener) {
            super.bind(company, clickListener);
            tvCompanyName.setText(company.getCompanyName());
            int width = widthScreen / 5;
            cvCompany.getLayoutParams().width = width;
            cvCompany.getLayoutParams().height = width + 64;
            onCircleSet.onCircleSet(company.getUrl(), ivCompanyLogo);
        }
    }
}
