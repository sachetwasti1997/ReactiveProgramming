package com.sachet.reactiveproject.section01;

import java.util.stream.Stream;

public class Stream01 {

    public static void main(String[] args) {

        Stream<Integer> stream = Stream.of(1)
                                    .map( integer -> {
                                        try {
                                            Thread.sleep(1000);
                                        } catch (InterruptedException e) {
                                            e.printStackTrace();
                                        }
                                        return integer * 2;
                                    });

        System.out.println(stream);
        //Doing this it will not wait for 1 seconds as we had expected but will return the result immediatly. It will
//        not do anything unless we connect the terminal operator
        stream.forEach(System.out::println);
        /**
         * Here we connected the stream with the terminal operator, now it will block and prints the result
         */
    }

}
