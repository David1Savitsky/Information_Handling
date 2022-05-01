package com.epam.informationhandling.logic.calculation;

import java.util.ArrayDeque;
import java.util.Deque;

public class Context {

    private final Deque<Integer> stack = new ArrayDeque<>();

    public Integer pop() {
        return stack.pop();
    }

    public void push(Integer number) {
        stack.push(number);
    }
}
