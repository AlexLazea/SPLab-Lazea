package com.example.designpatterns.difexample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
@Component
@Scope("prototype")
public class ClientComponent {
    private final String id;

    public ClientComponent() {
        this.id = Integer.toHexString(System.identityHashCode(this));
    }

    @Override
    public String toString() {
        return "ClientComponent@" + id;
    }
}