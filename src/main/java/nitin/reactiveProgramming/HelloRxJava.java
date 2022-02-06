package nitin.reactiveProgramming;

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

        for (int i = 0; i < 10; i++) {
            int finalI = i;
            observable.subscribe(element -> System.out.println("Subscriber " + finalI + element));
        }
    }
}
