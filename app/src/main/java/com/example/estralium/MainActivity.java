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
    boolean isMuted = false;

    Player player = new Player();
    Gather gather = new Gather();
    Inventory invent = new Inventory();
    SoundPlayer gatherSound = new SoundPlayer();
    SoundPlayer levelUpSound = new SoundPlayer();

    ProgressBar woodCuttingPb;
    //TESTING
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
                levelUpSound.Play(this, R.raw.level_up_sound, isMuted);
                tvWoodCuttingLevel = findViewById(R.id.textViewWoodCuttingLevel);
                ProgressBar(player);
                tvWoodCuttingLevel.setText(levelDisplay + player.getWoodCuttingLevelString());
                dm.Show(this, "Woodcutting", R.drawable.wood_cutting_icon, player.getWoodCuttingLevel(), Gravity.BOTTOM);
            }
        }

        if (player.CheckIfPlayerLevelUp())
        {
            tvPlayerLevel = findViewById(R.id.textViewPlayerLevel);
            tvPlayerLevel.setText(levelDisplay + player.getPlayerLevelString());
            dm.Show(this, "You", R.drawable.player, player.getPlayerLevel(), Gravity.CENTER);
            levelUpSound.Play(this, R.raw.level_up_sound, isMuted);
        }
    }







}