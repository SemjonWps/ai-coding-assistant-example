package org.example.heroesjavaspringbackend;

import java.util.*;
import org.junit.jupiter.api.*;

public class OtherTests {

    @Test
    void example_1() {
        System.out.println('x' - 'z');
    }

    @Test
    void example_2() {
        System.out.println("\u0300a la votre!");
        System.out.println("\u0300");

    }

    @Test
    void example_3() {
        System.out.println("foobar" == "foobar");
        System.out.println("foo" + "bar" == "foobar");
        System.out.println("foo".concat("bar") == "foobar");
    }

    public class PrefixWriter {
        private String prefix;

        public void set(String newPrefix) {
            String prefix = newPrefix;
        }

        public void write(String message) {
            System.out.println(prefix + message);
        }
    }

    @Test
    void example_4() {
        PrefixWriter writer = new PrefixWriter();
        writer.set("not ");
        writer.write("cool");
    }

    @Test
    void example_5() {
        for (int i = 4; i == 8; i += 2) ;
        {
            System.out.println('.');
        }
    }

    @Test
    void example_6() {
        float f = 0;

        for (int i = 0; i >= 0; i++) {
            ++f;
        }

        System.out.println(f);
    }

    @Disabled
    @Test
    void example_7() {
        String s = "ben";
        s.concat("der");
        s.substring(1, 4);
        System.out.println(s);
    }

    @Test
    void example_8() {
        Map<String, Integer> map = new HashMap<>();
        map.put("apple", 1);
        map.put("banana", 2);
        map.put("cherry", 3);

        // map.forEach(entry -> System.out.println(entry.getKey() + " -> " + entry.getValue()));
        map.forEach((key, value) -> System.out.println(key + " -> " + value));
    }

    @FunctionalInterface
    interface BinaryOperator<T> {
        T apply(T t1, T t2);
    }

    private static <T> BinaryOperator<T> compose(BinaryOperator<T> op1, BinaryOperator<T> op2) {
        return (x, y) -> op1.apply(op2.apply(x, y), y);
    }

    @Test
    void example_9() {
        BinaryOperator<Integer> add = (x, y) -> x + y;
        BinaryOperator<Integer> multiply = (x, y) -> x * x;

        var composed = compose(add, multiply);
        // System.out.println(composed(2, 3));
    }
    // System.out.println(compose(add, multiply).apply(2, 3));
}
