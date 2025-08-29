package edu.polina.optional2;

import java.util.HashMap;
import java.util.Optional;


// 7 задание
public class Main {
    public static void main(String[] args) {
        //7 задание
        Optional<String> token = Optional.of("555");
        UserTok userTok = new UserTok();
        userTok.map = new HashMap<>();
        UserTok.UserMan man1 = new UserTok.UserMan("Mike");
        UserTok.UserMan man2 = new UserTok.UserMan("John");
        userTok.map.put("123", Optional.of(man1));
        userTok.map.put("365", Optional.of(man2));
        Optional<String> username = userTok.findUserName(token);
    }
}
