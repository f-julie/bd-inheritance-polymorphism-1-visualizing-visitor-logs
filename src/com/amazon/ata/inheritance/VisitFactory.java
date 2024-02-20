package com.amazon.ata.inheritance;

import com.amazon.ata.inheritance.model.InvalidVisit;
import com.amazon.ata.inheritance.model.Visit;

/**
 * Produces all the various types of Visits.
 */
public class VisitFactory {
    /**
     * Construct a Visit from the data in the log event.
     * @param logEvent the pipe-delimited String representing a log event.
     * @return An appropriate Visit.
     */
    public Visit createVisitFromLogEvent(final String logEvent) {
        final String[] columns = logEvent.split("\\|");
        final String visitorId = columns[1];
        final Visit visit;
        if (visitorId.startsWith("ff")) {
            // TODO: Return a test visit
            visit = new Visit();
        } else if (visitorId.matches(".*a[0-9a-f]$")) {
            // TODO: Return an Amazon account visit
            visit = new Visit();
        } else if (visitorId.matches(".*f[0-9a-f]$")) {
            // TODO: Return a Zappos account visit
            if (visitorId.startsWith("f0")) {
                visit = new Visit();
            } else {
                // TODO: Return an Amazon account visit
                visit = new Visit();
            }
        } else if (visitorId.equals("000000000000")) {
            // The known ID for anonymous session visitors
            visit = new Visit();
        } else {
            // Invalid visitor ID
            visit = new InvalidVisit();
        }

        return visit;
    }
}
