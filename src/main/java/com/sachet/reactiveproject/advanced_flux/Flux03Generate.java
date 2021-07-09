package com.sachet.reactiveproject.advanced_flux;

import com.sachet.reactiveproject.util.ConsumerUtil;
import reactor.core.publisher.Flux;

import java.util.Locale;

public class Flux03Generate {

    public static void main(String[] args) {

        Flux.generate(synchronousSink -> {
            String name = ConsumerUtil.getFAKER().country().name();
            synchronousSink.next(name);
        })
                .take(5)
                .subscribe(ConsumerUtil.subscriber());

    }

}
