package com.sachet.reactiveproject.section01;

import reactor.core.publisher.Mono;

import java.time.Duration;

public class MonoJust02 {

    public static void main(String[] args) {

        //publisher
        Mono<Integer> mono = Mono.just(1);

        System.out.println(mono);

        mono.subscribe(i -> System.out.println("Received: "+i));

    }

}
