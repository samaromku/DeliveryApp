package ru.savchenko.andrey.deliveryapp.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;

import ru.savchenko.andrey.deliveryapp.R;

/**
 * Created by Andrey on 11.09.2017.
 */

public class FindCourierFragment extends Fragment implements OnMapReadyCallback {
    public static final String TAG = "";
    private GoogleMap mMap;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_map, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setUpMapIfNeeded();
    }

    private void setUpMapIfNeeded() {
        // Do a null check to confirm that we have not already instantiated the map.
        if (mMap == null) {
            // Try to obtain the map from the SupportMapFragment.
//            mMap = ((SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.map1)).getMapAsync(googleMap -> Log.i(TAG, "setUpMapIfNeeded: "));
            // Check if we were successful in obtaining the map.
            if (mMap != null) {
                setUpMap();
            }
        }
    }

    private void setUpMap() {
//        mMap.setMyLocationEnabled(true);//выводим индикатор своего местоположения
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {

    }
}
