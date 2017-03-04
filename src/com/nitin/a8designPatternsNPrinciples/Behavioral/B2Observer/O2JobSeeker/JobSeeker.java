package com.nitin.a8designPatternsNPrinciples.Behavioral.B2Observer.O2JobSeeker;

/**
 * Created by nitin.chaurasia on 3/4/2017.
 */
public class JobSeeker implements Observer {
    private String name;

    public JobSeeker(String name){
        this.name = name;
    }
    @Override
    public void update(Subject s) {
        System.out.println(this.name + " got notified!");
        //print job list
        System.out.println(s);
    }
}
