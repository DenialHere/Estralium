package com.example.estralium;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView logs, tvWoodCuttingLevel, tvWoodCuttingXpLeft, tvPlayerLevel;
    final String levelDisplay = "Level: ";
    final String woodCuttingXpLeft = "XP left: ";
    final String logCounter = "Logs: ";

    Player player = new Player();
    Gather gather = new Gather();
    Inventory invent = new Inventory();

    MediaPlayer resourceSound;
    MediaPlayer levelUpSound;

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
            resourceSound = MediaPlayer.create(this, R.raw.wood_chop2);
            resourceSound.start();
            logs = findViewById(R.id.textViewLogs);
            gather.Harvest(invent, 1, view.getId(), player);
            logs.setText(String.valueOf(invent.numOfLogs));
            ProgressBar(player);
        }

        CheckIfLevel(view);




    }

    public void ProgressBar(Player player)
    {
        woodCuttingPb.setMax((int)player.getWoodCuttingXpNeeded());

        woodCuttingPb.setProgress(player.getWoodCuttingXp());
    }
    public void CheckIfLevel(View view){
        DialogueManager dm = new DialogueManager();


        if (view.getId() == R.id.buttonChop)
        {

            if (player.checkIfWoodCuttingLevelUp()) {
                tvWoodCuttingLevel = findViewById(R.id.textViewWoodCuttingLevel);
                ProgressBar(player);
                tvWoodCuttingLevel.setText(levelDisplay + player.getWoodCuttingLevelString());
                dm.Show(this, player.getWoodCuttingLevel(), "Woodcutting");
            }
        }

        if (player.CheckIfPlayerLevelUp())
        {
            tvPlayerLevel = findViewById(R.id.textViewPlayerLevel);
            tvPlayerLevel.setText(levelDisplay + player.getPlayerLevelString());
            dm.Show(this, player.getPlayerLevel(), "Player");
        }
    }


    public void showLevelUpDialog(int level, String nameOfSkill)
    {

        levelUpSound = MediaPlayer.create(this, R.raw.level_up_sound);
        levelUpSound.start();


    }




}