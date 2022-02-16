package com.example.estralium;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

public class LoggingCamp extends AppCompatActivity {

    Player player = new Player("woodcutting");
    Resource resource = new Resource("logs", 1);
    Building building = new Building("LoggingCamp", resource);
    Inventory inventory = new Inventory();

    public void Harvest(){

    inventory.add(resource);
    player.AddSkillExperience(resource);


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.logging_camp);
    }

}