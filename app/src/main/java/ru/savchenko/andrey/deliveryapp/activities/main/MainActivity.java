package ru.savchenko.andrey.deliveryapp.activities.main;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.annotation.StringRes;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import javax.inject.Inject;

import ru.savchenko.andrey.deliveryapp.App;
import ru.savchenko.andrey.deliveryapp.R;
import ru.savchenko.andrey.deliveryapp.base.BaseActivity;
import ru.savchenko.andrey.deliveryapp.base.BaseFragment;
import ru.savchenko.andrey.deliveryapp.di.main.MainComponent;
import ru.savchenko.andrey.deliveryapp.di.main.MainModule;
import ru.savchenko.andrey.deliveryapp.fragments.companies.CompaniesFragment;
import ru.savchenko.andrey.deliveryapp.fragments.discount.DiscountFragment;
import ru.savchenko.andrey.deliveryapp.fragments.review.ReviewFragment;
import ru.savchenko.andrey.deliveryapp.fragments.current_orders.FragmentCurrentOrders;
import ru.savchenko.andrey.deliveryapp.fragments.delivered.DeliveredFragment;
import ru.savchenko.andrey.deliveryapp.interfaces.OnChangeTitle;

public class MainActivity extends BaseActivity implements
        NavigationView.OnNavigationItemSelectedListener,
        OnChangeTitle,
        MainView {
    public static final String TAG = "MainActivity";
    @Inject MainPresenter presenter;

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delivery);
        ((MainComponent)App.getComponentManager()
                .getPresenterComponent(getClass(), new MainModule(this))).inject(this);
        initToolbar(R.string.app_name);



//        fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(view -> Log.i(TAG, "onCreate: fab"));

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        onNavigationItemSelected(navigationView.getMenu().findItem(R.id.nav_not_delivered));

        View header=navigationView.getHeaderView(0);
        TextView tvStatus = header.findViewById(R.id.tvStatus);
        TextView tvName = header.findViewById(R.id.tvName);
        tvStatus.setText("Статус: Лучший клиент");
        tvName.setText("Имя: Я есть Грут");
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.delivery, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_search) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.nav_not_delivered:
                openFragment(new FragmentCurrentOrders());
                return closeDrawer(true);
            case R.id.nav_delivered:
                openFragment(new DeliveredFragment());
                return closeDrawer(true);
            case R.id.nav_review:
                openFragment(new ReviewFragment());
                return closeDrawer(true);
            case R.id.nav_exit:
                finishAffinity();
                return closeDrawer(true);
            case R.id.nav_discount:
                openFragment(new DiscountFragment());
                return closeDrawer(true);
            case R.id.nav_companies:
                openFragment(new CompaniesFragment());
                return closeDrawer(true);
            default:
                return closeDrawer(true);
        }
    }

    private void openFragment(BaseFragment fragment){
        fragment.setOnChangeTitle(this);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, fragment)
                .commit();
    }

    private boolean closeDrawer(boolean isClose){
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return isClose;
    }

    @Override
    public void changeTitle(@StringRes int title) {
        changeToolbarTitle(title);
    }

    @Override
    protected void onStop() {
        super.onStop();
        if(isFinishing()){
            Log.i(TAG, "onDestroy: really");
        }else {
            Log.i(TAG, "onDestroy: not really");
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

    }
}
