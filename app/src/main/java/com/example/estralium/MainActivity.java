package com.example.estralium;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    /** This MainActivity is not going to be used to gather resources, instead it will be used as a main menu/loading screen on startup.
     *  Individual Activities such as logging_camp.xml will be used for gathering.
     */
    Player player = new Player();
    Resource resource = new Resource("Logs", 1);
    Building building = new Building("LoggingCamp", resource);
    Inventory inventory = new Inventory();
    TextView logs, tvWoodCuttingLevel, tvWoodCuttingXpLeft, tvPlayerLevel;
    boolean isMuted = false;
    ProgressBar pb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void Chop(View view){
        inventory.add(resource);
        player.AddSkillExperience(resource, inventory);
        logs = findViewById(R.id.textViewLogs);
        logs.setText(String.valueOf(inventory.getLog_Quantity()));

    }
}