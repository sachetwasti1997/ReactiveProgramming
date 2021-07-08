package com.sachet.reactiveproject.sectionflux02;

import com.sachet.reactiveproject.util.ConsumerUtil;
import reactor.core.publisher.Flux;

import java.time.Duration;

public class Flux09Interval {

    public static void main(String[] args) {

        Flux
                .interval(Duration.ofSeconds(1))
                .map(i -> ConsumerUtil.getFAKER().name().fullName())
                .subscribe(
                        ConsumerUtil.onNext()
                );

        ConsumerUtil.sleepSeconds(10);

    }

}
