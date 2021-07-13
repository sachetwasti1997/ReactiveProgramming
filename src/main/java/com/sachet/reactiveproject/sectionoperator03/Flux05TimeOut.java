package com.sachet.reactiveproject.sectionoperator03;

import com.sachet.reactiveproject.util.ConsumerUtil;
import reactor.core.publisher.Flux;

import java.time.Duration;

public class Flux05TimeOut {

    public static void main(String[] args) {
        getOrderNumbers()
                .timeout(Duration.ofSeconds(1)) //Delay elements happens in a separate thread.
                .subscribe(ConsumerUtil.subscriber());

        ConsumerUtil.sleepSeconds(60);
    }

    private static Flux<Integer> getOrderNumbers(){
        return Flux.range(1, 10)
                .delayElements(Duration.ofSeconds(4));
    }

}
