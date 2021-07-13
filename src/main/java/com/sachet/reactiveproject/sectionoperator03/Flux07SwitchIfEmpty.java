package com.sachet.reactiveproject.sectionoperator03;

import com.sachet.reactiveproject.util.ConsumerUtil;
import reactor.core.publisher.Flux;

public class Flux07SwitchIfEmpty {

    public static void main(String[] args) {
        getNumbers()
                .filter(i -> i > 10)
                .switchIfEmpty(fallBack())
                .subscribe(ConsumerUtil.subscriber());
    }

    private static Flux<Integer> getNumbers(){
        return Flux.range(1, 10);
    }

    private static Flux<Integer> fallBack(){
        return Flux.range(20, 5);
    }

}
