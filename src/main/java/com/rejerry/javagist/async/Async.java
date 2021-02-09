package com.rejerry.javagist.async;

import java.util.Collection;
import java.util.List;
import java.util.concurrent.*;

public class Async {
    public static void main(String[] args) {
        Executor executor = new Executor() {
            @Override
            public void execute(Runnable command) {
                System.out.println("execute");
            }
        };
    }
}
