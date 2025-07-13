package com.utilities;

import com.github.javafaker.Faker;
import java.util.function.Consumer;

public class ReactorUtils {

    private static final Faker FAKER = Faker.instance();

    public static Consumer<Object> onNext() {
        return object -> System.out.println("Received : " + object);
    }

    public static Consumer<Object> onNext(String message) {
        return object -> System.out.println("Received : " + object + " with message " + message);
    }

    public static Consumer<Throwable> onError() {
        return e -> System.out.println("ERROR : " + e.getMessage());
    }

    public static Runnable onComplete() {
        return () -> System.out.println("-- Completed --");
    }

    public static Faker faker() {
        return FAKER;
    }
}
