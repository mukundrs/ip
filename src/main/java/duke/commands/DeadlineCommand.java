package duke.commands;

import duke.DukeStorage;
import duke.TaskList;
import duke.Ui;
import duke.tasks.Deadline;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Class that contains the deadline command
 *
 */
public class DeadlineCommand extends Command {

    /** The description of the deadline command */
    private String description;

    /** The date and time for the deadline command */
    private LocalDateTime byDateTime;

    /**
     * Constructor for the deadline command class
     *
     * @param description The description of the deadline command
     * @param byDateTime The date and time for the deadline command
     */
    public DeadlineCommand(String description, LocalDateTime byDateTime) {
        this.description = description;
        this.byDateTime = byDateTime;
    }

    /**
     * Method to execute deadline command
     *
     * @param taskList The list of tasks that is associated with the instance of Duke
     * @param ui The UI that is associated with the instance of Duke
     * @param storage The storage that is associated with the instance of Duke
     */
    @Override
    public void execute(TaskList taskList, Ui ui, DukeStorage storage) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMM dd yyyy HH:mm");
        Deadline deadline = new Deadline(description, byDateTime.format(formatter));
        taskList.add(deadline);
        ui.addedMessage(taskList, deadline);
    }

    /**
     * Method to return boolean depending on if Duke is to be exited
     *
     * @return boolean that returns false
     */
    @Override
    public boolean isExit() {
        return false;
    }
}
