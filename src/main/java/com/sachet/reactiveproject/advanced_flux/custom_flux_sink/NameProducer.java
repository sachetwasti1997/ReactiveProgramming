package com.sachet.reactiveproject.advanced_flux.custom_flux_sink;

import com.sachet.reactiveproject.util.ConsumerUtil;
import reactor.core.publisher.FluxSink;

import java.util.Locale;
import java.util.function.Consumer;

public class NameProducer implements Consumer<FluxSink<Object>> {

    private FluxSink<Object> fluxSink;

    @Override
    public void accept(FluxSink<Object> objectFluxSink) {
        this.fluxSink = objectFluxSink;
    }

    public void produce(){
        String name;
        do {
            name = ConsumerUtil.getFAKER().country().name();
            fluxSink.next(name);
        }while (!name.toLowerCase().equals("canada"));
    }
}
