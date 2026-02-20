package com.starttohkar;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Mono;

public class MonoTest {

    @Test
    public void testMono() {
        Mono<String> mStr = Mono.just("Hello, Mono!").log();
        mStr.subscribe(System.out::println);
    }

    @Test
    public void testMonoWithError() {
        Mono<?> mStr = Mono.just("Hello, Mono!!")
                .then(Mono.error(new RuntimeException("Something went wrong!")))
                .log();
        mStr.subscribe(System.out::println);
    }

    @Test
    public void testMonoWithErrorMessage() {
        Mono<?> mStr = Mono.just("Hello, Mono!!!")
                .then(Mono.error(new RuntimeException("Something went wrong! Pls try again later.")))
                .log();
        mStr.subscribe(System.out::println, error -> System.err.println("Error: " + error.getMessage()));
    }
}
