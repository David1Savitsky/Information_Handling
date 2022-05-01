package com.epam.informationhandling.logic.calculation;

import com.epam.informationhandling.logic.calculation.AbstractMathExpression;
import com.epam.informationhandling.logic.calculation.Context;

public class TerminalExpressionDivide implements AbstractMathExpression {
    @Override
    public void interpret(Context context) {
        Integer divider = context.pop();
        Integer dividend = context.pop();
        context.push(dividend / divider);
    }
}
