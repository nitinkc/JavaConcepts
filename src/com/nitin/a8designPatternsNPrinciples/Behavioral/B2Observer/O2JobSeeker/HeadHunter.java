package com.nitin.a8designPatternsNPrinciples.Behavioral.B2Observer.O2JobSeeker;

import java.util.ArrayList;

/**
 * Created by nitin.chaurasia on 3/4/2017.
 */
public class HeadHunter implements Subject {
    //define a list of users, such as Mike, Bill, etc.
    private ArrayList<Observer> userList;
    private ArrayList<String> jobs;

    public HeadHunter() {
        userList = new ArrayList<Observer>();
        jobs = new ArrayList<String>();
    }

    @Override
    public void registerObserver(Observer o) {
        userList.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
    }

    @Override
    public void notifyAllObservers() {
        for (Observer o : userList) {
            o.update(this);
        }
    }

    public void addJob(String job) {
        this.jobs.add(job);
        notifyAllObservers();
    }

    public ArrayList<String> getJobs() {
        return jobs;
    }

    public String toString() {
        return jobs.toString();
    }
}
