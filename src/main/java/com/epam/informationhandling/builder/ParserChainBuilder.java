package com.epam.informationhandling.builder;

import com.epam.informationhandling.parsers.ParagraphParser;
import com.epam.informationhandling.parsers.Parser;
import com.epam.informationhandling.parsers.SentenceParser;
import com.epam.informationhandling.parsers.TextParser;

public class ParserChainBuilder {
    public Parser build() {
        return new TextParser(new ParagraphParser(new SentenceParser()));
    }
}
