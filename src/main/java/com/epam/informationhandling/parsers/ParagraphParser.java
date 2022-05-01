package com.epam.informationhandling.parsers;

import com.epam.informationhandling.component.Composite;

public class ParagraphParser extends AbstractParser {

    private static final String PARAGRAPH_DELIMITER = "(?<=[\\?\\!\\.[\\.]{3}])\\s";

    public ParagraphParser(Parser successor) {
        super(successor);
    }

    @Override
    public Composite parse(String text) {
        return sampleParse(text, PARAGRAPH_DELIMITER);
    }
}
