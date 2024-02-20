package com.amazon.ata.inheritance.model;

/**
 * The various kinds of colored characters the visualizer can use, and their ANSI escape codes.
 */
public enum VisitColor {
    /** Invalid visits. Black on light red. */
    INVALID_COLOR("1;97;101"),
    /** Visits from people who aren't logged in. Gray on blue. */
    ANONYMOUS_VISITOR_COLOR("90;44"),
    /** Visits from test automation. Gray on "Amazon" yellow. */
    TEST_VISITOR_COLOR("90;43"),
    /** Visits from logged-in Amazon customer. Grey on white.*/
    AMAZON_VISITOR_COLOR("90;40"),
    /** Visits from logged-in Zappos customer. Grey on black. */
    ZAPPOS_VISITOR_COLOR("90;107");

    private String ansiCode;

    /**
     * Returns the ANSI sequence that represents this visit type.
     * @param ansiCode The ANSI sequence that represents this visit type.
     */
    VisitColor(String ansiCode) {
        this.ansiCode = ansiCode;
    }

    public String getAnsiCode() {
        return this.ansiCode;
    }
}
