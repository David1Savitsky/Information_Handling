package com.epam.informationhandling.logic.calculation;

import com.epam.informationhandling.logic.calculation.AbstractMathExpression;
import com.epam.informationhandling.logic.calculation.Context;

public class TerminalExpressionSubtract implements AbstractMathExpression {
    @Override
    public void interpret(Context context) {
        Integer subtrahend = context.pop();
        Integer minuend = context.pop();
        context.push(minuend - subtrahend);
    }
}
