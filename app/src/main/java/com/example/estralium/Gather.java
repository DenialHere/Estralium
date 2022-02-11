package com.example.estralium;

import android.widget.Toast;

public class Gather
{

    public void Harvest(Inventory invent, int harvestCount, int resource)
    {
        if (resource == R.id.buttonChop){
            invent.numOfLogs = invent.numOfLogs + harvestCount;
        }

    }
}
