package com.epam.informationhandling.parsers;

import com.epam.informationhandling.component.Composite;
import com.epam.informationhandling.component.Lexeme;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.Collections;

public class TextParserTest {

    private static final String TEXT_TO_PARSE = "Believe me. Yea.\nAs soon as possible.";
    private static final String FIRST_PARAGRAPH = "Believe me. Yea.";
    private static final String SECOND_PARAGRAPH = "As soon as possible.";
    private static final Composite FIRST_SENTENCE_COMPOSITE = new Composite(Arrays.asList(
            Lexeme.makeWord("Believe me"), Lexeme.makeWord("me.")
    ));
    private static final Composite SECOND_SENTENCE_COMPOSITE = new Composite(Collections.singletonList(Lexeme.makeWord("Yea.")));
    private static final Composite THIRD_SENTENCE_COMPOSITE = new Composite(Arrays.asList(
            Lexeme.makeWord("As"), Lexeme.makeWord("soon"), Lexeme.makeWord("as"), Lexeme.makeWord("possible.")
    ));
    private static final Composite FIRST_PARAGRAPH_COMPOSITE = new Composite(Arrays.asList(
            FIRST_SENTENCE_COMPOSITE, SECOND_SENTENCE_COMPOSITE
    ));
    private static final Composite SECOND_PARAGRAPH_COMPOSITE = new Composite(Collections.singletonList(THIRD_SENTENCE_COMPOSITE));
    private static final Composite EXPECTED_TEXT_COMPOSITE = new Composite(Arrays.asList(
            FIRST_PARAGRAPH_COMPOSITE, SECOND_PARAGRAPH_COMPOSITE
    ));

    @Test
    public void testParseShouldReturnCorrectCompositeWhenTextIsValid() {
        //given
        ParagraphParser paragraphParser = Mockito.mock(ParagraphParser.class);
        Mockito.when(paragraphParser.parse(FIRST_PARAGRAPH)).thenReturn(FIRST_PARAGRAPH_COMPOSITE);
        Mockito.when(paragraphParser.parse(SECOND_PARAGRAPH)).thenReturn(SECOND_PARAGRAPH_COMPOSITE);
        TextParser textParser = new TextParser(paragraphParser);
        //when
        Composite actualTextComposite = textParser.parse(TEXT_TO_PARSE);
        //then
        Assert.assertEquals(EXPECTED_TEXT_COMPOSITE, actualTextComposite);
    }

}
