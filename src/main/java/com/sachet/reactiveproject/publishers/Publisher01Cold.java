package com.sachet.reactiveproject.publishers;

import com.sachet.reactiveproject.util.ConsumerUtil;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

public class Publisher01Cold {

    public static void main(String[] args) {

        Flux<String> moviesStream = Flux.fromStream(getMovies())
                .delayElements(Duration.ofSeconds(1)).share();

        moviesStream
                .subscribe(ConsumerUtil.subscriber("rosy"));

        ConsumerUtil.sleepSeconds(4);

        moviesStream.subscribe(ConsumerUtil.subscriber("sachet"));

        ConsumerUtil.sleepSeconds(60);

    }

    private static Stream<String> getMovies(){
        AtomicInteger i = new AtomicInteger();
//        return Stream.generate(() -> "Stream")
//                .map(str -> {
//                    str += " "+ i;
//                    i.getAndIncrement();
//                    return str;
//                }).limit(10);
        return Stream.of(
                "Stream 1",
                "Stream 2",
                "Stream 3",
                "Stream 4",
                "Stream 5",
                "Stream 6",
                "Stream 7",
                "Stream 8",
                "Stream 9",
                "Stream 10"
        );
    }

}
