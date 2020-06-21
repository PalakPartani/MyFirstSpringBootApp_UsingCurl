package com.bl.demo.service;

import com.bl.demo.model.Greeting;
import com.bl.demo.model.User;

import java.util.List;

public interface IGreetingService {
    Greeting addGreeting(User user);
    List<Greeting> getAllGreetings();

}
