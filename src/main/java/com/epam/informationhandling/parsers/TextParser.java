package com.epam.informationhandling.parsers;

import com.epam.informationhandling.component.Composite;

public class TextParser extends AbstractParser {

    private static final String PARAGRAPH_DELIMITER = "\n";

    public TextParser(Parser successor) {
        super(successor);
    }

    @Override
    public Composite parse(String text) {
        return sampleParse(text, PARAGRAPH_DELIMITER);
    }
}
