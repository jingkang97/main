package seedu.hustler.logic.parser.anomaly;

import seedu.hustler.logic.CommandLineException;

/**
 * Detects sort anomalies in user input.
 */
public class SortAnomaly extends DetectAnomaly {

    /**
     * Detects anomalies for input.
     *
     * @param userInput input for which anomaly is detected
     */
    @Override
    public void detect(String[] userInput) throws CommandLineException {
        String sortTypeString = userInput[1];
        String[] validSortTypes = {"normal", "datetime", "priority"};
        for (String validSortType: validSortTypes) {
            if (sortTypeString.equals(validSortType)) {
                return;
            }
        }
        throw new CommandLineException("Invalid sort type entered.");
    }
}
