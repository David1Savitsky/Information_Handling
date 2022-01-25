package com.epam.informationhandling.component;

import java.util.List;

public interface Component {
    List<Component> getChildren();
    int size();
}
