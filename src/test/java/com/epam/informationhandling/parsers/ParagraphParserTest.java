package com.epam.informationhandling.parsers;

import com.epam.informationhandling.component.Composite;
import com.epam.informationhandling.component.Lexeme;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.Arrays;

public class ParagraphParserTest {

    private static final String PARAGRAPH_TO_PARSE = "He wakes up... Wow! Hurray? Hello, men.";
    private static final String FIRST_SENTENCE = "He wakes up...";
    private static final String SECOND_SENTENCE = "Wow!";
    private static final String THIRD_SENTENCE = "Hurray?";
    private static final String FOURTH_SENTENCE = "Hello, men.";
    private static final Composite FIRST_SENTENCE_COMPOSITE = new Composite(Arrays.asList(
            Lexeme.makeWord("He"), Lexeme.makeWord("wakes"), Lexeme.makeWord("up...")
    ));
    private static final Composite SECOND_SENTENCE_COMPOSITE = new Composite(Arrays.asList(Lexeme.makeWord("Wow!")));
    private static final Composite THIRD_SENTENCE_COMPOSITE = new Composite(Arrays.asList(Lexeme.makeWord("Hurray?")));
    private static final Composite FOURTH_SENTENCE_COMPOSITE = new Composite(Arrays.asList(
            Lexeme.makeWord("Hello,"), Lexeme.makeWord("men.")
    ));
    private static final Composite EXPECTED_PARAGRAPH_COMPOSITE = new Composite(Arrays.asList(
            FIRST_SENTENCE_COMPOSITE, SECOND_SENTENCE_COMPOSITE,THIRD_SENTENCE_COMPOSITE, FOURTH_SENTENCE_COMPOSITE
    ));

    @Test
    public void testParseShouldReturnCorrectCompositeWhenSentenceIsValid() {
        //given
        SentenceParser sentenceParser = Mockito.mock(SentenceParser.class);
        Mockito.when(sentenceParser.parse(FIRST_SENTENCE)).thenReturn(FIRST_SENTENCE_COMPOSITE);
        Mockito.when(sentenceParser.parse(SECOND_SENTENCE)).thenReturn(SECOND_SENTENCE_COMPOSITE);
        Mockito.when(sentenceParser.parse(THIRD_SENTENCE)).thenReturn(THIRD_SENTENCE_COMPOSITE);
        Mockito.when(sentenceParser.parse(FOURTH_SENTENCE)).thenReturn(FOURTH_SENTENCE_COMPOSITE);
        ParagraphParser paragraphParser = new ParagraphParser(sentenceParser);
        //when
        Composite actualParagraphComposite = paragraphParser.parse(PARAGRAPH_TO_PARSE);
        //then
        Assert.assertEquals(EXPECTED_PARAGRAPH_COMPOSITE, actualParagraphComposite);
    }
}
