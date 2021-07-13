package com.sachet.reactiveproject.sectionoperator03;

import com.sachet.reactiveproject.util.ConsumerUtil;
import reactor.core.publisher.Flux;

public class Flux03LimitRange {

    public static void main(String[] args) {

        Flux.range(1, 1000)
                .log()
                .limitRate(100)
                .subscribe(ConsumerUtil.subscriber());

    }

}
