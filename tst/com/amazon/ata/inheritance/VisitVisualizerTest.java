package com.amazon.ata.inheritance;

import com.amazon.ata.inheritance.VisitFactory;
import com.amazon.ata.inheritance.VisitVisualizer;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class VisitVisualizerTest {

    @Test
    public void testVisualizerRuns() {
        // GIVEN
        // The default VisitFactory
        VisitFactory factory = new VisitFactory();
        // And VisitVisualizer
        VisitVisualizer visualizer = new VisitVisualizer(factory);

        // WHEN
        // We run the visualization
        visualizer.visualize("happy.log");

        // THEN
        // Manually check output
    }

    @Test
    public void testVisualizationHasCorrectNumberOfVisits() throws UnsupportedEncodingException {
        // GIVEN
        // All output captured by our own stream
        ByteArrayOutputStream capture = new ByteArrayOutputStream(1000);
        PrintStream stdout = System.out;
        System.setOut(new PrintStream(capture));
        // And a visit factory providing Visits by account type
        VisitFactory factory = new VisitFactory();
        // And VisitVisualizer
        VisitVisualizer visualizer = new VisitVisualizer(factory);

        // WHEN
        // We run the visualization
        visualizer.visualize("happy.log");
        // and restore stdout
        System.setOut(stdout);
        // and strip the header and formatting out of the visualization
        String output = capture.toString("UTF-8");
        String noHeader = output.replaceFirst("^.*\n", "");
        String strippedOutput = noHeader.replaceAll("[^@ X]", "");

        // THEN
        // The stripped output has 96 characters
        assertEquals(96, strippedOutput.length(),
                String.format("Expected 96 characters in visualization '%s'", strippedOutput));
        // Count the number of X
        String allXs = strippedOutput.replaceAll("[^X]", "");
        if (allXs.length() > 0) {
            assertEquals(96, allXs.length(), "Before prework implementation, visualization should be all Xs");
        } else {
            // Count the number of @ signs
            String allAts = strippedOutput.replaceAll("[^@]", "");
            assertEquals(36, allAts.length(), "Incorrect number of Amazon visits!");
            // Count the number of spaces
            String allSpaces = strippedOutput.replaceAll("[^ ]", "");
            assertEquals(60, allSpaces.length(), "Incorrect number of test visits!");
        }
    }
}
