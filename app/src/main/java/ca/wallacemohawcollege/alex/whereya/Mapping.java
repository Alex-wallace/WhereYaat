package ca.wallacemohawcollege.alex.whereya;

import android.database.DataSetObserver;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;
import java.util.List;

public class Mapping extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    List<String> names = new ArrayList<String>();
    List<String> aLat = new ArrayList<String>();
    List<String> aLong = new ArrayList<String>();
    int  position;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mapping);
        names.add(0,"first");
        names.add(1,"second");
        names.add(2,"third");
        aLat.add(0,"0");
        aLong.add(0,"0");
        aLat.add(1,"43");
        aLong.add(1,"70");
        aLat.add(2,"-34");
        aLong.add(2,"108");
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,names) ;
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        final Spinner favs = (Spinner) findViewById(R.id.spinner2);
        favs.setAdapter(adapter);

        favs.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                position = favs.getSelectedItemPosition();
                int Lat = 0;
                int Long = 0;
                try{
                    Lat = Integer.parseInt(aLat.get(position));
                    Long = Integer.parseInt(aLong.get(position));
                }catch (Exception e)
                {
                    e.printStackTrace();
                }
                LatLng pos = new LatLng(Lat,Long);
                mMap.moveCamera(CameraUpdateFactory.newLatLng(pos));
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });




    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        int Lat = 0;
        int Long = 0;
        try{
            Lat = Integer.parseInt(aLat.get(0));
            Long = Integer.parseInt(aLong.get(0));
        }catch (Exception e) {
            e.printStackTrace();
        }
        // Add a marker in Sydney and move the camera
        LatLng sydney = new LatLng(Lat, Long);
        placeMarks();
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
    }

    public void placeMarks(){
        int Lat = 0;
        int Long = 0;
        String name = null;
        for(int x =0; x<names.size();x++) {
            try {
                Lat = Integer.parseInt(aLat.get(x));
                Long = Integer.parseInt(aLong.get(x));
                name = names.get(x);
                LatLng pos = new LatLng(Lat,Long);
                mMap.addMarker(new MarkerOptions().position(pos).title(name));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
