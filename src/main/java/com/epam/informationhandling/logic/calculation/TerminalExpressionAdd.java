package com.epam.informationhandling.logic.calculation;

import com.epam.informationhandling.logic.calculation.AbstractMathExpression;
import com.epam.informationhandling.logic.calculation.Context;

public class TerminalExpressionAdd implements AbstractMathExpression {

    @Override
    public void interpret(Context context) {
        Integer firstTerm = context.pop();
        Integer secondTerm = context.pop();
        context.push(firstTerm + secondTerm);
    }
}
