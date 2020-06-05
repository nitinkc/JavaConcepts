package com.nitin.a10collections.a_list.ArrayList.ListApplication;

import java.util.ArrayList;

/**
 * Created by synergisticit on 2/26/2016.
 */
public class Info {
    private int population;
    private String city;
    private String state;
    private ArrayList<String> interstate;

    public Info(int population, String city, String state, ArrayList<String> interstate) {
        this.population = population;
        this.city = city;
        this.state = state;
        this.interstate = interstate;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public ArrayList<String> getInterstate() {
        return interstate;
    }

    public void setInterstate(ArrayList<String> interstate) {
        this.interstate = interstate;
    }

    @Override
    public String toString() {
        return "Info{" +
                "population=" + population +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", interstate=" + interstate +
                '}';
    }
}
