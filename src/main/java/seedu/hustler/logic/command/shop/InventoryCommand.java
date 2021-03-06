package seedu.hustler.logic.command.shop;

import seedu.hustler.Hustler;
import seedu.hustler.logic.CommandLineException;
import seedu.hustler.logic.command.Command;
import seedu.hustler.logic.parser.anomaly.OneWordAnomaly;
import seedu.hustler.ui.Ui;

public class InventoryCommand extends Command {

    private final String[] userInput;
    private OneWordAnomaly inventoryAnomaly = new OneWordAnomaly();

    public InventoryCommand(String[] userInput) {
        this.userInput = userInput;
    }

    public void execute() {
        Ui ui = new Ui();
        try {
            inventoryAnomaly.detect(this.userInput);
            Hustler.inventory.list();
        } catch (CommandLineException e) {
            ui.show_message(e.getMessage());
        }

    }
}
