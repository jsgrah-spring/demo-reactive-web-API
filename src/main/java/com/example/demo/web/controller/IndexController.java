package com.example.demo.web.controller;

import com.example.demo.web.dto.Foo;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.time.Duration;

@RestController
public class IndexController {

    @GetMapping(produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Foo> getResource() {
        return Flux.interval(Duration.ofSeconds(1))
                .map(val -> new Foo(1, "Bar"));
    }
}
