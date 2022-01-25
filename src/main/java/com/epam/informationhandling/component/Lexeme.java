package com.epam.informationhandling.component;


import java.util.List;

public class Lexeme implements Component{

    private final String value;
    private final LexemeType type;

    public Lexeme(String value, LexemeType type) {
        this.value = value;
        this.type = type;
    }

    public static Lexeme makeWord(String value) {
        return new Lexeme(value, LexemeType.WORD);
    }

    public static Lexeme makeExpression(String value) {
        return new Lexeme(value, LexemeType.EXPRESSION);
    }

    @Override
    public List<Component> getChildren() {
        throw new UnsupportedOperationException();
    }

    @Override
    public int size() {
        return value.length();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o){
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Lexeme lexeme = (Lexeme) o;
        return value.equals(lexeme.value) && type == lexeme.type;
    }

    @Override
    public int hashCode() {
        int prime = 17;
        prime = 31 * prime + value.hashCode();
        prime = 31 * prime + value.hashCode();
        return prime;
    }

    @Override
    public String toString() {
        return "Lexeme{" +
                "value='" + value + '\'' +
                ", type=" + type +
                '}';
    }
}
