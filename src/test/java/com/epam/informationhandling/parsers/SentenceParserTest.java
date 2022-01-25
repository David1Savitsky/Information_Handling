package com.epam.informationhandling.parsers;

import com.epam.informationhandling.component.Composite;
import com.epam.informationhandling.component.Lexeme;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class SentenceParserTest {

    private static final String SENTENCE_TO_PARSE = "It is an [ 1200 5 / ] established fact.";
    private static final Composite EXPECTED_SENTENCE_COMPOSITE = new Composite(Arrays.asList(
            Lexeme.makeWord("It"), Lexeme.makeWord("is"), Lexeme.makeWord("an"),
            Lexeme.makeExpression("[ 1200 5 / ]"), Lexeme.makeWord("established"),
            Lexeme.makeWord("fact.")
    ));

    private final SentenceParser sentenceParser = new SentenceParser();

    @Test
    public void testParseShouldReturnCorrectCompositeWhenSentenceIsValid() {
        //given
        //when
        Composite actualSentenceComposite = sentenceParser.parse(SENTENCE_TO_PARSE);
        //then
        Assert.assertEquals(EXPECTED_SENTENCE_COMPOSITE, actualSentenceComposite);
    }
}
