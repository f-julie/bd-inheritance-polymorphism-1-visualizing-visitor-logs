package com.amazon.ata.inheritance.model;

public class ZapposAccountVisit extends Visit {
    @Override
    public char getVisitCharacter() {
        return '@';
    }

    @Override
    public VisitColor getVisitColor() {
        return VisitColor.ZAPPOS_VISITOR_COLOR;
    }
}
