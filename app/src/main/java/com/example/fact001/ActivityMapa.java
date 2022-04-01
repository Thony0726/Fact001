package com.example.fact001;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Point;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.Projection;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MapStyleOptions;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;

public class ActivityMapa extends AppCompatActivity implements OnMapReadyCallback {
    private GoogleMap mMap;
    private Button paris, bog, pira, toastP;
    private RadioButton estilo1, estilo2;
    private Spinner modos;
    private ToggleButton zoom;

    private Double latC = 0.0287957200001;
    private Double  LongC= -78.1492354367;

    private Double latE = 0.0537;
    private Double  LongE= -78.1394 ;

    private CameraPosition posi;
    private LatLng DatosParis;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mapa);

        paris=findViewById(R.id.paris);
        bog=findViewById(R.id.bog);
        pira=findViewById(R.id.pira);
        toastP=findViewById(R.id.toastP);

        estilo1=findViewById(R.id.estilo1);
        estilo2=findViewById(R.id.estilo2);

        modos=(Spinner) findViewById(R.id.modos);
        zoom=findViewById(R.id.zoom);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);


        ArrayList<String> tipo = new ArrayList<>();
        tipo.add("NORMAL");
        tipo.add("SATELITE");
        tipo.add("TERRENO");
        tipo.add("HÍBRIDO");
        modos.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item,tipo));


        modos.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i){
                    case 0:
                        mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
                        break;
                    case 1 :
                        mMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
                        break;
                    case 2 :
                        mMap.setMapType(GoogleMap.MAP_TYPE_TERRAIN);
                        break;
                    case 3 :
                        mMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
                        break;
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
    }

    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {
        mMap = googleMap;


        // Add a marker in Sydney and move the camera
        LatLng sydney = new LatLng(-34, 151);
        mMap.addMarker(new MarkerOptions()
                .position(sydney)
                .title("Marker in Sydney"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));

        //bogota
        bog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LatLng suc1 = new LatLng(latC, LongC);

                mMap.addMarker(new MarkerOptions()
                        .position(suc1)
                        .title("Cayambe (Parque-Yaznan)"));

                CameraUpdate camaraBog = CameraUpdateFactory.newLatLngZoom(
                        new LatLng(latC, LongC),8
                );
                mMap.moveCamera(camaraBog);
                CameraPosition camPos = new CameraPosition.Builder()
                        .target(suc1)   //Centramos el mapa en Madrid
                        .zoom(17)         //Establecemos el zoom en 19
                        .bearing(50)      //Establecemos la orientación con el noreste arriba
                        .tilt(65)         //Bajamos el punto de vista de la cámara 70 grados
                        .build();

                CameraUpdate camUpd3 =
                        CameraUpdateFactory.newCameraPosition(camPos);

                mMap.animateCamera(camUpd3);
                Toast.makeText(
                        ActivityMapa.this,
                        "Parque-Yaznan\n" +
                                "Latitud: " + suc1.latitude + "\n" +
                                "Longitud: " + suc1.longitude + "\n" ,
                        Toast.LENGTH_SHORT).show();



            }
        });
        //zoom
        zoom.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                mMap.getUiSettings().setZoomControlsEnabled(b);
            }
        });

        pira.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);

                LatLng suc2 = new LatLng(latE, LongE);

                mMap.addMarker(new MarkerOptions()
                        .position(suc2)
                        .title("Instituto Nelson Isauro Torres"));

                CameraPosition camPos = new CameraPosition.Builder()
                        .target(suc2)   //Centramos el mapa en Madrid
                        .zoom(17)         //Establecemos el zoom en 19
                        .bearing(50)      //Establecemos la orientación con el noreste arriba
                        .tilt(65)         //Bajamos el punto de vista de la cámara 70 grados
                        .build();

                CameraUpdate camUpd3 =
                        CameraUpdateFactory.newCameraPosition(camPos);
                mMap.animateCamera(camUpd3);
                Toast.makeText(
                        ActivityMapa.this,
                        "Instituto Nelson Isauro Torres\n" +
                                "Latitud: " + suc2.latitude + "\n" +
                                "Longitud: " + suc2.longitude + "\n" ,
                        Toast.LENGTH_SHORT).show();


            }
        });
        mMap.setOnMapClickListener(new GoogleMap.OnMapClickListener() {
            @Override
            public void onMapClick(@NonNull LatLng latLng) {
                Projection proj = mMap.getProjection();
                Point coord = proj.toScreenLocation(latLng);

                mMap.addMarker(new MarkerOptions()
                        .position(latLng)
                        .title("Marcador"));

                DatosParis = latLng;

                Toast.makeText(
                        ActivityMapa.this,
                        "Click\n" +
                                "Lat: " + latLng.latitude + "\n" +
                                "Lng: " + latLng.longitude + "\n" +
                                "X: " + coord.x + " - Y: " + coord.y,
                        Toast.LENGTH_SHORT).show();

            }
        });

        mMap.setOnCameraChangeListener(new GoogleMap.OnCameraChangeListener() {
            public void onCameraChange(CameraPosition position) {
                posi = position;
            }
        });


        toastP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(
                        ActivityMapa.this,
                        "Cambio Cámara\n" +
                                "Orientación: " + posi.bearing + "\n" +
                                "Ángulo: " + posi.tilt,
                        Toast.LENGTH_SHORT).show();


            }
        });

        paris.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LatLng suc3 = new LatLng(0.0443054, -78.14534305);

                mMap.addMarker(new MarkerOptions()
                        .position(suc3)
                        .title("Natalia Jarrin"));

                CameraUpdate camaraBog = CameraUpdateFactory.newLatLngZoom(
                        new LatLng(0.0287957200001, -78.1492354367),8
                );
                mMap.moveCamera(camaraBog);

                CameraPosition camPos = new CameraPosition.Builder()
                        .target(suc3)   //Centramos el mapa en Madrid
                        .zoom(17)         //Establecemos el zoom en 19
                        .bearing(50)      //Establecemos la orientación con el noreste arriba
                        .tilt(65)         //Bajamos el punto de vista de la cámara 70 grados
                        .build();

                CameraUpdate camUpd3 =
                        CameraUpdateFactory.newCameraPosition(camPos);
                mMap.animateCamera(camUpd3);
                Toast.makeText(
                        ActivityMapa.this,
                        "Natalia Jarrin \n" +
                                "Lat: " + suc3.latitude + "\n" +
                                "Lng: " + suc3.longitude + "\n" ,
                        Toast.LENGTH_SHORT).show();






            }
        });



    }
    public void estilos1 (View v){
        mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
        boolean success = mMap.setMapStyle(new MapStyleOptions(getResources()
                .getString(R.string.style_json)));


    }
    public void estilos2 (View v){
        mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
        boolean success = mMap.setMapStyle(new MapStyleOptions(getResources()
                .getString(R.string.style_json2)));

    }
}