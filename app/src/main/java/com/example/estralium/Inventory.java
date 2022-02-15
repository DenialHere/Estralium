package com.example.estralium;

public class Inventory {

    public int Log_Quantity = 0, Stone_Quantity, Iron_Ore_Quantity, Copper_Ore_Quantity, Tin_Ore_Quantity;
    public int Multiplier = 1;

    public void add(Resource resource){

        if(resource.getName() == "Logs"){

            this.Log_Quantity = this.Log_Quantity + Multiplier;

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

}
