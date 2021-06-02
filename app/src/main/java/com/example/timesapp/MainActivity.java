package com.example.timesapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView timesTableView = findViewById(R.id.timesTableView);
        SeekBar tableNumber = findViewById(R.id.seekBar);
        tableNumber.setMax(20);
        tableNumber.setProgress(6);
        fetchList(timesTableView, tableNumber.getProgress());
        tableNumber.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                int min = 1;
                int timesTableNumber;
                if (progress < min) {
                    timesTableNumber = min;
                    seekBar.setProgress(min);
                } else {
                    timesTableNumber = progress;
                }
                fetchList(timesTableView, timesTableNumber);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    private void fetchList(ListView timesTableView, int progress) {
        List<Integer> tableList = new ArrayList<>(10);
        for (int i = 1; i <= 10; i++) {
            tableList.add(progress * i);
        }

        ArrayAdapter<Integer> arrayAdapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1, tableList);
        timesTableView.setAdapter(arrayAdapter);
    }

}