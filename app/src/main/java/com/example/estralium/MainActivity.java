package com.example.estralium;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView logs, tvWoodCuttingLevel, tvWoodCuttingXpLeft;
    final String levelDisplay = "Level: ";
    final String woodCuttingXpLeft = "XP left: ";
    final String logCounter = "Logs: ";

    Player player = new Player();
    Gather gather = new Gather();
    Inventory invent = new Inventory();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void Chop(View view) {

        if (view.getId() == R.id.buttonChop)
        {
            logs = findViewById(R.id.textViewLogs);
            tvWoodCuttingXpLeft = findViewById(R.id.textViewWoodCuttingXpLeft);
            player.Harvest(invent, 1, view.getId());
            logs.setText(String.valueOf(invent.numOfLogs));
            tvWoodCuttingXpLeft.setText(player.woodCuttingXpLeft());
        }


        CheckIfLevel(view);




    }
    public void CheckIfLevel(View view){


        if (view.getId() == R.id.buttonChop)
        {
            tvWoodCuttingLevel = findViewById(R.id.textViewWoodCuttingLevel);
            if (player.checkIfWoodCuttingLevelUp())
            {
                player.setWoodCuttingXpNeeded(player.getWoodCuttingXpNeeded() * 1.3);
                player.setWoodCuttingXp(0);
                player.setWoodCuttingLevel();
                tvWoodCuttingLevel.setText(levelDisplay + player.getWoodCuttingLevelString());
                LevelUpMessage(player.getWoodCuttingLevel(), "Woodcutting");

                if (player.getWoodCuttingLevel() % 5 == 0){
                    player.setWoodCuttingXpPerClick();
                }
        }
        }
    }

    public void LevelUpMessage(int level, String nameOfSkill){
        String levelUpMessage = nameOfSkill + " level up! You are now level " + level;

        if (level % 5 == 0){
            levelUpMessage += "\n50% more xp per click!";
        }



    }
}