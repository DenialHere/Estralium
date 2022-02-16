package com.example.estralium;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    /** This MainActivity is not going to be used to gather resources, instead it will be used as a main menu/loading screen on startup.
     *  Individual Activities such as logging_camp.xml will be used for gathering.
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}