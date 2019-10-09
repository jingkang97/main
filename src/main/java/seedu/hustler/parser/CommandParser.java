package seedu.hustler.parser;

import java.util.Arrays;

import seedu.hustler.data.CommandLog;
import seedu.hustler.command.*;
import seedu.hustler.command.ListCommand;
import seedu.hustler.command.DoneCommand;
import seedu.hustler.command.DeleteCommand;
import seedu.hustler.command.AddCommand;
import seedu.hustler.command.InvalidCommand;
import seedu.hustler.command.CheckAvatarCommand;
import seedu.hustler.command.RemindCommand;
import seedu.hustler.command.ScheduleCommand;
import seedu.hustler.command.SnoozeCommand;
import seedu.hustler.command.FindCommand;
import seedu.hustler.command.Command;
import seedu.hustler.logic.CommandLineException;


/**
 * Takes raw user input as string, makes sense out of the input using
 * regex and then performs operations based on the input.
 */
public class CommandParser extends Parser {
    /**
     * Takes raw input and splits it into task type (eg. todo) and task
     * description (eg. finish work). In cases like task type: list, bye,
     * the output array only contains task type.
     *
     * @param rawInput users single line string input
     * @return an array split into task type and task description
     */
    public String[] split(String rawInput) {
        String[] userInput = rawInput.split(" ", 2);
        return userInput;
    }
    /**
     * Default constructor.
     */

    /**
     * This method takes the raw user input and attempts to decipher
     * the user's intentions (whether the user wants to find a task, add
     * a task, etc.), thereafter returning the corresponding command.
     *
     * @param rawInput user's single line string input
     * @return an instruction, of type Command, to be executed.
     */
    public Command parse(String rawInput) throws CommandLineException {
        String[] userInput = this.split(rawInput);

        /* String[] taskCommands = {"todo", "deadline", "event"}; */
        /* Arrays.sort(taskCommands); */
        if (userInput[0].equals("find")) {
            return new FindCommand(userInput);
        } else if (userInput[0].equals("delete")) {
            CommandLog.recordCommand(rawInput);
            return new DeleteCommand(userInput);
        } else if (userInput[0].equals("list")) {
            return new ListCommand();
        } else if (userInput[0].equals("remind")) {
            return new RemindCommand();
        } else if (userInput[0].equals("done")) {
            CommandLog.recordCommand(rawInput);
            return new DoneCommand(userInput);
        } else if (userInput[0].equals("show")) {
            return new ScheduleCommand(userInput);
        } else if (userInput[0].equals("snooze")) {
            return new SnoozeCommand(userInput);
        } else if (userInput[0].equals("/avatar")) {
            return new CheckAvatarCommand();
        } else if (userInput[0].equals("/add")) {
            CommandLog.recordCommand(rawInput);
            return new AddCommand(userInput);
        } else if (userInput[0].equals("timer")) {
            return new TimerCommand(userInput);
        } else if (userInput[0].equals("undo")) {
            return new UndoCommand(userInput);
        } else if (userInput[0].equals("stoptimer")) {
            return new StopTimerCommand();
        } else if (userInput[0].equals("showtimer")) {
            return new ShowTimerCommand();
        } else {
            return new InvalidCommand();
        }
    }
}