package com.example.designpatterns.controllers;

import com.example.designpatterns.difexample.ClientComponent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import lombok.RequiredArgsConstructor;
import java.util.function.Supplier;
@RestController
public class HelloController {
    private final Supplier<ClientComponent> clientComponentProvider;

    @Autowired
    public HelloController(Supplier<ClientComponent> clientComponentProvider) {
        this.clientComponentProvider = clientComponentProvider;
    }

    @GetMapping("/new-client")
    public String newClientInfo() {
        ClientComponent newClientComponent = clientComponentProvider.get();
        return "New ClientComponent instance = " + newClientComponent;
    }
}
