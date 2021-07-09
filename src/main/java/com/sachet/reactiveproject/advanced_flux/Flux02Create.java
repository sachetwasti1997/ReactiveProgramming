package com.sachet.reactiveproject.advanced_flux;

import com.sachet.reactiveproject.advanced_flux.custom_flux_sink.NameProducer;
import com.sachet.reactiveproject.util.ConsumerUtil;
import reactor.core.publisher.Flux;

public class Flux02Create {

    public static void main(String[] args) {

        NameProducer producer = new NameProducer();

        Flux.create(producer)
                .subscribe(ConsumerUtil.subscriber());

        producer.produce();

    }

}
