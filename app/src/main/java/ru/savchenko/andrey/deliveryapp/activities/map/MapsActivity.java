package ru.savchenko.andrey.deliveryapp.activities.map;

import android.os.Bundle;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import butterknife.BindView;
import butterknife.ButterKnife;
import ru.savchenko.andrey.deliveryapp.R;
import ru.savchenko.andrey.deliveryapp.base.BaseActivity;

public class MapsActivity extends BaseActivity implements OnMapReadyCallback {

    @BindView(R.id.tvTitle)TextView tvTitle;
    @BindView(R.id.tvText)TextView tvText;
    @BindView(R.id.tvTimer)TextView tvTimer;
    @BindView(R.id.tvDistance)TextView tvDistance;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        initToolbar(R.string.one_order);
        initBackButton();
        ButterKnife.bind(this);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        tvTitle.setText("Крабовые палочки с соусом терияки");
        tvText.setText("n ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum");
        tvDistance.setText("8,1 км");
        tvTimer.setText("01:35");
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {

        // Add a marker in Sydney and move the camera
        LatLng krasnodar = new LatLng(45.6415289, 39.7055977);
        LatLng myCoords = new LatLng(45.4415289, 39.5055977);
        googleMap.addMarker(new MarkerOptions().position(krasnodar).title("Ваш заказ здесь"));
        googleMap.addMarker(new MarkerOptions().position(myCoords).title("Вы здесь"));
        googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(krasnodar, 9.0f));
        googleMap.getUiSettings().setZoomControlsEnabled(true);
        googleMap.getUiSettings().setMyLocationButtonEnabled(true);
    }
}
