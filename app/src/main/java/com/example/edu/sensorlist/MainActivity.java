package com.example.edu.sensorlist;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    TextView textViewSensorList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewSensorList = findViewById(R.id.textViewSensorList);

        StringBuffer report = new StringBuffer();
        SensorManager sensorManager = (SensorManager)getSystemService(Context.SENSOR_SERVICE);
        List<Sensor> sensorList = sensorManager.getSensorList(Sensor.TYPE_ALL);
        report.append("All Sensor:").append(sensorList.size()).append("\n");
        int i = 0;
        /*for(Sensor sensor:sensorList){
            report.append(i++ + "Name:" + sensor.getName() + "\n")
                    .append("\t Power :" + sensor.getPower() + "\n")
                    .append("\t Resolution" + sensor.getResolution() + "\n")
                    .append("\t Range" + sensor.getMaximumRange() + "\n");
        }*/
        for (Sensor sensor : sensorList) {
            report.append(i++ + " : " + sensor.toString() + "\n");
        }
        textViewSensorList.setText(report.toString());
    }
}
