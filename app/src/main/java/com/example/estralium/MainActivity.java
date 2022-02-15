package com.example.estralium;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView logs, tvWoodCuttingLevel, tvWoodCuttingXpLeft, tvPlayerLevel;
    final String levelDisplay = "Level: ";
    boolean isMuted = true;

    Player player = new Player();
    Gather gather = new Gather();
    Inventory invent = new Inventory();
    SoundPlayer gatherSound = new SoundPlayer();
    SoundPlayer levelUpSound = new SoundPlayer();

    ProgressBar woodCuttingPb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void Chop(View view) {
        woodCuttingPb = findViewById(R.id.progressBarWoodCutting);
        if (view.getId() == R.id.buttonChop)
        {
            gatherSound.Play(this, R.raw.axe_chop, isMuted);
            logs = findViewById(R.id.textViewLogs);
            gather.Harvest(invent, 1, view.getId(), player);
            logs.setText(String.valueOf(invent.numOfLogs));
            ProgressBar(player);
            player.checkIfLevel(this,"Woodcutting",  isMuted);
        }






    }

    public void ProgressBar(Player player)
    {
        woodCuttingPb.setMax((int)player.getWoodCuttingXpNeeded());

        woodCuttingPb.setProgress(player.getWoodCuttingXp());
    }








}