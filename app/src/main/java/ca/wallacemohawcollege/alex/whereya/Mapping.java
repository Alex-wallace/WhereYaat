package ca.wallacemohawcollege.alex.whereya;

import android.database.DataSetObserver;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
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
    List<locTable> locations = new ArrayList<locTable>();
    List<String> names = new ArrayList<String>();
    List<String> aLat = new ArrayList<String>();
    List<String> aLong = new ArrayList<String>();
    int  position;
    LatLng cursor = null;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mapping);
        locTable first = new locTable();
        locTable second = new locTable();
        locTable third = new locTable();
        first.setName("First");
        first.setLat("0");
        first.setLon("0");
        second.setName("Second");
        second.setLat("48");
        second.setLon("72");
        third.setName("Third");
        third.setLat("-48");
        third.setLon("-72");
        locations.add(0,first);
        locations.add(1,second);
        locations.add(2,third);
        loc_array();
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,names) ;
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        final Spinner favs = (Spinner) findViewById(R.id.spinner2);
        favs.setAdapter(adapter);
        final Button add = (Button) findViewById(R.id.addbtn);
        final EditText name = (EditText) findViewById(R.id.Nametxt);
        favs.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                position = favs.getSelectedItemPosition();
                double Lat = 0;
                double Long = 0;
                try{
                    Lat = Double.parseDouble(aLat.get(position));
                    Long = Double.parseDouble(aLong.get(position));
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
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(cursor != null)
                {
                    if(!name.getText().equals(""))
                    {
                        locTable item = array_loc(name.getText().toString(),cursor.latitude,cursor.longitude);

                        locations.add(item);
                        names.add(item.getName());
                        aLat.add(item.getLat());
                        aLong.add(item.getLon());
                        //adapter.add(name.getText().toString());
                        mMap.clear();
                        name.setText("");

                        placeMarks();
                    }
                }
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
        double Lat = 0;
        double Long = 0;
        try{
            Lat = Double.parseDouble(aLat.get(0));
            Long = Double.parseDouble(aLong.get(0));
        }catch (Exception e) {
            e.printStackTrace();
        }
        // Add a marker in Sydney and move the camera
        LatLng pos = new LatLng(Lat, Long);
        placeMarks();
        mMap.moveCamera(CameraUpdateFactory.newLatLng(pos));
        mMap.setOnMapClickListener(new GoogleMap.OnMapClickListener(){

            @Override
            public void onMapClick(LatLng latLng) {
                cursor = latLng;
                mMap.addMarker(new MarkerOptions().position(cursor));
            }
        });

    }


    public void placeMarks(){
        double Lat = 0;
        double Long = 0;
        String name = null;
        for(int x =0; x<names.size();x++) {
            try {
                Lat = Double.parseDouble(aLat.get(x));
                Long = Double.parseDouble(aLong.get(x));
                name = names.get(x);
                LatLng pos = new LatLng(Lat,Long);
                mMap.addMarker(new MarkerOptions().position(pos).title(name));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void loc_array()
    {
        for (locTable item:
             locations) {
            names.add(item.getName());
            aLat.add(item.getLat());
            aLong.add(item.getLon());
        }
    }

    private locTable array_loc(String name, double Lat, double Long)
    {
        locTable result = new locTable();
        result.setName(name);
        result.setLat(String.valueOf(Lat));
        result.setLon(String.valueOf(Long));
        return result;

    }

}
