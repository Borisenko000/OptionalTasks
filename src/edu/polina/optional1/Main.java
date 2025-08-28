package edu.polina.optional1
;
import java.util.*;
import java.util.function.Supplier;


//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
       // 1 задание
        String s1 = findUserNameById(1).orElse(" ");
        System.out.println(s1);

        // 2 задание
        String s = getEmail(1).orElse("unknown@mail.com");
        System.out.println(s);

        // 3 задание
        Optional<String> name = Optional.of("alice");
        Optional<String> nameUp = name.map(String::toUpperCase);
        System.out.println(nameUp.get());

        // 4 задание
        User user = new User("Paul", Optional.of(new Address("Paris")));
        Optional<User> optional = Optional.of(user);
        Optional<String> city = optional
                .flatMap(u -> u.getAddress())
                .map(Address::getCity);
        System.out.println(city.get());

        // 5 задание
        getAdultAge(17).ifPresentOrElse(
                System.out::println,
                () -> System.out.println("возраст меньше 18")
        );

        //6 задание
        Supplier<String> expensiveDefault = () -> {
            return "Значение по умолчанию";
        };
        Optional<String> value = Optional.of("что-то");
        Optional<String> value1 = Optional.empty();
        String res =resolveConfig(value1, expensiveDefault);
        System.out.println(res);

    }
    //id=1 → "Alice", id=2 → "Bob", иначе пусто. Вывести имя, если есть.
    public static Optional<String> findUserNameById(int id) {
        if (id == 1) {
            return Optional.of("Alice");
        }
        else if (id == 2) {
            return Optional.of("Bob");
        }
        else {
            return Optional.empty();
        }
    }

    //id=1 → "user@mail.com", иначе пусто. Вернуть строку с помощью orElse("unknown@mail.com")
    public static Optional<String> getEmail(int id) {
        if (id == 1) {
            return Optional.of("user@mail.com");
        }
        else {
            return Optional.empty();
        }
    }

    // Вернуть значение только если age >= 18
    public static Optional<Integer> getAdultAge(Integer age) {

        return Optional.ofNullable(age).filter(a -> a > 18);
    }

    //Если значение есть — вернуть его, иначе вызвать expensiveDefault.get()
    public static String resolveConfig(Optional<String> value, Supplier<String> expensiveDefault) {
        return value.orElseGet(expensiveDefault);
    }

    // 8 задание
    public static boolean needsUpdate(Optional<String> newValue, Optional<String> storedValue) {
        return newValue
                .filter(x -> !(x.isEmpty()))
                .map(y -> !y.equals(storedValue.map(z -> !(z.isEmpty())).orElse(true)))
                .orElse(storedValue.isPresent());
    }






}