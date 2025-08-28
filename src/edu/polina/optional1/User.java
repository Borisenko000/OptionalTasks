package edu.polina.optional1;

import java.util.Optional;

public class User {
    Optional<Address> address;
    String name;

    public User(String name, Optional<Address> adress) {
        this.name = name;
        this.address = adress;
    }

    public Optional<Address> getAddress() {
        return address;
    }

    public String getName() {
        return name;
    }
}
