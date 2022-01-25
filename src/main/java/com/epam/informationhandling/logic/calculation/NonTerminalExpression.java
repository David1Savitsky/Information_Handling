package com.epam.informationhandling.logic.calculation;

import com.epam.informationhandling.logic.calculation.AbstractMathExpression;
import com.epam.informationhandling.logic.calculation.Context;

public class NonTerminalExpression implements AbstractMathExpression {

    private final int number;

    public NonTerminalExpression(int number) {
        this.number = number;
    }

    @Override
    public void interpret(Context context) {
        context.push(number);
    }
}
