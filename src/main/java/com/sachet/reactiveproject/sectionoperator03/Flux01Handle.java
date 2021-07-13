package com.sachet.reactiveproject.sectionoperator03;

import com.sachet.reactiveproject.util.ConsumerUtil;
import reactor.core.publisher.Flux;

public class Flux01Handle {

    public static void main(String[] args) {

        Flux.range(1, 20)
                .handle(
                        ((integer, synchronousSink) -> {
                            if (integer == 7){
                                synchronousSink.complete();
                            }else {
                                synchronousSink.next(integer);
                            }
                        })
                )
                .subscribe(ConsumerUtil.subscriber());

        Flux
                .generate(
                        (synchronousSink -> {
                            synchronousSink.next(ConsumerUtil.getFAKER().country().name());
                        })
                )
                .map(Object::toString)
                .handle(
                        ((s, synchronousSink) -> {
                            synchronousSink.next(s);
                            if (s.equalsIgnoreCase("canada")){
                                synchronousSink.complete();
                            }
                        })
                )
                .subscribe(ConsumerUtil.subscriber());

    }

}
