package com.sachet.reactiveproject.sectionflux02;

import com.sachet.reactiveproject.util.ConsumerUtil;
import reactor.core.publisher.Flux;

public class Flux05Range {

    public static void main(String[] args) {

        Flux.range(1, 10)
                .subscribe(
                        obj -> System.out.println(ConsumerUtil.getFAKER().name().fullName()+" "+obj),
                        ConsumerUtil.onError(),
                        ConsumerUtil.onComplete()
                );

        Flux.range(1, 10)
                .map(obj -> ConsumerUtil.getFAKER().name().fullName())
                .subscribe(
                        ConsumerUtil.onNext()
                );

    }

}
