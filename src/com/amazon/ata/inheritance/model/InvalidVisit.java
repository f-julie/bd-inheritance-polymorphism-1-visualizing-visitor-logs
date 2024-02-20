package com.amazon.ata.inheritance.model;

public class InvalidVisit extends Visit {

    @Override
    public char getVisitCharacter() {
        return 'X';
    }

    @Override
    public VisitColor getVisitColor() {
        return VisitColor.INVALID_COLOR;
    }
}
