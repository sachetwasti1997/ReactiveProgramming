package com.sachet.reactiveproject.advanced_flux;

import com.sachet.reactiveproject.util.ConsumerUtil;
import reactor.core.publisher.Flux;

public class Flux04Conditional {

    public static void main(String[] args) {

        Flux.generate(synchronousSink -> {
            String name = ConsumerUtil.getFAKER().country().name();
            synchronousSink.next(name);
            if (name.toLowerCase().equals("canada")){
                synchronousSink.complete();
            }
        })
                .subscribe(ConsumerUtil.subscriber());

    }

}
