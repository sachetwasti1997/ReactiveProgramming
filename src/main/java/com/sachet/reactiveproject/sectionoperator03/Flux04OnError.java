package com.sachet.reactiveproject.sectionoperator03;

import com.sachet.reactiveproject.util.ConsumerUtil;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class Flux04OnError {

    public static void main(String[] args) {

        Flux.range(1, 10)
                .log()
                .map(i -> 10 / (5 - i))
                .onErrorReturn(-1)
                .subscribe(ConsumerUtil.subscriber());
        System.out.println("-------------------------------------------------------------------------------------------");
        Flux.range(1, 10)
                .log()
                .map(integer -> 10 / (5 - integer))
                .onErrorResume(e -> fallback())
                .subscribe(ConsumerUtil.subscriber());
        System.out.println("-------------------------------------------------------------------------------------------");
        Flux.range(1, 10)
                .log()
                .map(integer -> 10/(5-integer))
                .onErrorContinue((throwable, o) -> {
                    System.out.println("Oops an error is thrown! "+throwable);
                })
                .subscribe(ConsumerUtil.subscriber());
    }

    private static Mono<Integer> fallback(){
        return Mono.fromSupplier(() -> ConsumerUtil.getFAKER().random().nextInt(100, 200));
    }

}
