package com.example.estralium;

public class Currency {

    public int Coins = 0;
    public int Platinum = 0;

    public Currency(){}

    public void addCoins(int Amount){

        Coins = Coins + Amount;

    }
    public void removeCoins(int Amount){

        Coins = Coins - Amount;

    }
    public void addPlatinum(int Amount){

        Platinum = Platinum + Amount;

    }
    public void removePlatinum(int Amount){

        Platinum = Platinum - Amount;

    }

    public int getCoins() {
        return Coins;
    }

    public void setCoins(int coins) {
        this.Coins = coins;
    }

    public int getPlatinum() {
        return Platinum;
    }

    public void setPlatinum(int platinum) {
        this.Platinum = platinum;
    }

}
