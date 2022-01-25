package com.epam.informationhandling.logic.calculation;

import com.epam.informationhandling.logic.calculation.AbstractMathExpression;
import com.epam.informationhandling.logic.calculation.Context;

public class TerminalExpressionMultiply implements AbstractMathExpression {
    @Override
    public void interpret(Context context) {
        Integer firstMultiplier = context.pop();
        Integer secondMultiplier = context.pop();
        context.push(firstMultiplier * secondMultiplier);
    }
}
