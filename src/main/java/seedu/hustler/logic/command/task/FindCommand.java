package seedu.hustler.logic.command.task;

import seedu.hustler.Hustler;
import seedu.hustler.logic.CommandLineException;
import seedu.hustler.logic.command.Command;
import seedu.hustler.logic.parser.anomaly.FindAnomaly;
import seedu.hustler.ui.Ui;

/**
 * Command that lists tasks in TaskList instance.
 */
public class FindCommand extends Command {
    /**
     * User input that contains keyword to search for in list.
     */
    private String[] userInput;

    /**
     * Detect anomalies for input.
     */
    private FindAnomaly anomaly = new FindAnomaly();
    /**
     * Initializes userInput.
     *
     * @param userInput the array of users inputs to initialize with.
     */
    public FindCommand(String[] userInput) {
        this.userInput = userInput;
    }
    
    /**
     * Lists commands which contain keyword.
     */
    public void execute() {
        Ui ui = new Ui();
        try {
            anomaly.detect(userInput);
            Hustler.list.findTask(this.userInput[1]);
        } catch (CommandLineException e) {
            ui.show_message(e.getMessage());
        }
    }
}
