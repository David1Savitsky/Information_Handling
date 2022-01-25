package com.epam.informationhandling.parsers;

import com.epam.informationhandling.component.Component;
import com.epam.informationhandling.component.Composite;

public abstract class AbstractParser implements Parser {

    private final Parser successor;

    public AbstractParser() {
        successor = null;
    }

    public AbstractParser(Parser successor) {
        this.successor = successor;
    }

    public Parser getSuccessor() {
        return successor;
    }

    protected Composite sampleParse(String text, String delimiter) {
        Composite composite = new Composite();
        String[] paragraphs = text.split(delimiter);
        for (String paragraph : paragraphs) {
            Component paragraphComposite = getSuccessor().parse(paragraph);
            composite.add(paragraphComposite);
        }
        return composite;
    }

}
