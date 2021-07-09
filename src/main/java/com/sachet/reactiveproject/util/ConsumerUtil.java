package com.sachet.reactiveproject.util;

import com.github.javafaker.Faker;
import org.reactivestreams.Subscriber;

import java.util.function.Consumer;

public class ConsumerUtil {

    private static final Faker FAKER = Faker.instance();

    public static Consumer<Object> onNext(){
        return o -> System.out.println("Received: "+o);
    }

    public static Consumer<Throwable> onError(){
        return err -> System.out.println("Oops there is an error: "+err);
    }

    public static Runnable onComplete(){
        return () -> System.out.println("The process completed!");
    }

    public static Faker getFAKER() {
        return FAKER;
    }

    public static void sleepSeconds(int seconds){
        try {
            Thread.sleep(seconds * 1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static Subscriber<Object> subscriber(){
        return new DefaultSubscriber();
    }

    public static Subscriber<Object> subscriber(String name){
        return new DefaultSubscriber(name);
    }
}
