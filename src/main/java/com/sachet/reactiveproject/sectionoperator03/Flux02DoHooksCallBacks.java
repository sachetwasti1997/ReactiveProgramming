package com.sachet.reactiveproject.sectionoperator03;

import com.sachet.reactiveproject.util.ConsumerUtil;
import reactor.core.publisher.Flux;

public class Flux02DoHooksCallBacks {

    public static void main(String[] args) {

        Flux.create(fluxSink -> {
            System.out.println("Inside Create!");
            int i;
            for (i=0; i<5; i++){
                fluxSink.next(i);
            }
            System.out.println(1/0);
            fluxSink.complete();
            System.out.println("---Completed");
        })
        .doOnComplete(() -> System.out.println("The process is completed!"))
        .doFirst(() -> System.out.println("This is the first task!"))
        .doOnNext(o -> System.out.println("This is the object received: "+o))
        .doOnSubscribe(subscription -> System.out.println("We can control subscription here!"))
        .doOnRequest(l -> System.out.println("This is the number requested: "+l))
        .doOnError(err -> System.out.println("Here is where the error is called: "+err))
        .doOnTerminate(() -> System.out.println("The process terminated!"))
        .doOnCancel(() -> System.out.println("The process is cancelled!"))
        .doFinally(signalType -> System.out.println("Finally a signalType is received: "+signalType))
        .doOnDiscard(Object.class, o -> System.out.println("I don't know this is discard callback: "+o))
        .subscribe(ConsumerUtil.subscriber());
        /*The flow is from subscriber to the publisher ie from bottom to top*/
        /*The subscription passes from publisher to subscriber*/

    }

}
