package com.epam.informationhandling.parsers;

import com.epam.informationhandling.component.Composite;
import com.epam.informationhandling.component.Lexeme;

public class SentenceParser extends AbstractParser {

    private static final String WORDS_DELIMITER = "\\s";
    private static final String LEXEME_DELIMITER = "(?:\\s(?=\\[)|(?<=])\\s)";

    public SentenceParser() {
        super();
    }

    @Override
    public Composite parse(String text) {
        Composite composite = new Composite();
        String[] splitLexemes = text.split(LEXEME_DELIMITER);
        for(String splitLexeme : splitLexemes) {
            if (splitLexeme.contains("[") && splitLexeme.contains("]")) {
                composite.add(Lexeme.makeExpression(splitLexeme));
            }
            else{
                parseWords(splitLexeme, composite);
            }
        }
        return composite;
    }

    private void parseWords(String splitLexeme, Composite composite) {
        String[] splitWords = splitLexeme.split(WORDS_DELIMITER);
        for (String  splitWord : splitWords) {
            composite.add(Lexeme.makeWord(splitWord));
        }
    }
}
