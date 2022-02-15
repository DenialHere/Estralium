package com.example.estralium;

public class Resource {

    public double Value, Experience;
    public String Name;


    //This constructor is used for the vendor. Where the user may buy and/or sell their resources.
    public Resource(String Name, double Value, double Experience){
        this.Name = Name;
        this.Value = Value;
        this.Experience = Experience;
    }

    //This Constructor should be used to help the inventory manager determine which resource to increment upon harvesting.
    public Resource(String Name){

        this.Name = Name;

    }

    public String getName() {
        return Name;
    }
    public void setName(String name) {
        Name = name;
    }
    public double getValue() {
        return Value;
    }
    public void setValue(double value) {
        Value = value;
    }
    public double getExperience() {
        return Experience;
    }
    public void setExperience(double experience) {
        Experience = experience;
    }

    public void AddToInventory(){



    }

}
