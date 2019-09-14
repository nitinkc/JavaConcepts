package com.nitin.a8designPatternsNPrinciples.Behavioral.B2Observer.O2JobSeeker;

/**
 * Created by nitin.chaurasia on 3/4/2017.
 */
public class Driver {
    public static void main(String[] args) {
        HeadHunter hh = new HeadHunter();
        hh.registerObserver(new JobSeeker("Mike"));
        hh.registerObserver(new JobSeeker("Chris"));
        hh.registerObserver(new JobSeeker("Jeff"));

        //Each time, a new job is added, all registered job seekers will get noticed.
        hh.addJob("Google Job");
        hh.addJob("Yahoo Job");
    }
}
