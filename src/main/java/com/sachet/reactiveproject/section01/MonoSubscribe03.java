package com.sachet.reactiveproject.section01;

import com.sachet.reactiveproject.util.ConsumerUtil;
import reactor.core.publisher.Mono;

public class MonoSubscribe03 {

    public static void main(String[] args) {
        //publisher : emits events to subscriber listening to it.
        Mono<String> mono = Mono.just("ball");

        //1
//        mono.subscribe(s -> System.out.println(s+" received!"));

        //2
        mono.subscribe(
                s -> System.out.println(s+" Received"),
                err -> System.err.println(err+" thrown"),
                () -> System.out.println("The mono completed!")
        );

        Mono<Integer> integerMono = Mono.just("ball")
                                        .map(String::length)
                                        .map(l -> l / 0);


        integerMono.subscribe(
                i -> System.out.println("The output is "+i),
                err -> System.out.println("Oops there is an error "+err),
                () -> System.out.println("The process completed!")
        );

        Mono<Integer> integerMono1 = Mono.just("Name")
                                            .map(String::length)
                                            .map(l -> l/2);

        integerMono1.subscribe(
                ConsumerUtil.onNext(),
                ConsumerUtil.onError(),
                ConsumerUtil.onComplete()
        );

    }

}
