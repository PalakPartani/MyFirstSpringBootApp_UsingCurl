
package com.bl.demo.controller;

import com.bl.demo.model.Greeting;
import com.bl.demo.model.User;
import com.bl.demo.service.IGreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class GreetingController {

    @Autowired
    private IGreetingService greetingService;

    @GetMapping("/addgreeting")
    public Greeting addGreeting(@RequestParam(value = "fName", defaultValue = "World") String firstName,

                                @RequestParam(value = "lName", defaultValue = "World") String lastName) {
        User user = new User();
        user.setFirstName(firstName);
        user.setLastName(lastName);
        return greetingService.addGreeting(user);
    }

    @RequestMapping("/getallgreeting")
    public List<Greeting> getAllGreeting() {
        return greetingService.getAllGreetings();

    }
    @GetMapping("/getgreetingbyid/{id}")
    public Greeting getGreetingById(@PathVariable Long id){
        return greetingService.getGreetingsById(id);
    }

    @PutMapping("/update/{id}")
    public Greeting updateGreetingById(@PathVariable Long id,@RequestParam(value = "fName") String fName,@RequestParam(value="lName") String lName){
        User user = new User();
        user.setFirstName(fName);
        user.setLastName(lName);
        return greetingService.updateGreetingsById(id,user);
    }
    @DeleteMapping("/delete/{id}")
    public Greeting deleteUserById(@PathVariable Long id){
        return greetingService.deleteById(id);
    }
}

















/*
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
    @PutMapping("/put/{name}")
    public Greeting greetingUpdate(@PathVariable Greeting greeting) {
        return new Greeting(counter.incrementAndGet(),String.format(template,greeting.getName()));
    }*/
