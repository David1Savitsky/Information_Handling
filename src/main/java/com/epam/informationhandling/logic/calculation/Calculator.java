package com.epam.informationhandling.logic.calculation;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Calculator {

    private final List<AbstractMathExpression> expressionList = new ArrayList<>();

    private static final String LEXEME_DELIMITER = " ";

    public Integer calculate(String expression) {
        String[] lexemes = expression.split(LEXEME_DELIMITER);
        for(String lexeme : lexemes) {
            if(lexeme.isEmpty() || lexeme.length() > 1 && addIntegerToExpression(lexeme)) {
                continue;
            }
            switch (lexeme.charAt(0)){
                case '+':
                    expressionList.add(new TerminalExpressionAdd());
                    break;
                case '-':
                    expressionList.add(new TerminalExpressionSubtract());
                    break;
                case '*':
                    expressionList.add(new TerminalExpressionMultiply());
                    break;
                case '/':
                    expressionList.add(new TerminalExpressionDivide());
                    break;
                default:
                    Scanner scanner = new Scanner(lexeme);
                    if (scanner.hasNextInt()) {
                        expressionList.add(new NonTerminalExpression(scanner.nextInt()));
                    }
            }
        }
        return finishCalculation();
    }

    private boolean addIntegerToExpression(String lexeme) {
        Scanner scanner = new Scanner(lexeme);
        if (scanner.hasNextInt()) {
            expressionList.add(new NonTerminalExpression(scanner.nextInt()));
        } else {
            return false;
        }
        return true;
    }

    private Integer finishCalculation() {
        Context context = new Context();
        for(AbstractMathExpression expression : expressionList) {
            expression.interpret(context);
        }
        return context.pop();
    }

}
