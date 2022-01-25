package com.epam.informationhandling.logic;

import com.epam.informationhandling.builder.ParserChainBuilder;
import com.epam.informationhandling.component.Component;
import com.epam.informationhandling.component.Composite;
import com.epam.informationhandling.logic.comparator.ComponentSizeComparator;
import com.epam.informationhandling.parsers.Parser;

import java.util.List;

public class TextLogic {

    public Composite parse(String text) {
        ParserChainBuilder parserChainBuilder = new ParserChainBuilder();
        Parser parser = parserChainBuilder.build();
        return parser.parse(text);
    }

    public Composite sortParagraphsBySentenceNumber(Composite text) {
        List<Component> paragraphs = text.getChildren();
        paragraphs.sort(new ComponentSizeComparator());
        return new Composite(paragraphs);
    }

    public Composite sortSentencesByWordLength(Composite text) {
        List<Component> paragraphs = text.getChildren();
        ComponentSizeComparator lexemeSizeComparator = new ComponentSizeComparator();

        for(Component paragraph : paragraphs) {
            List<Component> sentences = paragraph.getChildren();
            for(Component sentence : sentences){
                List<Component> lexemes = sentence.getChildren();
                lexemes.sort(lexemeSizeComparator);
            }
        }
        return new Composite(paragraphs);
    }

}
