package com.sachet.reactiveproject.sectionoperator03;

import com.sachet.reactiveproject.util.ConsumerUtil;
import reactor.core.publisher.Flux;

public class Flux06DefaultIfEmpty {

    public static void main(String[] args) {
        getNumbers()
                .filter(i -> i > 10)
                .defaultIfEmpty(-100)
                .subscribe(ConsumerUtil.subscriber());
    }

    private static Flux<Integer> getNumbers(){
        return Flux.range(1, 10);
    }

}
