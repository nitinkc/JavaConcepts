package java.reactiveProgramming;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.operators.observable.ObservableCreate;

/**
 * Created by nichaurasia on Friday, June/05/2020 at 7:32 PM
 */

public class ObservableNObserver {
    public static void main(String[] args) {

        Observable<Integer> observable = new ObservableCreate<Integer> (new ObservableOnSubscribe<Integer>() {

            @Override
            public void subscribe(@NonNull ObservableEmitter<Integer> observableEmitter) throws Exception {
                try {
                    observableEmitter.onNext(100);
                    observableEmitter.onNext(200);
                    observableEmitter.onComplete();
                } catch (Throwable t) {
                    observableEmitter.onError(t);
                }
            }
        });

        Observer<Integer> observer = new Observer<Integer>() {
            @Override
            public void onSubscribe(Disposable disposable) {
                System.out.println("Subscribed : " + disposable);
            }

            @Override
            public void onNext(Integer integer) {
                System.out.println("On Next : " + integer);
            }

            @Override
            public void onError(Throwable throwable) {
                throwable.printStackTrace();
            }

            @Override
            public void onComplete() {
                System.out.println("On Complete Invoked : ");
            }
        };

        observable.subscribe(observer);
    }
}
