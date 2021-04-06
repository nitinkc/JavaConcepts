package com.j9.nitin.RxJava;

import io.reactivex.Observable;

/**
 * Created by nichaurasia on Friday, June/05/2020 at 6:40 PM
 */

public class HelloRxJava {
    public static void main(String[] args) {
         Observable<String> observable = Observable.create(
                 emitter -> {
                     emitter.onNext("Hello World Practise from RxJava");
                     emitter.onNext("Mic Testing 1....2.....3...");
                 });

        observable.subscribe(element -> System.out.println("Subscriber 1 "+element));
        observable.subscribe(element -> System.out.println("Subscriber 2 "+element));
    }
}
