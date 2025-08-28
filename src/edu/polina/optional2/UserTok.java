package edu.polina.optional2;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class UserTok {

    static Map<String, Optional<UserMan>> map;

    static {
        map = new HashMap<>();
        map.put("000", Optional.of(new UserMan("NONAME")));
    }

    public static class UserMan {
        String name;

        public UserMan(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }


    public Map<String, Optional<UserMan>> getMap() {
        return map;
    }

    public Optional<UserMan> findUser(String token) {
        Optional<UserMan> userman = map.get(token).or(() -> Optional.of(new UserTok.UserMan("000")));
        return userman;
    }

    Optional<String> findUserName(Optional<String> token) {
        Optional<UserMan> userman = findUser(token.get());
        Optional<String> username = userman.map(u -> u.getName());
        String name = username.orElseGet(() -> "Пользователь не найден");
        System.out.println(name);
        return username;
    }
}
