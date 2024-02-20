package com.amazon.ata.inheritance.model;

/**
 * Representation of a Visit. Includes default colors, internal color printing
 * method, and visualization method.
 */
public class Visit {

    /** UTF-8 representation of ESC. */
    private static final char ESCAPE = '\u001b';

    /**
     * Create the visualization output (one colored character) for this
     * Visit type.
     *
     * NOTE - YOU SHOULD NOT NEED TO CHANGE THIS CODE!
     */
    public void visualize() {
        System.out.print(String.format("%c[%sm%c%c[0m",
            ESCAPE, getVisitColor().getAnsiCode(), getVisitCharacter(), ESCAPE));
    }

    public char getVisitCharacter() {
        return ' ';
    }

    public VisitColor getVisitColor() {
        return VisitColor.ANONYMOUS_VISITOR_COLOR;
    }
}
