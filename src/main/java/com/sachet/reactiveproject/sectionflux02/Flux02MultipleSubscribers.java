package com.sachet.reactiveproject.sectionflux02;

import com.sachet.reactiveproject.util.ConsumerUtil;
import reactor.core.publisher.Flux;

public class Flux02MultipleSubscribers {

    public static void main(String[] args) {

        Flux<Integer> flux = Flux.just(1, 2, 3, 4);

        Flux<Integer> evenFlux = flux.filter(i -> i % 2 == 0);

        flux.subscribe(
                ConsumerUtil.onNext(),
                ConsumerUtil.onError(),
                ConsumerUtil.onComplete()
        );

        evenFlux.subscribe(
                ConsumerUtil.onNext(),
                ConsumerUtil.onError(),
                ConsumerUtil.onComplete()
        );

    }

}
