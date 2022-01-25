package com.epam.informationhandling.logic;

import com.epam.informationhandling.builder.ParserChainBuilder;
import com.epam.informationhandling.component.Component;
import com.epam.informationhandling.component.Composite;
import com.epam.informationhandling.component.Lexeme;
import com.epam.informationhandling.logic.calculation.Calculator;
import com.epam.informationhandling.logic.comparator.ComponentSizeComparator;
import com.epam.informationhandling.logic.exception.InformationHandlingException;
import com.epam.informationhandling.parsers.Parser;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TextLogic {

    private static final String EXPRESSION_REGEX = "\\[[^]\\[]*]";
    private static final String COMPONENT_DELIMITER = " ";
    private static final String PARAGRAPH_DELIMITER = "\n";

    private static final Calculator calculator = new Calculator();

    private static final Logger LOGGER = LogManager.getLogger();

    public Composite parse(String text) {
        ParserChainBuilder parserChainBuilder = new ParserChainBuilder();
        Parser parser = parserChainBuilder.build();
        return parser.parse(text);
    }

    public String parseTextToString(Component text) throws InformationHandlingException {
        return parseComponentsToString(text, PARAGRAPH_DELIMITER);
    }

    private String parseComponentsToString(Component text, String delimiter) throws InformationHandlingException{
        StringBuilder result = new StringBuilder();

        if(text.getClass() == Lexeme.class){
            String lexemeText =((Lexeme) text).getValue();
            result.append(lexemeText);
            return result.toString();
        }
        if(text.getClass() == Composite.class) {
            List<Component> textCompositeComponents =  text.getChildren();
            for(Component component : textCompositeComponents) {
                result.append(parseComponentsToString(component, COMPONENT_DELIMITER));
                if (textCompositeComponents.indexOf(component) != (textCompositeComponents.size() - 1)) {
                    result.append(delimiter);
                }
            }
            return result.toString();
        }
        InformationHandlingException informationHandlingException = new InformationHandlingException("The Component can not be processed");
        LOGGER.throwing(informationHandlingException);
        throw informationHandlingException;
    }

    public Composite calculateExpressions(Composite text) {
        Composite calculatedTextComponents = new Composite();
        List<Component> textComponents = text.getChildren();
        for (Component paragraph : textComponents) {
            Composite newParagraph = new Composite();
            List<Component> paragraphComponents = paragraph.getChildren();
            for (Component sentence : paragraphComponents) {
                List<Component> lexemes = new ArrayList<>();
                List<Component> sentenceComponents = sentence.getChildren();
                for (Component lexemeComponent : sentenceComponents) {
                    String value = lexemeComponent.toString();
                    if (value.matches(EXPRESSION_REGEX)) {
                        Integer calculatedValue = calculator.calculate(value);
                        String stringValue = Double.toString(calculatedValue);
                        Component lexeme = Lexeme.makeWord(stringValue);
                        lexemes.add(lexeme);
                    } else {
                        lexemes.add(lexemeComponent);
                    }
                }
                newParagraph.add(new Composite(lexemes));
            }
            calculatedTextComponents.add(newParagraph);
        }
        LOGGER.info("All the expressions have been calculated successfully");
        return new Composite(Collections.singletonList(calculatedTextComponents));
    }

    public Composite sortParagraphsBySentenceNumber(Composite text) {
        List<Component> paragraphs = text.getChildren();
        paragraphs.sort(new ComponentSizeComparator());
        LOGGER.info("Paragraphs are successfully sorted by sentence number");
        return new Composite(paragraphs);
    }

    public Composite sortSentencesByWordLength(Composite text) {
        ComponentSizeComparator lexemeSizeComparator = new ComponentSizeComparator();
        Composite sortedText = new Composite();
        List<Component> paragraphs = text.getChildren();

        for(Component paragraph : paragraphs) {
            Composite sortedParagraph = new Composite();
            List<Component> sentences = paragraph.getChildren();
            for(Component sentence : sentences){
                List<Component> lexemes = sentence.getChildren();
                lexemes.sort(lexemeSizeComparator);
                Composite sortedSentence = new Composite(lexemes);
                sortedParagraph.add(sortedSentence);
            }
            sortedText.add(sortedParagraph);
        }
        LOGGER.info("Sentences are successfully sorted by word length");
        return sortedText;
    }

}
