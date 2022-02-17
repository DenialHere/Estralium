package com.example.estralium;

import android.app.Activity;
import android.view.Gravity;
import android.widget.TextView;
import android.widget.Toast;

public class Player {

    public int CurrentSkillTraining;
    public int WoodcuttingLevel, MiningLevel, FishingLevel, FarmingLevel;
    public int WoodcuttingExperience, MiningExperience, FishingExperience, FarmingExperience;
    public int WoodCuttingXpPerClick;
    public int ExperienceMultiplier = 1;
    public int PlayerLevel, PlayerExperience;
    public double PlayerXpNeeded, WoodCuttingXpNeeded;



    public Player(int playerLevel,
                  int playerXp,
                  double playerXpNeeded,
                  int woodCuttingLevel,
                  double woodCuttingXpNeeded,
                  int woodCuttingXp,
                  int woodCuttingXpPerClick,
                  int currentSkillTraining)
    {
        setPlayerLevel(playerLevel);
        setPlayerExperience(playerXp);
        setPlayerXpNeeded(playerXpNeeded);
        setWoodcuttingLevel(woodCuttingLevel);
        setWoodCuttingXpNeeded(woodCuttingXpNeeded);
        setWoodcuttingExperience(woodCuttingXp);
        setWoodCuttingXpPerClick(woodCuttingXpPerClick);
        setCurrentSkillTraining(currentSkillTraining);
    }

    public Player (){
        setPlayerExperience(0);
        setPlayerLevel(1);
        setPlayerXpNeeded(60);
        setWoodcuttingLevel(1);
        setWoodCuttingXpNeeded(10);
        setWoodcuttingExperience(0);
        setWoodCuttingXpPerClick(1);
        setCurrentSkillTraining(1);

    }


    public void AddSkillExperience(Resource resource, Inventory invent){

        int exp = resource.getExperience();
        String name = resource.getName();

        if (name == "Woodcutting")
        {
            if (invent.getMagicSeed() > 0)
            {
                WoodcuttingExperience = WoodcuttingExperience + (exp * invent.getMagicSeed());
            }
            else {
                WoodcuttingExperience = WoodcuttingExperience + 1;
            }


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
                if (this.getWoodCuttingXpNeeded() - this.WoodcuttingExperience <= 0.999) {
                    //Play level up sound
                    levelUpSound = new SoundPlayer();
                    levelUpSound.Play(activity, R.raw.level_up_sound, isMuted);

                    //Incrementing level
                    this.setWoodcuttingLevel(this.getWoodcuttingLevel() + 1 );
                    //Setting woodcutting xp to new value after level
                    this.setWoodCuttingXpNeeded(this.getWoodCuttingXpNeeded() * CalculateExperienceMultiplier(this.getWoodcuttingLevel()));
                    //Setting woodcutting xp to 0
                    this.setWoodcuttingExperience(0);

                    //Setting textview to the the woodcutting level textview and setting it to new
                    //level
                    tvWoodCuttingLevel = activity.findViewById(R.id.textViewWoodCuttingLevel);
                    tvWoodCuttingLevel.setText(levelDisplay + this.getWoodcuttingLevel());

                    //Showing level up dialog
                    dm.Show(activity, "Woodcutting", R.drawable.wood_cutting_icon, this.getWoodcuttingLevel(), Gravity.BOTTOM);

                    //If new woodcutting level is a muiltplie of 5 increment xp per click
                    if (this.getWoodcuttingLevel() % 5 == 0) {
                        this.setWoodCuttingXpPerClick(this.getWoodCuttingXpPerClick() + 1);
                    }

                }
            case "You":
                if (this.getPlayerXpNeeded() - this.getPlayerExperience() <= 0.999) {
                    //Play level up sound
                    levelUpSound = new SoundPlayer();
                    levelUpSound.Play(activity, R.raw.level_up_sound, isMuted);
                    //Setting textview of player level to the the new level
                    TextView tvPlayerLevel = activity.findViewById(R.id.textViewPlayerLevel);
                    tvPlayerLevel.setText(levelDisplay + String.valueOf(this.getPlayerLevel()));
                    //Showing level up dialog
                    dm.Show(activity, "You", R.drawable.player, this.getPlayerLevel(), Gravity.CENTER);
                }

        }

    }

//    public int CheckCurrentSkillLevel(){
//
//        if (isWoodcutting() == true){
//
//            getWoodcuttingLevel();
//
//        }else if (isMining() == true){
//
//            getMiningLevel();
//
//        }else if(isFishing() == true){
//
//            getFishingLevel();
//
//        }else if(isFarming() == true){
//
//            getFarmingLevel();
//
//        }else{
//
//            System.out.println("UNKNOWN ERROR Handling the level checker!");
//
//        }
//        return 0;
//    }

    private double CalculateExperienceMultiplier(int level)
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

    //TODO
    public void CalculateExperienceNeededToLevel(){



        }

    //TODO
    public void CalculateCurrentSkillLevel(int experience){



    }

    /** GETTER AND SETTERS */


    public int getWoodcuttingLevel() {
        return WoodcuttingLevel;
    }

    public void setWoodcuttingLevel(int woodcuttingLevel) {
        WoodcuttingLevel = woodcuttingLevel;
    }

    public int getMiningLevel() {
        return MiningLevel;
    }

    public void setMiningLevel(int miningLevel) {
        MiningLevel = miningLevel;
    }

    public int getFishingLevel() {
        return FishingLevel;
    }

    public void setFishingLevel(int fishingLevel) {
        FishingLevel = fishingLevel;
    }

    public int getFarmingLevel() {
        return FarmingLevel;
    }

    public void setFarmingLevel(int farmingLevel) {
        FarmingLevel = farmingLevel;
    }

    public int getWoodcuttingExperience() {
        return WoodcuttingExperience;
    }

    public void setWoodcuttingExperience(int woodcuttingExperience) {
        WoodcuttingExperience = woodcuttingExperience;
    }

    public int getMiningExperience() {
        return MiningExperience;
    }

    public void setMiningExperience(int miningExperience) {
        MiningExperience = miningExperience;
    }

    public int getFishingExperience() {
        return FishingExperience;
    }

    public void setFishingExperience(int fishingExperience) {
        FishingExperience = fishingExperience;
    }

    public int getFarmingExperience() {
        return FarmingExperience;
    }

    public void setFarmingExperience(int farmingExperience) {
        FarmingExperience = farmingExperience;
    }

    public int getPlayerLevel() {
        return PlayerLevel;
    }

    public void setPlayerLevel(int playerLevel) {
        PlayerLevel = playerLevel;
    }

    public int getPlayerExperience() {
        return PlayerExperience;
    }

    public void setPlayerExperience(int playerExperience) {
        PlayerExperience = playerExperience;
    }

    public int getExperienceMultiplier() {
        return ExperienceMultiplier;
    }

    public void setExperienceMultiplier(int experienceMultiplier) {
        ExperienceMultiplier = experienceMultiplier;
    }

    public double getPlayerXpNeeded() {
        return PlayerXpNeeded;
    }

    public void setPlayerXpNeeded(double playerXpNeeded) {
        PlayerXpNeeded = playerXpNeeded;
    }

    public double getWoodCuttingXpNeeded() {
        return WoodCuttingXpNeeded;
    }

    public void setWoodCuttingXpNeeded(double woodCuttingXpNeeded) {
        WoodCuttingXpNeeded = woodCuttingXpNeeded;
    }

    public int getCurrentSkillTraining() {
        return CurrentSkillTraining;
    }

    public void setCurrentSkillTraining(int currentSkillTraining) {
        CurrentSkillTraining = currentSkillTraining;
    }


    public int getWoodCuttingXpPerClick() {
        return WoodCuttingXpPerClick;
    }

    public void setWoodCuttingXpPerClick(int woodCuttingXpPerClick) {
        WoodCuttingXpPerClick = woodCuttingXpPerClick;
    }
}
