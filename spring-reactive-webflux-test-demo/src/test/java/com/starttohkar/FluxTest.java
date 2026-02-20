package com.starttohkar;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;

public class FluxTest {

    @Test
    public void testFlux() {
        Flux<String> mStr = Flux.just("Hello, Flux!","Hi, java","Hi, Spring","Hello, Hibernate").log();
        mStr.subscribe(System.out::println);
    }

    @Test
    public void testFluxConcat() {
        Flux<String> mStr = Flux.just("Hello, Flux!","Hi, java","Hi, Spring","Hello, Hibernate")
                .concatWithValues("Hello, Project Reactor!")
                .log();
        mStr.subscribe(System.out::println);
    }

    @Test
    public void testFluxConcateWithError() {
        Flux<String> mStr = Flux.just("Hello, Flux!","Hi, java","Hi, Spring","Hello, Hibernate")
                .concatWithValues("Hello, Project Reactor!")
                .concatWith(Flux.error(new RuntimeException("Something went wrong! Pls try again later.")))
                .log();
        mStr.subscribe(System.out::println);
    }

    @Test
    public void testFluxConcateWithErrorMessage() {
        Flux<String> mStr = Flux.just("Hello, Flux!","Hi, java","Hi, Spring","Hello, Hibernate")
                .concatWithValues("Hello, Project Reactor!")
                .concatWith(Flux.error(new RuntimeException("Something went wrong! Pls try again later.")))
                .log();
        mStr.subscribe(System.out::println, error -> System.err.println("Error: " + error.getMessage()));
    }

    @Test
    public void testFluxConcateWithErrorMessageAgainConcate() {
        Flux<String> mStr = Flux.just("Hello, Flux!","Hi, java","Hi, Spring","Hello, Hibernate")
                .concatWithValues("Hello, Project Reactor!")
                .concatWith(Flux.error(new RuntimeException("Something went wrong! Pls try again later.")))
                .concatWithValues("This will not be emitted due to error")
                .log();
        mStr.subscribe(System.out::println, error -> System.err.println("Error: " + error.getMessage()));
    }
}
