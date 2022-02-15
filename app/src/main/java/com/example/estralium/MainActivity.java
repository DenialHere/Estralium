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
    Inventory inventory = new Inventory();
    SoundPlayer gatherSound = new SoundPlayer();
    SoundPlayer levelUpSound = new SoundPlayer();
    Resource resource = new Resource("Logs");


    ProgressBar woodCuttingPb;
    //TESTING
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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

    public void Chop(View view){
        inventory.add(resource);
        player.AddExp();
        System.out.println(inventory.getLog_Quantity());
    }
}