package com.sachet.reactiveproject.section01;

import com.sachet.reactiveproject.util.ConsumerUtil;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Scheduler;
import reactor.core.scheduler.Schedulers;

public class MonoFromSupplierRefactored {

    public static void main(String[] args) {
        getName(1);
        getName(2);
        getName(3)
                .subscribeOn(Schedulers.boundedElastic())
            .subscribe(
                    ConsumerUtil.onNext()
            );// this executes the pipeline
        getName(4);
        getName(5);
        getName(6);

        ConsumerUtil.sleepSeconds(4);
    }

    public static Mono<String> getName(int index){

        System.out.println("In the method call with index "+index);

        return
                Mono.fromSupplier(() -> {
                    System.out.println("Generating Name...");
                    ConsumerUtil.sleepSeconds(3);
                    return ConsumerUtil.getFAKER().name().fullName();
                }).map(String::toUpperCase);//this builds the pipeline

    }

}
