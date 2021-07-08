package com.sachet.reactiveproject.sectionflux02;

import com.sachet.reactiveproject.util.ConsumerUtil;
import reactor.core.publisher.Flux;

import java.util.Arrays;
import java.util.List;

public class Flux03FromList {

    public static void main(String[] args) {

        List<String> stringList = Arrays.asList("a", "b", "c");

        Flux.fromIterable(stringList)
                .subscribe(
                        ConsumerUtil.onNext()
                );

        Integer[] arr = {23, 55, 61, 45};

        Flux.fromArray(arr)
                .subscribe(
                        ConsumerUtil.onNext()
                );

    }

}
