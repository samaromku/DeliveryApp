package ru.savchenko.andrey.deliveryapp.fragments.companies;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import ru.savchenko.andrey.deliveryapp.R;
import ru.savchenko.andrey.deliveryapp.adapters.CompaniesAdapter;
import ru.savchenko.andrey.deliveryapp.base.BaseFragment;
import ru.savchenko.andrey.deliveryapp.entities.Company;
import ru.savchenko.andrey.deliveryapp.interfaces.OnItemClickListener;

import static ru.savchenko.andrey.deliveryapp.activities.auth.AuthActivity.TAG;

/**
 * Created by savchenko on 20.12.17.
 */

public class CompaniesFragment extends BaseFragment implements OnItemClickListener{
    @BindView(R.id.rvCompanies)RecyclerView rvCompanies;
    private CompaniesAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_companies, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);
        rvCompanies.setLayoutManager(
                new StaggeredGridLayoutManager(5, StaggeredGridLayoutManager.VERTICAL));
        adapter = new CompaniesAdapter();
        setAdapterWithScreen();
        rvCompanies.setHasFixedSize(true);
        List<Company>companies = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            companies.add(new Company(i, "test", "test"));
        }adapter.setClickListener(this);
        adapter.setDataList(companies);
        rvCompanies.setAdapter(adapter);
    }

    @Override
    public void onClick(int position) {
        Log.i(TAG, "onClick: " + position);
    }

    private void setAdapterWithScreen(){
        Display display = getActivity().getWindowManager().getDefaultDisplay();
        int width = display.getWidth();
        adapter.setWidthScreen(width);
    }
}
