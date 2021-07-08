package com.sachet.reactiveproject.section01;

import com.sachet.reactiveproject.util.ConsumerUtil;
import reactor.core.publisher.Mono;

import java.util.concurrent.Callable;

public class MonoFromSupplier05 {

    public static void main(String[] args) {

        // use `just` only when the data is present
        Mono<String> mono = Mono.just(getName());

        Mono<String> stringMono = Mono.fromSupplier(MonoFromSupplier05::getName);

        stringMono.subscribe(
                ConsumerUtil.onNext()
        );

        Callable<String> stringCallable = MonoFromSupplier05::getName;

        Mono.fromCallable(stringCallable)
                .subscribe(
                        ConsumerUtil.onNext()
                );

    }

    public static String getName(){
        System.out.println("Generating Name...");
        return ConsumerUtil.getFAKER().name().fullName();
    }

}
