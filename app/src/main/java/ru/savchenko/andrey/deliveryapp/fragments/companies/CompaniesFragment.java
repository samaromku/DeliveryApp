package ru.savchenko.andrey.deliveryapp.fragments.companies;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import ru.savchenko.andrey.deliveryapp.R;
import ru.savchenko.andrey.deliveryapp.adapters.CompaniesAdapter;
import ru.savchenko.andrey.deliveryapp.base.BaseFragment;
import ru.savchenko.andrey.deliveryapp.entities.Company;
import ru.savchenko.andrey.deliveryapp.interfaces.OnCircleSet;
import ru.savchenko.andrey.deliveryapp.interfaces.OnItemClickListener;
import ru.savchenko.andrey.deliveryapp.view.CircleTransform;

import static ru.savchenko.andrey.deliveryapp.activities.auth.AuthActivity.TAG;

/**
 * Created by savchenko on 20.12.17.
 */

public class CompaniesFragment extends BaseFragment implements OnItemClickListener, OnCircleSet{
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
        changeToolbarTitle(R.string.companies_partners);

        rvCompanies.setLayoutManager(
                new GridLayoutManager(getActivity(), 5));
        adapter = new CompaniesAdapter();
        setAdapterWithScreen();
        rvCompanies.setHasFixedSize(true);
        List<Company>companies = new ArrayList<>();

        companies.add(new Company(1, "2 берега", "https://spb.zakazaka.ru/db/348/772/org625.jpg"));
        companies.add(new Company(2, "Газелькин", "https://public.superjob.ru/images/clients_logos.ru/603366_f65f9c18cf57ff58170a281ccc865fd2.jpg"));
        companies.add(new Company(3, "Токио Сити", "https://pp.userapi.com/c618820/v618820621/a762/UHYX3xjPjhY.jpg"));
        companies.add(new Company(4, "Пицца оллис", "https://spb.zakazaka.ru/db/403/146/org306.jpg"));
        companies.add(new Company(5, "Lucky pizza", "https://spb.zakazaka.ru/db/970/361/image.c.1943000.jpg"));
        companies.add(new Company(6, "Telepizza", "https://spb.zakazaka.ru/db/493/241/image.c.40031.jpg"));
        companies.add(new Company(7, "Две палочки", "https://spb.zakazaka.ru/db/896/543/org1148.jpg"));
        companies.add(new Company(8, "MiaSushi", "https://spb.zakazaka.ru/db/930/317/org676.jpg"));
        companies.add(new Company(9, "Хочу шашлык", "https://spb.zakazaka.ru/db/848/958/image.c.42614.jpg"));
        companies.add(new Company(10, "Пиворама", "https://spb.zakazaka.ru/db/289/208/image.c.45775.jpg"));
        companies.add(new Company(11, "Брынза", "https://spb.zakazaka.ru/db/258/697/org312.jpg"));
        companies.add(new Company(12, "Евразия", "https://spb.zakazaka.ru/db/399/637/org1187.jpg"));
        companies.add(new Company(13, "Шашлычный двор", "https://spb.zakazaka.ru/db/824/584/org146.jpg"));
        companies.add(new Company(14, "Невские суши", "https://spb.zakazaka.ru/db/250/514/image.c.114190.jpg"));
        companies.add(new Company(15, "Васаби", "https://spb.zakazaka.ru/db/215/776/org151.jpg"));
        companies.add(new Company(16, "Кухня на углях", "https://spb.zakazaka.ru/db/408/402/image.c.695524.jpg"));

        adapter.setClickListener(this);
        adapter.setDataList(companies);
        adapter.setOnCircleSet(this);
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

    @Override
    public void onCircleSet(String url, ImageView imageView) {
        Picasso.with(getActivity()).load(url).transform(new CircleTransform()).into(imageView);
    }

    @Override
    public void onClickReview(int position) {

    }
}
