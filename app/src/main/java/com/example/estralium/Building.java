package com.example.estralium;

public class Building {

    public String Name;
    public Resource resource;
    public int BuildingTier, WorkerCount;


    /** CALL THIS CONSTRUCTOR AT THE BEGINNING OF A NEW ACTIVITY TO ASSIGN IT A RESOURCE AND BUILDING NAME*/
    public Building(String Name, Resource resource){

        this.Name = Name;
        this.resource = resource;

    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

}
