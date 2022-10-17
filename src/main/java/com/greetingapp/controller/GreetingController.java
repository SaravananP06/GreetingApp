package com.greetingapp.controller;

import com.greetingapp.entity.Greeting;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/greeting")
public class GreetingController {
    private static final String template = "Hello,%s";
    private static AtomicLong counter = new AtomicLong();


    @GetMapping(value = {"", "/", "/home"})
    public Greeting greeting(@RequestParam(value = "name",defaultValue = "world")String name)
    {
        return new Greeting(counter.incrementAndGet(),
                String.format(template,name));
    }

    @PostMapping("/posts")
    public Greeting sayHello(@RequestBody Greeting greeting){
        return new Greeting(counter.incrementAndGet(),
                String.format(template,greeting.getContent()));
    }

    @PutMapping("/put/{counter}")
    public Greeting sayHello(@PathVariable long counter, @RequestParam(value = "content") String content) {
        return new Greeting(counter, String.format(template, content));
    }


}
