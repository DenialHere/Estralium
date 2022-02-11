package com.example.estralium;



public class Gather
{

    public void Harvest(Inventory invent, int harvestCount, int resource, Player player)
    {
        if (resource == R.id.buttonChop){
            invent.numOfLogs = invent.numOfLogs + harvestCount;
            player.setWoodCuttingXp();
        }

        player.setPlayerXp();
    }
}
