package com.sachet.reactiveproject.sectionflux02;

import com.sachet.reactiveproject.util.ConsumerUtil;

import java.util.List;

public class Flux08FluxList {

    public static void main(String[] args) {
        List<String> names = NameGenerator.getNames(5);
        System.out.println(names);
        System.out.println("-----------------------------------------------------------");
        NameGenerator.getName(5)
                .subscribe(
                        ConsumerUtil.onNext()
                );
    }

}
