package com.amazon.ata.inheritance.model;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class VisitTest {

    @Test
    public void testDefaultVisitVisualizesAsInvalid() throws UnsupportedEncodingException {
        // GIVEN
        // A anonymous Visit
        Visit visit = new Visit();

        // With all output captured by our own stream
        ByteArrayOutputStream capture = new ByteArrayOutputStream(100);
        PrintStream stdout = System.out;
        System.setOut(new PrintStream(capture));

        // WHEN
        // We visualize the visit
        visit.visualize();
        // And restore stdout
        System.setOut(stdout);

        // THEN
        // The output is expected for an invalid Visit
        // An expected anonymous visit String
        String anonymousVisitVisualization = getExpectedVisualization(VisitColor.ANONYMOUS_VISITOR_COLOR, ' ');
        String actual = capture.toString("UTF-8");
        assertEquals(anonymousVisitVisualization, actual);
    }

    private String getExpectedVisualization(VisitColor visitColor, char ch) {
        return String.format("\u001b[%sm%c\u001b[0m", visitColor.getAnsiCode(), ch);
    }
}
