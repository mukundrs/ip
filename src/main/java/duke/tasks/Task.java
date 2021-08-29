package duke.tasks;

public class Task {
    protected String description;
    protected boolean isDone;

    public Task(String d) {
        this.description = d;
        this.isDone = false;
    }

    /**
     * Method to get task description
     *
     * @return Task description string
     */
    public String getDescription() {
        return this.description;
    }

    public void setDone() {
        isDone = true;
    }

    public String getStatusIcon() {
        return (isDone ? "X" : " ");
    }

    public String getFileString() {
        int i = this.isDone ? 1 : 0;
        return "T | " + i + " | " + this.description;
    }

    public String toString() {
        return "[" + getStatusIcon() + "] " + description;
    }
}