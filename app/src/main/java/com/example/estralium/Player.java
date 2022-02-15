package com.example.estralium;

import android.app.Activity;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class Player extends Activity{

    private int playerLevel;
    private int playerXp;
    private double playerXpNeeded;
    private int woodCuttingLevel;
    private int woodCuttingXp;
    private int numberOfLogs;
    private int woodCuttingXpPerClick;
    private double woodCuttingXpNeeded;

    public Player(int playerLevel,
                  int playerXp,
                  double playerXpNeeded,
                  int woodCuttingLevel,
                  double woodCuttingXpNeeded,
                  int woodCuttingXp,
                  int numberOfLogs,
                  int woodCuttingXpPerClick)
    {
        this.playerLevel = playerLevel;
        this.playerXp = playerXp;
        this.playerXpNeeded = playerXpNeeded;
        this.woodCuttingLevel = woodCuttingLevel;
        this.woodCuttingXpNeeded = woodCuttingXpNeeded;
        this.woodCuttingXp = woodCuttingXp;
        this.numberOfLogs = numberOfLogs;
        this.woodCuttingXpPerClick = woodCuttingXpPerClick;
    }

    public Player (){
        this.playerLevel = 1;
        this.playerXp = 0;
        this.playerXpNeeded = 60;
        this.woodCuttingLevel = 1;
        this.woodCuttingXpNeeded = 10;
        this.woodCuttingXp = 0;
        this.numberOfLogs = 0;
        this.woodCuttingXpPerClick = 1;
    }

    //Player level

    public int getPlayerLevel()
    {
        return this.playerLevel;
    }
    public String getPlayerLevelString()
    {
        return String.valueOf(this.playerLevel);
    }

    public void setPlayerLevel(int level)
    {
        if (level >=1)
        {
            this.playerLevel = level;
        }
    }
    public void setPlayerLevel()
    {
        this.playerLevel++;
    }

    //Player xp
    public int getPlayerXp()
    {
        return this.playerXp;
    }
    public String getPlayerXpString()
    {
        return String.valueOf(this.playerXp);
    }

    public void setPlayerXp(int xp)
    {
        if (xp >=0)
        {
            this.playerXp = xp;
        }
    }
    public void setPlayerXp()
    {
        this.playerXp++;
    }

    //Player xp needed
    public double getPlayerXpNeeded()
    {
        return this.playerXpNeeded;
    }
    public String getPlayerXpNeededString()
    {
        return String.valueOf(this.playerXpNeeded);
    }

    public void setPlayerXpNeeded(double xp)
    {
        if (xp >=1)
        {
            this.playerXpNeeded = xp;
        }
    }

    public boolean CheckIfPlayerLevelUp(){
        if (this.playerXpNeeded - this.playerXp <= 0.999){
            this.setPlayerXpNeeded(this.playerXpNeeded * 1.1);
            this.setPlayerXp(0);
            this.setPlayerLevel();
            return true;
        }
        else {
            return false;
        }
    }

    //Woodcutting level
    public int getWoodCuttingLevel()
    {
        return this.woodCuttingLevel;
    }
    public String getWoodCuttingLevelString()
    {
        return String.valueOf(this.woodCuttingLevel);
    }
    public void setWoodCuttingLevel(int level)
    {

        if (level >=1)
        {
            this.woodCuttingLevel = level;

        }
    }
    public void setWoodCuttingLevel()
    {
        this.woodCuttingLevel++;
    }

    //Woodcutting xp
    public int getWoodCuttingXp()
    {
        return this.woodCuttingXp;
    }
    public String getWoodCuttingXpString()
    {
        return String.valueOf(this.woodCuttingXp);
    }
    public void setWoodCuttingXp(int xp)
    {
        if (xp >=0)
        {
            this.woodCuttingXp = xp;
        }
    }
    public void setWoodCuttingXp()
    {
        this.woodCuttingXp = this.woodCuttingXp + this.woodCuttingXpPerClick;
    }

    //Woodcutting xp needed
    public double getWoodCuttingXpNeeded()
    {
        return this.woodCuttingXpNeeded;
    }
    public String getWoodCuttingXpNeededString()
    {
        return String.valueOf(this.woodCuttingXpNeeded);
    }
    public void setWoodCuttingXpNeeded(double xp)
    {
        if (xp >=0)
        {
            this.woodCuttingXpNeeded = xp;
        }

    }

    //Woodcutting xp per click
    public double getWoodCuttingXpPerClick()
    {
        return this.woodCuttingXpPerClick;
    }
    public String getWoodCuttingXpPerClickString()
    {
        return String.valueOf(this.woodCuttingXpPerClick);
    }
    public void setWoodCuttingXpPerClick(int xp)
    {
        if (xp >=1)
        {
            this.woodCuttingXpPerClick = xp;
        }
    }
    public void setWoodCuttingXpPerClick()
    {
        this.woodCuttingXpPerClick++;
    }

    //Number of logs
    public double getNumberOfLogs()
    {
        return this.numberOfLogs;
    }
    public String getNumberOfLogsString()
    {
        return String.valueOf(this.numberOfLogs);
    }
    public void setNumberOfLogs(int num)
    {
        if (num >=0)
        {
            this.numberOfLogs = num;
        }
    }
    public void setNumberOfLogs()
    {
        this.numberOfLogs++;
    }

    //TIME TO LEVEL

    public String woodCuttingXpLeft(){

        return String.valueOf((int)(this.woodCuttingXpNeeded - this.woodCuttingXp));
    }

    public boolean checkIfWoodCuttingLevelUp(){
        if (this.woodCuttingXpNeeded - this.woodCuttingXp <= 0.999){
            this.setWoodCuttingXpNeeded(this.getWoodCuttingXpNeeded() * XpNeedMultiplier(this.woodCuttingLevel));
            this.setWoodCuttingXp(0);
            this.setWoodCuttingLevel();
            if (this.getWoodCuttingLevel() % 5 == 0){
                this.setWoodCuttingXpPerClick();
            }
            return true;
        }
        else {
            return false;
        }
    }

    public void checkIfLevel(Activity activity, String nameOfSkill, Boolean isMuted) {

        final String levelDisplay = "Level: ";
        SoundPlayer levelUpSound;
        DialogueManager dm = new DialogueManager();

        switch (nameOfSkill) {
            case "Woodcutting":
            case "woodcutting":
                //Defining the text view of the woodcutting level
                TextView tvWoodCuttingLevel;

                //If woodcutting xp is greater than woodcutting xp needed
                if (this.woodCuttingXpNeeded - this.woodCuttingXp <= 0.999) {
                    //Play level up sound
                    levelUpSound = new SoundPlayer();
                    levelUpSound.Play(activity, R.raw.level_up_sound, isMuted);

                    //Incrementing level
                    this.setWoodCuttingLevel();
                    //Setting woodcutting xp to new value after level
                    this.setWoodCuttingXpNeeded(this.getWoodCuttingXpNeeded() * XpNeedMultiplier(this.woodCuttingLevel));
                    //Setting woodcutting xp to 0
                    this.setWoodCuttingXp(0);

                    //Setting textview to the the woodcutting level textview and setting it to new
                    //level
                    tvWoodCuttingLevel = activity.findViewById(R.id.textViewWoodCuttingLevel);
                    tvWoodCuttingLevel.setText(levelDisplay + this.getWoodCuttingLevelString());

                    //Showing level up dialog
                    dm.Show(activity, "Woodcutting", R.drawable.wood_cutting_icon, this.getWoodCuttingLevel(), Gravity.BOTTOM);

                    //If new woodcutting level is a muiltplie of 5 increment xp per click
                    if (this.getWoodCuttingLevel() % 5 == 0) {
                        this.setWoodCuttingXpPerClick();
                    }

                }
            case "You":
                if (this.playerXpNeeded - this.playerXp <= 0.999) {
                    //Play level up sound
                    levelUpSound = new SoundPlayer();
                    levelUpSound.Play(activity, R.raw.level_up_sound, isMuted);
                    //Setting textview of player level to the the new level
                    TextView tvPlayerLevel = activity.findViewById(R.id.textViewPlayerLevel);
                    tvPlayerLevel.setText(levelDisplay + this.getPlayerLevelString());
                    //Showing level up dialog
                    dm.Show(activity, "You", R.drawable.player, this.getPlayerLevel(), Gravity.CENTER);
                }

        }

    }

    public double XpNeedMultiplier(int level)
    {
        if (level <10){
            return 1.25;
        }
        else if (level <20){
            return 1.2;
        }
        else if (level <30){
            return 1.1;
        }
        else if (level <40){
            return 1.05;
        }
        else if (level <50){
            return 1.04;
        }
        else if (level <60){
            return 1.04;
        }
        else if (level <70){
            return 1.03;
        }
        else if (level <80){
            return 1.02;
        }
        else {
            return 1.1;
        }
    }

    public void Harvest(Inventory invent, int harvestCount, int resource)
    {
        if (resource == R.id.buttonChop){
            invent.numOfLogs = invent.numOfLogs + harvestCount;
            this.setWoodCuttingXp();
        }

        this.playerXp++;

    }

}

