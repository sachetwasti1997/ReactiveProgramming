package com.sachet.reactiveproject.sectionflux02;

import com.sachet.reactiveproject.util.ConsumerUtil;
import reactor.core.publisher.Flux;

import java.util.ArrayList;
import java.util.List;

public class NameGenerator {

    public static List<String> getNames(int count){
        List<String> stringList = new ArrayList<>();
        for (int i=0; i<count; i++){
            stringList.add(nameGenerator());
        }
        return stringList;
    }

    public static Flux<String> getName(int count){
        return Flux.range(1, count)
                .map(i -> nameGenerator());
    }

    private static String nameGenerator(){
        ConsumerUtil.sleepSeconds(1);
        return ConsumerUtil.getFAKER().name().fullName();
    }

}
