package com.sachet.reactiveproject.section01;

import com.sachet.reactiveproject.util.ConsumerUtil;
import reactor.core.publisher.Mono;

public class MonoEmpty04 {

    public static void main(String[] args) {

        userRepository(1)
                .subscribe(
                        ConsumerUtil.onNext(),
                        ConsumerUtil.onError(),
                        ConsumerUtil.onComplete()
                );

    }

    private static Mono<String> userRepository(Integer userId){

        if (userId == 1){
            return Mono.just(ConsumerUtil.getFAKER().name().fullName());
        }else if (userId == 2){
            return Mono.empty();
        }else{
            return Mono.error(new RuntimeException("The ID is not allowed!"));
        }

    }

}
