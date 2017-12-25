package ru.savchenko.andrey.deliveryapp.activities.map;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;
import com.google.maps.android.PolyUtil;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import ru.savchenko.andrey.deliveryapp.R;
import ru.savchenko.andrey.deliveryapp.base.BaseActivity;
import ru.savchenko.andrey.deliveryapp.di.ComponentManager;
import ru.savchenko.andrey.deliveryapp.entities.map.Distance;
import ru.savchenko.andrey.deliveryapp.entities.map.Duration;
import ru.savchenko.andrey.deliveryapp.entities.map.Leg;
import ru.savchenko.andrey.deliveryapp.network.MapService;

import static ru.savchenko.andrey.deliveryapp.activities.main.DeliveryActivity.TAG;

public class MapsActivity extends BaseActivity implements OnMapReadyCallback {

    @BindView(R.id.tvTitle)
    TextView tvTitle;
    @BindView(R.id.tvText)
    TextView tvText;
    @BindView(R.id.tvTimer)
    TextView tvTimer;
    @BindView(R.id.tvDistance)
    TextView tvDistance;
    @Inject
    MapService mapService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        ComponentManager.getAppComponent().inject(this);
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
        LatLng krasnodar = new LatLng(45.6415289, 39.7055977);
        LatLng myCoords = new LatLng(45.4415289, 39.5055977);

        googleMap.getUiSettings().setZoomControlsEnabled(true);
        googleMap.getUiSettings().setMyLocationButtonEnabled(true);

        //get directions between two points
        mapService.getDirection("45.6415289,39.7055977",
                "45.4415289,39.5055977",
                "AIzaSyDAI8tMCJiA2PQYE9F__J2dmT1APUxTetA")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(o -> {
                    Log.i(TAG, "onViewCreated: " + o);
                            Leg leg = o.getRoutes().get(0).getLegs().get(0);
                    Distance distance = leg.getDistance();
                    tvDistance.setText(distance.getText());
                    Duration duration = leg.getDuration();
                    tvTimer.setText(duration.getText());
                    drawPrimaryLinePath(PolyUtil.decode(o.getRoutes().get(0).getOverviewPolyline().getPoints()), googleMap);
                },
                throwable -> throwable.printStackTrace());
    }

    private void drawPrimaryLinePath(List<LatLng>mPoints, GoogleMap mGoogleMap) {

        PolylineOptions line = new PolylineOptions();
        line.width(4f).color(R.color.cardview_dark_background);
        LatLngBounds.Builder latLngBuilder = new LatLngBounds.Builder();
        LatLng whereUserMarker = null;
        for (int i = 0; i < mPoints.size(); i++) {
            if (i == 0) {
                MarkerOptions startMarkerOptions = new MarkerOptions()
                        .position(mPoints.get(i))
                        .icon(bitmapDescriptorFromVector(this, R.drawable.ic_marker))
                        .title("Ваш заказ здесь");
                mGoogleMap.addMarker(startMarkerOptions);
            } else if (i == mPoints.size() - 1) {
                MarkerOptions endMarkerOptions = new MarkerOptions()
                        .position(mPoints.get(i))
                        .icon(bitmapDescriptorFromVector(this, R.drawable.ic_marker))
                        .title("Вы здесь");
                mGoogleMap.addMarker(endMarkerOptions);
                whereUserMarker = endMarkerOptions.getPosition();
            }
            line.add(mPoints.get(i));
            latLngBuilder.include(mPoints.get(i));
        }
        mGoogleMap.addPolyline(line);

        mGoogleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(whereUserMarker, 10f));

//        int size = getResources().getDisplayMetrics().widthPixels;
//        LatLngBounds latLngBounds = latLngBuilder.build();
//        CameraUpdate track = CameraUpdateFactory.newLatLngBounds(latLngBounds, size, size, 25);
//        mGoogleMap.moveCamera(track);
    }

    private BitmapDescriptor bitmapDescriptorFromVector(Context context, int vectorResId) {
        Drawable vectorDrawable = ContextCompat.getDrawable(context, vectorResId);
        vectorDrawable.setBounds(0, 0, vectorDrawable.getIntrinsicWidth(), vectorDrawable.getIntrinsicHeight());
        Bitmap bitmap = Bitmap.createBitmap(vectorDrawable.getIntrinsicWidth(), vectorDrawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        vectorDrawable.draw(canvas);
        return BitmapDescriptorFactory.fromBitmap(bitmap);
    }
}
