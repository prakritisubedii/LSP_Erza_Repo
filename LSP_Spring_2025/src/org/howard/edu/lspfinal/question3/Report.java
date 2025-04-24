package org.howard.edu.lspfinal.question3;

/**
 * Abstract class that defines the template method for report generation.
 */
public abstract class Report {
    /**
     * Template method to generate the report.
     */
    public final void generateReport() {
        loadData();
        formatData();
        printReport();
    }

    /**
     * Loads data for the report.
     */
    protected abstract void loadData();

    /**
     * Formats the loaded data.
     */
    protected abstract void formatData();

    /**
     * Prints the final report.
     */
    protected abstract void printReport();
}
