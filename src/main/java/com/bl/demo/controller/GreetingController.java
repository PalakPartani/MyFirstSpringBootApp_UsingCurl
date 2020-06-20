
package com.bl.demo.controller;

import com.bl.demo.model.Greeting;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class GreetingController {
    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @GetMapping("/greeting")
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name){
        return new Greeting(counter.incrementAndGet(),String.format(template,name));
    }

    @PostMapping("/postgreeting")
    public Greeting greeting(@RequestBody Greeting greeting) {
        return new Greeting(counter.incrementAndGet(),String.format(template,greeting.name));
    }
}

