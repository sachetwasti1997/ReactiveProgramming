package com.sachet.reactiveproject.sectionflux02;

import com.sachet.reactiveproject.util.ConsumerUtil;
import reactor.core.publisher.Flux;

import java.util.List;
import java.util.stream.Stream;

public class Flux04FromStream {

    /**
     * Note that the data can be accessed from the stream only once
     * @param args
     */
    public static void main(String[] args) {
        List<Integer> lst = List.of(1, 2, 3, 4, 5);
        Stream<Integer> stream = lst.stream();

        Flux<Integer> integerFlux = Flux.fromStream(lst::stream);

        integerFlux.subscribe(
                ConsumerUtil.onNext(),
                ConsumerUtil.onError(),
                ConsumerUtil.onComplete()
        );

        integerFlux.subscribe(
                ConsumerUtil.onNext(),
                ConsumerUtil.onError(),
                ConsumerUtil.onComplete()
        );
    }

}
