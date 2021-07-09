package com.sachet.reactiveproject.advanced_flux;

import com.sachet.reactiveproject.util.ConsumerUtil;
import reactor.core.publisher.Flux;

import java.util.Locale;

public class Flux01Create {

    public static void main(String[] args) {

        Flux.create(fluxSink -> {
            String country;
            do{
                country = ConsumerUtil.getFAKER().country().name();
                fluxSink.next(country);
            }while (!country.toLowerCase().equals("canada"));
        })
        .subscribe(ConsumerUtil.subscriber());

    }

}
