package com.sachet.reactiveproject.sectionflux02;

import com.sachet.reactiveproject.util.ConsumerUtil;
import reactor.core.publisher.Flux;

import java.time.Duration;

public class Flux01Intro {

    public static void main(String[] args) {

        Flux<Object> flux = Flux.just(1, 2, 3, 4, 5, ConsumerUtil.getFAKER().name().fullName(), System.out);

        flux
                .delayElements(Duration.ofSeconds(1))
                .subscribe(
                        ConsumerUtil.onNext(),
                        err -> System.out.println("Oops there is an error "+err),
                        ConsumerUtil.onComplete()
                );

        ConsumerUtil.sleepSeconds(9);

    }

}
