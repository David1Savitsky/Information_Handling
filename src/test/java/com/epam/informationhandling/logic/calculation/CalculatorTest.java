package com.epam.informationhandling.logic.calculation;

import com.epam.informationhandling.logic.calculation.Calculator;
import org.junit.Assert;
import org.junit.Test;

public class CalculatorTest {

    private static final String POSITIVE_ADDITION_EXPRESSION = "[ 5 10 + ]";
    private static final Integer RESULT_TO_POSITIVE_ADDITION = 15;
    private static final String NEGATIVE_ADDITION_EXPRESSION = "[ -7 11 + ]";
    private static final Integer RESULT_TO_NEGATIVE_ADDITION = 4;
    private static final String POSITIVE_SUBTRACTION_EXPRESSION = "[ 7 4 - ]";
    private static final Integer RESULT_TO_POSITIVE_SUBTRACTION = 3;
    private static final String NEGATIVE_SUBTRACTION_EXPRESSION = "[ -7 3 - ]";
    private static final Integer RESULT_TO_NEGATIVE_SUBTRACTION = -10;
    private static final String POSITIVE_MULTIPLICATION_EXPRESSION = "[ 10 3 * ]";
    private static final Integer RESULT_TO_POSITIVE_MULTIPLICATION = 30;
    private static final String NEGATIVE_MULTIPLICATION_EXPRESSION = "[ -2 -13 * ]";
    private static final Integer RESULT_TO_NEGATIVE_MULTIPLICATION = 26;
    private static final String POSITIVE_DIVISION_EXPRESSION = "[ 12 4 / ]";
    private static final Integer RESULT_TO_POSITIVE_DIVISION = 3;
    private static final String NEGATIVE_DIVISION_EXPRESSION = "[ -120 12 / ]";
    private static final Integer RESULT_TO_NEGATIVE_DIVISION = -10;
    private static final String COMPLEX_EXPRESSION = "[ 2 3 6 * + 10 5 1 * - / ]";
    private static final Integer RESULT_TO_COMPLEX_EXPRESSION = 4;

    private final Calculator calculator = new Calculator();

    @Test
    public void testCalculateShouldReturnRightAnswerWhenAddPositiveNumbers() {
        //given
        //when
        Integer actualResult = calculator.calculate(POSITIVE_ADDITION_EXPRESSION);
        //then
        Assert.assertEquals(RESULT_TO_POSITIVE_ADDITION, actualResult);
    }

    @Test
    public void testCalculateShouldReturnRightAnswerWhenAddNegativeNumbers() {
        //given
        //when
        Integer actualResult = calculator.calculate(NEGATIVE_ADDITION_EXPRESSION);
        //then
        Assert.assertEquals(RESULT_TO_NEGATIVE_ADDITION, actualResult);
    }

    @Test
    public void testCalculateShouldReturnRightAnswerWhenSubtractPositiveNumbers() {
        //given
        //when
        Integer actualResult = calculator.calculate(POSITIVE_SUBTRACTION_EXPRESSION);
        //then
        Assert.assertEquals(RESULT_TO_POSITIVE_SUBTRACTION, actualResult);
    }

    @Test
    public void testCalculateShouldReturnRightAnswerWhenSubtractNegativeNumbers() {
        //given
        //when
        Integer actualResult = calculator.calculate(NEGATIVE_SUBTRACTION_EXPRESSION);
        //then
        Assert.assertEquals(RESULT_TO_NEGATIVE_SUBTRACTION, actualResult);
    }

    @Test
    public void testCalculateShouldReturnRightAnswerWhenMultiplyPositiveNumbers() {
        //given
        //when
        Integer actualResult = calculator.calculate(POSITIVE_MULTIPLICATION_EXPRESSION);
        //then
        Assert.assertEquals(RESULT_TO_POSITIVE_MULTIPLICATION, actualResult);
    }

    @Test
    public void testCalculateShouldReturnRightAnswerWhenMultiplyNegativeNumbers() {
        //given
        //when
        Integer actualResult = calculator.calculate(NEGATIVE_MULTIPLICATION_EXPRESSION);
        //then
        Assert.assertEquals(RESULT_TO_NEGATIVE_MULTIPLICATION, actualResult);
    }

    @Test
    public void testCalculateShouldReturnRightAnswerWhenDividePositiveNumbers() {
        //given
        //when
        Integer actualResult = calculator.calculate(POSITIVE_DIVISION_EXPRESSION);
        //then
        Assert.assertEquals(RESULT_TO_POSITIVE_DIVISION, actualResult);
    }

    @Test
    public void testCalculateShouldReturnRightAnswerWhenDivideNegativeNumbers() {
        //given
        //when
        Integer actualResult = calculator.calculate(NEGATIVE_DIVISION_EXPRESSION);
        //then
        Assert.assertEquals(RESULT_TO_NEGATIVE_DIVISION, actualResult);
    }

    @Test
    public void testCalculateShouldReturnRightAnswerWhenDataValid() {
        //given
        //when
        Integer actualResult = calculator.calculate(COMPLEX_EXPRESSION);
        //then
        Assert.assertEquals(RESULT_TO_COMPLEX_EXPRESSION, actualResult);
    }
}
