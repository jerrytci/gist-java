package com.rejerry.javagist;

import java.awt.*;
import java.io.File;
import java.util.Objects;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class javamain {
    public static void main(String[] args) {
        testFunction2();
//        testFunction();
//        testPredicate();
    }

    private static void testFunction() {
        Function<String, Boolean> keyEventDispatcher = s -> s.length() > 0;
        System.out.println("keyEventDispatcher.apply(\"one\") = " + keyEventDispatcher.apply("one"));
        System.out.println("keyEventDispatcher.apply(\" \") = " + keyEventDispatcher.apply(" "));
        System.out.println("keyEventDispatcher.apply(\"\") = " + keyEventDispatcher.apply(""));

        Predicate<String> predicate = s -> s.equals("tianci");
        boolean chentianci = predicate.test("chentianci");
        System.out.println("chentianci = " + chentianci);

        Predicate<String> predicate1 = s -> s.contains("tianci");
        System.out.println("predicate1.test(\"tianciv2\") = " + predicate1.test("tianciv2"));
    }

    private static void testFunction2() {
        Function<Integer, Integer> aa = a -> a * 3;
        Function<Integer, Integer> bb = b -> b + 2;
        Integer apply = aa.andThen(bb).apply(5);
        System.out.println("apply = " + apply);
        Integer apply1 = aa.compose(bb).andThen(bb).apply(5);
        System.out.println("apply1 = " + apply1);

    }

    private static void testPredicate() {
        Predicate<String> predicate = (s) -> s.length() > 0;

        predicate.test("foo");              // true
        predicate.negate().test("foo");     // false

        Predicate<Boolean> nonNull = Objects::nonNull;
        Predicate<Boolean> isNull = Objects::isNull;

        Predicate<String> isEmpty = String::isEmpty;
        Predicate<String> isNotEmpty = isEmpty.negate();

        System.out.println("nonNull.test(null) = " + nonNull.test(null));
        System.out.println("isEmpty.test(\" \") = " + isEmpty.test(" "));
        System.out.println("isEmpty.test(null) = " + isEmpty.test(null));
    }
}
