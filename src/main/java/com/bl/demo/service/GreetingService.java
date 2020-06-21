package com.bl.demo.service;

import com.bl.demo.model.Greeting;
import com.bl.demo.model.User;
import com.bl.demo.repository.IGreetingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class GreetingService implements IGreetingService {
    private final AtomicLong counter = new AtomicLong();

    private Greeting greeting;

    @Autowired
    private IGreetingRepository greetingRepository;

    @Override
    public Greeting addGreeting(User user) {
        String message = user.toString().isEmpty() ? "Hello World" :
                "Hello " + user.getFirstName() + " " + user.getLastName();

        greeting = new Greeting();
        greeting.setCounter(counter.incrementAndGet());

        greeting.setName(message);

        return greetingRepository.save(greeting);
    }

    @Override
    public Greeting getGreetingsById(long id) {
       return greetingRepository.findById(id).get();
    }

    @Override
    public List<Greeting> getAllGreetings() {
        return greetingRepository.findAll();
    }
    @Override
    public Greeting updateGreetingsById(long id, User user) {
        Greeting greetingsById = getGreetingsById(id);
        greetingsById.setName("Hello " + user.getFirstName() + " " + user.getLastName());
        return greetingRepository.save(greetingsById);
    }

}