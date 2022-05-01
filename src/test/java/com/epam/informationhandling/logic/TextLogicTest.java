package com.epam.informationhandling.logic;

import com.epam.informationhandling.component.Composite;
import com.epam.informationhandling.component.Lexeme;
import com.epam.informationhandling.logic.calculation.Calculator;
import com.epam.informationhandling.logic.exception.InformationHandlingException;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.Collections;

public class TextLogicTest {

    private static final String FIRST_EXPRESSION = "[ 2 1 + 6 / 2 + ]";
    private static final Integer RESULT_TO_FIRST_EXPRESSION = 2;
    private static final String RESULT_TO_FIRST_EXPRESSION_STRING = "2";

    private static final Composite FIRST_SENTENCE_COMPOSITE = new Composite(Arrays.asList(Lexeme.makeWord("Believe"),
            Lexeme.makeWord("me.")));
    private static final Composite SECOND_SENTENCE_COMPOSITE = new Composite(Collections.singletonList(Lexeme.makeWord("Yea.")));
    private static final Composite THIRD_SENTENCE_WITH_EXPRESSION_COMPOSITE = new Composite(Arrays.asList(
            Lexeme.makeExpression(FIRST_EXPRESSION),
            Lexeme.makeWord("As"),
            Lexeme.makeWord("soon.")
    ));
    private static final Composite FIRST_PARAGRAPH_COMPOSITE = new Composite(Arrays.asList(FIRST_SENTENCE_COMPOSITE, SECOND_SENTENCE_COMPOSITE));
    private static final Composite SECOND_PARAGRAPH_COMPOSITE = new Composite(Collections.singletonList(THIRD_SENTENCE_WITH_EXPRESSION_COMPOSITE));
    private static final Composite TEXT_COMPOSITE = new Composite(Arrays.asList(FIRST_PARAGRAPH_COMPOSITE, SECOND_PARAGRAPH_COMPOSITE));
    private static final String EXPECTED_TEXT_COMPOSITE = "Believe me. Yea.\n[ 2 1 + 6 / 2 + ] As soon.";
    private static final Composite EXPECTED_TEXT_WITH_SORTED_PARAGRAPHS = new Composite(Arrays.asList(
        SECOND_PARAGRAPH_COMPOSITE, FIRST_PARAGRAPH_COMPOSITE));

    private static final Composite FIRST_SORTED_SENTENCE_COMPOSITE = new Composite(Arrays.asList(Lexeme.makeWord("me."),
            Lexeme.makeWord("Believe")));
    private static final Composite THIRD_SORTED_SENTENCE_COMPOSITE = new Composite(Arrays.asList(Lexeme.makeWord("As"),
            Lexeme.makeWord("soon."), Lexeme.makeExpression(FIRST_EXPRESSION)));
    private static final Composite FIRST_PARAGRAPH_COMPOSITE_WITH_SORTED_SENTENCES = new Composite(Arrays.asList(
            FIRST_SORTED_SENTENCE_COMPOSITE, SECOND_SENTENCE_COMPOSITE));
    private static final Composite SECOND_PARAGRAPH_COMPOSITE_WITH_SORTED_SENTENCES = new Composite(Collections.singletonList(THIRD_SORTED_SENTENCE_COMPOSITE));
    private static final Composite EXPECTED_TEXT_WITH_SORTED_SENTENCES = new Composite(Arrays.asList(
            FIRST_PARAGRAPH_COMPOSITE_WITH_SORTED_SENTENCES, SECOND_PARAGRAPH_COMPOSITE_WITH_SORTED_SENTENCES));

    private static final Composite THIRD_SENTENCE_WITH_CALCULATED_EXPRESSION_COMPOSITE = new Composite(Arrays.asList(
            Lexeme.makeWord(RESULT_TO_FIRST_EXPRESSION_STRING), Lexeme.makeWord("As"), Lexeme.makeWord("soon.")));
    private static final Composite SECOND_PARAGRAPH_CALCULATED_EXPRESSION_COMPOSITE = new Composite(
            Collections.singletonList(THIRD_SENTENCE_WITH_CALCULATED_EXPRESSION_COMPOSITE));
    private static final Composite EXPECTED_CALCULATED_TEXT_COMPOSITE = new Composite(Arrays.asList(
            FIRST_PARAGRAPH_COMPOSITE, SECOND_PARAGRAPH_CALCULATED_EXPRESSION_COMPOSITE));

    private final TextLogic textLogic = new TextLogic();

    @Test
    public void testParseTextToStringShouldReturnAStringValueWhenCompositeValid() throws InformationHandlingException {
        //given
        //when
        String actualTextComposite = textLogic.parseTextToString(TEXT_COMPOSITE);
        //then
        Assert.assertEquals(EXPECTED_TEXT_COMPOSITE, actualTextComposite);
    }

    @Test
    public void testSortParagraphsBySentenceNumberShouldSortWhenTextValid() {
        //given
        //when
        Composite actualTextWithSortedParagraphs = textLogic.sortParagraphsBySentenceNumber(TEXT_COMPOSITE);
        //then
        Assert.assertEquals(EXPECTED_TEXT_WITH_SORTED_PARAGRAPHS, actualTextWithSortedParagraphs);
    }

    @Test
    public void testSortSentencesByWordLengthShouldSortWhenTextValid() {
        //given
        //when
        Composite actualTextWithSortedSentences = textLogic.sortSentencesByWordLength(TEXT_COMPOSITE);
        //then
        Assert.assertEquals(EXPECTED_TEXT_WITH_SORTED_SENTENCES, actualTextWithSortedSentences);
    }

    @Test
    public void testCalculateExpressionsShouldCalculateWhenCompositeValid() {
        //given
        Calculator calculatorMock = Mockito.mock(Calculator.class);
        Mockito.when(calculatorMock.calculate(FIRST_EXPRESSION)).thenReturn(RESULT_TO_FIRST_EXPRESSION);
        TextLogic textLogic = new TextLogic();
        //when
        Composite actualCalculatedTextComposite = textLogic.calculateExpressions(TEXT_COMPOSITE);
        //then
        Assert.assertEquals(EXPECTED_CALCULATED_TEXT_COMPOSITE, actualCalculatedTextComposite);
    }
}
