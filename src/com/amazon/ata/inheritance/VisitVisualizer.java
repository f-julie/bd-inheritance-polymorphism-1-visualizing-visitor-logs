package com.amazon.ata.inheritance;

import com.amazon.ata.inheritance.model.Visit;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Visualizes all the visits in a given log as a block of colored characters.
 */
public class VisitVisualizer {
    private VisitFactory visitFactory;
    private int linebreakAfter = 12;

    /**
     * Constructs a VisitVisualizer that retrieves Visits from the specified
     * VisitFactory.
     * @param visitFactory The VisitFactory to use when creating Visits.
     */
    public VisitVisualizer(final VisitFactory visitFactory) {
        this.visitFactory = visitFactory;
    }

    /**
     * Creates a terminal-based visualization of the provided visit log.
     * @param dataset The name of a visit log.
     */
    public void visualize(final String dataset) {
        // Read the dataset
        final List<String> visits = readVisits(dataset);
        System.out.println(String.format("Visualizing %d visits...", visits.size()));

        // Visualize each visit
        for (int i = 0; i < visits.size(); i++) {
            // Get the correct Visit class from the factory
            final String line = visits.get(i);
            final Visit visit = visitFactory.createVisitFromLogEvent(line);

            // Visualize this visit
            visit.visualize();

            // Newline?
            int read = i + 1;
            if (read % linebreakAfter == 0) {
                System.out.println();
            }
        }

        // Extra newline
        System.out.println();
    }

    private List<String> readVisits(final String dataset) {
        final InputStream visitLog = this.getClass().getClassLoader().getResourceAsStream(dataset);
        final Scanner visitScanner = new Scanner(visitLog, "UTF-8");
        final List<String> visits = new ArrayList<>();
        while (visitScanner.hasNext()) {
            visits.add(visitScanner.next());
        }
        return visits;
    }

}
