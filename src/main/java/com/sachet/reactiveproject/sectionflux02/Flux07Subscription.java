package com.sachet.reactiveproject.sectionflux02;

import com.sachet.reactiveproject.util.ConsumerUtil;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import reactor.core.publisher.Flux;

import java.util.concurrent.atomic.AtomicReference;

public class Flux07Subscription {

    public static void main(String[] args) {

        AtomicReference<Subscription> subscriptionAtomicReference = new AtomicReference<>();

        Flux.range(1, 20)
                .subscribe(new Subscriber<Integer>() {
                    @Override
                    public void onSubscribe(Subscription subscription) {
                        System.out.println("Subscription Received: "+subscription);
                        subscriptionAtomicReference.set(subscription);
                    }

                    @Override
                    public void onNext(Integer integer) {
                        System.out.println("Received: "+integer);
                    }

                    @Override
                    public void onError(Throwable throwable) {
                        System.out.println("Oops an error is thrown: "+throwable.getLocalizedMessage());
                    }

                    @Override
                    public void onComplete() {
                        System.out.println("OnComplete called!");
                    }
                });

        ConsumerUtil.sleepSeconds(1);

        subscriptionAtomicReference.get().request(3);

        ConsumerUtil.sleepSeconds(1);

        subscriptionAtomicReference.get().request(3);

        ConsumerUtil.sleepSeconds(1);

        subscriptionAtomicReference.get().request(3);

        subscriptionAtomicReference.get().cancel();

        ConsumerUtil.sleepSeconds(1);

        subscriptionAtomicReference.get().request(3);

    }

}
