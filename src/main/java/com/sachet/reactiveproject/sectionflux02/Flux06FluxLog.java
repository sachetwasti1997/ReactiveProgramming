package com.sachet.reactiveproject.sectionflux02;

import com.sachet.reactiveproject.util.ConsumerUtil;
import reactor.core.publisher.Flux;

public class Flux06FluxLog {

    public static void main(String[] args) {

        Flux.range(1, 10)
                .log()
                .subscribe(
                        ConsumerUtil.onNext()
                );

        Flux.range(1, 10)
                .log()
                .map(i -> ConsumerUtil.getFAKER().name().fullName()+" "+i)
                .log()
                .subscribe(
                        ConsumerUtil.onNext()
                );

        /**
         * In all the above operations we are requesting for all the data in the flux
         */

    }

}
