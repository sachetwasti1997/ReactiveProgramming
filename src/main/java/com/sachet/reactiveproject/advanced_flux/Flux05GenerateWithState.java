package com.sachet.reactiveproject.advanced_flux;

import com.sachet.reactiveproject.util.ConsumerUtil;
import reactor.core.publisher.Flux;

public class Flux05GenerateWithState {

    public static void main(String[] args) {

        Flux.generate(
                () -> 1,
                (counter, sink) -> {
                    String name = ConsumerUtil.getFAKER().country().name();
                    sink.next(name);
                    if (counter == 10 || name.toLowerCase().equals("canada")){
                        sink.complete();
                    }
                    return counter + 1;
                }
        )
                .subscribe(ConsumerUtil.subscriber());

    }

}
