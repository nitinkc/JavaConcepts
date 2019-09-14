package com.nitin.a8designPatternsNPrinciples.Behavioral.B2Observer.O2JobSeeker;

/**
 * Created by nitin.chaurasia on 3/4/2017.
 */
public interface Subject {
    public void registerObserver(Observer o);

    public void removeObserver(Observer o);

    public void notifyAllObservers();
}

