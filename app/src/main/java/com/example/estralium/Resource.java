package com.example.estralium;

public class Resource {

    public double Value;
    public int Experience;
    public String Name;

    public Resource(String Name, double Value){
        this.Name = Name;
        this.Value = Value;
    }

    public Resource(String Name, int Experience){

        this.Name = Name;
        this.Experience = Experience;
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
    public int getExperience() {
        return Experience;
    }
    public void setExperience(int experience) {
        Experience = experience;
    }

    public void AddToInventory(){



    }

}
