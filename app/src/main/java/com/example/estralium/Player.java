package com.example.estralium;

import android.widget.Toast;

public class Player {

    public boolean woodcutting = false, mining = false, fishing = false, farming = false;
    public int WoodcuttingLevel, MiningLevel, FishingLevel, FarmingLevel;
    public int WoodcuttingExperience, MiningExperience, FishingExperience, FarmingExperience;
    public int ExperienceMultiplier = 1;
    public int PlayerLevel, PlayerExperience;

    public Player(String Skill){

        if(Skill == "woodcutting") {

            this.woodcutting = true;

        }else if(Skill == "mining"){

            this.mining = true;

        }else if(Skill == "fishing"){

            this.fishing = true;

        }else if(Skill == "farming"){

            this.farming = true;

        }else{

            this.woodcutting = false;
            this.mining = false;
            this.fishing = false;
            this.farming = false;

        }

    }

    public void AddSkillExperience(Resource resource){

        int exp = resource.getExperience();

        if ( isWoodcutting() == true){

            WoodcuttingExperience = WoodcuttingExperience + (exp * ExperienceMultiplier);

        }else if (isMining() == true){
            MiningExperience = MiningExperience + (exp * ExperienceMultiplier);

        }else if(isFishing() == true){

            FishingExperience = FishingExperience + (exp * ExperienceMultiplier);

        }else if(isFarming() == true){

            FarmingExperience = FarmingExperience + (exp * ExperienceMultiplier);

        }else{

            System.out.println("ERROR Handling the Experience Calculator!");
            System.out.println("You must be inside a building to gain experience.");
        }

    }

    public int CheckCurrentSkillLevel(){

        if (isWoodcutting() == true){

            getWoodcuttingLevel();

        }else if (isMining() == true){

            getMiningLevel();

        }else if(isFishing() == true){

            getFishingLevel();

        }else if(isFarming() == true){

            getFarmingLevel();

        }else{

            System.out.println("UNKNOWN ERROR Handling the level checker!");

        }
        return 0;
    }

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

    public boolean isWoodcutting() {
        return woodcutting;
    }

    public void setWoodcutting(boolean woodcutting) {
        this.woodcutting = woodcutting;
    }

    public boolean isMining() {
        return mining;
    }

    public void setMining(boolean mining) {
        this.mining = mining;
    }

    public boolean isFishing() {
        return fishing;
    }

    public void setFishing(boolean fishing) {
        this.fishing = fishing;
    }

    public boolean isFarming() {
        return farming;
    }

    public void setFarming(boolean farming) {
        this.farming = farming;
    }

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


}
