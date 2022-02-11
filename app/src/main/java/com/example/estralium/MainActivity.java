package com.example.estralium;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void Chop(View view) {

        if (view.getId() == R.id.buttonChop)
        {
            resourceSound = MediaPlayer.create(this, R.raw.wood_chop2);
            resourceSound.start();
            logs = findViewById(R.id.textViewLogs);
            tvWoodCuttingXpLeft = findViewById(R.id.textViewWoodCuttingXpLeft);
            gather.Harvest(invent, 1, view.getId(), player);
            logs.setText(String.valueOf(invent.numOfLogs));
            tvWoodCuttingXpLeft.setText(woodCuttingXpLeft + player.woodCuttingXpLeft());
        }

        CheckIfLevel(view);




    }
    public void CheckIfLevel(View view){


        if (view.getId() == R.id.buttonChop)
        {

            if (player.checkIfWoodCuttingLevelUp()) {
                tvWoodCuttingLevel = findViewById(R.id.textViewWoodCuttingLevel);
                tvWoodCuttingXpLeft.setText(woodCuttingXpLeft + player.woodCuttingXpLeft());
                tvWoodCuttingLevel.setText(levelDisplay + player.getWoodCuttingLevelString());
                showLevelUpDialog(player.getWoodCuttingLevel(), "Woodcutting");
            }
        }

        if (player.CheckIfPlayerLevelUp())
        {
            tvPlayerLevel = findViewById(R.id.textViewPlayerLevel);
            tvPlayerLevel.setText(levelDisplay + player.getPlayerLevelString());
            showLevelUpDialog(player.getPlayerLevel(), "You");
        }
    }

    public void LevelUpMessage(int level, String nameOfSkill){
        String levelUpMessage = nameOfSkill + " level up! You are now level " + level + "xp needed: " + player.getPlayerXpNeededString();

        if (level % 5 == 0){
            levelUpMessage += "\n50% more xp per click!";
        }

        Toast.makeText(getApplicationContext(), levelUpMessage, Toast.LENGTH_SHORT).show();


    }

    public void showLevelUpDialog(int level, String nameOfSkill)
    {
        String levelUpMessageString = nameOfSkill + " level up! \nYou are now level " + level + ".";

        Dialog dialog = new Dialog(MainActivity.this);
        dialog.setContentView(R.layout.level_message);
        dialog.getWindow().setGravity(Gravity.BOTTOM);
        TextView levelUpMessage = dialog.findViewById(R.id.textViewLevelUp);
        levelUpMessage.setText(levelUpMessageString);


        ImageView img = dialog.findViewById(R.id.imageViewIcon);
        if (nameOfSkill == "Woodcutting"){
            img.setImageResource(R.drawable.wood_cutting_icon);
        }
        if (nameOfSkill == "You"){
            img.setImageResource(R.drawable.player);
        }

        levelUpSound = MediaPlayer.create(this, R.raw.level_up_sound);
        levelUpSound.start();


        dialog.show();
    }




}