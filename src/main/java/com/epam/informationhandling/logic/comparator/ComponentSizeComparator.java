package com.epam.informationhandling.logic.comparator;

import com.epam.informationhandling.component.Component;

import java.util.Comparator;

public class ComponentSizeComparator implements Comparator<Component> {
    @Override
    public int compare(Component firstComponent, Component secondComponent) {
        return firstComponent.size() - secondComponent.size();
    }
}
