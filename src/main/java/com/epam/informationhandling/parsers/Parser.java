package com.epam.informationhandling.parsers;

import com.epam.informationhandling.component.Composite;

public interface Parser {
    Composite parse(String text);
}
