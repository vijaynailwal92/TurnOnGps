package com.vijay.turnongps;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.google.android.gms.maps.model.LatLng;

import java.text.DecimalFormat;

public class Distance extends AppCompatActivity {
    double sum = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_distance);
        total_disatance();
    }

    private String total_disatance() {

        double lat1 = 28.610955;
        double lon1 = 77.0937283;
        LatLng latLng1 = new LatLng(lat1, lon1);

        double lat2 = 28.617617;
        double lon2 = 77.0929604;
        LatLng latLng2 = new LatLng(lat2, lon2);

        double lat3 = 28.6123655;
        double lon3 = 77.0940937;
        LatLng latLng3 = new LatLng(lat3, lon3);


        LatLng lat_long_list[] = {latLng1, latLng2, latLng3};

        for (int i = 0; i < 2; i++) {
            double distance = CalculationByDistance(lat_long_list[i], lat_long_list[i + 1]);
            sum += distance;


        }
        Log.e("sum ----- ", String.valueOf(sum));




        DecimalFormat decimalFormat= new DecimalFormat("#.##");
        Log.e("after round off ", String.valueOf(Double.valueOf(decimalFormat.format(sum))));

        return "";
    }


    public double CalculationByDistance(LatLng StartP, LatLng EndP) {
        int Radius = 6371;// radius of earth in Km

        double dLat = Math.toRadians(EndP.latitude - StartP.latitude);
        double dLon = Math.toRadians(EndP.longitude - EndP.longitude);


        double a = Math.sin(dLat / 2) * Math.sin(dLat / 2)
                + Math.cos(Math.toRadians(StartP.latitude))
                * Math.cos(Math.toRadians(EndP.latitude)) * Math.sin(dLon / 2)
                * Math.sin(dLon / 2);

        double c = 2 * Math.asin(Math.sqrt(a));
        double valueResult = Radius * c;
        double km = valueResult / 1;
        DecimalFormat newFormat = new DecimalFormat("####");
        int kmInDec = Integer.valueOf(newFormat.format(km));
        double meter = valueResult % 1000;
        int meterInDec = Integer.valueOf(newFormat.format(meter));
//        Log.e("Radius Value", "" + valueResult + "   KM  " + kmInDec + " Meter   " + meterInDec);

        return Radius * c;
    }


}
