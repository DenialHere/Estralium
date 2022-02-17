package com.example.estralium;
import android.app.Activity;
import android.view.Gravity;

import java.util.Random;

public class Inventory {

    Random random = new Random();
    public int Log_Quantity = 0, Stone_Quantity, Iron_Ore_Quantity, Copper_Ore_Quantity, Tin_Ore_Quantity;
    public int MagicSeed;
    public int Multiplier;

    public void add(Resource resource, Player player, Activity activity){


        if(resource.getName() == "Logs"){
            Multiplier = CalculateMultiplier(player.getWoodPerClick(), resource, player);
            this.Log_Quantity +=  player.getWoodPerClick() + Multiplier;


        }else if (resource.getName() == "Stones"){

            this.Stone_Quantity = this.Stone_Quantity + Multiplier;


        }else if(resource.getName() == "IronOre"){

            this.Iron_Ore_Quantity = this.Iron_Ore_Quantity + Multiplier;


        }else if(resource.getName() == "CopperOre"){

            this.Copper_Ore_Quantity = this.Copper_Ore_Quantity + Multiplier;


        }else if(resource.getName() == "TinOre"){

            this.Tin_Ore_Quantity = this.Tin_Ore_Quantity + Multiplier;


        }else{

            System.out.println("ERROR");

        }

        CheckForRareDrop(resource, player, activity);

    }
    public void remove(Resource resource, int AmountSold){

        if(resource.getName() == "Logs"){

            this.Log_Quantity = this.Log_Quantity - AmountSold;

        }else if (resource.getName() == "Stones"){

            this.Stone_Quantity = this.Stone_Quantity - AmountSold;

        }else if(resource.getName() == "IronOre"){

            this.Iron_Ore_Quantity = this.Iron_Ore_Quantity - AmountSold;

        }else if(resource.getName() == "CopperOre"){

            this.Copper_Ore_Quantity = this.Copper_Ore_Quantity - AmountSold;

        }else if(resource.getName() == "TinOre"){

            this.Tin_Ore_Quantity = this.Tin_Ore_Quantity - AmountSold;

        }else{

            System.out.println("ERROR");

        }

    }
    public int CalculateMultiplier(int multiplier, Resource resource, Player player){

        if (resource.getName() == "Logs")
        {
            Multiplier = getMagicSeed();
        }
        return Multiplier;
    }
    public void CheckForRareDrop(Resource resource, Player player, Activity activity){

        int baseDropChance = 125;

            if (resource.getName() == "Logs")
            {
                if (getMagicSeed() > 0 )
                {
                    baseDropChance = baseDropChance * getMagicSeed();
                }


                if(random.nextInt(baseDropChance) == 0) {
                    DialogueManager dm = new DialogueManager();

                    setMagicSeed(getMagicSeed() + 1);
                    dm.Show(activity, "Magic seed", R.drawable.magic_seed, 1, Gravity.TOP,
                            2);
                }

        }

    }

    /** Getter and Setter */

    public int getLog_Quantity() {
        return Log_Quantity;
    }

    public void setLog_Quantity(int log_Quantity) {
        Log_Quantity = log_Quantity;
    }

    public int getStone_Quantity() {
        return Stone_Quantity;
    }

    public void setStone_Quantity(int stone_Quantity) {
        Stone_Quantity = stone_Quantity;
    }

    public int getIron_Ore_Quantity() {
        return Iron_Ore_Quantity;
    }

    public void setIron_Ore_Quantity(int iron_Ore_Quantity) {
        Iron_Ore_Quantity = iron_Ore_Quantity;
    }

    public int getCopper_Ore_Quantity() {
        return Copper_Ore_Quantity;
    }

    public void setCopper_Ore_Quantity(int copper_Ore_Quantity) {
        Copper_Ore_Quantity = copper_Ore_Quantity;
    }

    public int getTin_Ore_Quantity() {
        return Tin_Ore_Quantity;
    }

    public void setTin_Ore_Quantity(int tin_Ore_Quantity) {
        Tin_Ore_Quantity = tin_Ore_Quantity;
    }

    public int getMultiplier() {
        return Multiplier;
    }

    public void setMultiplier(int multiplier) {
        Multiplier = multiplier;
    }
    public int getMagicSeed() {
        return MagicSeed;
    }

    public void setMagicSeed(int magicSeed) {
        MagicSeed = magicSeed;
    }


}
